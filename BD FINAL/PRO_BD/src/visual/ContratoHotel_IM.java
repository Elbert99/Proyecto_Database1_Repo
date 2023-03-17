/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Dialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.ContractHotelDto;
import model.HotelDto;
import utils.Tools;
import utils.Tools;
import utils.GestorInterface;

/**
 *
 * @author Victor
 */
public class ContratoHotel_IM extends Contrato_IM {
    public ContractHotelDto contrato;
    public GestorInterface iG;  //Interfaz al Gestor
    private final String idtitle = " Contrato Hotel";
    public PanelContrato panelcontrato;
    public PanelListHotelCH panelhotel;
    public PanelTempCH paneltemporada;
    public PanelHabitacionAlimento panelhabitacion;
    private int tipo;
    
    public ContratoHotel_IM(java.awt.Dialog parent, boolean modal) {
        super(parent, modal,null);
        initComponents();
        setBounds(Tools.center(355,315));
        setResizable(false);
        
    }
//   Get y Set
    private ContractHotelDto getContrato() {
        return contrato;
    }
    private void setContrato(ContractHotelDto contrato) {
        this.contrato = contrato;
        refreshcomponents(contrato);
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
//    Logica
    public void mostrar() {
        crearinterface();
        refresh();
        construirpaneles();
        actualizarpanel(0);
        setVisible(true);
    }
 
    private void refresh(){
        if(!iG.isInsert())actualizarinstanciatabla(iG.getObjetoactual());       
    }
   
    private void actualizarinstanciatabla(Object objetoactual) {
        setContrato((ContractHotelDto)objetoactual);
    }
    
    private void refreshcomponents(ContractHotelDto contratohotel) {
      
    }
     
    private void crearinterface(){
        iG = GestorArchivoGenerico.getInstance();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void construirpaneles(){
        panelcontrato = new PanelContrato(this);
        panelcontrato.setBounds(0,23,383,368);
        panelhotel = new PanelListHotelCH(this);
        panelhotel.setBounds(0,23,386,291);
        paneltemporada = new PanelTempCH(this);
        paneltemporada.setBounds(0,23,384,332);
        panelhabitacion = new PanelHabitacionAlimento(this);
        panelhabitacion.setBounds(0,23,399,411);
    }
    
    public void actualizarpanel(int t){
        setTipo(t);
        String item = " ["+String.valueOf(t+1)+"/4] ";
        switch(t){
            case 0 :
                Tools.setTitulo(this,iG.getTipo(), idtitle+item+" (Definir Contrato)");      
                this.setBounds(this.getX(),this.getY(),386,395);
                setContentPane(panelcontrato);
                break;
            case 1 :
                Tools.setTitulo(this,iG.getTipo(), idtitle+item+" (Selecionar Hotel)");      
                this.setBounds(this.getX(),this.getY(),386,318);
                setContentPane(panelhotel);
                break;
            case 2 :
                Tools.setTitulo(this,iG.getTipo(), idtitle+item+" (Definir Temporada)");
                this.setBounds(this.getX(),this.getY(),386,359);
                setContentPane(paneltemporada);
                break;
            case 3 : 
                Tools.setTitulo(this,iG.getTipo(), idtitle+item+" (Definir Planes)");
                this.setBounds(this.getX(),this.getY(),407,438);
                setContentPane(panelhabitacion);
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
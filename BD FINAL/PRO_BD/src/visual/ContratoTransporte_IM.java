/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import model.ContractServComplDto;
import model.ContractTransportDto;
import utils.Tools;
import utils.Tools;
import utils.GestorInterface;

/**
 *
 * @author Victor
 */
public class ContratoTransporte_IM extends Contrato_IM {
    public ContractTransportDto contrato;
    public GestorInterface iG;  //Interfaz al Gestor
    private final String idtitle = " Contrato Transporte";
    public PanelContrato panelcontrato;
    public PanelPrestario panelprestario;
    public PanelVehiculos panelvehiculos;
    private int tipo;
    public ContratoTransporte_IM(java.awt.Dialog parent, boolean modal) {
        super(parent, modal,null);
        initComponents();
        setBounds(Tools.center(355,315));
        setResizable(false);
    }
    //Get y Set
    private ContractTransportDto getContrato() {
        return contrato;
    }
    private void setContrato(ContractTransportDto contrato) {
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
        setContrato((ContractTransportDto)objetoactual);
    }
    
    private void refreshcomponents(ContractTransportDto contratotransporte) {
      
    }
     
    private void crearinterface(){
        iG = GestorArchivoGenerico.getInstance();
    }
  
    private void construirpaneles(){
        panelcontrato = new PanelContrato(this);
        panelcontrato.setBounds(0,23,386,368);
        panelprestario = new PanelPrestario(this);
        panelprestario.setBounds(0,23,390,220);
        panelvehiculos = new PanelVehiculos(this);
        panelvehiculos.setBounds(0,23,816,345);
    }
    
    public void actualizarpanel(int t){
        setTipo(t);
        String item = " ["+String.valueOf(t+1)+"/3] ";
        switch(t){
            case 0 :
                Tools.setTitulo(this,iG.getTipo(), idtitle+item+" (Definir Contrato)");      
                this.setBounds(this.getX(),this.getY(),386,395);
                setContentPane(panelcontrato);
                break;
            case 1 :
                Tools.setTitulo(this,iG.getTipo(), idtitle+item+" (Selecc. Prestario)");      
                this.setBounds(this.getX(),this.getY(),390,247);
                setContentPane(panelprestario);
                break;
            case 2 :
                Tools.setTitulo(this,iG.getTipo(), idtitle+item+" (Añadir Vehiculos)");      
                this.setBounds(this.getX(),this.getY(),816,372);
                setContentPane(panelvehiculos);
                break;
        }
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

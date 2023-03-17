/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import model.ContractHotelDto;
import model.ContractServComplDto;
import utils.Tools;
import utils.Tools;
import utils.GestorInterface;

/**
 *
 * @author Victor
 */
public class ContratoServCompl_IM extends Contrato_IM {
    public ContractServComplDto contrato;
    public GestorInterface iG;  //Interfaz al Gestor
    public final String idtitle = " Contrato Serv. Compl.";
    public PanelContrato panelcontrato;
    public PanelListActividadCSC panelactividad;
    private int tipo;
    
    public ContratoServCompl_IM(java.awt.Dialog parent, boolean modal) {
        super(parent, modal,null);
        initComponents();
        setBounds(Tools.center(355,315));
        setResizable(false);
    }
     //Get y Set
    private ContractServComplDto getContrato() {
        return contrato;
    }
    private void setContrato(ContractServComplDto contrato) {
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
        setContrato((ContractServComplDto)objetoactual);
    }
    
    private void refreshcomponents(ContractServComplDto contratoservcompl) {
      
    }
     
    private void crearinterface(){
        iG = GestorArchivoGenerico.getInstance();
    }
    
    private void construirpaneles(){
        panelcontrato = new PanelContrato(this);
        panelcontrato.setBounds(0,23,383,368);
        panelactividad = new PanelListActividadCSC(this);
        panelactividad.setBounds(0,23,386,283);
    }
    
    public void actualizarpanel(int t){
        setTipo(t);
        String item = " ["+String.valueOf(t+1)+"/2] ";
        switch(t){
            case 0 :
                Tools.setTitulo(this,iG.getTipo(), idtitle+item+" (Definir Contrato)");      
                this.setBounds(this.getX(),this.getY(),386,395);
                setContentPane(panelcontrato);
                break;
            case 1 :
                Tools.setTitulo(this,iG.getTipo(), idtitle+item+" (Definir Actv.)");      
                this.setBounds(this.getX(),this.getY(),386,308);
                setContentPane(panelactividad);
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

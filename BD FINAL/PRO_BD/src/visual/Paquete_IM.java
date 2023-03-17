/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import model.ContractHotelDto;
import model.PackDto;
import utils.GestorInterface;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class Paquete_IM extends javax.swing.JDialog {
    public PackDto paquete;
    public GestorInterface iG;  //Interfaz al Gestor
    private final String idtitle = " Paquete Turístico";
    public PanelProgramaPaquete panelprogramapaquete;
    public PanelListVehiculos panelvehiculo;
    public PanelHotelPlan panelhotel;
    public PanelProgActividades panelactividades;
    public PanelPrecios panelprecios;
    private int tipo;
    
    public Paquete_IM(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBounds(Tools.center(429, 411));
        setResizable(false);
    }
//  Get y Set
    private PackDto getPaquete() {
        return paquete;
    }
    private void setPaquete(PackDto paquete) {
        this.paquete = paquete;
        refreshcomponents(paquete);
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
        setPaquete((PackDto)objetoactual);
    }
    
    private void refreshcomponents(PackDto paquete) {
              
    }
     
    private void crearinterface(){
        iG = GestorArchivoGenerico.getInstance();
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
    private void construirpaneles(){
        panelprogramapaquete = new PanelProgramaPaquete(this);
        panelprogramapaquete.setBounds(0,23,429, 411);
        panelvehiculo = new PanelListVehiculos(this);
        panelvehiculo.setBounds(0,23,429, 417);
        panelhotel = new PanelHotelPlan(this);
        panelhotel.setBounds(0,23,562,417);
        panelactividades = new PanelProgActividades(this);
        panelactividades.setBounds(0,23,562,417);
        panelprecios = new PanelPrecios(this);
        panelprecios.setBounds(0,23,429, 373);
    }
    public void actualizarpanel(int t){
        setTipo(t);
        String item = " ["+String.valueOf(t+1)+"/5] ";
        switch(t){
            case 0 :
                Tools.setTitulo(this,iG.getTipo(),idtitle+item+" (Definir Paquete Turístico)");      
                this.setBounds(this.getX(),this.getY(),429,438);
                setContentPane(panelprogramapaquete);
                break;
            case 1 :
                Tools.setTitulo(this,iG.getTipo(),idtitle+item+" (Selecc. Vehículo y Modalidad)");      
                this.setBounds(this.getX(),this.getY(),429,444);
                setContentPane(panelvehiculo);
                break;
            case 2 :
                Tools.setTitulo(this,iG.getTipo(),idtitle+item+" (Selecc. Alojamiento y Plan)");      
                this.setBounds(this.getX(),this.getY(),562,444);
                setContentPane(panelhotel);
                break;
            case 3:
                Tools.setTitulo(this,iG.getTipo(),idtitle+item+" (Definir Programa de Actividades)");      
                this.setBounds(this.getX(),this.getY(),562,444);
                setContentPane(panelactividades);
                break;
            case 4:
                Tools.setTitulo(this,iG.getTipo(),idtitle+item+" (Resultados)");      
                this.setBounds(this.getX(),this.getY(),429,399);
                setContentPane(panelprecios);
                if(!iG.isVer())panelprecios.generarPrecios(); 
                break;
        } 
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

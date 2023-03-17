/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.util.LinkedList;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import model.ModeCKDto;
import model.ModeHKDto;
import model.ModeREDto;
import model.ModeTransportDto;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class InfoModalidad extends javax.swing.JDialog {
    private ModeTransportDto objeto;
    private DefaultTableModel modelokm;
    private DefaultTableModel modelohoras;
    private DefaultTableModel modelorecorrido;
    private LinkedList<Component> c = new LinkedList<Component>();
    
    public InfoModalidad(JDialog parent, boolean modal,ModeTransportDto modalidad) {
        super(parent, modal);
        initComponents();
        c.add(panel); Tools.actualizarcomponentes(c,PrincipalVisual.getInstance().getUsuario().getTema());
        setBounds(Tools.center(this.getWidth(),this.getHeight()));
        setResizable(false);
        objeto=modalidad;
        crearmodelos(); 
    }
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información de Modalidad");

        panel.setBackground(new java.awt.Color(204, 255, 204));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(aceptar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aceptar)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
         dispose();
    }//GEN-LAST:event_aceptarActionPerformed
//Mostrar Descripcion al dar click en la tabla
    private void tablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseReleased
        if(objeto instanceof ModeREDto){
            ModeREDto aux = (ModeREDto)objeto;
            Texto_IM texto = new Texto_IM(this,true,aux.getDescripcion(),"Descripción",true);
            texto.setVisible(true);
        }
        
    }//GEN-LAST:event_tablaMouseReleased

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    
    //Crear el Modelo y la Tabla dependiendo del tipo de modalidad entrada
    private void crearmodelos(){
        if(objeto instanceof ModeCKDto){
            ModeCKDto a = (ModeCKDto)objeto;
            modelokm = new DefaultTableModel(new Object[]{"Costo Km","Costo Km ida vuelta","Costo Horas Esp."}, 0x0){
                public boolean isCellEditable(int rowIndex,int columnIndex){
                    return false;
                }
            };
            modelokm.addRow(new Object[]{a.getCostokm(),a.getCostokm_idavuelta(),a.getCosto_horasesperas()});
            tabla.setModel(modelokm);
        }else if(objeto instanceof ModeHKDto){
            ModeHKDto a = (ModeHKDto)objeto;
            modelohoras = new DefaultTableModel(new Object[]{"Costo Km Recorr.","Costo Horas","Costo Km Ext.","Costo Horas Ext"}, 0x0){
                public boolean isCellEditable(int rowIndex,int columnIndex){
                    return false;
                }
            };
            modelohoras.addRow(new Object[]{a.getCostokm_recorridos(),a.getCosto_horas(),a.getCostokm_extras(),a.getCostohoras_extras()});
            tabla.setModel(modelohoras);
        }else if(objeto instanceof ModeREDto){
            ModeREDto a = (ModeREDto)objeto;
            modelorecorrido = new DefaultTableModel(new Object[]{"Descripcion","Costo Ida Vuelta","Costo  Recorrido"}, 0x0){
                public boolean isCellEditable(int rowIndex,int columnIndex){
                    return false;
                }
            };
            modelorecorrido.addRow(new Object[]{"Click(Ver Descripción)",a.getCosto_idavuelta(),a.getCosto_recorrido()});
            tabla.setModel(modelorecorrido);
        }
    }
}

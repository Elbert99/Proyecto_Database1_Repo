/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.LinkedList;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeListener;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class CambiarTema extends javax.swing.JDialog {
    private LinkedList<Component> c = new LinkedList<Component>();
    private int tema;            
    private boolean acceso; //Verificar desde el exterior si se presionó algun boton
    
    public CambiarTema(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setAcceso(false);
        setBounds(Tools.center(this.getWidth(),this.getHeight()));
        setResizable(false);
        buttonGroup1.add(azul);
        buttonGroup1.add(verde);
        buttonGroup1.add(xp);
        c.add(azul); c.add(verde); c.add(xp); c.add(panel);
        setTema(PrincipalVisual.getInstance().getUsuario().getTema());
        inicializarradiobutton();
        Tools.actualizarcomponentes(c,getTema());      
    }
    
    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }
    
    public boolean isAcceso() {
        return acceso;
    }
    
    public int getTema() {
        return tema;
    }
    public void setTema(int tema) {
        this.tema = tema;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        azul = new javax.swing.JRadioButton();
        verde = new javax.swing.JRadioButton();
        xp = new javax.swing.JRadioButton();
        jSeparator5 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar Tema");

        azul.setText("Azul");
        azul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                azulActionPerformed(evt);
            }
        });

        verde.setText("Verde");
        verde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verdeActionPerformed(evt);
            }
        });

        xp.setText("Window Xp");
        xp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xpActionPerformed(evt);
            }
        });

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(aceptar)
                        .addGap(18, 18, 18)
                        .addComponent(cancelar))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(azul)
                                .addGap(50, 50, 50)
                                .addComponent(verde)
                                .addGap(44, 44, 44)
                                .addComponent(xp)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(azul)
                    .addComponent(verde)
                    .addComponent(xp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelar)
                    .addComponent(aceptar))
                .addGap(16, 16, 16))
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
         setAcceso(true);
         PrincipalVisual.getInstance().getUsuario().setTema(getTema());
         setVisible(false);
    }//GEN-LAST:event_aceptarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        cancelar();
        setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed
    public void cancelar(){
        setAcceso(true);
        Tools.tema(PrincipalVisual.getInstance().getUsuario().getTema());
        refrescarvisual();
    }
    private void azulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_azulActionPerformed
        final int t=0;
        Tools.actualizarcomponentes(c,t);
        Tools.tema(t);
        refrescarvisual();
        setTema(t);
        
    }//GEN-LAST:event_azulActionPerformed

    private void verdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verdeActionPerformed
        final int t=1;
        Tools.actualizarcomponentes(c,t);
        Tools.tema(t);    
        refrescarvisual();
        setTema(t);
    }//GEN-LAST:event_verdeActionPerformed

    private void xpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xpActionPerformed
        final int t=2;
        Tools.actualizarcomponentes(c,t);
        Tools.tema(t);
        refrescarvisual();
        setTema(t);
    }//GEN-LAST:event_xpActionPerformed
    
    private void refrescarvisual(){
        this.repaint();
        PrincipalVisual.getInstance().repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JRadioButton azul;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPanel panel;
    private javax.swing.JRadioButton verde;
    private javax.swing.JRadioButton xp;
    // End of variables declaration//GEN-END:variables

    private void inicializarradiobutton() {
        switch(getTema()){
            case 0 : azul.setSelected(true); break;
            case 1 : verde.setSelected(true); break;
            case 2 : xp.setSelected(true); break;
        }
    }
}

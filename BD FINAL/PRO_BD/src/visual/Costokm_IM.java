/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import model.ModeCKDto;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class Costokm_IM extends javax.swing.JDialog {

    ModeCKDto arreglo;
    boolean bandera = false;
    private LinkedList<Component> c = new LinkedList<Component>();
    private boolean ver;
    private JTextField  refcostokm;
    private JTextField  refidavuelta;
    private JTextField  refhorasext;
    
    public Costokm_IM(JDialog parent, boolean modal, ModeCKDto input, int tipo) {
        super(parent, modal);
        initComponents();
        c.add(panel);
        ver = tipo == 1 ? true : false;
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        refhorasext = ((JSpinner.DefaultEditor) horasext.getEditor()).getTextField();
        refhorasext.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.flotante(e,refhorasext, 8);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        refidavuelta = ((JSpinner.DefaultEditor) idavuelta.getEditor()).getTextField();
        refidavuelta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.flotante(e, refidavuelta, 8);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        refcostokm = ((JSpinner.DefaultEditor) costokm.getEditor()).getTextField();
        refcostokm.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.flotante(e, refcostokm, 8);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        arreglo = new ModeCKDto(0, 0, 0, 0, "", "");
        setBounds(Tools.center(this.getWidth(), this.getHeight()));
        setResizable(false);
        if (input != null) {
            arreglo = input;
            cargar();
        }
        if (tipo == 1) {
            ver();
        }
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(costokm);
        lista.add(horasext);
        lista.add(idavuelta);
        lista.add(horasext);
        lista.add(cancelar);
        Tools.desactivar(lista);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        costokm = new javax.swing.JSpinner();
        idavuelta = new javax.swing.JSpinner();
        horasext = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Costo por:");

        panel.setBackground(new java.awt.Color(204, 255, 204));

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

        jLabel1.setText("Km");

        jLabel2.setText("Km Ida Vuelta");

        jLabel3.setText("Horas Ext.");

        costokm.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));

        idavuelta.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));

        horasext.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel1))
                                    .addComponent(costokm, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(idavuelta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(17, 17, 17))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(horasext, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(aceptar)
                        .addGap(27, 27, 27)
                        .addComponent(cancelar)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(costokm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(idavuelta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(horasext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap(16, Short.MAX_VALUE))
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
        if (!ver) {
            leer();
            bandera = true;
        }
        this.setVisible(false);
    }//GEN-LAST:event_aceptarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JSpinner costokm;
    private javax.swing.JSpinner horasext;
    private javax.swing.JSpinner idavuelta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
    private void leer() {
        arreglo.setCostokm((float)costokm.getValue());
        arreglo.setCostokm_idavuelta((float)idavuelta.getValue());
        arreglo.setCosto_horasesperas((float)horasext.getValue());
    }

    private void cargar() {
        costokm.setValue(arreglo.getCostokm());
        idavuelta.setValue(arreglo.getCostokm_idavuelta());
        horasext.setValue(arreglo.getCosto_horasesperas());
    }
}

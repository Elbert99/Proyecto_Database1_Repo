/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.AgencyDto;
import services.ServicesLocator;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class PanelPrestario extends javax.swing.JPanel {

    private ContratoTransporte_IM control;
    private LinkedList<Component> c = new LinkedList<Component>();
    private DefaultComboBoxModel modelo;
    private LinkedList<String> lista = new LinkedList<String>();

    public PanelPrestario(ContratoTransporte_IM atras) {
        initComponents();
        crearmodelo();
        c.add(panel);
        c.add(panel2);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        control = atras;
        aceptar.setEnabled(false);
        if (!control.iG.isInsert()) {
            actualizarcombo();
        }
        if (control.iG.isVer()) {
            ver();
        }
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(combonombre);
        Tools.desactivar(lista);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        combonombre = new javax.swing.JComboBox<>();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 320, 10));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        aceptar.setText("Aceptar");
        panel.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Prestario"));

        jLabel2.setText("Nombre:");

        combonombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel2Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                    .addComponent(combonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel2Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(combonombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(11, Short.MAX_VALUE)))
        );

        panel.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 340, 100));

        anterior.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        anterior.setText("<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        panel.add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        siguiente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        siguiente.setText(">");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        panel.add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        control.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        control.actualizarpanel(control.getTipo() - 1);
    }//GEN-LAST:event_anteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        if (!control.iG.isVer()) {
            if (control.iG.isInsert()) {
                if (confirmar(control)) {
                    boolean existe;
                    existe = Tools.existecodigo(control.panelcontrato.txtcodigo.getText(), control);
                    if (!existe) {
                        insertarbd();
                        control.iG.setEstado(true);
                        control.dispose();
                    }
                }
            } else {
                control.actualizarpanel(control.getTipo() + 1);
            }
        } else {
            control.actualizarpanel(control.getTipo() + 1);
        }
    }//GEN-LAST:event_siguienteActionPerformed

    public static boolean confirmar(JDialog vent) {
        return JOptionPane.showConfirmDialog(vent, "Desea Insertar el Contrato para Poder agregar Vehiculos", "Informacion", JOptionPane.YES_NO_OPTION) == 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    public javax.swing.JButton anterior;
    public javax.swing.JButton cancelar;
    public javax.swing.JComboBox<String> combonombre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel2;
    public javax.swing.JButton siguiente;
    // End of variables declaration//GEN-END:variables

    private void crearmodelo() {
        try {
            lista = ServicesLocator.getContratoTransporteServices().obtenerPrestarios();
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrestario.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelo = new DefaultComboBoxModel(lista.toArray());
        combonombre.setModel(modelo);
    }

    private void actualizarcombo() {
        combonombre.setSelectedItem(control.contrato.getTipoprestario());
    }

    private void insertarbd() {
        String codigoaux = control.panelcontrato.txtcodigo.getText();
        Date fechai = Tools.ConDateSql(control.panelcontrato.chooserInicio.getDate());
        Date fechat = Tools.ConDateSql(control.panelcontrato.chooserfin.getDate());
        Date fechac = Tools.ConDateSql(control.panelcontrato.chooserconciliacion.getDate());
        String desc = control.panelcontrato.texto.getContenido();
        String tipo = control.panelcontrato.tipocontrato;

        try {
            ServicesLocator.getContratoTransporteServices().insertar((String) combonombre.getSelectedItem(), codigoaux, fechai, fechat, fechac, desc, AgencyDto.get().serial(), tipo);
            Tools.exito(control, "Contrato Transporte", " Insertado");
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrestario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

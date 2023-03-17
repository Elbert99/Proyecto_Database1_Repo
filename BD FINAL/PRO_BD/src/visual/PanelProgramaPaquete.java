/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import model.ProgramPackDto;
import services.ServicesLocator;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class PanelProgramaPaquete extends javax.swing.JPanel {

    private Paquete_IM control;
    public ProgramPackDto programapaquete;
    private LinkedList<Component> c = new LinkedList<Component>();
    public JTextField refcantidaddias;
    public JTextField refcantidaddenoches;
    public JTextField refcantidadpax;

    public PanelProgramaPaquete(Paquete_IM atras) {
        initComponents();
        c.add(panel);
        c.add(panel2);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        refcantidadpax = ((JSpinner.DefaultEditor) cantidadpax.getEditor()).getTextField();
        refcantidadpax.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.digit(e, refcantidadpax, 2);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        refcantidaddias = ((JSpinner.DefaultEditor) cantidaddias.getEditor()).getTextField();
        refcantidaddias.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.digit(e, refcantidaddias, 3);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        refcantidaddenoches = ((JSpinner.DefaultEditor) cantidaddenoches.getEditor()).getTextField();
        refcantidaddenoches.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.digit(e, refcantidaddenoches, 3);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        control = atras;
        anterior.setEnabled(false);
        aceptar.setEnabled(false);
        if (control.iG.isInsert()) {
            iniciarfecha();
        } else {
            actualizarventana();
        }
        if (control.iG.isVer()) {
            ver();
        }
        info();
    }
    private void info(){
        codigo.setToolTipText("(no menos 4 caracteres alfabeticos y 1 digito)");
        nombre.setToolTipText("(no menos 3 caracteres alfabeticos)");
        cantidaddias.setToolTipText("[1-365]");
        cantidaddenoches.setToolTipText("[1-365]");
        cantidadpax.setToolTipText("[1-20]");
    }
    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(codigo);
        lista.add(nombre);
        lista.add(fechainicio);
        lista.add(cantidaddias);
        lista.add(cantidaddenoches);
        lista.add(cantidadpax);
        Tools.desactivar(lista);
    }

    private void iniciarfecha() {
        Tools.chsosser(fechainicio);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        spinnercantdias1 = new javax.swing.JSpinner();
        panel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        fechainicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        cantidaddias = new javax.swing.JSpinner();
        cantidaddenoches = new javax.swing.JSpinner();
        cantidadpax = new javax.swing.JSpinner();

        jLabel5.setText("Cantidad de Días:");

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 350, 10));

        aceptar.setText("Aceptar");
        panel.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        anterior.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        anterior.setText("<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        panel.add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        siguiente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        siguiente.setText(">");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        panel.add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Programa de Paquete"));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Cantidad de Días:");
        panel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        panel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 77, 137, -1));

        fechainicio.setBackground(new java.awt.Color(255, 255, 204));
        panel2.add(fechainicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 123, 137, 22));

        jLabel3.setText("Fecha Inicial:");
        panel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 123, -1, -1));

        jLabel2.setText("Nombre Promocional:");
        panel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 83, -1, -1));

        jLabel6.setText("Cantidad de Noches:");
        panel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel7.setText("Cantidad de Pax:");
        panel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel8.setText("Código de Paquete:");
        panel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 40, -1, -1));

        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoKeyTyped(evt);
            }
        });
        panel2.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 34, 137, -1));

        cantidaddias.setModel(new javax.swing.SpinnerNumberModel(1, 1, 365, 1));
        panel2.add(cantidaddias, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 140, -1));

        cantidaddenoches.setModel(new javax.swing.SpinnerNumberModel(1, 1, 365, 1));
        panel2.add(cantidaddenoches, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 140, -1));

        cantidadpax.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        panel2.add(cantidadpax, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 140, -1));

        panel.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 380, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        control.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed

    }//GEN-LAST:event_anteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        try {
            if (!control.iG.isVer()) {
                valido(codigo.getText(), nombre.getText());
                control.actualizarpanel(control.getTipo() + 1);
            } else {
                control.actualizarpanel(control.getTipo() + 1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_siguienteActionPerformed

    private void codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyTyped
        Tools.alphadigit(evt,codigo, 20);
    }//GEN-LAST:event_codigoKeyTyped

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        Tools.alpha(evt,nombre,30);
    }//GEN-LAST:event_nombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    public javax.swing.JButton anterior;
    public javax.swing.JButton cancelar;
    public javax.swing.JSpinner cantidaddenoches;
    public javax.swing.JSpinner cantidaddias;
    public javax.swing.JSpinner cantidadpax;
    public javax.swing.JTextField codigo;
    public com.toedter.calendar.JDateChooser fechainicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JTextField nombre;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel2;
    public javax.swing.JButton siguiente;
    private javax.swing.JSpinner spinnercantdias1;
    // End of variables declaration//GEN-END:variables

    private void actualizarventana() {
        obtenerprogramapaquete();
        codigo.setText(control.paquete.getCodigopaquete());
        nombre.setText(control.paquete.getNombrepaquete());
        fechainicio.setDate(programapaquete.getFechainicial());
        cantidaddias.setValue(programapaquete.getCantdias());
        cantidaddenoches.setValue(programapaquete.getCantnoches());
        cantidadpax.setValue(control.paquete.getCantpax());
    }

    private void obtenerprogramapaquete() {
        try {
            programapaquete = ServicesLocator.getPaqueteServices().obtenerProgramaPaquete(control.paquete.getCodigopaquete());
        } catch (SQLException ex) {
            Logger.getLogger(PanelProgramaPaquete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void valido(String codpk, String nombre) throws Exception {
        boolean bcodpk = Tools.mezclaalphadigit(true, codpk, 4, 1);
        if (!bcodpk) {
            throw new Exception("Fallos en Codigo");
        }
        boolean bnombre = Tools.isAlpha(nombre, true, 3, -1);
        if (!bnombre) {
            throw new Exception("Fallos en Nombre");
        }
    }

}

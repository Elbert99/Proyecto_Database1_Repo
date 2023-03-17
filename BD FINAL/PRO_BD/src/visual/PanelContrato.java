/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.ContractDto;
import services.ServicesLocator;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class PanelContrato extends javax.swing.JPanel {

    private Contrato_IM control;
    Texto_IM texto;
    private LinkedList<Component> c = new LinkedList<Component>();
    private boolean insertar;
    private boolean ver;
    ContractDto contrato;
    public String tipocontrato;
    private LinkedList<String> tiposcontrato = new LinkedList<>();

    public PanelContrato(Contrato_IM atras) {
        initComponents();
        c.add(panel);
        c.add(panel2);
        obtenertipos();
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        control = atras;
        determinarver();
        texto = new Texto_IM(control, true, "", "Gestionar Descripción", ver);
        aceptar.setEnabled(false);
        anterior.setEnabled(false);
        determinarinsertarytipo();
        if (!insertar) {
            setcontrato();
        } else {
            actualizarchosser();
        }
        if (ver) {
            ver();
        }
        info();
    }

    private void info(){
        txtcodigo.setToolTipText("(no menos 4 caracteres alfabeticos y 1 digito)");
    }
    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(txtcodigo);
        lista.add(chooserInicio);
        lista.add(chooserfin);
        lista.add(chooserconciliacion);
        Tools.desactivar(lista);
    }

    public void setcontrato() {
        if (control instanceof ContratoHotel_IM) {
            contrato = ((ContratoHotel_IM) control).contrato;
        } else if (control instanceof ContratoServCompl_IM) {
            contrato = ((ContratoServCompl_IM) control).contrato;
        } else if (control instanceof ContratoTransporte_IM) {
            contrato = ((ContratoTransporte_IM) control).contrato;
        }
        actualizarcomponentes();
    }

    public void actualizarcomponentes() {
        txtcodigo.setText(contrato.getCodigocontrato());
        chooserInicio.setDate(contrato.getFechainicio());
        chooserfin.setDate(contrato.getFechaterminacion());
        chooserconciliacion.setDate(contrato.getFechaconciliacion());
        texto.setContenido(contrato.getDescripcion());
    }

    private void actualizarchosser() {
        Tools.chsosser(chooserInicio);
        Tools.chsosser(chooserfin);
        Tools.chsosser(chooserconciliacion);
    }

    private void valido(String codigo, String descripcion) throws Exception {
        boolean bdesc = Tools.isAlpha(descripcion, false, 5, -1);
        if (!bdesc) {
            throw new Exception("Fallos en Descripcion");
        }
        boolean bcod = Tools.mezclaalphadigit(true, codigo, 4, 1);
        if (!bcod) {
            throw new Exception("Fallos en Codigo");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chooserfin = new com.toedter.calendar.JDateChooser();
        chooserconciliacion = new com.toedter.calendar.JDateChooser();
        editar = new javax.swing.JButton();
        txtcodigo = new javax.swing.JTextField();
        chooserInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(204, 255, 255));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 320, 10));

        aceptar.setText("Aceptar");
        panel.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

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

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Contrato"));

        jLabel5.setText("Descripción:");

        jLabel6.setText("Fecha Conciliación:");

        jLabel4.setText("Fecha Fin:");

        chooserfin.setBackground(new java.awt.Color(255, 255, 204));

        chooserconciliacion.setBackground(new java.awt.Color(255, 255, 204));

        editar.setText("Editar Descripción");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });

        chooserInicio.setBackground(new java.awt.Color(255, 255, 204));

        jLabel3.setText("Fecha Inicio:");

        jLabel2.setText("Código:");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chooserfin, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(21, 21, 21)
                        .addComponent(chooserconciliacion, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(chooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(197, 197, 197))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooserfin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(chooserconciliacion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        panel.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 340, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        control.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed

    }//GEN-LAST:event_anteriorActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        texto.setContenido(texto.getContenido());
        texto.setVisible(true);
    }//GEN-LAST:event_editarActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        try {
            if (!ver) {
                valido(txtcodigo.getText(), texto.getContenido());
                siguiente();
            } else {
                siguiente();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_siguienteActionPerformed

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
        Tools.alphadigit(evt, txtcodigo, 20);
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void siguiente() {
        if (control instanceof ContratoHotel_IM) {
            ((ContratoHotel_IM) control).actualizarpanel(((ContratoHotel_IM) control).getTipo() + 1);
        } else if (control instanceof ContratoServCompl_IM) {
            ((ContratoServCompl_IM) control).actualizarpanel(((ContratoServCompl_IM) control).getTipo() + 1);
        } else if (control instanceof ContratoTransporte_IM) {
            ((ContratoTransporte_IM) control).actualizarpanel(((ContratoTransporte_IM) control).getTipo() + 1);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    public javax.swing.JButton anterior;
    public javax.swing.JButton cancelar;
    public com.toedter.calendar.JDateChooser chooserInicio;
    public com.toedter.calendar.JDateChooser chooserconciliacion;
    public com.toedter.calendar.JDateChooser chooserfin;
    private javax.swing.JButton editar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panel;
    public javax.swing.JPanel panel2;
    public javax.swing.JButton siguiente;
    public javax.swing.JTextField txtcodigo;
    // End of variables declaration//GEN-END:variables
private void determinarinsertarytipo() {
        if (control instanceof ContratoHotel_IM) {
            insertar = ((ContratoHotel_IM) control).iG.isInsert();
            tipocontrato = tiposcontrato.get(0);
        } else if (control instanceof ContratoServCompl_IM) {
            insertar = ((ContratoServCompl_IM) control).iG.isInsert();
            tipocontrato = tiposcontrato.get(1);
        } else if (control instanceof ContratoTransporte_IM) {
            insertar = ((ContratoTransporte_IM) control).iG.isInsert();
            tipocontrato = tiposcontrato.get(2);
        }
    }

    private void determinarver() {
        if (control instanceof ContratoHotel_IM) {
            ver = ((ContratoHotel_IM) control).iG.isVer();
        } else if (control instanceof ContratoServCompl_IM) {
            ver = ((ContratoServCompl_IM) control).iG.isVer();
        } else if (control instanceof ContratoTransporte_IM) {
            ver = ((ContratoTransporte_IM) control).iG.isVer();
        }
    }

    private void obtenertipos() {
        try {
            tiposcontrato = ServicesLocator.getAgenciaServices().obtenerTiposContratos();
        } catch (SQLException ex) {
            Logger.getLogger(PanelContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

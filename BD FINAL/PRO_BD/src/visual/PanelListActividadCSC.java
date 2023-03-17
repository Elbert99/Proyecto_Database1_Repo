/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import model.ActivityDto;
import model.AgencyDto;
import services.ServicesLocator;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class PanelListActividadCSC extends javax.swing.JPanel {

    ContratoServCompl_IM control;
    private LinkedList<Component> c = new LinkedList<Component>();
    private DefaultComboBoxModel modelo;
    private LinkedList<String> provincias = new LinkedList<String>();
    private ActivityDto actividad;
    private JTextField refprecio;

    public PanelListActividadCSC(ContratoServCompl_IM atras) {
        initComponents();
        c.add(panel);
        c.add(panel2);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        refprecio = ((JSpinner.DefaultEditor) precio.getEditor()).getTextField();
        refprecio.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.flotante(e, refprecio, 8);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        obtenerprovincias();
        modelo = new DefaultComboBoxModel(provincias.toArray());
        comboProvincia.setModel(modelo);
        control = atras;
        siguiente.setEnabled(false);
        if (!control.iG.isInsert()) {
            actualizar();
        }
        if (control.iG.isVer()) {
            ver();
        }
        info();
    }
    private void info(){
        nombreactividad.setToolTipText("(no menos 3 caracteres alfabeticos)");
    }
    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(nombreactividad);
        lista.add(comboProvincia);
        lista.add(precio);
        lista.add(cancelar);
        Tools.desactivar(lista);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboProvincia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreactividad = new javax.swing.JTextField();
        precio = new javax.swing.JSpinner();

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 320, 10));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        panel.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        siguiente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        siguiente.setText(">");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        panel.add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        anterior.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        anterior.setText("<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        panel.add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Actividad"));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Provincia:");
        panel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 89, -1, -1));

        comboProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel2.add(comboProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 84, 163, -1));

        jLabel3.setText("Precio por Pax:");
        panel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 134, -1, -1));

        jLabel2.setText("Nombre Actividad:");
        panel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 44, -1, -1));

        nombreactividad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreactividadKeyTyped(evt);
            }
        });
        panel2.add(nombreactividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 38, 163, -1));

        precio.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioKeyTyped(evt);
            }
        });
        panel2.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, -1));

        panel.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 340, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        control.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed

    }//GEN-LAST:event_siguienteActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        control.actualizarpanel(control.getTipo() - 1);
    }//GEN-LAST:event_anteriorActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        try {
            if (!control.iG.isVer()) {
                valido(nombreactividad.getText());
                if (control.iG.isInsert()) {
                    boolean existe;
                    existe = Tools.existecodigo(control.panelcontrato.txtcodigo.getText(), control);
                    if (!existe) {
                        insertarbd();
                    }
                } else {
                    boolean existe;
                    if (control.panelcontrato.contrato.getCodigocontrato().equals(control.panelcontrato.txtcodigo.getText())) {
                        existe = false;
                    } else {
                        existe = Tools.existecodigo(control.panelcontrato.txtcodigo.getText(), control);
                    }
                    if (!existe) {
                        modificarBd();
                    }
                }
            } else {
                control.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void nombreactividadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreactividadKeyTyped
        Tools.alpha(evt, nombreactividad, 30);
    }//GEN-LAST:event_nombreactividadKeyTyped

    private void precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyTyped

    }//GEN-LAST:event_precioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    public javax.swing.JButton anterior;
    public javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> comboProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nombreactividad;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel2;
    private javax.swing.JSpinner precio;
    public javax.swing.JButton siguiente;
    // End of variables declaration//GEN-END:variables

    private void obtenerprovincias() {
        try {
            provincias = ServicesLocator.getDistanciaServices().obtenerProvincias();
        } catch (SQLException ex) {
            Logger.getLogger(PanelListActividadCSC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private boolean existecodigo(String codigo) {
//        boolean retorno = false;
//        try {
//            retorno = ServicesLocator.getContratoServComplServices().existeActividad(codigo);
//            if (retorno) {
//                Tools.existe(control);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Vehiculo_IM.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return retorno;
//    }
    private void actualizar() {
        try {
            actividad = ServicesLocator.getContratoServComplServices().obtenerActividadxContrato(control.contrato.getCodigocontrato());
        } catch (SQLException ex) {
            Logger.getLogger(PanelListActividadCSC.class.getName()).log(Level.SEVERE, null, ex);
        }
        nombreactividad.setText(actividad.getNombre());
        comboProvincia.setSelectedItem(actividad.getProvincia());
        precio.setValue(control.contrato.getCostopax());
    }

    private void insertarbd() {
        try {
            String codigoaux = control.panelcontrato.txtcodigo.getText();
            Date fechai = Tools.ConDateSql(control.panelcontrato.chooserInicio.getDate());
            Date fechat = Tools.ConDateSql(control.panelcontrato.chooserfin.getDate());
            Date fechac = Tools.ConDateSql(control.panelcontrato.chooserconciliacion.getDate());
            String desc = control.panelcontrato.texto.getContenido();
            String tipo = control.panelcontrato.tipocontrato;
            ServicesLocator.getContratoServComplServices().insertar((float)precio.getValue(), codigoaux, fechai, fechat, fechac, desc, AgencyDto.get().serial(), tipo);
            insertarActividad();//Lanza una excepcion
            Tools.exito(control, "Contrato Servicio Complementario", " Insertado");
            control.iG.setEstado(true);
            control.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PanelListActividadCSC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            Tools.existe(control, "Existe esta Ocurrencia de Nombre de Actividad en el Sistema");
        }
    }

    private void modificarBd() {
        try {
            String codigoaux = control.panelcontrato.txtcodigo.getText();
            Date fechai = Tools.ConDateSql(control.panelcontrato.chooserInicio.getDate());
            Date fechat = Tools.ConDateSql(control.panelcontrato.chooserfin.getDate());
            Date fechac = Tools.ConDateSql(control.panelcontrato.chooserconciliacion.getDate());
            String desc = control.panelcontrato.texto.getContenido();
            String tipo = control.panelcontrato.tipocontrato;
            ServicesLocator.getContratoServComplServices().editar((float)precio.getValue(), control.contrato.getCodigocontrato(), codigoaux, fechai, fechat, fechac, desc, AgencyDto.get().serial(), tipo);
            modificarActividad();
            Tools.exito(control, "Contrato Servicio Complementario", "Modificado");
            control.iG.setEstado(true);
            control.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PanelListActividadCSC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Tools.existe(control, "Existe esta Ocurrencia de Nombre de Actividad en el Sistema");
        }
    }

    private void insertarActividad() throws Exception {
        String codigoaux = control.panelcontrato.txtcodigo.getText();
        String nombreact = nombreactividad.getText();
        try {
            if (!ServicesLocator.getContratoServComplServices().existeActividad(nombreact)) {
                ServicesLocator.getContratoServComplServices().insertarActividad(nombreact, codigoaux, (String) comboProvincia.getSelectedItem());
                ServicesLocator.getContratoServComplServices().insertarServicioActividad(true, nombreact);
            } else {
                ServicesLocator.getAgenciaServices().eliminarContrato(codigoaux);//delete contrato
                throw new Exception("Eliminar y Parar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelListActividadCSC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarActividad() throws Exception {
        String codigoaux = control.panelcontrato.txtcodigo.getText();
        String nombreact = nombreactividad.getText();
        try {
            if (!actividad.getNombre().equals(nombreact)) {
                if (!ServicesLocator.getContratoServComplServices().existeActividad(nombreact)) {
                    ServicesLocator.getContratoServComplServices().editarActividad(actividad.getNombre(), nombreact, (String) comboProvincia.getSelectedItem());
                } else {
                    throw new Exception("ERROR");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelListActividadCSC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void valido(String nombre) throws Exception {
        boolean bnom = Tools.isAlpha(nombre, true, 3, -1);
        if (!bnom) {
            throw new Exception("Fallos en Nombre");
        }
    }
}

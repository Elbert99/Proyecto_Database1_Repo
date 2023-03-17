/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import model.AgencyDto;
import model.VehicleDto;
import services.ServicesLocator;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class PanelVehiculos extends javax.swing.JPanel {
     DefaultTableModel modelo;
    ContratoTransporte_IM control;
    private LinkedList<Component> c = new LinkedList<Component>();
    //private LinkedList<EstructuraVehiculo> listaaux = new LinkedList<EstructuraVehiculo>();
    private LinkedList<VehicleDto> listaimpresion = new LinkedList<VehicleDto>();

    public PanelVehiculos(ContratoTransporte_IM atras) {
        initComponents();
        c.add(panelinterno);
        c.add(panel);
        modelo = new DefaultTableModel(new Object[]{"Cod. Contrato", "Chapa", "Marca","Color","Cap. Sin Equip.","Cap. Con Equip.","Cap. Total","Año Fab."}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tabla.setModel(modelo);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        control = atras;
        //int x=control.getWidth() - (2*panelinterno.getX()); //Resta de el ancho del frame - el doble del espacio del panel al borde del frame
        //panelinterno.setBounds(panelinterno.getX(),panelinterno.getY(),x,panelinterno.getHeight());
        siguiente.setEnabled(false);
        if (!control.iG.isInsert()) {
            actualizarvehiculos();
        }
        if (control.iG.isVer()) {
            ver();
        }
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(insertar);
        lista.add(modificar);
        lista.add(eliminar);
        lista.add(cancelar);
        Tools.desactivar(lista);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        panelinterno = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        insertar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        ver = new javax.swing.JButton();

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 740, 10));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, -1));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        panel.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));

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

        panelinterno.setBackground(new java.awt.Color(204, 255, 204));
        panelinterno.setBorder(javax.swing.BorderFactory.createTitledBorder("Vehículos"));
        panelinterno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cod. Contrato", "Chapa", "Marca","Color","Cap. Sin Equip.","Cap. Con Equip.","Cap. Total","Año Fab."
            }

        ));
        jScrollPane1.setViewportView(tabla);

        panelinterno.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 730, 119));

        insertar.setText("Insertar");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });
        panelinterno.add(insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 83, -1));

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        panelinterno.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 83, -1));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        panelinterno.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 82, -1));

        ver.setText("Ver");
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        panelinterno.add(ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        panel.add(panelinterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 770, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        control.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        control.actualizarpanel(control.getTipo() + 1);
    }//GEN-LAST:event_siguienteActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        control.actualizarpanel(control.getTipo() - 1);
    }//GEN-LAST:event_anteriorActionPerformed

    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        Vehiculo_IM a = new Vehiculo_IM(control, true, null, this,'i');
        a.setVisible(true);
        actualizarvehiculos();
    }//GEN-LAST:event_insertarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        if (!Tools.errorselection(tabla, '1', control)) {
            VehicleDto vaux = listaimpresion.get(tabla.getSelectedRow());
            Vehiculo_IM a = new Vehiculo_IM(control, true, vaux, this,'m');
            a.setVisible(true);
            actualizarvehiculos();
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if (!control.iG.isVer()) {
            if (!control.iG.isInsert()) {
                modificarcontratohotel();
            } else {
                control.iG.setEstado(true);
                control.dispose();
            }
        } else {
            control.dispose();
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (!Tools.errorselection(tabla, '2', control)) {
            int pos[] = tabla.getSelectedRows();
            for (int i = 0; i < pos.length; i++) {
                try {
                    ServicesLocator.getContratoTransporteServices().eliminarVehiculo(listaimpresion.get(pos[i]).getChapa());
                } catch (SQLException ex) {
                    Logger.getLogger(PanelVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            actualizarvehiculos();
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        if (!Tools.errorselection(tabla, '1', control)) {
            VehicleDto vaux = listaimpresion.get(tabla.getSelectedRow());
            Vehiculo_IM a = new Vehiculo_IM(control, true, vaux, this,'v');
            a.setVisible(true);
        }
    }//GEN-LAST:event_verActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    public javax.swing.JButton anterior;
    public javax.swing.JButton cancelar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton insertar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton modificar;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelinterno;
    public javax.swing.JButton siguiente;
    public javax.swing.JTable tabla;
    private javax.swing.JButton ver;
    // End of variables declaration//GEN-END:variables
    private void pintartabla(LinkedList<VehicleDto> listavehiculo) {
        Tools.borrartabla(tabla, (DefaultTableModel) tabla.getModel());
        Iterator<VehicleDto> iter = listavehiculo.iterator();

        while (iter.hasNext()) {
            VehicleDto v = iter.next();
            ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{v.getCodigocontrato(), v.getChapa(), v.getMarca(), v.getColor(), v.getCapsinequip(), v.getCapconequip(), v.getCaptotal(), v.getAnnofabricacion()});
        }
    }

    private void actualizarvehiculos() {
        try {
            listaimpresion = ServicesLocator.getContratoTransporteServices().obtenerVehiculosxContrato(control.contrato.getCodigocontrato());
        } catch (SQLException ex) {
            Logger.getLogger(PanelVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

        pintartabla(listaimpresion);
    }

    private void modificarcontratohotel() {
        String codigoaux = control.panelcontrato.txtcodigo.getText();
        Date fechai = Tools.ConDateSql(control.panelcontrato.chooserInicio.getDate());
        Date fechat = Tools.ConDateSql(control.panelcontrato.chooserfin.getDate());
        Date fechac = Tools.ConDateSql(control.panelcontrato.chooserconciliacion.getDate());
        String desc = control.panelcontrato.texto.getContenido();
        String tipo = control.panelcontrato.tipocontrato;

        try {
            ServicesLocator.getContratoTransporteServices().editar((String) control.panelprestario.combonombre.getSelectedItem(), control.contrato.getCodigocontrato(), codigoaux, fechai, fechat, fechac, desc, AgencyDto.get().serial(), tipo);
            Tools.exito(control, "Contrato Transporte", " Modificado");
            control.iG.setEstado(true);
            control.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrestario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

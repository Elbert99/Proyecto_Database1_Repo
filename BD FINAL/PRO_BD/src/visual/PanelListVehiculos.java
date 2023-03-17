/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;
//setToolTipText(title)

import java.awt.Component;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import model.ModeCKDto;
import model.ModeHKDto;
import model.ModeREDto;
import model.ModeTransportDto;
import model.ServiceTransportDto;
import model.VehicleDto;
import services.ServicesLocator;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class PanelListVehiculos extends javax.swing.JPanel {

    private Paquete_IM control;
    private LinkedList<Component> c = new LinkedList<Component>();
    private DefaultTableModel modelovehiculos;
    private DefaultTableModel modelomodalidad;
    private LinkedList<VehicleDto> vehiculos = new LinkedList<VehicleDto>();
    private LinkedList<ModeTransportDto> modalidades = new LinkedList<ModeTransportDto>();
    public VehicleDto vehiculoactual = null;
    public ModeTransportDto modalidadtransporte = null;
    private String title = "Vehículo";
    private String title1 = "Modalidad";

    public PanelListVehiculos(Paquete_IM atras) {
        initComponents();
        c.add(panel);
        c.add(panel1);
        c.add(panel2);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        control = atras;
        modelovehiculos = new DefaultTableModel(new Object[]{"Chapa", "Marca", "Color", "Cap. Total", "Año de Fab.", "Ocupado"}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tablavehiculo.setModel(modelovehiculos);
        modelomodalidad = new DefaultTableModel(new Object[]{"No.", "Tipo de Modalidad"}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        aceptar.setEnabled(false);
        tablamodalidad.setModel(modelomodalidad);
        obtenervehiculos();
        pintarvehiculo();
        if (!control.iG.isInsert()) {
            actualizarventana();
        }
        if (control.iG.isVer()) {
            ver();
        }
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(tablamodalidad);
        lista.add(tablavehiculo);
        Tools.desactivar(lista);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablavehiculo = new javax.swing.JTable();
        panel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablamodalidad = new javax.swing.JTable();

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 350, 10));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        panel.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

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
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Vehículo"));

        tablavehiculo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablavehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablavehiculoMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablavehiculo);

        panel1.setBackground(new java.awt.Color(204, 255, 204));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modalidad"));

        tablamodalidad.setModel(new javax.swing.table.DefaultTableModel(
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
        tablamodalidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablamodalidadMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablamodalidad);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 390, 310));

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
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
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
            if (valido()) {
                control.actualizarpanel(control.getTipo() + 1);
            }
        } else {
            control.actualizarpanel(control.getTipo() + 1);
        }

    }//GEN-LAST:event_siguienteActionPerformed

    private void tablamodalidadMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablamodalidadMouseReleased
        if (!Tools.errorselection(tablamodalidad, '1', control)) {
            modalidadtransporte = modalidades.get(tablamodalidad.getSelectedRow());
            Tools.pintartablapanel(false, null, null, null, true, panel1, title1, modalidadtransporte.getTipomodalidadtransporte());
            InfoModalidad info = new InfoModalidad(control, true, modalidadtransporte);
            info.setVisible(true);
        }
    }//GEN-LAST:event_tablamodalidadMouseReleased

    private void tablavehiculoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablavehiculoMouseReleased
        if (!Tools.errorselection(tablavehiculo, '1', control)) {
            VehicleDto vehiculoaux = vehiculos.get(tablavehiculo.getSelectedRow());
            if (!vehiculoaux.isOcupado()) {//evitar el error en el mismo vehiculo seleccionado
                desocuparvehiculo();
                vehiculoactual = vehiculoaux;
                ocuparvehiculo();
                obtenermodalidades(vehiculoactual.getChapa());
                pintarmodadlidad();
                pintarvehiculo();
                Tools.pintartablapanel(true, tablavehiculo, vehiculos, vehiculoactual, true, panel2, title, null);
            } else {
                JOptionPane.showMessageDialog(control, "Vehiculo Ocupado", "Error de Vehiculo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tablavehiculoMouseReleased

    private void jScrollPane2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseReleased

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed

    }//GEN-LAST:event_aceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    public javax.swing.JButton anterior;
    public javax.swing.JButton cancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    public javax.swing.JButton siguiente;
    public javax.swing.JTable tablamodalidad;
    public javax.swing.JTable tablavehiculo;
    // End of variables declaration//GEN-END:variables
    private void obtenervehiculos() {
        try {
            LinkedList<ServiceTransportDto> serviciostransporte = ServicesLocator.getContratoTransporteServices().obtenerServiciosTransporte();
            Iterator<ServiceTransportDto> iter = serviciostransporte.iterator();
            while (iter.hasNext()) {
                VehicleDto vehiculo = ServicesLocator.getContratoTransporteServices().obtenerVehiculoChapa(iter.next().getChapavehiculo());
                vehiculos.add(vehiculo);
//                if (!vehiculo.isOcupado()) {
//                    vehiculos.add(vehiculo);
//                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelListVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pintarvehiculo() {
        Tools.borrartabla(tablavehiculo, modelovehiculos);
        Iterator<VehicleDto> iter = vehiculos.iterator();
        while (iter.hasNext()) {
            VehicleDto v = iter.next();
            modelovehiculos.addRow(new Object[]{v.getChapa(), v.getMarca(), v.getColor(), v.getCaptotal(), v.getAnnofabricacion(), v.isOcupado() ? "Si" : "No"});
        }
    }

    private void actualizarventana() {
        obtenervehiculo();
        Tools.pintartablapanel(true, tablavehiculo, vehiculos, vehiculoactual, true, panel2, title, null);
        obtenermodalidades(vehiculoactual.getChapa());
        pintarmodadlidad();
        Tools.pintartablapanel(false, null, null, null, true, panel1, title1, control.panelprogramapaquete.programapaquete.getTipomodalidadtrasporte());
    }

    private void obtenervehiculo() {
        try {
            vehiculoactual = ServicesLocator.getContratoTransporteServices().obtenerVehiculoChapa(control.panelprogramapaquete.programapaquete.getChapavehiculo());
            System.out.println(vehiculoactual.getChapa());
        } catch (SQLException ex) {
            Logger.getLogger(PanelListVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void obtenermodalidades(String chapa) {
        modalidades.clear();
        try {
            ModeCKDto mck = ServicesLocator.getContratoTransporteServices().obtenerModalidadCostoKmxVehiculo(chapa);
            ModeHKDto mh = ServicesLocator.getContratoTransporteServices().obtenerModalidadHoraKmxVehiculo(chapa);
            LinkedList<ModeREDto> lista = ServicesLocator.getContratoTransporteServices().obtenerModalidadesRecorridoxVehiculo(chapa);
            if (mck != null) {
                modalidades.add(mck);
            }
            if (mh != null) {
                modalidades.add(mh);
            }
            if (lista.size() > 0) {
                modalidades.addAll(lista);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelListVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pintarmodadlidad() {
        modalidadtransporte = null;
        Tools.borrartabla(tablamodalidad, modelomodalidad);
        Iterator<ModeTransportDto> iter = modalidades.iterator();
        int i = 0;
        while (iter.hasNext()) {
            ModeTransportDto mod = iter.next();
            modelomodalidad.addRow(new Object[]{++i, mod.getTipomodalidadtransporte()});
        }
    }

    private boolean valido() {
        boolean result = vehiculoactual != null && modalidadtransporte != null;
        if (!result) {
            Tools.errordate(control);
        }
        return result;
    }

    private void desocuparvehiculo() {
        if (vehiculoactual != null) {
            vehiculoactual.setOcupado(false);
        }
    }

    private void ocuparvehiculo() {
        if (vehiculoactual != null) {
            vehiculoactual.setOcupado(true);
        }
    }
}

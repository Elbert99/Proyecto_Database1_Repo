/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import model.HotelDto;
import model.PlainRoomFoodDto;
import model.ServiceLodginDto;
import services.ServicesLocator;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class PanelHotelPlan extends javax.swing.JPanel {

    private Paquete_IM control;
    private DefaultTableModel modelohoteles;
    private DefaultTableModel modeloplanes;
    private LinkedList<Component> c = new LinkedList<Component>();
    private LinkedList<HotelDto> hoteles = new LinkedList<HotelDto>();
    public HotelDto hotelactual = null;
    private LinkedList<PlainRoomFoodDto> planes = new LinkedList<PlainRoomFoodDto>();
    public PlainRoomFoodDto plan = null;
    private LinkedList<ServiceLodginDto> serviciosalojamientos = new LinkedList<ServiceLodginDto>();
    private String codigocontrato;
    private String title = "Hotel";
    private String title1 = "Plan";

    public PanelHotelPlan(Paquete_IM atras) {
        initComponents();
        c.add(panel);
        c.add(panel1);
        c.add(panel2);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        control = atras;
        modelohoteles = new DefaultTableModel(new Object[]{"Nombre", "Cadena Hot.", "Provincia", "Categoría", "Localización"}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tablahoteles.setModel(modelohoteles);
        modeloplanes = new DefaultTableModel(new Object[]{"Tipo Hab.", "Tipo Alim.", "Precio"}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tablaplanes.setModel(modeloplanes);
        aceptar.setEnabled(false);
        obtenerhoteles();
        pintarhoteles();
        if (!control.iG.isInsert()) {
            actualizarventana();
        }
        if (control.iG.isVer()) {
            ver();
        }
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(tablahoteles);
        lista.add(tablaplanes);
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
        tablahoteles = new javax.swing.JTable();
        panel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaplanes = new javax.swing.JTable();

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 500, 10));

        aceptar.setText("Aceptar");
        panel.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, -1, -1));

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
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hotel"));

        tablahoteles.setModel(new javax.swing.table.DefaultTableModel(
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
        tablahoteles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablahotelesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablahoteles);

        panel1.setBackground(new java.awt.Color(204, 255, 204));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Plan"));

        tablaplanes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaplanes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaplanesMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablaplanes);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)))
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

        panel.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 520, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
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
        }else
            control.actualizarpanel(control.getTipo() + 1);
    }//GEN-LAST:event_siguienteActionPerformed

    private void tablaplanesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaplanesMouseReleased
        if (!Tools.errorselection(tablaplanes, '1', control)) {
            plan = planes.get(tablaplanes.getSelectedRow());
            Tools.pintartablapanel(false, null, null, plan, true, panel1, title1, null);
        }
    }//GEN-LAST:event_tablaplanesMouseReleased

    private void tablahotelesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablahotelesMouseReleased
        if (!Tools.errorselection(tablahoteles, '1', control)) {
            hotelactual = hoteles.get(tablahoteles.getSelectedRow());
            Tools.pintartablapanel(false, null, null, hotelactual, true, panel2, title, null);
            actualizarcodigocontrato(hotelactual.getNombre());
            obtenerplanes();
            pintarplanes();
        }
    }//GEN-LAST:event_tablahotelesMouseReleased


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
    public javax.swing.JTable tablahoteles;
    public javax.swing.JTable tablaplanes;
    // End of variables declaration//GEN-END:variables
   private void obtenerhoteles() {
        try {
            serviciosalojamientos = ServicesLocator.getContratoHotelServices().obtenerServiciosAlojamiento();
            Iterator<ServiceLodginDto> iter = serviciosalojamientos.iterator();
            while (iter.hasNext()) {
                hoteles.add(ServicesLocator.getHotelServices().obtenerHotelNombre(iter.next().getNombrehotel()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelListVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pintarhoteles() {
        Tools.borrartabla(tablahoteles, modelohoteles);
        Iterator<HotelDto> iter = hoteles.iterator();
        while (iter.hasNext()) {
            HotelDto ho = iter.next();
            modelohoteles.addRow(new Object[]{ho.getNombre(), ho.getCadenahotelera(), ho.getProvincia(), ho.getCategoria(), ho.getLocalizacion()});
        }
    }

    private void obtenerplanes() {
        try {
            planes = ServicesLocator.getContratoHotelServices().obtenerPlanesHAxContratoHotel(codigocontrato);
        } catch (SQLException ex) {
            Logger.getLogger(PanelHotelPlan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pintarplanes() {
        plan = null;
        Tools.borrartabla(tablaplanes, modeloplanes);
        Iterator<PlainRoomFoodDto> iter = planes.iterator();
        while (iter.hasNext()) {
            PlainRoomFoodDto pha = iter.next();
            modeloplanes.addRow(new Object[]{pha.getTipohabitacion(), pha.getTipoalimento(), pha.getPrecio()});
        }
    }

    private void actualizarcodigocontrato(String nombrehotel) {
        Iterator<ServiceLodginDto> iter = serviciosalojamientos.iterator();
        boolean salir = true;
        while (iter.hasNext() && salir) {
            ServiceLodginDto sa = iter.next();
            if (sa.getNombrehotel().equals(nombrehotel)) {
                codigocontrato = sa.getCodigocontratohotel();
                salir = false;
            }
        }
    }

    private void actualizarventana() {
        try {
            hotelactual = ServicesLocator.getHotelServices().obtenerHotelNombre(control.panelprogramapaquete.programapaquete.getNombrehotel());
            Tools.pintartablapanel(true, tablahoteles, hoteles, hotelactual, true, panel2, title, null);
            actualizarcodigocontrato(hotelactual.getNombre());
            obtenerplanes();
            pintarplanes();
            Tools.pintartablapanel(false, null, null, null, true, panel1, title1, control.panelprogramapaquete.programapaquete.getTipohabitacion() + "-" + control.panelprogramapaquete.programapaquete.getTipoalimento());
        } catch (SQLException ex) {
            Logger.getLogger(PanelHotelPlan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean valido() {
        boolean result = hotelactual != null && plan != null;
        if (!result) {
            Tools.errordate(control);
        }
        return result;
    }

}

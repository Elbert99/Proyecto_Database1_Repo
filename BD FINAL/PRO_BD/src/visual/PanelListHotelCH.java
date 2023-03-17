/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import model.HotelDto;
import model.ServiceLodginDto;
import services.ServicesLocator;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class PanelListHotelCH extends javax.swing.JPanel {

    DefaultTableModel modelo;
    private ContratoHotel_IM control;
    private LinkedList<Component> c = new LinkedList<Component>();
    HotelDto hotelactual = null;
    private LinkedList<HotelDto> listahoteles = new LinkedList<HotelDto>();
    private String title = "Hotel";

    public PanelListHotelCH(ContratoHotel_IM atras) {
        initComponents();
        c.add(this);
        c.add(panel2);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        control = atras;
        modelo = new DefaultTableModel(new Object[]{"Nombre", "Provincia"}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tabla.setModel(modelo);
        obtenerlistahoteles();
        pinterhoteles();
        aceptar.setEnabled(false);
        if (!control.iG.isInsert()) {
            seleccionarhotel();
        }
        if (control.iG.isVer()) {
            ver();
        }
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(tabla);
        Tools.desactivar(lista);
    }

    private boolean errorselection(JTable table) {
        boolean result = false;
        if (table.getSelectedRowCount() != 1) {
            result = true;
            JOptionPane.showMessageDialog(this, "Seleccione una casilla", "Error en seleción", JOptionPane.ERROR_MESSAGE);
            table.clearSelection();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 320, 10));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        aceptar.setText("Aceptar");
        add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        siguiente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        siguiente.setText(">");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        anterior.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        anterior.setText("<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hotel"));

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

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 340, 170));
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        if (!control.iG.isVer()) {
            if (valido()) {
                control.actualizarpanel(control.getTipo() + 1);
            }
        } else {
            control.actualizarpanel(control.getTipo() + 1);
        }
    }//GEN-LAST:event_siguienteActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        control.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        control.actualizarpanel(control.getTipo() - 1);
    }//GEN-LAST:event_anteriorActionPerformed

    private void tablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseReleased
        if (Tools.errorselection(tabla, '1', control)) {
            hotelactual = listahoteles.get(tabla.getSelectedRow());
            Tools.pintartablapanel(false, null, null, hotelactual, true, panel2, title, null);
        }
    }//GEN-LAST:event_tablaMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    public javax.swing.JButton anterior;
    public javax.swing.JButton cancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panel2;
    public javax.swing.JButton siguiente;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    private boolean valido() {
        boolean result = hotelactual != null;
        if (!result) {
            Tools.errordate(control);
        }
        return result;
    }

    private void obtenerlistahoteles() {
        try {
            listahoteles = ServicesLocator.getHotelServices().obtener();
        } catch (SQLException ex) {
            Logger.getLogger(PanelListHotelCH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pinterhoteles() {
        Tools.borrartabla(tabla, modelo);
        Iterator<HotelDto> iter = listahoteles.iterator();
        while (iter.hasNext()) {
            HotelDto h = iter.next();
            modelo.addRow(new Object[]{h.getNombre(), h.getProvincia()});
        }
    }

    private void seleccionarhotel() {
        ServiceLodginDto sa = null;
        try {
            sa = ServicesLocator.getContratoHotelServices().obtenerServicioAlojamientoxContrato(control.contrato.getCodigocontrato());
        } catch (SQLException ex) {
            Logger.getLogger(PanelListHotelCH.class.getName()).log(Level.SEVERE, null, ex);
        }
        hotelactual = (HotelDto) Tools.obtenerObjeto(Tools.GenericConvertObject(listahoteles), sa.getNombrehotel());
        Tools.pintartablapanel(true, tabla, listahoteles, hotelactual, true, panel2, title, null);
    }

}

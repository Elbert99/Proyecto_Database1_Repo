/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument;
import model.SeasonDto;
import model.TypeSeasonDto;
import services.ServicesLocator;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class PanelTempCH extends javax.swing.JPanel {

    private ContratoHotel_IM control;
    Texto_IM texto;
    private LinkedList<Component> c = new LinkedList<Component>();
    private SeasonDto temporadaactual;
    private LinkedList<TypeSeasonDto> listatemporada = new LinkedList<TypeSeasonDto>();
    private LinkedList<String> listanombres = new LinkedList<>();
    private DefaultComboBoxModel modelo;

    public PanelTempCH(ContratoHotel_IM atras) {
        initComponents();
        c.add(this);
        c.add(panel2);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        control = atras;
        texto = new Texto_IM(control, true, "", "Gestionar Descripción", control.iG.isVer());
        aceptar.setEnabled(false);
        obtenerlistatemporada();
        crearmodelo();
        comboTemporada.setModel(modelo);
        if (!control.iG.isInsert()) {
            settemporada();
        } else {
            actualizarchosser();
        }
        if (control.iG.isVer()) {
            ver();
        }
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(comboTemporada);
        lista.add(choserinicio);
        lista.add(choserfin);
        Tools.desactivar(lista);
    }

    private boolean valido(String d) {
        boolean bd = Tools.isAlpha(d, false, 5, -1);
        if (!bd) {
            Tools.errordate(control);
        }
        return bd;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabla = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboTemporada = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        choserinicio = new com.toedter.calendar.JDateChooser();
        choserfin = new com.toedter.calendar.JDateChooser();
        editar = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();

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

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 300, 10));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, -1));

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Temporada"));

        jLabel2.setText("Nombre:");

        comboTemporada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Fecha Inicio:");

        jLabel4.setText("Fecha Fin:");

        jLabel5.setText("Descripción:");

        editar.setText("Editar Descripción");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboTemporada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choserfin, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choserinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choserinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choserfin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editar)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 340, 200));

        anterior.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        anterior.setText("<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        siguiente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        siguiente.setText(">");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        control.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed

        texto.setContenido(texto.getContenido());
        texto.setVisible(true);

    }//GEN-LAST:event_editarActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        control.actualizarpanel(control.getTipo() - 1);
    }//GEN-LAST:event_anteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        if (!control.iG.isVer()) {
            if (valido(texto.getContenido())) {
                control.actualizarpanel(control.getTipo() + 1);
            }
        } else {
            control.actualizarpanel(control.getTipo() + 1);
        }
    }//GEN-LAST:event_siguienteActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed

    }//GEN-LAST:event_aceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    public javax.swing.JButton anterior;
    public javax.swing.JButton cancelar;
    public com.toedter.calendar.JDateChooser choserfin;
    public com.toedter.calendar.JDateChooser choserinicio;
    public javax.swing.JComboBox<String> comboTemporada;
    private javax.swing.JButton editar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panel2;
    public javax.swing.JButton siguiente;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    private void obtenerlistatemporada() {
        try {
            listatemporada = ServicesLocator.getContratoHotelServices().obtenerTiposTemporada();
        } catch (SQLException ex) {
            Logger.getLogger(PanelTempCH.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<TypeSeasonDto> iter = listatemporada.iterator();
        while (iter.hasNext()) {
            listanombres.add(iter.next().getNombretemporada());
        }
    }

    private void settemporada() {
        try {
            temporadaactual = ServicesLocator.getContratoHotelServices().obtenerTemporadaxContratoHotel(control.contrato.getCodigocontrato());
        } catch (SQLException ex) {
            Logger.getLogger(PanelTempCH.class.getName()).log(Level.SEVERE, null, ex);
        }
        comboTemporada.setSelectedItem(temporadaactual.getNombretemporada());
        choserinicio.setDate(temporadaactual.getFechainicio());
        choserfin.setDate(temporadaactual.getFechafin());
        texto.setContenido(temporadaactual.getDescripciontemporada());
    }

    private void actualizarchosser() {
        Tools.chsosser(choserinicio);
        Tools.chsosser(choserfin);
    }

    private void crearmodelo() {
        modelo = new DefaultComboBoxModel(listanombres.toArray());
    }
}

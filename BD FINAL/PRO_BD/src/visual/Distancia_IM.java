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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import model.DistanceDto;
import model.RoleDto;
import services.ServicesLocator;
import utils.Tools;
import utils.Tools;
import utils.GestorInterface;

/**
 *
 * @author Victor
 */
public class Distancia_IM extends javax.swing.JDialog {

    private DistanceDto distancia;
    private GestorInterface iG;
    private final String idtitle = " Distancia";
    private LinkedList<Component> c = new LinkedList<Component>();
    private LinkedList<String> provincias;
    DefaultComboBoxModel modelo;
    DefaultComboBoxModel modelo1;

    public Distancia_IM(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        c.add(panel);
        c.add(panel2);
        obtenerprovincias();
        modelo = new DefaultComboBoxModel(provincias.toArray());
        modelo1 = new DefaultComboBoxModel(provincias.toArray());
        comboProvinciaFinal.setModel(modelo);
        comboProvinciaInicial.setModel(modelo1);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        setBounds(Tools.center(this.getWidth(), this.getHeight()));
        setResizable(false);
    }
//  Get y Set   

    private DistanceDto getDistancia() {
        return distancia;
    }

    private void setDistancia(DistanceDto distancia) {
        this.distancia = distancia;
        refreshcomponents(distancia);
    }
//  Logica

    public void mostrar() {
        crearinterface();
        refresh();
        setVisible(true);
    }

    private void refresh() {
        Tools.setTitulo(this, iG.getTipo(), idtitle);
        if (!iG.isInsert()) {
            actualizarinstanciatabla(iG.getObjetoactual());
        }
        if (iG.isVer()) {
            ver();
        }
    }

    private void actualizarinstanciatabla(Object objetoactual) {
        setDistancia((DistanceDto) objetoactual);
    }

    private void refreshcomponents(DistanceDto distancia) {
        comboProvinciaInicial.setSelectedItem(distancia.getProvinciaInicial());
        comboProvinciaFinal.setSelectedItem(distancia.getProvinciaFinal());
        dist.setText(String.valueOf(distancia.getDistanciakm()));
        comboProvinciaFinal.setEnabled(false);
        comboProvinciaInicial.setEnabled(false);
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(comboProvinciaInicial);
        lista.add(comboProvinciaFinal);
        lista.add(dist);
        lista.add(cancelar);
        Tools.desactivar(lista);
    }

    private void crearinterface() {
        iG = GestorArchivoGenerico.getInstance();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboProvinciaInicial = new javax.swing.JComboBox<>();
        comboProvinciaFinal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dist = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBackground(new java.awt.Color(204, 255, 204));

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Provincia Inicial:");
        panel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel2.setText("Provincia Final:");
        panel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        comboProvinciaInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel2.add(comboProvinciaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 180, -1));

        comboProvinciaFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProvinciaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProvinciaFinalActionPerformed(evt);
            }
        });
        panel2.add(comboProvinciaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 181, -1));

        jLabel3.setText("Distancia:");
        panel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        panel2.add(dist, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 170, -1));

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

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(aceptar)
                                .addGap(27, 27, 27)
                                .addComponent(cancelar)
                                .addGap(21, 21, 21))))
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if (!iG.isVer()) {
            if (valido(dist.getText(), (String) comboProvinciaInicial.getSelectedItem(), (String) comboProvinciaFinal.getSelectedItem())) {
                String ini = (String) comboProvinciaInicial.getSelectedItem();
                String fin = (String) comboProvinciaFinal.getSelectedItem();
                float dato = Float.parseFloat(dist.getText());
                if (iG.isInsert()) {
                    try {
                        ServicesLocator.getDistanciaServices().insertar(ini, fin, dato);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
                    }
                    iG.setEstado(true);
                } else {
                    try {
                        ServicesLocator.getDistanciaServices().editar(ini, fin, dato);
                    } catch (SQLException ex) {
                        Logger.getLogger(Distancia_IM.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    iG.setEstado(true);
                }
            }
        }
        dispose();
    }//GEN-LAST:event_aceptarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void comboProvinciaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProvinciaFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProvinciaFinalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> comboProvinciaFinal;
    private javax.swing.JComboBox<String> comboProvinciaInicial;
    private javax.swing.JTextField dist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel2;
    // End of variables declaration//GEN-END:variables

    private void obtenerprovincias() {
        try {
            provincias = ServicesLocator.getDistanciaServices().obtenerProvincias();
        } catch (SQLException ex) {
            Logger.getLogger(Distancia_IM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean valido(String text, String s1, String s2) {
        boolean m = Tools.isFlotante(text, false, 0, false, 0) || Tools.isNumeric(text, true, false, 0, false, 0);
        boolean string = !s1.equals(s2);
        boolean result = m && string;
        if (!result) {
            Tools.errordate(this);
        }
        return result;
    }
}

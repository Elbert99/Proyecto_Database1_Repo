/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.AgencyDto;
import model.PlainRoomFoodDto;
import model.ModeREDto;
import model.ServiceLodginDto;
import services.ServicesLocator;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class PanelHabitacionAlimento extends javax.swing.JPanel implements MouseListener {

    private DefaultTableModel modelo;
    private ContratoHotel_IM control;
    LinkedList<PlainRoomFoodDto> planes = new LinkedList<PlainRoomFoodDto>();
    private LinkedList<Component> c = new LinkedList<Component>();

    private DefaultComboBoxModel modelohabitacion;
    private DefaultComboBoxModel modeloalimento;

    private boolean modificar; //Indicar que se va a Modificar con true
    private JTextField refprecio;

    public PanelHabitacionAlimento(ContratoHotel_IM atras) {
        initComponents();
        c.add(panel);
        c.add(panel2);
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
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        control = atras;
        modelo = new DefaultTableModel(new Object[]{"Tipo Hab.", "Tipo Alim.", "Precio"}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tabla.setModel(modelo);
        tabla.addMouseListener(this);

        crearmodelos();

        habitacion.setModel(modelohabitacion);
        alimento.setModel(modeloalimento);
        siguiente.setEnabled(false);

        if (!control.iG.isInsert()) {
            setlistaplanes();
        }
        if (control.iG.isVer()) {
            ver();
        }
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(habitacion);
        lista.add(alimento);
        lista.add(precio);
        lista.add(insertar);
        lista.add(eliminar);
        lista.add(cancelar);
        Tools.desactivar(lista);
    }

    public boolean valido() {
        boolean result = planes.size() > 0;
        if (!result) {
            Tools.errordate(control);
        }
        return result;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        habitacion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        alimento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        insertar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        precio = new javax.swing.JSpinner();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 360, 330, 10));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        panel.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Alojamiento"));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre de Habitación:");
        panel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 46, -1, -1));

        habitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel2.add(habitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 46, 140, -1));

        jLabel3.setText("Nombre de Pensión:");
        panel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 86, -1, -1));

        alimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel2.add(alimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 86, 140, -1));

        jLabel4.setText("Precio:");
        panel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 132, -1, -1));

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

        panel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 182, 239, 88));

        insertar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        insertar.setText("+");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });
        panel2.add(insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 192, 44, -1));

        eliminar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        eliminar.setText("-");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        panel2.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 232, 44, -1));

        precio.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioKeyTyped(evt);
            }
        });
        panel2.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 130, -1));

        panel.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 360, 300));

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
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
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
        control.actualizarpanel(control.getTipo() - 1);
    }//GEN-LAST:event_anteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed

    }//GEN-LAST:event_siguienteActionPerformed

    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        String habit = (String) habitacion.getSelectedItem();
        String alim = (String) alimento.getSelectedItem();
        float preciov = (float)precio.getValue();
        PlainRoomFoodDto o = new PlainRoomFoodDto("", habit, alim, preciov);
        if (modificar) {
            if (confirmar() && valido(o, tabla.getSelectedRow())) {
                planes.set(tabla.getSelectedRow(), o);
            }
            tabla.clearSelection();
        } else {
            if (valido(o, -1)) {
                planes.add(o);
            }
        }

        llenarmodelo();
    }//GEN-LAST:event_insertarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (!Tools.errorselection(tabla, '2', control)) {
            if (Tools.confirmar(control)) {
                Tools.eliminar(tabla.getSelectedRows(), planes);
                llenarmodelo();
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void tablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseReleased
        modificar = true;
        cargar(planes.get(tabla.getSelectedRow()));
    }//GEN-LAST:event_tablaMouseReleased

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if (!control.iG.isVer()) {
            if (valido()) {
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
            }
        } else {
            control.dispose();
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyTyped
        Tools.flotante(evt, refprecio, 10);
    }//GEN-LAST:event_precioKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    private javax.swing.JComboBox<String> alimento;
    public javax.swing.JButton anterior;
    public javax.swing.JButton cancelar;
    private javax.swing.JButton eliminar;
    private javax.swing.JComboBox<String> habitacion;
    private javax.swing.JButton insertar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel2;
    private javax.swing.JSpinner precio;
    public javax.swing.JButton siguiente;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void llenarmodelo() {  //Actualizar la tabla
        Tools.borrartabla(tabla, modelo);
        Iterator<PlainRoomFoodDto> iter = planes.iterator();
        while (iter.hasNext()) {
            PlainRoomFoodDto o = iter.next();
            modelo.addRow(new Object[]{o.getTipohabitacion(), o.getTipoalimento(), o.getPrecio()});
        }
        modificar = false;
        resetinterfaz();
    }

    public void cargar(PlainRoomFoodDto o) {//Actualizar Interfaz
        habitacion.setSelectedItem(o.getTipohabitacion());
        alimento.setSelectedItem(o.getTipoalimento());
        precio.setValue(o.getPrecio());
    }

    private boolean confirmar() {
        return JOptionPane.showConfirmDialog(this, "Está seguro/a de modificar", "Informacion", JOptionPane.YES_NO_OPTION) == 0;
    }

    //Validar que no este repetida la combinacion de alimento-habitacion menos en la pos
    private boolean valido(PlainRoomFoodDto o, int pos) {
        boolean result = true;
        for (int i = 0; i < planes.size() && result; i++) {
            if (i != pos && planes.get(i).getTipoalimento().equals(o.getTipoalimento()) && planes.get(i).getTipohabitacion().equals(o.getTipohabitacion())) {
                result = false;
            }
        }
        if (!result) {
            JOptionPane.showMessageDialog(control, "Ya Existe Esta Combinación", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    private void resetinterfaz() {
        refprecio.setText("0.0");
    }

    private void crearmodelos() {
        try {
            modelohabitacion = new DefaultComboBoxModel(ServicesLocator.getContratoHotelServices().obtenerHabitaciones().toArray());
            modeloalimento = new DefaultComboBoxModel(ServicesLocator.getContratoHotelServices().obtenerAlimentos().toArray());
        } catch (SQLException ex) {
            Logger.getLogger(PanelHabitacionAlimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setlistaplanes() {
        try {
            planes = ServicesLocator.getContratoHotelServices().obtenerPlanesHAxContratoHotel(control.contrato.getCodigocontrato());
        } catch (SQLException ex) {
            Logger.getLogger(PanelHabitacionAlimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        pintarplanes();
    }

    private void pintarplanes() {
        Tools.borrartabla(tabla, modelo);
        Iterator<PlainRoomFoodDto> iter = planes.iterator();
        while (iter.hasNext()) {
            PlainRoomFoodDto aux = iter.next();
            modelo.addRow(new Object[]{aux.getTipohabitacion(), aux.getTipoalimento(), aux.getPrecio()});
        }
    }

    //CREAR CONTRATO HOTEL
    private void insertarbd() {
        insertarcontratohotel();
    }

    private void insertarcontratohotel() {
        String codigoaux = control.panelcontrato.txtcodigo.getText();
        Date fechai = Tools.ConDateSql(control.panelcontrato.chooserInicio.getDate());
        Date fechat = Tools.ConDateSql(control.panelcontrato.chooserfin.getDate());
        Date fechac = Tools.ConDateSql(control.panelcontrato.chooserconciliacion.getDate());
        String desc = control.panelcontrato.texto.getContenido();
        String tipo = control.panelcontrato.tipocontrato;
        try {
            ServicesLocator.getContratoHotelServices().insertar(codigoaux, fechai, fechat, fechac, desc, AgencyDto.get().serial(), tipo);
            insertarservicioalojamiento(); //Lanza Excepcion si existe otro hotel 
            insertartemporada();
            insertarplanes();
            Tools.exito(control, "Contrato Hotel", " Insertado");
            control.iG.setEstado(true);
            control.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PanelHabitacionAlimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            Tools.existe(control, "Existe esta Ocurrencia de Servicio Alojamiento en el Sistema");
        }
    }

    private void insertarservicioalojamiento() throws Exception {
        String nombre = control.panelhotel.hotelactual.getNombre();
        String codigo = control.panelcontrato.txtcodigo.getText();
        try {
            if (!ServicesLocator.getContratoHotelServices().existeServicioAlojemientoHotel(nombre)) {
                ServicesLocator.getContratoHotelServices().insertarServicioAlojamiento(true, codigo, nombre);
            } else {// si existe otro hotel en otro contrato eliminar el contrato y notificar
                ServicesLocator.getAgenciaServices().eliminarContrato(codigo);//delete contrato
                throw new Exception("Eliminar y Parar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelHabitacionAlimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertartemporada() {
        String codigo = control.panelcontrato.txtcodigo.getText();
        String nombre = (String) control.paneltemporada.comboTemporada.getSelectedItem();
        Date fechai = Tools.ConDateSql(control.paneltemporada.choserinicio.getDate());
        Date fechaf = Tools.ConDateSql(control.paneltemporada.choserfin.getDate());
        String desc = control.paneltemporada.texto.getContenido();
        try {
            ServicesLocator.getContratoHotelServices().insertarTemporada(fechai, fechaf, desc, codigo, nombre);
        } catch (SQLException ex) {
            Logger.getLogger(PanelHabitacionAlimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertarplanes() {
        Iterator<PlainRoomFoodDto> iter = control.panelhabitacion.planes.iterator();
        String codigo = control.panelcontrato.txtcodigo.getText();
        while (iter.hasNext()) {
            PlainRoomFoodDto o = iter.next();
            try {
                ServicesLocator.getContratoHotelServices().insertarPlanHabitacionAlimento(codigo, o.getTipohabitacion(), o.getTipoalimento(), o.getPrecio());
            } catch (SQLException ex) {
                Logger.getLogger(PanelHabitacionAlimento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //******MODIFICAR BD***************
    private void modificarBd() {
        modificarcontratohotel();
    }

    private void modificarcontratohotel() {
        String codigoid = control.panelcontrato.contrato.getCodigocontrato();
        String codigoaux = control.panelcontrato.txtcodigo.getText();
        Date fechai = Tools.ConDateSql(control.panelcontrato.chooserInicio.getDate());
        Date fechat = Tools.ConDateSql(control.panelcontrato.chooserfin.getDate());
        Date fechac = Tools.ConDateSql(control.panelcontrato.chooserconciliacion.getDate());
        String desc = control.panelcontrato.texto.getContenido();
        String tipo = control.panelcontrato.tipocontrato;
        try {
            ServicesLocator.getContratoHotelServices().editar(codigoid, codigoaux, fechai, fechat, fechac, desc, AgencyDto.get().serial(), tipo);
            modificarservicioalojamiento();
            modificartemporada();
            modificarplanes();
            Tools.exito(control, "Contrato Hotel", "Modificado");
            control.iG.setEstado(true);
            control.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PanelHabitacionAlimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            Tools.existe(control, "Existe esta Ocurrencia de Servicio Alojamiento en el Sistema");

        }
    }

    private void modificarservicioalojamiento() throws Exception {
        String codigoid = control.panelcontrato.txtcodigo.getText();
        String nombre = control.panelhotel.hotelactual.getNombre();
        try {
            ServiceLodginDto sa = ServicesLocator.getContratoHotelServices().obtenerServicioAlojamientoxContrato(codigoid);
            String nombreaux = sa.getNombrehotel();
            if (!nombre.equals(nombreaux)) {
                if (!ServicesLocator.getContratoHotelServices().existeServicioAlojemientoHotel(nombre)) {
                    ServicesLocator.getContratoHotelServices().editarServicioAlojamiento(sa.getSerial_servicioalojamiento(), true, nombre);
                } else {
                    throw new Exception("ERROR");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelHabitacionAlimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificartemporada() {
        String codigo = control.panelcontrato.txtcodigo.getText();
        String nombre = (String) control.paneltemporada.comboTemporada.getSelectedItem();
        Date fechai = Tools.ConDateSql(control.paneltemporada.choserinicio.getDate());
        Date fechaf = Tools.ConDateSql(control.paneltemporada.choserfin.getDate());
        String desc = control.paneltemporada.texto.getContenido();
        try {
            ServicesLocator.getContratoHotelServices().insertarTemporada(fechai, fechaf, desc, codigo, nombre);
        } catch (SQLException ex) {
            Logger.getLogger(PanelHabitacionAlimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarplanes() {
        try {
            ServicesLocator.getContratoHotelServices().eliminarPlanesxContrato(control.panelcontrato.txtcodigo.getText());
            Iterator<PlainRoomFoodDto> iter = control.panelhabitacion.planes.iterator();
            String codigo = control.panelcontrato.txtcodigo.getText();
            while (iter.hasNext()) {
                PlainRoomFoodDto o = iter.next();
                ServicesLocator.getContratoHotelServices().insertarPlanHabitacionAlimento(codigo, o.getTipohabitacion(), o.getTipoalimento(), o.getPrecio());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelHabitacionAlimento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

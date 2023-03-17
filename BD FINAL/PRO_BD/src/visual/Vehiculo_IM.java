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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.ModeCKDto;
import model.ModeHKDto;
import model.ModeREDto;
import model.ModeTransportDto;
import model.VehicleDto;
import services.ServicesLocator;
import utils.Colores;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class Vehiculo_IM extends javax.swing.JDialog {

    private String[] listacolores = new String[]{"Azul", "Rojo", "Verde", "Negro", "Blanco", "Naranja", "Violeta", "Rozado"};
    private String idtitle = "Vehículo";
    DefaultComboBoxModel color;
    private DefaultTableModel modelokm;
    private DefaultTableModel modelohoras;
    private DefaultTableModel modelorecorrido;

    private ModeCKDto datoskm = null;
    int pk = -1;
    private ModeHKDto datoshoras = null;
    int ph = -1;
    private LinkedList<ModeREDto> listarecestab = new LinkedList<ModeREDto>();

    private LinkedList<Component> c = new LinkedList<Component>();
    public VehicleDto vehiculo;
    public LinkedList<String> listamodalidades = new LinkedList<String>();
    private LinkedList<Integer> listaposciones = new LinkedList<Integer>();
    PanelVehiculos panelatras;
    private JTextField refcapsinequip;
    private JTextField refcapconequip;
    private JTextField refcaptotal;
    private JTextField refannofab;
    private boolean bver = false;
    
    public Vehiculo_IM(JDialog parent, boolean modal, VehicleDto v, PanelVehiculos panelaux, char tb) {
        super(parent, modal);
        initComponents();
        panelatras = panelaux;
        int tt = 0;
        switch (tb){
            case 'v':tt=1;bver=true;
            break;
            case 'i':tt=2;
            break;
            case 'm':tt=3;
            break;
        }
        Tools.setTitulo(this, tt, idtitle);

        refannofab = ((JSpinner.DefaultEditor) annofab.getEditor()).getTextField();
        refannofab.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.digit(e, refannofab, 4);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        refcaptotal = ((JSpinner.DefaultEditor) captotal.getEditor()).getTextField();
        refcaptotal.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.digit(e, refcaptotal, 2);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        refcapconequip = ((JSpinner.DefaultEditor) capconequip.getEditor()).getTextField();
        refcapconequip.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.digit(e, refcapconequip, 2);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        refcapsinequip = ((JSpinner.DefaultEditor) capsinequip.getEditor()).getTextField();
        refcapsinequip.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.digit(e, refcapsinequip, 2);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        c.add(panel);
        c.add(panel1);
        c.add(panel2);
        c.add(checkchk);
        c.add(checkckm);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        setBounds(Tools.center(this.getWidth(), this.getHeight()));
        setResizable(false);
        obtenerlistamodalidades();
        modelokm = new DefaultTableModel(new Object[]{"Costo Km", "Costo Km ida vuelta", "Costo Horas Esp."}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        modelohoras = new DefaultTableModel(new Object[]{"Costo Km Recorr.", "Costo Horas", "Costo Km Ext.", "Costo Horas Ext"}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        modelorecorrido = new DefaultTableModel(new Object[]{"Descripcion", "Costo Ida Vuelta", "Costo  Recorrido"}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        color = new DefaultComboBoxModel(listacolores);
        combocolor.setModel(color);
        this.vehiculo = v;
        tablacostokm.setModel(modelokm);
        tablahoras.setModel(modelohoras);
        tablarecorrido.setModel(modelorecorrido);
        if (vehiculo != null) {
            refrescarventana();
        }
        if (panelatras.control.iG.isVer() || tb=='v') {
            ver();
        }
        info();
    }
    private void info(){
        chapa.setToolTipText("formato ejemplo: P987654");
        marca.setToolTipText("(no menos 3 caracteres alfabeticos)");
    }
    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(chapa);
        lista.add(marca);
        lista.add(combocolor);
        lista.add(capsinequip);
        lista.add(capconequip);
        lista.add(captotal);
        lista.add(annofab);
        lista.add(checkckm);
        lista.add(checkchk);
        lista.add(insertar);
        lista.add(modificar);
        lista.add(eliminar);
        lista.add(cancelar);
        Tools.desactivar(lista);
    }

    private void llenarmodelo(DefaultTableModel modelo, ModeTransportDto arr) {
        if (arr instanceof ModeCKDto) {
            ModeCKDto o = (ModeCKDto) arr;
            modelo.addRow(new Object[]{o.getCostokm(), o.getCostokm_idavuelta(), o.getCosto_horasesperas()});
        } else if (arr instanceof ModeHKDto) {
            ModeHKDto o = (ModeHKDto) arr;
            modelo.addRow(new Object[]{o.getCostokm_recorridos(), o.getCosto_horas(), o.getCostokm_extras(), o.getCostohoras_extras()});
        } else if (arr instanceof ModeREDto) {
            Tools.borrartabla(tablarecorrido, modelorecorrido);
            Iterator<ModeREDto> iter = listarecestab.iterator();
            while (iter.hasNext()) {
                ModeREDto o = iter.next();
                modelo.addRow(new Object[]{o.getDescripcion(), o.getCosto_idavuelta(), o.getCosto_recorrido()});
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        Chapa = new javax.swing.JLabel();
        chapa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        marca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combocolor = new javax.swing.JComboBox<>();
        capsinequip = new javax.swing.JSpinner();
        capconequip = new javax.swing.JSpinner();
        captotal = new javax.swing.JSpinner();
        annofab = new javax.swing.JSpinner();
        panel2 = new javax.swing.JPanel();
        checkckm = new javax.swing.JCheckBox();
        checkchk = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacostokm = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablahoras = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablarecorrido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        ver = new javax.swing.JButton();
        insertar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insertar Vehiculo");

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(204, 255, 204));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Chapa.setText("Chapa:");
        panel1.add(Chapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        chapa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                chapaKeyTyped(evt);
            }
        });
        panel1.add(chapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 148, -1));

        jLabel2.setText("Marca:");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel3.setText("Cap. Sin Equipaje:");
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel4.setText("Cap. Con Equipaje:");
        panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel5.setText("Cap. Total:");
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        marca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                marcaKeyTyped(evt);
            }
        });
        panel1.add(marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 148, -1));

        jLabel6.setText("Año de Fabricación:");
        panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel7.setText("Color:");
        panel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        combocolor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel1.add(combocolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 150, -1));

        capsinequip.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        panel1.add(capsinequip, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 150, -1));

        capconequip.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        panel1.add(capconequip, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 150, -1));

        captotal.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        panel1.add(captotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 150, -1));

        annofab.setModel(new javax.swing.SpinnerNumberModel(1900, 1900, 2020, 1));
        panel1.add(annofab, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 150, -1));

        panel.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 19, 470, 370));

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Modalidades de Transporte"));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkckm.setBackground(new java.awt.Color(204, 255, 204));
        checkckm.setText("Costo por Km");
        checkckm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkckmActionPerformed(evt);
            }
        });
        panel2.add(checkckm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        checkchk.setBackground(new java.awt.Color(204, 255, 204));
        checkchk.setText("Costo por Horas y Km");
        checkchk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkchkActionPerformed(evt);
            }
        });
        panel2.add(checkchk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        tablacostokm.setModel(new javax.swing.table.DefaultTableModel(
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
        tablacostokm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablacostokmMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablacostokm);

        panel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 52, -1, 46));

        tablahoras.setModel(new javax.swing.table.DefaultTableModel(
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
        tablahoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablahorasMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablahoras);

        panel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 140, -1, 46));

        tablarecorrido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablarecorrido);

        panel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 450, 110));

        jLabel1.setText("Recorridos Establecidos:");
        panel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        panel2.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, 22));

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        panel2.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, -1, 22));

        ver.setText("Ver");
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        panel2.add(ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, 22));

        insertar.setText("Insertar");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });
        panel2.add(insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, 22));

        panel.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 520, 370));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 255));
        panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 1010, 10));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        panel.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 430, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 430, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        try {
            if (!bver) {
                valido(chapa.getText(), marca.getText());
                if (vehiculo == null) {
                    boolean existe;
                    existe = existecodigo(chapa.getText());
                    if (!existe) {
                        try {
                            ServicesLocator.getContratoTransporteServices().insertarVehiculo(chapa.getText(), marca.getText(), (String) combocolor.getSelectedItem(),(int)capconequip.getValue(),(int)capsinequip.getValue(),(int)captotal.getValue(),(int)annofab.getValue(), false, panelatras.control.contrato.getCodigocontrato());
                            insertarmodalidadestransporte();
                            ServicesLocator.getContratoTransporteServices().insertarServicioTransporte(true, chapa.getText());
                            Tools.exito(this, "Vehiculo", "Insertado");
                            dispose();
                        } catch (SQLException ex) {
                            Logger.getLogger(Vehiculo_IM.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    boolean existe;
                    if (vehiculo.getChapa().equals(chapa.getText())) {
                        existe = false;
                    } else {
                        existe = existecodigo(chapa.getText());
                    }

                    if (!existe) {
                        try {
                            ServicesLocator.getContratoTransporteServices().editarVehiculo(vehiculo.getChapa(), chapa.getText(), marca.getText(), (String) combocolor.getSelectedItem(),(int)capconequip.getValue(),(int)capsinequip.getValue(),(int)captotal.getValue(),(int)annofab.getValue(), false);
                            eliminarmodalides();
                            insertarmodalidadestransporte();
                            Tools.exito(this, "Vehiculo", "Modificado");
                            dispose();
                        } catch (SQLException ex) {
                            Logger.getLogger(Vehiculo_IM.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }

            } else {
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_aceptarActionPerformed
    public void valido(String chapa, String marca) throws Exception {
        boolean bch = Tools.mezclaalphadigit(true, chapa, 1, 6) && Tools.isLength(chapa, true, 7, false, 0, false, 0);
        if (!bch) {
            throw new Exception("Fallos en Chapa");
        }
        boolean bm = Tools.isAlpha(marca, true, 3, -1);
        if (!bm) {
            throw new Exception("Fallos en Marca");
        }
        boolean cantmodalidad = datoshoras != null || datoskm != null || listarecestab.size() > 0;
        if (!cantmodalidad) {
            throw new Exception("Fallos en Modalidades(al menos debe existir una modalidad)");
        }
    }

    private boolean existecodigo(String codigo) {
        boolean retorno = false;
        try {
            retorno = ServicesLocator.getContratoTransporteServices().existeVehiculo(codigo);
            if (retorno) {
                Tools.existe(this, "Existe esta Ocurrencia de Chapa de Vehiculo en el Sistema");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculo_IM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void checkckmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkckmActionPerformed
        if (checkckm.isSelected()) {
            Costokm_IM aux = new Costokm_IM(this, true, null, panelatras.control.iG.getTipo());
            aux.setVisible(true);
            if (aux.bandera) {
                datoskm = aux.arreglo;
                llenarmodelo(modelokm, datoskm);
            } else {
                checkckm.setSelected(false);
            }
        } else {
            if (Tools.confirmar(this)) {
                Tools.borrartabla(tablacostokm, modelokm);
                datoskm = null;
            } else {
                checkckm.setSelected(true);
            }
        }

    }//GEN-LAST:event_checkckmActionPerformed

    private void checkchkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkchkActionPerformed
        if (checkchk.isSelected()) {
            CostoHoraskm_IM aux = new CostoHoraskm_IM(this, true, null, panelatras.control.iG.getTipo());
            aux.setVisible(true);
            if (aux.bandera) {
                datoshoras = aux.arreglo;
                llenarmodelo(modelohoras, datoshoras);
            } else {
                checkchk.setSelected(false);
            }
        } else {
            if (Tools.confirmar(this)) {
                Tools.borrartabla(tablahoras, modelohoras);
                datoshoras = null;
            } else {
                checkchk.setSelected(true);
            }
        }

    }//GEN-LAST:event_checkchkActionPerformed

    private void tablacostokmMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablacostokmMouseReleased
        if (!bver) {
            Costokm_IM aux = new Costokm_IM(this, true, datoskm, panelatras.control.iG.getTipo());
            aux.setVisible(true);
            if (aux.bandera) {
                Tools.borrartabla(tablacostokm, modelokm);
                datoskm = aux.arreglo;
                llenarmodelo(modelokm, datoskm);
            } else {
                tablacostokm.clearSelection();
            }
        }
    }//GEN-LAST:event_tablacostokmMouseReleased

    private void tablahorasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablahorasMouseReleased
        if (!bver) {
            CostoHoraskm_IM aux = new CostoHoraskm_IM(this, true, datoshoras, panelatras.control.iG.getTipo());
            aux.setVisible(true);
            if (aux.bandera) {
                Tools.borrartabla(tablahoras, modelohoras);
                datoshoras = aux.arreglo;
                llenarmodelo(modelohoras, datoshoras);
            } else {
                tablahoras.clearSelection();
            }
        }
    }//GEN-LAST:event_tablahorasMouseReleased

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        if (!Tools.errorselection(tablarecorrido, '1', this)) {
            int pos = tablarecorrido.getSelectedRow();
            ModeREDto select = listarecestab.get(pos);
            RecorrEstabl_IM aux = new RecorrEstabl_IM(this, true, select, 1);
            aux.setVisible(true);
        }
    }//GEN-LAST:event_verActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        if (!Tools.errorselection(tablarecorrido, '1', this)) {
            int pos = tablarecorrido.getSelectedRow();
            ModeREDto select = listarecestab.get(pos);
            RecorrEstabl_IM aux = new RecorrEstabl_IM(this, true, select, panelatras.control.iG.getTipo());
            aux.setVisible(true);
            if (aux.bandera) {
                listarecestab.set(pos, aux.objeto);
                llenarmodelo(modelorecorrido, aux.objeto);
            }
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (!Tools.errorselection(tablarecorrido, '2', this)) {
            if (Tools.confirmar(this)) {
                Tools.eliminar(tablarecorrido.getSelectedRows(), listarecestab);
                llenarmodelo(modelorecorrido, new ModeREDto("", 0, 0, 0, "", ""));
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        RecorrEstabl_IM aux = new RecorrEstabl_IM(this, true,null, panelatras.control.iG.getTipo());
        aux.setVisible(true);
        if (aux.bandera) {
            listarecestab.add(aux.objeto);
            llenarmodelo(modelorecorrido, aux.objeto);
        }
    }//GEN-LAST:event_insertarActionPerformed

    private void chapaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chapaKeyTyped
        Tools.alphadigit(evt, chapa, 7);
    }//GEN-LAST:event_chapaKeyTyped

    private void marcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marcaKeyTyped
        Tools.alpha(evt, marca, 30);
    }//GEN-LAST:event_marcaKeyTyped

//   public void entervirtual(){
//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_ENTER); // Simula presion
//            robot.keyRelease(KeyEvent.VK_ENTER); // Simula solta
//        } catch (AWTException e) {
//            throw new RuntimeException("Error");
//        }
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Chapa;
    private javax.swing.JButton aceptar;
    private javax.swing.JSpinner annofab;
    private javax.swing.JButton cancelar;
    private javax.swing.JSpinner capconequip;
    private javax.swing.JSpinner capsinequip;
    private javax.swing.JSpinner captotal;
    private javax.swing.JTextField chapa;
    private javax.swing.JCheckBox checkchk;
    private javax.swing.JCheckBox checkckm;
    private javax.swing.JComboBox<String> combocolor;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton insertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField marca;
    private javax.swing.JButton modificar;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JTable tablacostokm;
    private javax.swing.JTable tablahoras;
    public javax.swing.JTable tablarecorrido;
    private javax.swing.JButton ver;
    // End of variables declaration//GEN-END:variables

    private void refrescarventana() {
        chapa.setText(vehiculo.getChapa());
        marca.setText(vehiculo.getMarca());
        color.setSelectedItem(vehiculo.getColor());
        capsinequip.setValue(vehiculo.getCapsinequip());
        capconequip.setValue(vehiculo.getCapconequip());
        captotal.setValue(vehiculo.getCaptotal());
        annofab.setValue(vehiculo.getAnnofabricacion());

        try {
            ModeCKDto mck = ServicesLocator.getContratoTransporteServices().obtenerModalidadCostoKmxVehiculo(vehiculo.getChapa());
            if (mck != null) {
                checkckm.setSelected(true);
                datoskm = mck;
                llenarmodelo(modelokm, datoskm);
                pk = datoskm.getSerial_modalidadtransporte();
            }
            ModeHKDto mhk = ServicesLocator.getContratoTransporteServices().obtenerModalidadHoraKmxVehiculo(vehiculo.getChapa());
            if (mhk != null) {
                checkchk.setSelected(true);
                datoshoras = mhk;
                llenarmodelo(modelohoras, datoshoras);
                ph = datoshoras.getSerial_modalidadtransporte();
            }
            LinkedList<ModeREDto> mre = ServicesLocator.getContratoTransporteServices().obtenerModalidadesRecorridoxVehiculo(vehiculo.getChapa());
            if (mre.size() > 0) {
                listarecestab = mre;
                obtenerlistaposiciones(listarecestab);
                llenarmodelo(modelorecorrido, listarecestab.getFirst());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculo_IM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertarmodalidadestransporte() {
        try {
            if (datoskm != null) {
                ServicesLocator.getContratoTransporteServices().insertarModalidadCostoKm(datoskm.getCostokm(), datoskm.getCostokm_idavuelta(), datoskm.getCosto_horasesperas(), chapa.getText(), listamodalidades.get(0));
            }
            if (datoshoras != null) {
                ServicesLocator.getContratoTransporteServices().insertarModalidadHorasKm(datoshoras.getCostokm_recorridos(), datoshoras.getCosto_horas(), datoshoras.getCostokm_extras(), datoshoras.getCostohoras_extras(), chapa.getText(), listamodalidades.get(1));
            }
            if (listarecestab.size() > 0) {
                Iterator<ModeREDto> iter = listarecestab.iterator();
                while (iter.hasNext()) {
                    ModeREDto o = iter.next();
                    ServicesLocator.getContratoTransporteServices().insertarModalidadRecorrido(o.getDescripcion(), o.getCosto_idavuelta(), o.getCosto_recorrido(), chapa.getText(), listamodalidades.get(2));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculo_IM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void obtenerlistamodalidades() {
        try {
            listamodalidades = ServicesLocator.getContratoTransporteServices().obtenerTiposModalidadTransporte();
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculo_IM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarmodalides() {

        try {
            if (pk != -1) {
                ServicesLocator.getContratoTransporteServices().eliminarModalidadTransporte(pk);
            }
            if (ph != -1) {
                ServicesLocator.getContratoTransporteServices().eliminarModalidadTransporte(ph);
            }
            if (listaposciones.size() > 0) {
                Iterator<Integer> iter = listaposciones.iterator();
                while (iter.hasNext()) {
                    ServicesLocator.getContratoTransporteServices().eliminarModalidadTransporte(iter.next());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vehiculo_IM.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void obtenerlistaposiciones(LinkedList<ModeREDto> lista) {
        Iterator<ModeREDto> iter = lista.iterator();
        while (iter.hasNext()) {
            listaposciones.add(iter.next().getSerial_modalidadtransporte());
        }
    }

}

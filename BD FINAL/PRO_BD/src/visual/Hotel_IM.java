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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.table.DefaultTableModel;
import model.HotelDto;
import model.PackDto;
import services.ServicesLocator;
import utils.Tools;
import utils.GestorInterface;

/**
 *
 * @author Victor
 */
public class Hotel_IM extends javax.swing.JDialog {

    private HotelDto hotel;
    private GestorInterface iG;  //Interfaz al Gestor
    private final String idtitle = " Hotel";
    private DefaultTableModel modelo;
    private LinkedList<Component> c = new LinkedList<Component>();
    private DefaultComboBoxModel mprovincia;
    private DefaultComboBoxModel mcategoria;
    private DefaultComboBoxModel mlocalizacion;
    private DefaultComboBoxModel mmodalidad;
    private LinkedList<String> modalidades = new LinkedList<>();
    private JTextField reftxtDCC;
    private JTextField reftxtDA;
    private JTextField reftxtCA;
    private JTextField reftxtCP;

    public Hotel_IM(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        reftxtCP = ((JSpinner.DefaultEditor) txtCP.getEditor()).getTextField();
        reftxtCP.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.digit(e, reftxtCP, 4);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        reftxtCA = ((JSpinner.DefaultEditor) txtCA.getEditor()).getTextField();
        reftxtCA.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.digit(e, reftxtCA, 8);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        reftxtDA = ((JSpinner.DefaultEditor) txtDA.getEditor()).getTextField();
        reftxtDA.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.flotante(e, reftxtDA, 8);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        reftxtDCC = ((JSpinner.DefaultEditor) txtDCC.getEditor()).getTextField();
        reftxtDCC.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.flotante(e, reftxtDCC, 8);
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
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());

        setBounds(Tools.center(this.getWidth(), this.getHeight()));
        setResizable(false);

        modelo = new DefaultTableModel(new Object[]{"Modalidades"}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        tabla.setModel(modelo);

        inicilizarmodeloscombos();
        comboCategoria.setModel(mcategoria);
        comboLocalizacion.setModel(mlocalizacion);
        comboModalidades.setModel(mmodalidad);
        comboProvincia.setModel(mprovincia);
        info();
    }

    private void info() {
        txtNombre.setToolTipText("(no menos 3 caracteres alfabeticos)");
        txtCadena.setToolTipText("(no menos 3 caracteres alfabeticos)");
        txtTelefono.setToolTipText("(8 digitos)");
        txtFax.setToolTipText("(4 digitos)");
        txtEmail.setToolTipText("(formato ejemplo: xxx@xxx.xx)");
        txtDCC.setToolTipText("[1-1023]");
        txtDA.setToolTipText("[1-1023]");
        txtCA.setToolTipText("[2-5000]");
        txtCP.setToolTipText("[1-1000]");

    }
//******Atributos Activos************
    //get y set

    private HotelDto getHotelactual() {
        return hotel;
    }

    private void setHotelactual(HotelDto hotelactual) {
        this.hotel = hotelactual;
        refreshcomponents(hotelactual);
    }

//Logica
    public void mostrar() {
        crearinterface();
        refresh();
        setVisible(true);
    }

    private void refresh() {
        Tools.setTitulo(this, iG.getTipo(), idtitle);
        if (!iG.isInsert()) {
            actualizarinstanciatabla(iG.getObjetoactual());
        } else {
            actualizarchosser();
        }
        if (iG.isVer()) {
            ver();
        }
    }

    private void actualizarchosser() {
        Tools.chsosser(fecha);
    }

    private void actualizarinstanciatabla(Object objetoactual) {
        setHotelactual((HotelDto) objetoactual);
    }

    private void refreshcomponents(HotelDto hotelactual) {
        fecha.setDate(hotelactual.getFecha());
        txtNombre.setText(hotelactual.getNombre());
        txtCadena.setText(hotelactual.getCadenahotelera());
        txtTelefono.setText(hotelactual.getTelefono());
        txtFax.setText(hotelactual.getFax());
        txtEmail.setText(hotelactual.getEmail());
        txtDCC.setValue(hotelactual.getDistanciaciudadcerca());
        txtDA.setValue(hotelactual.getDistanciaaeropuerto());
        txtCA.setValue(hotelactual.getCantidadhabitaciones());
        txtCP.setValue(hotelactual.getCantidadpisos());
        comboCategoria.setSelectedItem(hotelactual.getCategoria());
        comboLocalizacion.setSelectedItem(hotelactual.getLocalizacion());
        comboProvincia.setSelectedItem(hotelactual.getProvincia());
        try {
            modalidades = ServicesLocator.getHotelServices().obtenerModalidadesxHotel(hotelactual.getNombre());
        } catch (SQLException ex) {
            Logger.getLogger(Hotel_IM.class.getName()).log(Level.SEVERE, null, ex);
        }
        pintarmodalidades();
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(fecha);
        lista.add(txtNombre);
        lista.add(txtCadena);
        lista.add(txtTelefono);
        lista.add(txtFax);
        lista.add(txtEmail);
        lista.add(txtDCC);
        lista.add(txtDA);
        lista.add(txtCA);
        lista.add(txtCP);
        lista.add(comboCategoria);
        lista.add(comboLocalizacion);
        lista.add(comboModalidades);
        lista.add(comboProvincia);
        lista.add(mas);
        lista.add(menos);
        lista.add(cancelar);
        Tools.desactivar(lista);
    }

    private void crearinterface() {
        iG = GestorArchivoGenerico.getInstance();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCadena = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtFax = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        txtDCC = new javax.swing.JSpinner();
        txtDA = new javax.swing.JSpinner();
        txtCA = new javax.swing.JSpinner();
        txtCP = new javax.swing.JSpinner();
        panel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboProvincia = new javax.swing.JComboBox<>();
        comboCategoria = new javax.swing.JComboBox<>();
        comboLocalizacion = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        comboModalidades = new javax.swing.JComboBox<>();
        mas = new javax.swing.JButton();
        menos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBackground(new java.awt.Color(204, 255, 204));

        panel1.setBackground(new java.awt.Color(204, 255, 204));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Nombre:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel2.setText("Cadena Hotelera:");

        jLabel3.setText("Teléfono:");

        jLabel4.setText("Fax:");

        jLabel5.setText("E-mail:");

        jLabel6.setText("Distancia Ciudad Cercana:");

        jLabel7.setText("Distancia Aeropuerto:");

        jLabel8.setText("Cantidad de Habitaciones:");

        jLabel9.setText("Cantidad de Pisos:");

        txtCadena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCadenaKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtFax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFaxKeyTyped(evt);
            }
        });

        jLabel15.setText("Fecha:");

        fecha.setBackground(new java.awt.Color(255, 255, 204));

        txtDCC.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(1024.0f), Float.valueOf(1.0f)));

        txtDA.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(1024.0f), Float.valueOf(1.0f)));

        txtCA.setModel(new javax.swing.SpinnerNumberModel(2, 2, 5000, 1));

        txtCP.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000, 1));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtCadena)
                    .addComponent(txtTelefono)
                    .addComponent(txtFax)
                    .addComponent(txtEmail)
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(txtDCC)
                    .addComponent(txtDA)
                    .addComponent(txtCA)
                    .addComponent(txtCP))
                .addGap(22, 22, 22))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos"));

        jLabel11.setText("Provincia:");

        jLabel12.setText("Categoría:");

        jLabel13.setText("Localización:");

        comboProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboLocalizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Modalidad:");

        comboModalidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        mas.setText("+");
        mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masActionPerformed(evt);
            }
        });

        menos.setText("-");
        menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));

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
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(mas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(menos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(comboCategoria, 0, 155, Short.MAX_VALUE)
                    .addComponent(comboLocalizacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboModalidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(comboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboModalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mas)
                    .addComponent(menos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(204, 204, 255));

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
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(568, 568, 568)
                        .addComponent(aceptar)
                        .addGap(27, 27, 27)
                        .addComponent(cancelar))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        try {
            if (!iG.isVer()) {
                if (iG.isInsert()) {
                    boolean existe;
                    existe = existecodigo(txtNombre.getText());
                    valido(txtNombre.getText(), txtCadena.getText(), txtTelefono.getText(), txtFax.getText(), txtEmail.getText());
                    if (!existe) {
                        Date fechaaux = new Date(fecha.getDate().getYear(), fecha.getDate().getMonth(), fecha.getDate().getDate());
                        try {
                            ServicesLocator.getHotelServices().insertar(fechaaux, txtNombre.getText(), txtCadena.getText(), txtTelefono.getText(), txtFax.getText(), txtEmail.getText(), (float) txtDCC.getValue(), (float) txtDA.getValue(), (int) txtCA.getValue(), (int) txtCP.getValue(), (String) comboCategoria.getSelectedItem(), (String) comboLocalizacion.getSelectedItem(), (String) comboProvincia.getSelectedItem());
                            insertarmodalidades(txtNombre.getText());
                            Tools.exito(this, "Hotel", "Insertado");//NOTIFICACION DE INSERCCION
                            iG.setEstado(true);
                            dispose();
                        } catch (SQLException ex) {
                            Logger.getLogger(Hotel_IM.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    boolean existe;
                    if (hotel.getNombre().equals(txtNombre.getText())) {
                        existe = false;
                    } else {
                        existe = existecodigo(txtNombre.getText());
                    }
                    valido(txtNombre.getText(), txtCadena.getText(), txtTelefono.getText(), txtFax.getText(), txtEmail.getText());
                    if (!existe) {
                        Date fechaaux = new Date(fecha.getDate().getYear(), fecha.getDate().getMonth(), fecha.getDate().getDate());
                        try {
                            ServicesLocator.getHotelServices().editar(hotel.getNombre(), fechaaux, txtNombre.getText(), txtCadena.getText(), txtTelefono.getText(), txtFax.getText(), txtEmail.getText(), (float) txtDCC.getValue(), (float) txtDA.getValue(), (int) txtCA.getValue(), (int) txtCP.getValue(), (String) comboCategoria.getSelectedItem(), (String) comboLocalizacion.getSelectedItem(), (String) comboProvincia.getSelectedItem());
                            ServicesLocator.getHotelServices().eliminarModalidadHotel(hotel.getNombre());
                            insertarmodalidades(hotel.getNombre());
                            Tools.exito(this, "Hotel", "Editado");//NOTIFICACION DE INSERCCION
                            iG.setEstado(true);
                            dispose();
                        } catch (SQLException ex) {
                            Logger.getLogger(Hotel_IM.class.getName()).log(Level.SEVERE, null, ex);
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
    private boolean existecodigo(String codigo) throws Exception {
        boolean retorno = false;

        try {
            retorno = ServicesLocator.getHotelServices().existe(codigo);
            if (retorno) {
                Tools.existe(this, "Existe esta Ocurrencia de Nombre de Hotel en el Sistema");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_IM.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    private void valido(String nombre, String cadenahotelera, String telefono, String fax, String email) throws Exception {
        boolean bnom = Tools.isAlpha(nombre, true, 3, -1);
        if (!bnom) {
            throw new Exception("Fallos en Nombre");
        }
        boolean bcad = Tools.isAlpha(cadenahotelera, true, 3, -1);
        if (!bcad) {
            throw new Exception("Fallos en Cadena Hotelera");
        }
        boolean btel = Tools.isNumeric(telefono, true, false, 0, false, 0) && Tools.isLength(telefono, true, 8, false, 0, false, 0);
        if (!btel) {
            throw new Exception("Fallos en Telefono");
        }
        boolean bfax = Tools.isNumeric(fax, true, false, 0, false, 0) && Tools.isLength(fax, true, 4, false, 0, false, 0);
        if (!bfax) {
            throw new Exception("Fallos en Fax");
        }
        boolean bema = Tools.correo(email);
        if (!bema) {
            throw new Exception("Fallos en Email");
        }
        boolean bmod = modalidades.size() > 0;
        if (!bmod) {
            throw new Exception("Fallos en Modalidades tiene que existir al menos una");
        }
//        boolean dcc = Tools.isFlotante(distanciaciudadcerca, false, 0.0f, false, 0.0f) || Tools.isNumeric(distanciaciudadcerca, true, false, 0, false, 0);
//        boolean da = Tools.isFlotante(distanciaaeropuerto, false, 0.0f, false, 0.0f) || Tools.isNumeric(distanciaaeropuerto, true, false, 0, false, 0);;
//        boolean bca = Tools.isNumeric(cantidadhabitaciones, true, true, 5, true, 100);
//        boolean bcp = Tools.isNumeric(cantidadpisos, true, true, 1, true, 100);

    }

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masActionPerformed
        String aux = (String) comboModalidades.getSelectedItem();
        if (!modalidades.contains(aux)) {
            modalidades.add(aux);
            pintarmodalidades();
        }
    }//GEN-LAST:event_masActionPerformed

    private void menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosActionPerformed
        if (modalidades.size() > 0) {
            modalidades.removeLast();
            pintarmodalidades();
        }
    }//GEN-LAST:event_menosActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        Tools.alpha(evt, txtNombre, 30);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCadenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCadenaKeyTyped
        Tools.alpha(evt, txtCadena, 30);
    }//GEN-LAST:event_txtCadenaKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        Tools.digit(evt, txtTelefono, 8);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtFaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFaxKeyTyped
        Tools.digit(evt, txtFax, 4);
    }//GEN-LAST:event_txtFaxKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboLocalizacion;
    private javax.swing.JComboBox<String> comboModalidades;
    private javax.swing.JComboBox<String> comboProvincia;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton mas;
    private javax.swing.JButton menos;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JTable tabla;
    private javax.swing.JSpinner txtCA;
    private javax.swing.JSpinner txtCP;
    private javax.swing.JTextField txtCadena;
    private javax.swing.JSpinner txtDA;
    private javax.swing.JSpinner txtDCC;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void inicilizarmodeloscombos() {
        try {
            mprovincia = new DefaultComboBoxModel(ServicesLocator.getDistanciaServices().obtenerProvincias().toArray());
            mcategoria = new DefaultComboBoxModel(ServicesLocator.getHotelServices().obtenerCategorias().toArray());
            mlocalizacion = new DefaultComboBoxModel(ServicesLocator.getHotelServices().obtenerLocalizaciones().toArray());
            mmodalidad = new DefaultComboBoxModel(ServicesLocator.getHotelServices().obtenerModalidades().toArray());
        } catch (SQLException ex) {
            Logger.getLogger(Hotel_IM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pintarmodalidades() {
        Tools.borrartabla(tabla, modelo);
        Iterator<String> iter = modalidades.iterator();
        while (iter.hasNext()) {
            modelo.addRow(new Object[]{iter.next()});
        }
    }

    private void insertarmodalidades(String nombre) {
        Iterator<String> iter = modalidades.iterator();
        while (iter.hasNext()) {
            String mod = iter.next();
            try {
                ServicesLocator.getHotelServices().insertarModalidadHotel(nombre, mod);
            } catch (SQLException ex) {
                Logger.getLogger(Hotel_IM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import utils.Encription;
import java.awt.Component;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import model.AgencyDto;
import model.HotelDto;
import model.UserDto;
import services.ServicesLocator;
import utils.Tools;
import utils.GestorInterface;

/**
 *
 * @author Victor
 */
public class Usuario_IM extends javax.swing.JDialog {

    private UserDto usuario;
    private GestorInterface iG;
    private final String idtitle = " Usuario";
    private LinkedList<Component> c = new LinkedList<Component>();
    private DefaultComboBoxModel modelo;

    public Usuario_IM(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        c.add(panel);
        c.add(panel1);
        c.add(panel2);
        try {
            modelo = new DefaultComboBoxModel(ServicesLocator.getAgenciaServices().obtenerRoles().toArray());
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_IM.class.getName()).log(Level.SEVERE, null, ex);
        }
        combo.setModel(modelo);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        setBounds(Tools.center(this.getWidth(), this.getHeight()));
        setResizable(false);
        info();
    }
    private void info(){
        txtid.setToolTipText("(11 digitos)");
        txtNombre.setToolTipText("(no menos 3 caracteres alfabeticos)");
        txtPrimerA.setToolTipText("(no menos 3 caracteres alfabeticos)");
        txtSegundoA.setToolTipText("(no menos 3 caracteres alfabeticos)");
        txtNick.setToolTipText("(no menos 3 caracteres alfabeticos)");
        txtContrasenna.setToolTipText("(no menos 8 caracteres)");
    }
    //Get y Set
    private void setUsuario(UserDto usuarioactual) {
        this.usuario = usuarioactual;
        refreshcomponents(usuarioactual);
    }

    private UserDto getUsuario() {
        return usuario;
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
            txtContrasenna.setEnabled(false);
        }
        if (iG.isVer()) {
            ver();
        }
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(txtid);
        lista.add(txtNombre);
        lista.add(txtPrimerA);
        lista.add(txtSegundoA);
        lista.add(txtNick);
        lista.add(combo);
        lista.add(cancelar);
        Tools.desactivar(lista);
    }

    private void actualizarinstanciatabla(Object objetoactual) {
        setUsuario((UserDto) objetoactual);
    }

    private void refreshcomponents(UserDto usuarioactual) {
        txtid.setText(usuarioactual.getId());
        txtNombre.setText(usuarioactual.getNombre());
        txtPrimerA.setText(usuarioactual.getPrimerapll());
        txtSegundoA.setText(usuarioactual.getSegundoapll());
        txtNick.setText(usuarioactual.getNick());
        txtContrasenna.setText("**Protegida**");
        combo.setSelectedItem(usuarioactual.getRol());
    }

    private void crearinterface() {
        iG = GestorArchivoGenerico.getInstance();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        panel = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrimerA = new javax.swing.JTextField();
        txtSegundoA = new javax.swing.JTextField();
        txtNick = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtContrasenna = new javax.swing.JTextField();
        panel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBackground(new java.awt.Color(204, 255, 204));

        panel1.setBackground(new java.awt.Color(204, 255, 204));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Carnet de Identidad:");

        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Primer Apellido:");

        jLabel4.setText("Segundo Apellido:");

        jLabel5.setText("Nick:");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtPrimerA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrimerAActionPerformed(evt);
            }
        });
        txtPrimerA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrimerAKeyTyped(evt);
            }
        });

        txtSegundoA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSegundoAKeyTyped(evt);
            }
        });

        txtNick.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNickKeyTyped(evt);
            }
        });

        jLabel6.setText("Contraseña:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtContrasenna, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrimerA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSegundoA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNick, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(24, 24, 24))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrimerA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSegundoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));

        jLabel7.setText("Rol:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
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
                .addGap(28, 28, 28)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aceptar)
                .addGap(27, 27, 27)
                .addComponent(cancelar)
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    existe = existencodigos(txtid.getText(), txtNick.getText(), true);
                    valido(txtid.getText(), txtNombre.getText(), txtPrimerA.getText(), txtSegundoA.getText(), txtNick.getText(), txtContrasenna.getText());
                    if (!existe) {
                        try {
                            ServicesLocator.getAgenciaServices().insertarUsuario(txtid.getText(), txtNombre.getText(), txtPrimerA.getText(), txtSegundoA.getText(), txtNick.getText(), Encription.SHA256(txtContrasenna.getText()), 0, AgencyDto.get().serial(), (String) combo.getSelectedItem());
                            Tools.exito(this, "Usuario", "Insertado");//NOTIFICACION DE INSERCCION
                            iG.setEstado(true);
                            dispose();
                        } catch (SQLException ex) {
                            Logger.getLogger(Usuario_IM.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } else {
                    boolean existe;
                    if (usuario.getId().equals(txtid.getText())) {
                        existe = false;
                    } else {
                        existe = existencodigos(txtid.getText(), null, false);
                    }
                    if (!existe) {
                        if (usuario.getNick().equals(txtNick.getText())) {
                            existe = false;
                        } else {
                            existe = existencodigos(null, txtNick.getText(), false);
                        }
                    }
                    valido(txtid.getText(), txtNombre.getText(), txtPrimerA.getText(), txtSegundoA.getText(), txtNick.getText(), null);
                    if (!existe) {
                        try {
                            ServicesLocator.getAgenciaServices().editarUsuario(usuario.getId(), txtid.getText(), txtNombre.getText(), txtPrimerA.getText(), txtSegundoA.getText(), txtNick.getText(), Encription.SHA256(txtContrasenna.getText()), usuario.getTema(), AgencyDto.get().serial(), (String) combo.getSelectedItem());
                            Tools.exito(this, "Usuario", "Editado");//NOTIFICACION DE INSERCCION
                            iG.setEstado(true);
                            dispose();
                        } catch (SQLException ex) {
                            Logger.getLogger(Usuario_IM.class.getName()).log(Level.SEVERE, null, ex);
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
    //ambos = true -> si existe uno o el otro
    //ambos = false -> si existe uno pero el otro tiene que estar null  
    private boolean existencodigos(String idv, String nickv, boolean ambos) {
        boolean retorno = false;
        try {
            retorno = ambos ? ServicesLocator.getAgenciaServices().existeUsuario(idv) || ServicesLocator.getAgenciaServices().existeNickUsuario(nickv) : (idv == null ? ServicesLocator.getAgenciaServices().existeNickUsuario(nickv) : ServicesLocator.getAgenciaServices().existeUsuario(idv));
            if (retorno) {
                Tools.existe(this, "Existe esta Ocurrencia (Carnet id-nick) de Usuario en el Sistema");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuario_IM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    private void valido(String id, String nombre, String primerapll, String segundoapll, String nick, String contrasenna) throws Exception {
        boolean bid = Tools.iscarnet(id);
        if (!bid) {
            throw new Exception("Fallos en Carnet de Identidad");
        }
        boolean bnombre = Tools.isAlpha(nombre, true, 3, -1);
        if (!bnombre) {
            throw new Exception("Fallos en Nombre");
        }
        boolean bpa = Tools.isAlpha(primerapll, true, 3, -1);
        if (!bpa) {
            throw new Exception("Fallos en Primer Apellido");
        }
        boolean bsa = Tools.isAlpha(segundoapll, true, 3, -1);
        if (!bsa) {
            throw new Exception("Fallos en Segundo Apellido");
        }
        boolean bn = Tools.isAlpha(nick, false, 3, -1);
        if (!bn) {
            throw new Exception("Fallos en Nick");
        }
        boolean bc = contrasenna == null ? true : Tools.isLength(contrasenna,false, WIDTH,true,8, false,0);//almenos 8 caracteres
        if (!bc) {
            throw new Exception("Fallos en Contraseña");
        }
    }
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void txtidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyTyped
        Tools.digit(evt, txtid, 11);
    }//GEN-LAST:event_txtidKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        Tools.alpha(evt, txtNombre, 25);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPrimerAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrimerAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrimerAActionPerformed

    private void txtPrimerAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrimerAKeyTyped
        Tools.alpha(evt, txtPrimerA, 25);
    }//GEN-LAST:event_txtPrimerAKeyTyped

    private void txtSegundoAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSegundoAKeyTyped
        Tools.alpha(evt, txtSegundoA, 25);
    }//GEN-LAST:event_txtSegundoAKeyTyped

    private void txtNickKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNickKeyTyped
        Tools.alpha(evt, txtNick, 25);
    }//GEN-LAST:event_txtNickKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JTextField txtContrasenna;
    private javax.swing.JTextField txtNick;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrimerA;
    private javax.swing.JTextField txtSegundoA;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import utils.Encription;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.AgencyDto;
import model.RoleDto;
import model.UserDto;
import services.AgenciaServices;
import services.ServicesLocator;
import utils.Cargando;
import utils.Tools;

/**
 *
 * @author Victor
 */
/*
user: pass
victor: victor00 Informatico
juliet: juliet00 Contratos
gabriel: gabriel00 Paquetes
elbert: elbert00 Reportes
marlon: marlon00 Paquetes
sergio: sergio00 Hotel,Distancia
*/
public class IniciarSesion extends javax.swing.JFrame {
    private String usuario;
    private String contrasenna;
    private Timer timer;
   
    
    public IniciarSesion() {
        initComponents();
        this.setSize(382,290);
        setResizable(false);
        setBounds(Tools.center(this.getWidth(),this.getHeight()));  
        notificacion.setVisible(false);       
    }

    public void pintarnotificacion() {
        timer = new Timer (2000, new ActionListener (){
            public void actionPerformed(ActionEvent e)
            {
                notificacion.setVisible(false);
                timer.stop();
            }
        });
        timer.start();
        notificacion.setVisible(true);   
    }
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        Gestor = new javax.swing.JLabel();
        jtextUsuario = new javax.swing.JTextField();
        Gestor1 = new javax.swing.JLabel();
        jpassContrasenna = new javax.swing.JPasswordField();
        notificacion = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");

        panel.setBackground(new java.awt.Color(204, 255, 204));

        Gestor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Gestor.setText("Usuario");

        jtextUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtextUsuarioKeyTyped(evt);
            }
        });

        Gestor1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Gestor1.setText("Contraseña");

        notificacion.setForeground(new java.awt.Color(255, 0, 0));
        notificacion.setText("Usuario o Contraseña incorrecto");

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
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(notificacion))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Gestor1)
                            .addComponent(Gestor)
                            .addComponent(jtextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpassContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(aceptar)
                                .addGap(18, 18, 18)
                                .addComponent(cancelar)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Gestor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(Gestor1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpassContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(notificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelar)
                    .addComponent(aceptar))
                .addGap(23, 23, 23))
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

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
         System.exit(0);
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        usuario = jtextUsuario.getText();
        contrasenna = jpassContrasenna.getText();
        
        UserDto u = null;
        try {
            u = ServicesLocator.getAgenciaServices().obtenerUsuarioxNick(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean autenticacion = false;
        if(u!=null)
            autenticacion = Encription.compare(contrasenna,u.getContrasenna());
        
        if(autenticacion){
            //MOSTRAR VENTANA PRINCIPAL
            //setVisible(false);
            u.setContrasenna(contrasenna);
            RoleDto b = new RoleDto(u.getRol());
            Tools.decoracion(false);
            Cargando carg = new Cargando(null,true,"Cargando Cuenta",2);
            Tools.decoracion(true);
            //JFrame.setDefaultLookAndFeelDecorated(false);
            borrar();
            setVisible(false);
            PrincipalVisual a = PrincipalVisual.getVentanaPrincipal(u, b,this);
            a.setVisible(true);
        }else{
            borrar();
            pintarnotificacion();
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void jtextUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextUsuarioKeyTyped
    }//GEN-LAST:event_jtextUsuarioKeyTyped
    private void borrar(){
        jtextUsuario.setText("");
        jpassContrasenna.setText("");
    }
    public void mostrar(){
        Tools.tema(1);
        setVisible(true);
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Gestor;
    private javax.swing.JLabel Gestor1;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPasswordField jpassContrasenna;
    private javax.swing.JTextField jtextUsuario;
    private javax.swing.JLabel notificacion;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}

package visual;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import utils.Tools;
import model.ProgramActivityDto;

/**
 *
 * @author Victor
 */
public class AuxProgActividades_IM extends javax.swing.JDialog {
    
    boolean bandera = false;
    private LinkedList<Component> c = new LinkedList<Component>();
    public ProgramActivityDto programaactividad;
    private boolean ver;
    private JTextField textohora;    
    
    public AuxProgActividades_IM(java.awt.Dialog parent, boolean modal, ProgramActivityDto programa, int tipo) {
        super(parent, modal);
        initComponents();
        ver = tipo == 1;
        c.add(panel);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        setBounds(Tools.center(this.getWidth(), this.getHeight()));
        setResizable(false);
        programaactividad = new ProgramActivityDto("", "", Tools.fecha(), 0, "");
        Tools.setTitulo(this, tipo, "Programa Actividad");
        if (programa != null) {
            programaactividad = programa;
            cargar();
        }
        if (tipo == 1) {
            ver();
        }
        textohora = ((JSpinner.DefaultEditor) hora.getEditor()).getTextField();
        hora.setToolTipText("[0-23]");
        textohora.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Tools.digit(e,textohora,2);
            }
            
            @Override
            public void keyPressed(KeyEvent e) {   
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
//        JFormattedTextField tf = ((JSpinner.DefaultEditor) hora.getEditor()).getTextField();
//        tf.setEditable(false);
    }
    
    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(dia);
        lista.add(hora);
        lista.add(descripcion);
        lista.add(cancelar);
        Tools.desactivar(lista);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        dia = new com.toedter.calendar.JDateChooser();
        hora = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("Día:");

        jLabel2.setText("Hora:");

        jLabel3.setText("Descripción:");

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

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

        dia.setBackground(new java.awt.Color(255, 255, 204));

        hora.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(23.0f), Float.valueOf(1.0f)));
        hora.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        hora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                horaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                horaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                horaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(63, 63, 63)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dia, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(hora)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(aceptar)
                                .addGap(21, 21, 21)
                                .addComponent(cancelar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if (!ver) {
            leer();
            bandera = true;
        }
        
        setVisible(false);

    }//GEN-LAST:event_aceptarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void horaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horaKeyReleased

    }//GEN-LAST:event_horaKeyReleased

    private void horaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horaKeyPressed

    }//GEN-LAST:event_horaKeyPressed

    private void horaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_horaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    public javax.swing.JButton cancelar;
    private javax.swing.JTextArea descripcion;
    private com.toedter.calendar.JDateChooser dia;
    private javax.swing.JSpinner hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    private void leer() {
        programaactividad.setDia(Tools.ConDateSql(dia.getDate()));
//        System.out.println(((Object)hora.getValue()).getClass().getSimpleName()); Conocer tipo de Dato
//        System.out.println(((Object)12.365f).getClass().getSimpleName());
        programaactividad.setHora((int)((float)hora.getValue()));
        programaactividad.setDescripcionactividad(descripcion.getText());
    }
    
    private void cargar() {
        dia.setDate(programaactividad.getDia());
        hora.setValue(programaactividad.getHora());
        descripcion.setText(programaactividad.getDescripcionactividad());
    }
}

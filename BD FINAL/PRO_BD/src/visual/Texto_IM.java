package visual;

import java.awt.Component;
import java.util.LinkedList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class Texto_IM extends javax.swing.JDialog {
    private String contenido;
    private LinkedList<Component> c = new LinkedList<Component>();
    private boolean estadover;
    public Texto_IM(JDialog parent, boolean modal,String contenido,String title,boolean ver) {
        super(parent, modal);
        initComponents();
        c.add(panel);Tools.actualizarcomponentes(c,PrincipalVisual.getInstance().getUsuario().getTema());
        setBounds(Tools.center(this.getWidth(),this.getHeight()));
        setResizable(false);
        setTitle(title);
        setContenido(contenido);
        estadover=ver;
        if(estadover){
            cancelar.setEnabled(false);
            texto.setEditable(false);
        }    
    }
//    Get y Set
    public void setVer(boolean b){
        this.estadover = b;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido){
        this.contenido = contenido;
        texto.setText(contenido);
    }
    private boolean confirmar() {
        return JOptionPane.showConfirmDialog(this,"Está seguro/a de modificar","Informacion",JOptionPane.YES_NO_OPTION) == 0;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        texto.setColumns(20);
        texto.setRows(5);
        jScrollPane1.setViewportView(texto);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 199));
        panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 211, 330, 10));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        panel.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 227, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 227, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed
    //Si es para ver cerrar normal
    //No-> Confirmar 
    //            Si->Guardar Nuevo Texto y Cerrar
    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if(!estadover){
            if(confirmar()){
                contenido=texto.getText();
                this.dispose();
            }
        }else
            this.dispose();
    }//GEN-LAST:event_aceptarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.Timer;

/**
 *
 * @author Victor
 */
public class Cargando extends javax.swing.JDialog {
    private Timer timer;
    private String info;
    private int parte;
    private int total;
    
    
    public Cargando(JDialog parent, boolean modal,String contenido,int segundos) {
        super(parent, modal);
        initComponents();  
        progreso.setStringPainted(true);
        setBounds(Tools.center(this.getWidth(),this.getHeight()));
        setResizable(false);
        info=contenido;
        total=segundos;
        parte=1;
        pintar(0);
        
        activartiempo();
        setVisible(true);
    }
    
    public void activartiempo() {
        
        timer = new Timer (1000, new ActionListener (){
            public void actionPerformed(ActionEvent e)
            {
                if(parte < total){
                    pintar(porciento(parte, total));
                    parte++;
                }else
                    dispose();
            }
        });
        
        timer.start();
    }
  
    public void pintar(int n){
        //progreso.setToolTipText(info+" "+String.valueOf(n)+"%");
        progreso.setValue(n);
    }
    
    private int porciento(int parte,int total){  
      return (parte * 100)/total;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        progreso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cargando ");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progreso, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progreso, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progreso;
    // End of variables declaration//GEN-END:variables

}

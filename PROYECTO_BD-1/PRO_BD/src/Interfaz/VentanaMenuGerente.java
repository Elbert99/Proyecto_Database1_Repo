/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;



import Interfaz.VentanaRepCli;
import Interfaz.VentanaContTrans;
import Interfaz.VentanaRepContConcHotel;


/**
 *
 * @author Rui Sergio Mané
 */
public class VentanaMenuGerente extends javax.swing.JFrame {

	/**
	 * Creates new form VentanaMenuGerentee
	 */
	public VentanaMenuGerente() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jmnBarra = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        mnAbrirPaquete = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnPaqueteTurist = new javax.swing.JMenuItem();
        mnCrearCont = new javax.swing.JMenuItem();
        jmenuCerrarSeccion = new javax.swing.JMenuItem();
        jmnSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmnHotelActivo = new javax.swing.JMenuItem();
        mnPaquetTurist = new javax.swing.JMenuItem();
        jmnReportClientes = new javax.swing.JMenu();
        jmnTransport = new javax.swing.JMenu();
        jmnkilometr = new javax.swing.JMenuItem();
        jmnhoraykilometr = new javax.swing.JMenuItem();
        jmnRecorrido = new javax.swing.JMenuItem();
        mnHoteles = new javax.swing.JMenuItem();
        mnServicioComp = new javax.swing.JMenuItem();
        mnTempHotel = new javax.swing.JMenuItem();
        VentPaquetTurist = new javax.swing.JMenuItem();
        jmenuAyuda = new javax.swing.JMenu();
        jmenuComentarios = new javax.swing.JMenuItem();
        jmenuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conozca Cuba");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(65, 63, 62));

        jMenu.setText("Menu");
        jMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });

        mnAbrirPaquete.setText("Abrir Paquete");
        mnAbrirPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAbrirPaqueteActionPerformed(evt);
            }
        });
        jMenu.add(mnAbrirPaquete);

        jMenu2.setText("Crear");

        mnPaqueteTurist.setText("Paquete Turistico");
        mnPaqueteTurist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPaqueteTuristActionPerformed(evt);
            }
        });
        jMenu2.add(mnPaqueteTurist);

        mnCrearCont.setText("Contrato");
        mnCrearCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCrearContActionPerformed(evt);
            }
        });
        jMenu2.add(mnCrearCont);

        jMenu.add(jMenu2);

        jmenuCerrarSeccion.setText("Cerrar Sección");
        jmenuCerrarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuCerrarSeccionActionPerformed(evt);
            }
        });
        jMenu.add(jmenuCerrarSeccion);

        jmnSalir.setText("Salir");
        jmnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnSalirActionPerformed(evt);
            }
        });
        jMenu.add(jmnSalir);

        jmnBarra.add(jMenu);

        jMenu1.setText("Ver");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jmnHotelActivo.setText("Hoteles Activos");
        jmnHotelActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnHotelActivoActionPerformed(evt);
            }
        });
        jMenu1.add(jmnHotelActivo);

        mnPaquetTurist.setText("Paquete Turistico");
        mnPaquetTurist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPaquetTuristActionPerformed(evt);
            }
        });
        jMenu1.add(mnPaquetTurist);

        jmnBarra.add(jMenu1);

        jmnReportClientes.setText("Reportes");

        jmnTransport.setText("Transporte por");

        jmnkilometr.setText("Kilometraje");
        jmnkilometr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnkilometrActionPerformed(evt);
            }
        });
        jmnTransport.add(jmnkilometr);

        jmnhoraykilometr.setText("Horas y Kilometraje");
        jmnhoraykilometr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnhoraykilometrActionPerformed(evt);
            }
        });
        jmnTransport.add(jmnhoraykilometr);

        jmnRecorrido.setText("Recorridos");
        jmnRecorrido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnRecorridoActionPerformed(evt);
            }
        });
        jmnTransport.add(jmnRecorrido);

        jmnReportClientes.add(jmnTransport);

        mnHoteles.setText("Hoteles");
        mnHoteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnHotelesActionPerformed(evt);
            }
        });
        jmnReportClientes.add(mnHoteles);

        mnServicioComp.setText("Servicio Complementario");
        mnServicioComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnServicioCompActionPerformed(evt);
            }
        });
        jmnReportClientes.add(mnServicioComp);

        mnTempHotel.setText("Temporadas de hotel");
        mnTempHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTempHotelActionPerformed(evt);
            }
        });
        jmnReportClientes.add(mnTempHotel);

        VentPaquetTurist.setText("Ventas Paquetes Turisticos");
        VentPaquetTurist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentPaquetTuristActionPerformed(evt);
            }
        });
        jmnReportClientes.add(VentPaquetTurist);

        jmnBarra.add(jmnReportClientes);

        jmenuAyuda.setText("Ayuda");

        jmenuComentarios.setText("Comentarios");
        jmenuComentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuComentariosActionPerformed(evt);
            }
        });
        jmenuAyuda.add(jmenuComentarios);

        jmenuSobre.setText("Sobre");
        jmenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuSobreActionPerformed(evt);
            }
        });
        jmenuAyuda.add(jmenuSobre);

        jmnBarra.add(jmenuAyuda);

        setJMenuBar(jmnBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmenuCerrarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuCerrarSeccionActionPerformed
        // TODO add your handling code here:
        VentanaInicial i = new VentanaInicial();
		i.setVisible(true);
		VentanaMenuGerente.this.setVisible(false);
    }//GEN-LAST:event_jmenuCerrarSeccionActionPerformed

    private void jMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuActionPerformed

    private void jmenuComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuComentariosActionPerformed
        // TODO add your handling code here:
        VentanaComentarios ayuda = new VentanaComentarios();
        ayuda.setVisible(true);
    }//GEN-LAST:event_jmenuComentariosActionPerformed

    private void jmenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuSobreActionPerformed
        // TODO add your handling code here:
        VentanaSobre sobre = new VentanaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_jmenuSobreActionPerformed

    private void jmnRecorridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnRecorridoActionPerformed
        // TODO add your handling code here:
        VentanaRepContRecorr rcr = new VentanaRepContRecorr();
		rcr.setVisible(true);
    }//GEN-LAST:event_jmnRecorridoActionPerformed

    private void jmnhoraykilometrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnhoraykilometrActionPerformed
        // TODO add your handling code here:
        VentanaRepContCostHK rchk = new VentanaRepContCostHK();
		rchk.setVisible(true);
    }//GEN-LAST:event_jmnhoraykilometrActionPerformed

    private void jmnkilometrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnkilometrActionPerformed
        // TODO add your handling code here:
       VentanaRepContCostHK rchk = new VentanaRepContCostHK();
		rchk.setVisible(true);
    }//GEN-LAST:event_jmnkilometrActionPerformed

    private void jmnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnSalirActionPerformed
        // TODO add your handling code here:
		VentanaMenuGerente.this.setVisible(false);
    }//GEN-LAST:event_jmnSalirActionPerformed

    private void mnAbrirPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAbrirPaqueteActionPerformed
        // TODO add your handling code here:
		VentanaAbrirPaquete ap = new VentanaAbrirPaquete();
		ap.setVisible(true);
    }//GEN-LAST:event_mnAbrirPaqueteActionPerformed

    private void mnPaqueteTuristActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPaqueteTuristActionPerformed
        // TODO add your handling code here:
		VentanaNuevoPaquete np = new VentanaNuevoPaquete();
		np.setVisible(true);
    }//GEN-LAST:event_mnPaqueteTuristActionPerformed

    private void mnServicioCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnServicioCompActionPerformed
        // TODO add your handling code here:
		VentanaRepContServComp sc = new VentanaRepContServComp();
		sc.setVisible(true);
    }//GEN-LAST:event_mnServicioCompActionPerformed

    private void VentPaquetTuristActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentPaquetTuristActionPerformed
        // TODO add your handling code here:
		VentanaRepVentPQT vpt = new VentanaRepVentPQT();
		vpt.setVisible(true);
    }//GEN-LAST:event_VentPaquetTuristActionPerformed

    private void mnTempHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTempHotelActionPerformed

		VentanaRepContTempHotel th = new VentanaRepContTempHotel();
		th.setVisible(true);
    }//GEN-LAST:event_mnTempHotelActionPerformed

    private void mnHotelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnHotelesActionPerformed

		VentanaRepContConcHotel ch = new VentanaRepContConcHotel();
		ch.setVisible(true);
    }//GEN-LAST:event_mnHotelesActionPerformed

    private void mnCrearContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCrearContActionPerformed
        // TODO add your handling code here:
		VentanaPaqueteCreados pc = new VentanaPaqueteCreados();
		pc.setVisible(true);
    }//GEN-LAST:event_mnCrearContActionPerformed

    private void mnPaquetTuristActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPaquetTuristActionPerformed
        // TODO add your handling code here:
        VentanasRepPQTurist p = new VentanasRepPQTurist();
        p.setVisible(true);
    }//GEN-LAST:event_mnPaquetTuristActionPerformed

    private void jmnHotelActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnHotelActivoActionPerformed
        // TODO add your handling code here:
        VentanaRepHotelesActivos ha = new VentanaRepHotelesActivos();
        ha.setVisible(true);
    }//GEN-LAST:event_jmnHotelActivoActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed
 
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(VentanaMenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(VentanaMenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(VentanaMenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(VentanaMenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new VentanaMenuGerente().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem VentPaquetTurist;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jmenuAyuda;
    private javax.swing.JMenuItem jmenuCerrarSeccion;
    private javax.swing.JMenuItem jmenuComentarios;
    private javax.swing.JMenuItem jmenuSobre;
    private javax.swing.JMenuBar jmnBarra;
    private javax.swing.JMenuItem jmnHotelActivo;
    private javax.swing.JMenuItem jmnRecorrido;
    private javax.swing.JMenu jmnReportClientes;
    private javax.swing.JMenuItem jmnSalir;
    private javax.swing.JMenu jmnTransport;
    private javax.swing.JMenuItem jmnhoraykilometr;
    private javax.swing.JMenuItem jmnkilometr;
    private javax.swing.JMenuItem mnAbrirPaquete;
    private javax.swing.JMenuItem mnCrearCont;
    private javax.swing.JMenuItem mnHoteles;
    private javax.swing.JMenuItem mnPaquetTurist;
    private javax.swing.JMenuItem mnPaqueteTurist;
    private javax.swing.JMenuItem mnServicioComp;
    private javax.swing.JMenuItem mnTempHotel;
    // End of variables declaration//GEN-END:variables
}
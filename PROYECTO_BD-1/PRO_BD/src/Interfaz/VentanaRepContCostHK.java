/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author Rui Sergio Mané
 */
public class VentanaRepContCostHK extends javax.swing.JFrame {

	/**
	 * Creates new form VentanaContCostHK
	 */
	public VentanaRepContCostHK() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbtnEliminar = new javax.swing.JButton();
        jbtnModificar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contrato por Hora y Kilometraje");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Gaviota", "11/09/2018", "10/07/2020", "", "", "", "20", "30", "50", "2005", "Hora x Kilometros", "horas"},
                {"Taxi", "20/05/2019", "18/11/2020", "", null, null, "5", "7", "12", "1998", "Hora x kilometro", "kilometro recorrido"},
                {"Panataxi", "03/04/2017", "10/12/2019", null, null, null, "8", "12", "20", "2002", "Hora x Kilometro", "horas extras"},
                {null, null, null, null, null, null, "", null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Prestario de Transporte", "Fecha de Inicio", "Fecha de Terminación", "Veiculo incuido", "Chapa", "Marca", "Capacidad sin Equipaje", "Capacidad con Equipaje", "Capacidad Total", "Año de Fabricación ", "Modalidad", "Tipo de Costo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jbtnEliminar.setText("Eliminar");

        jbtnModificar.setText("Modificar");

        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnEliminar)
                        .addGap(26, 26, 26)
                        .addComponent(jbtnModificar)
                        .addGap(28, 28, 28)
                        .addComponent(jbtnCancelar)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCancelar)
                    .addComponent(jbtnModificar)
                    .addComponent(jbtnEliminar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        // TODO add your handling code here:
        VentanaRepContCostHK.this.dispose();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

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
			java.util.logging.Logger.getLogger(VentanaRepContCostHK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(VentanaRepContCostHK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(VentanaRepContCostHK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(VentanaRepContCostHK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new VentanaRepContCostHK().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnModificar;
    // End of variables declaration//GEN-END:variables
}

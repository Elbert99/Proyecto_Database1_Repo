/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Component;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import utils.Tools;
import model.ActivityDto;
import model.ModeREDto;
import model.ProgramActivityDto;
import model.ServiceActivityDto;
import services.ServicesLocator;

/**
 *
 * @author Victor
 */
public class PanelProgActividades extends javax.swing.JPanel {

    private Paquete_IM control;
    private LinkedList<Component> c = new LinkedList<Component>();
    private DefaultTableModel modeloactividad;
    private DefaultTableModel modeloprograma;
    private LinkedList<ActivityDto> actividades = new LinkedList<ActivityDto>();
    public LinkedList<ProgramActivityDto> programaactividades = new LinkedList<ProgramActivityDto>();
    private LinkedList<ServiceActivityDto> serviciosactividad = new LinkedList<ServiceActivityDto>();

    public PanelProgActividades(Paquete_IM atras) {
        initComponents();
        c.add(panel);
        c.add(panel1);
        c.add(panel2);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        modeloactividad = new DefaultTableModel(new Object[]{"Nombre Actividad", "Provincia"}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tablaactividades.setModel(modeloactividad);
        modeloprograma = new DefaultTableModel(new Object[]{"Nombre Actividad", "Día", "Hora", "Descripción"}, 0x0) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        tablaprograma.setModel(modeloprograma);
        control = atras;
        aceptar.setEnabled(false);
        obteneractividades();
        pintaractividades();

        if (!control.iG.isInsert()) {
            actualizar();
        }
        if (control.iG.isVer()) {
            ver();
        }
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(tablaactividades);
        lista.add(annadir);
        lista.add(modificar);
        lista.add(eliminar);
        Tools.desactivar(lista);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaactividades = new javax.swing.JTable();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        ver = new javax.swing.JButton();
        panel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaprograma = new javax.swing.JTable();
        annadir = new javax.swing.JButton();

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 500, 10));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        panel.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, -1, -1));

        anterior.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        anterior.setText("<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        panel.add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        siguiente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        siguiente.setText(">");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        panel.add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        panel2.setBackground(new java.awt.Color(204, 255, 204));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Actividades"));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaactividades.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaactividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaactividadesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaactividades);

        panel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 34, 367, 93));

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        panel2.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 80, -1));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        panel2.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 140, 80, -1));

        ver.setText("Ver");
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        panel2.add(ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        panel1.setBackground(new java.awt.Color(204, 255, 204));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Programa"));

        tablaprograma.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaprograma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaprogramaMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablaprograma);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panel2.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 159, -1, -1));

        annadir.setText("Añadir");
        annadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annadirActionPerformed(evt);
            }
        });
        panel2.add(annadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 71, -1));

        panel.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 520, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        control.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        control.actualizarpanel(control.getTipo() - 1);
    }//GEN-LAST:event_anteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        if (!control.iG.isVer()) {
            if (valido1()) {
                control.actualizarpanel(control.getTipo() + 1);
            }
        } else {
            control.actualizarpanel(control.getTipo() + 1);
        }
    }//GEN-LAST:event_siguienteActionPerformed

    private void tablaprogramaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaprogramaMouseReleased
        //Llamar a InfoModalidad pasandole un ModalidadTransporte
    }//GEN-LAST:event_tablaprogramaMouseReleased

    private void annadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annadirActionPerformed
        /*Se Tiene que seleccionar un elemento en la tabla de actividades y luego mostrar
          la ventana AuxProgActividades para Insertar un elemento del programa de act
          se debe crear un modelo auxiliar con nomact dia hora descripcion para gestionar*/
        if (!Tools.errorselection(tablaactividades, '1', control)) {
            String nombreactividad = actividades.get(tablaactividades.getSelectedRow()).getNombre();
            if (valido(nombreactividad)) {
                AuxProgActividades_IM annadir = new AuxProgActividades_IM(control, true, null, control.iG.getTipo());
                annadir.setVisible(true);
                if (annadir.bandera) {
                    ProgramActivityDto auxiliar = annadir.programaactividad;
                    auxiliar.setNombreactividad(nombreactividad);
                    programaactividades.add(auxiliar);
                    pintarprograma();
                }
            }
        }
    }//GEN-LAST:event_annadirActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        if (!Tools.errorselection(tablaprograma, '1', control)) {
            int pos = tablaprograma.getSelectedRow();
            ProgramActivityDto select = programaactividades.get(pos);
            AuxProgActividades_IM annadir = new AuxProgActividades_IM(control, true, select, control.iG.getTipo());
            annadir.setVisible(true);
            if (annadir.bandera) {
                programaactividades.set(pos, annadir.programaactividad);
                pintarprograma();
            }
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (!Tools.errorselection(tablaprograma, '2', control)) {
            if (Tools.confirmar(control)) {
                Tools.eliminar(tablaprograma.getSelectedRows(), programaactividades);
                pintarprograma();
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aceptarActionPerformed

    private void tablaactividadesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaactividadesMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaactividadesMouseReleased

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        if (!Tools.errorselection(tablaprograma, '1', control)) {
            int pos = tablaprograma.getSelectedRow();
            ProgramActivityDto select = programaactividades.get(pos);
            AuxProgActividades_IM annadir = new AuxProgActividades_IM(control, true, select,1);
            annadir.setVisible(true);
        }
    }//GEN-LAST:event_verActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    private javax.swing.JButton annadir;
    public javax.swing.JButton anterior;
    public javax.swing.JButton cancelar;
    private javax.swing.JButton eliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton modificar;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    public javax.swing.JButton siguiente;
    public javax.swing.JTable tablaactividades;
    public javax.swing.JTable tablaprograma;
    private javax.swing.JButton ver;
    // End of variables declaration//GEN-END:variables
    private void obteneractividades() {
        try {
            serviciosactividad = ServicesLocator.getContratoServComplServices().obtenerServiciosActividad();
            Iterator<ServiceActivityDto> iter = serviciosactividad.iterator();
            while (iter.hasNext()) {
                actividades.add(ServicesLocator.getContratoServComplServices().obtenerActividadxNombre(iter.next().getNombreactividad()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelListVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pintaractividades() {
        Tools.borrartabla(tablaactividades, modeloactividad);
        Iterator<ActivityDto> iter = actividades.iterator();
        while (iter.hasNext()) {
            ActivityDto act = iter.next();
            modeloactividad.addRow(new Object[]{act.getNombre(), act.getProvincia()});
        }
    }

    private void obtenerprogramasactividades() {
        try {
            programaactividades = ServicesLocator.getPaqueteServices().obtenerProgramaActividadesxPaquete(control.panelprogramapaquete.programapaquete.getCodigopaquete());
        } catch (SQLException ex) {
            Logger.getLogger(PanelProgActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pintarprograma() {
        Tools.borrartabla(tablaprograma, modeloprograma);
        Iterator<ProgramActivityDto> iter = programaactividades.iterator();
        while (iter.hasNext()) {
            ProgramActivityDto pa = iter.next();
            String dia = String.valueOf(pa.getDia().getDate());
            String mes = String.valueOf(pa.getDia().getMonth() + 1);
            String anno = String.valueOf(pa.getDia().getYear() + 1900);
            modeloprograma.addRow(new Object[]{pa.getNombreactividad(), dia + "/" + mes + "/" + anno, pa.getHora(), pa.getDescripcionactividad()});
        }
    }

    private void actualizar() {
        obtenerprogramasactividades();
        pintarprograma();
    }

    private boolean valido(String codigo) {
        boolean result = true;
        Iterator<ProgramActivityDto> iter = programaactividades.iterator();
        while (iter.hasNext() && result) {
            if (iter.next().getNombreactividad().equals(codigo)) {
                result = false;
                Tools.errordate(control);
            }
        }
        return result;
    }

    private boolean valido1() {
        boolean result = programaactividades.size() > 0;
        if (!result) {
            Tools.errordate(control);
        }
        return result;
    }
}

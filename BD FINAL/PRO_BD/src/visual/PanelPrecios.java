/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import utils.Encription;
import java.awt.Component;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import model.ModeTransportDto;
import model.ModeCKDto;
import model.ModeHKDto;
import model.ModeREDto;
import model.ProgramActivityDto;
import model.ActivityDto;
import model.AgencyDto;
import model.ProgramPackDto;
import services.DistanciaServices;
import services.ContratoServComplServices;
import services.ServicesLocator;
import utils.Tools;
import utils.Cargando;

/**
 *
 * @author Victor
 */
public class PanelPrecios extends javax.swing.JPanel {

    private Paquete_IM control;
    private LinkedList<Component> c = new LinkedList<Component>();
    private float dtotalhotel;
    private float dtransportehotelaeropuerto;
    private float dtransporteactividadesdiarias;
    private float dtotaltransporte;
    private float dtotalactividades;
    private float dtotalpaquete;

    public PanelPrecios(Paquete_IM atras) {
        initComponents();
        control = atras;
        c.add(panel2);
        c.add(panel);
        Tools.actualizarcomponentes(c, PrincipalVisual.getInstance().getUsuario().getTema());
        siguiente.setEnabled(false);
        if (!control.iG.isInsert()) {
            actualizarventana();
        }
        if (control.iG.isVer()) {
            ver();
        }
    }

    private void ver() {
        LinkedList<JComponent> lista = new LinkedList<JComponent>();
        lista.add(cancelar);
        Tools.desactivar(lista);
    }

    private void actualizarventana() {
        ProgramPackDto pk = control.panelprogramapaquete.programapaquete;
        totalhotel.setText(String.valueOf(pk.getPreciototalhotel()));
        transporteha.setText(String.valueOf(pk.getPreciotransporteha()));
        transporteact.setText(String.valueOf(pk.getPreciotransporteactd()));
        totaltransporte.setText(String.valueOf(pk.getPreciototaltransporte()));
        totalactividades.setText(String.valueOf(pk.getPreciototalactividades()));
        totalpaquete.setText(String.valueOf(pk.getPreciototalpaquete()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalhotel = new javax.swing.JLabel();
        transporteha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        transporteact = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totaltransporte = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalactividades = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        totalpaquete = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 350, 10));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        panel.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        panel.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

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
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Precios del Programa de Paquete"));

        jLabel3.setText("Transporte Hotel-Aeropuerto:");

        jLabel2.setText("Total Hotel:");

        totalhotel.setText("0.0");

        transporteha.setText("0.0");

        jLabel5.setText("Transporte Actividades Diarias:");

        transporteact.setText("0.0");

        jLabel8.setText("Total Transporte:");

        totaltransporte.setText("0.0");

        jLabel9.setText("Total Actividades:");

        totalactividades.setText("0.0");

        jLabel10.setText("Total Paquete:");

        totalpaquete.setText("0.0");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalpaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalactividades, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transporteact, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(totalhotel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(transporteha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totaltransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalhotel))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(transporteha))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(transporteact))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(totaltransporte))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(totalactividades))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(totalpaquete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 380, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        control.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        control.actualizarpanel(control.getTipo() - 1);
    }//GEN-LAST:event_anteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed

    }//GEN-LAST:event_siguienteActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if (!control.iG.isVer()) {
            if (control.iG.isInsert()) {
                boolean existe;
                existe = existencodigos(control.panelprogramapaquete.codigo.getText(), control.panelprogramapaquete.nombre.getText(), true);

                if (!existe) {
                    if (confirmarmodificar()) {
                        insertarbd();
                    }
                }

            } else {
                boolean existe;
                if (control.paquete.getCodigopaquete().equals(control.panelprogramapaquete.codigo.getText())) {
                    existe = false;
                } else {
                    existe = existencodigos(control.panelprogramapaquete.codigo.getText(), null, false);
                }
                if (!existe) {
                    if (control.paquete.getNombrepaquete().equals(control.panelprogramapaquete.nombre.getText())) {
                        existe = false;
                    } else {
                        existe = existencodigos(null, control.panelprogramapaquete.nombre.getText(), false);
                    }
                }
                if (!existe) {
                    editarbd();
                }
            }
        } else {
            control.dispose();
        }
    }//GEN-LAST:event_aceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptar;
    public javax.swing.JButton anterior;
    public javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel2;
    public javax.swing.JButton siguiente;
    private javax.swing.JLabel totalactividades;
    private javax.swing.JLabel totalhotel;
    private javax.swing.JLabel totalpaquete;
    private javax.swing.JLabel totaltransporte;
    private javax.swing.JLabel transporteact;
    private javax.swing.JLabel transporteha;
    // End of variables declaration//GEN-END:variables
    //CALCULAR COSTOS DEL PAQUETE   
    public void generarPrecios() {
        Tools.decoracion(false);
        Cargando cargando = new Cargando(control, true, "", 2);
        Tools.decoracion(true);
        ctotalhotel();
        ctransportehotelaeropuerto();
        ctransporteactividadesdiarias();
        ctotaltransporte();
        ctotalactividades();
        ctotalpaquete();
    }

    private void ctotalhotel() {
        int cantidadnoches = (int)control.panelprogramapaquete.cantidaddenoches.getValue();
        float preciohabitacion = control.panelhotel.plan.getPrecio();
        dtotalhotel = cantidadnoches * preciohabitacion;
        totalhotel.setText(String.valueOf(dtotalhotel));
    }

    private void ctransportehotelaeropuerto() {
        float distanciaha = control.panelhotel.hotelactual.getDistanciaaeropuerto();
        float preciomodalidad = determinarprecio(control.panelvehiculo.modalidadtransporte);
        dtransportehotelaeropuerto = distanciaha * preciomodalidad;
        transporteha.setText(String.valueOf(dtransportehotelaeropuerto));
    }

    private void ctransporteactividadesdiarias() {
        float preciomodalidad = determinarprecio(control.panelvehiculo.modalidadtransporte);
        float sumatotal = 0.0f;
        String provinciahotel = control.panelhotel.hotelactual.getProvincia();
        Iterator<ProgramActivityDto> iter = control.panelactividades.programaactividades.iterator();
        while (iter.hasNext()) {
            ProgramActivityDto pa = iter.next();
            try {
                ActivityDto actividad = ServicesLocator.getContratoServComplServices().obtenerActividadxNombre(pa.getNombreactividad());
                String provinciaactividad = actividad.getProvincia();
                float distanciahotelactividad = ServicesLocator.getDistanciaServices().obtener(provinciahotel, provinciaactividad);
                float precioxrecorrido = preciomodalidad * distanciahotelactividad;
                sumatotal += precioxrecorrido;
            } catch (SQLException ex) {
                Logger.getLogger(PanelPrecios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dtransporteactividadesdiarias = sumatotal;
        transporteact.setText(String.valueOf(dtransporteactividadesdiarias));
    }

    private void ctotaltransporte() {
        dtotaltransporte = dtransportehotelaeropuerto + dtransporteactividadesdiarias;
        totaltransporte.setText(String.valueOf(dtotaltransporte));
    }

    private void ctotalactividades() {
        int cantidadpax = (int)control.panelprogramapaquete.cantidadpax.getValue();
        float sumatotal = 0.0f;
        Iterator<ProgramActivityDto> iter = control.panelactividades.programaactividades.iterator();
        while (iter.hasNext()) {
            ProgramActivityDto pa = iter.next();
            try {
                ActivityDto actividad = ServicesLocator.getContratoServComplServices().obtenerActividadxNombre(pa.getNombreactividad());
                float preciopax = ServicesLocator.getContratoServComplServices().obtenerPrecio(actividad.getCodigocontrato());
                float precioxactxpax = preciopax * cantidadpax;
                sumatotal += precioxactxpax;
            } catch (SQLException ex) {
                Logger.getLogger(PanelPrecios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dtotalactividades = sumatotal;
        totalactividades.setText(String.valueOf(dtotalactividades));
    }

    private void ctotalpaquete() {
        dtotalpaquete = dtotalhotel + dtotaltransporte + dtotalactividades;
        totalpaquete.setText(String.valueOf(dtotalpaquete));
    }

    private float determinarprecio(ModeTransportDto mod) {
        float precio = 0.0f;
        if (mod instanceof ModeCKDto) {
            precio = ((ModeCKDto) mod).getCostokm();
        } else if (mod instanceof ModeHKDto) {
            precio = ((ModeHKDto) mod).getCostokm_recorridos();
        } else if (mod instanceof ModeREDto) {
            precio = ((ModeREDto) mod).getCosto_recorrido();
        }
        return precio;
    }

    private void insertarbd() {
        try {
            ServicesLocator.getAgenciaServices().insertarPaquete(control.panelprogramapaquete.codigo.getText(), control.panelprogramapaquete.nombre.getText(), (int)control.panelprogramapaquete.cantidaddias.getValue(), dtotalpaquete, dtotalpaquete, AgencyDto.get().serial());
            Date fecha = Tools.ConDateSql(control.panelprogramapaquete.fechainicio.getDate());
            ServicesLocator.getPaqueteServices().insertarPrograma(fecha, (int)control.panelprogramapaquete.cantidaddias.getValue(), (int)control.panelprogramapaquete.cantidaddenoches.getValue(), dtotalhotel, dtransportehotelaeropuerto, dtransporteactividadesdiarias, dtotaltransporte, dtotalactividades, dtotalpaquete, control.panelprogramapaquete.codigo.getText(), control.panelvehiculo.modalidadtransporte.getTipomodalidadtransporte(), control.panelvehiculo.vehiculoactual.getChapa(), control.panelhotel.hotelactual.getNombre(), control.panelhotel.plan.getTipoalimento(), control.panelhotel.plan.getTipohabitacion());
            insertaractividades();
            ocuparvehiculo(control.panelvehiculo.vehiculoactual.getChapa());
            Tools.exito(control, "Paquete", "Insertado");//NOTIFICACION DE INSERCCION
            control.iG.setEstado(true);
            control.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_IM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editarbd() {
        try {
            ServicesLocator.getAgenciaServices().editarPaquete(control.paquete.getCodigopaquete(), control.panelprogramapaquete.codigo.getText(), control.panelprogramapaquete.nombre.getText(), (int)control.panelprogramapaquete.cantidaddias.getValue(), dtotalpaquete, dtotalpaquete, AgencyDto.get().serial());
            Date fecha = Tools.ConDateSql(control.panelprogramapaquete.fechainicio.getDate());
            ServicesLocator.getPaqueteServices().editarPrograma(control.panelprogramapaquete.programapaquete.getSerial_programapaquete(), fecha, (int)control.panelprogramapaquete.cantidaddias.getValue(),(int)control.panelprogramapaquete.cantidaddenoches.getValue(), dtotalhotel, dtransportehotelaeropuerto, dtransporteactividadesdiarias, dtotaltransporte, dtotalactividades, dtotalpaquete, control.panelvehiculo.modalidadtransporte.getTipomodalidadtransporte(), control.panelvehiculo.vehiculoactual.getChapa(), control.panelhotel.hotelactual.getNombre(), control.panelhotel.plan.getTipoalimento(), control.panelhotel.plan.getTipohabitacion());
            eliminaractividades();
            insertaractividades();
            desocuparvehiculo(control.panelprogramapaquete.programapaquete.getChapavehiculo());
            ocuparvehiculo(control.panelvehiculo.vehiculoactual.getChapa());
            Tools.exito(control, "Paquete", "Editado");//NOTIFICACION DE INSERCCION
            control.iG.setEstado(true);
            control.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrecios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ambos = true -> si existe uno o el otro
    //ambos = false -> si existe uno pero el otro tiene que estar null  
    private boolean existencodigos(String codigo, String nombre, boolean ambos) {
        boolean retorno = false;
        try {
            retorno = ambos ? ServicesLocator.getAgenciaServices().existePaquete(codigo) || ServicesLocator.getAgenciaServices().existePaqueteNombre(nombre) : (codigo == null ? ServicesLocator.getAgenciaServices().existePaqueteNombre(nombre) : ServicesLocator.getAgenciaServices().existePaquete(codigo));
            if (retorno) {
                Tools.existe(control, "Existe esta Ocurrencia (codigo-nombre) de Paquete en el Sistema");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuario_IM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    private void insertaractividades() {
        Iterator<ProgramActivityDto> iter = control.panelactividades.programaactividades.iterator();
        while (iter.hasNext()) {
            ProgramActivityDto pa = iter.next();
            try {
                ServicesLocator.getPaqueteServices().insertarProgramaActividad(pa.getNombreactividad(), control.panelprogramapaquete.codigo.getText(), pa.getDia(), pa.getHora(), pa.getDescripcionactividad());
            } catch (SQLException ex) {
                Logger.getLogger(PanelPrecios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void eliminaractividades() {
        try {
            ServicesLocator.getPaqueteServices().eliminarProgramaActividad(control.panelprogramapaquete.codigo.getText());
        } catch (SQLException ex) {
            Logger.getLogger(PanelPrecios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void desocuparvehiculo(String chapa) {
        try {
            ServicesLocator.getContratoTransporteServices().desocuparVehiculo(chapa);
        } catch (SQLException ex) {
            Logger.getLogger(PanelListVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ocuparvehiculo(String chapa) {
        try {
            ServicesLocator.getContratoTransporteServices().ocuparVehiculo(chapa);
        } catch (SQLException ex) {
            Logger.getLogger(PanelListVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean confirmarmodificar() {
        return JOptionPane.showConfirmDialog(control, "Está seguro/a de Insertar Paquete, Pues el Mismo No puede Ser Modificado", "Informacion", JOptionPane.YES_NO_OPTION) == 0;
    }
}

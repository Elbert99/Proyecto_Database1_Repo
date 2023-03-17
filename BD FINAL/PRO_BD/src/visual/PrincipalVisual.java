/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import model.AgencyDto;
import model.ContractTransportDto;
import model.PackDto;
import model.ProgramPackDto;
import model.RoleDto;
import model.UserDto;
import model.VehicleDto;
import reports.ServiciosReportes;
import services.ServicesLocator;
import utils.Cargando;
import utils.GestorInterface;
import utils.Image;
import utils.Tools;

/**
 *
 * @author Victor
 */
public class PrincipalVisual extends javax.swing.JFrame {

    private static PrincipalVisual ventanaprincipal;
    private UserDto usuario;
    private RoleDto rol;
    private JFrame atras;

    private JMenuBar menu;

    private JMenu micuenta;
    private JMenu archivo;
    private JMenu reportes;
    private JMenu actualizar;
    private JMenu ayuda;
    private JMenu espacio;
    private JMenu contrato;
    private JMenu listadocontratos;

    private JMenuItem informacion;
    private JMenuItem cambiartema;
    private JMenuItem cerrarsesion;

    private JMenuItem paqueteturisticoa;
    private JMenuItem usuarioa;
    private JMenuItem hotelac;
    private JMenuItem serviciocomplementarioac;
    private JMenuItem transporteac;
    private JMenuItem hotelr;
    private JMenuItem serviciocomplementarior;
    private JMenuItem transporter;
    private JMenuItem listadotemporadasr;
    private JMenuItem listadohotelesactivosr;
    private JMenuItem listadoprogramapaquetesr;
    private JMenuItem plandeingresos;
    private JMenuItem hotela;//1200
    private JMenuItem distanciaa;
    private JMenuItem tipotemporadaa;
    private JMenuItem vehiculospaquetes;
    private JMenuItem vigenciacontratos;
    private String titulo = "Control de Paquetes Turísticos";
    ;
    
    String menues = new String("");

    public PrincipalVisual(UserDto usuario, RoleDto rol, JFrame login) {
        initComponents();

        atras = login;
        ventanaprincipal = this;
        setResizable(false);
        this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());

        Image im = new Image(ventanaprincipal.getWidth(), ventanaprincipal.getHeight());
        im.setSize(ventanaprincipal.getWidth(), ventanaprincipal.getHeight());
        setContentPane(im);
        im.setLayout(null);

        menu = new JMenuBar();
        setJMenuBar(menu);

        //JmenuPrincipal
        micuenta = new JMenu("Mi Cuenta ");
        archivo = new JMenu(" Archivo ");
        menu.add(archivo);
        reportes = new JMenu("Reportes");
        menu.add(reportes);
        actualizar = new JMenu(" Actualizar Sistema  ");
        menu.add(actualizar);
        ayuda = new JMenu(" Ayuda ");
        menu.add(ayuda);
        espacio = new JMenu("");
        menu.add(espacio);

        informacion = new JMenuItem("Información");
        micuenta.add(informacion);
        informacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Informacion inform = new Informacion(atras, true);
                inform.setVisible(true);
            }
        });
        cambiartema = new JMenuItem("Cambiar Tema");
        micuenta.add(cambiartema);
        cambiartema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarTema aux = new CambiarTema(ventanaprincipal, rootPaneCheckingEnabled);
                aux.setVisible(true);
                if (!aux.isAcceso()) {
                    aux.cancelar();
                }
            }
        });
        cerrarsesion = new JMenuItem("Cerrar Sesión");
        micuenta.add(cerrarsesion);
        cerrarsesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ((IniciarSesion) atras).mostrar();
            }
        });

        //sub
        contrato = new JMenu("Crear Contrato");
        archivo.add(contrato);
        listadocontratos = new JMenu("Listado de Contratos");
        reportes.add(listadocontratos);

        //JmenuItem archivo
        paqueteturisticoa = new JMenuItem("Crear Paquete Turístico");
        archivo.add(paqueteturisticoa);
        paqueteturisticoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean continuar = false;
                do {
                    //Cargar los datos de la Bd
                    LinkedList<Object> lista = null;
                    try {
                        lista = Tools.GenericConvertObject(ServicesLocator.getAgenciaServices().obtenerPaquetes(AgencyDto.get().serial()));
                    } catch (SQLException ex) {
                        Logger.getLogger(PrincipalVisual.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //Crear Gestor
                    GestorArchivoGenerico gestor = GestorArchivoGenerico.getGestor(PrincipalVisual.getInstance(), true, new Paquete_IM(null, false), lista, new boolean[]{true, false, true}, "<" + Tools.sub(paqueteturisticoa.getText()) + ">");
                    gestor.setVisible(true);

                    //Preguntar si hay datos para eliminar
                    if (gestor.getEliminados().size() > 0) {
                        eliminarpaquete(gestor.getEliminados());
                    }

                    //Preguntar si se ha accedido a la Bd para cargar los nuevos datos a la Ram y mostrarlos en el Gestor
                    continuar = gestor.isEstado();
                } while (continuar);
            }
        });
        usuarioa = new JMenuItem("Crear Usuario");
        archivo.add(usuarioa);
        usuarioa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean continuar = false;
                do {
                    //Cargar los datos de la Bd
                    LinkedList<Object> lista = null;
                    try {
                        lista = Tools.GenericConvertObject(ServicesLocator.getAgenciaServices().obtenerUsuarios(AgencyDto.get().serial()));
                    } catch (SQLException ex) {
                        Logger.getLogger(PrincipalVisual.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //Crear Gestor 
                    GestorArchivoGenerico gestor = GestorArchivoGenerico.getGestor(PrincipalVisual.getInstance(), true, new Usuario_IM(null, false), lista, new boolean[]{true, true, true}, "<" + Tools.sub(usuarioa.getText()) + ">");
                    gestor.setVisible(true);

                    //Preguntar si hay datos para eliminar               
                    if (gestor.getEliminados().size() > 0) {
                        eliminarusuario(gestor.getEliminados());
                    }
                    //Preguntar si se ha accedido a la Bd para cargar los nuevos datos a la Ram y mostrarlos en el Gestor
                    continuar = gestor.isEstado();
                } while (continuar);
            }
        });

        hotela = new JMenuItem("Crear Hotel");
        archivo.add(hotela);
        hotela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean continuar = false;
                do {
                    //Cargar los datos de la Bd
                    LinkedList<Object> lista = null;

                    try {
                        lista = Tools.GenericConvertObject(ServicesLocator.getHotelServices().obtener());
                    } catch (SQLException ex) {
                        Logger.getLogger(PrincipalVisual.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(lista.size());
                    //Crear Gestor
                    GestorArchivoGenerico gestor = GestorArchivoGenerico.getGestor(PrincipalVisual.getInstance(), true, new Hotel_IM(null, false), lista, new boolean[]{true, true, true}, "<" + Tools.sub(hotela.getText()) + ">");
                    gestor.setVisible(true);

                    //Preguntar si hay datos para eliminar
                    if (gestor.getEliminados().size() > 0) {
                        eliminarhotel(gestor.getEliminados());
                    }
                    //Preguntar si se ha accedido a la Bd para cargar los nuevos datos a la Ram y mostrarlos en el Gestor
                    continuar = gestor.isEstado();
                } while (continuar);
            }
        });
        distanciaa = new JMenuItem("Crear Distancia");
        archivo.add(distanciaa);
        distanciaa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean continuar = false;
                do {
                    //Cargar los datos de la Bd
                    LinkedList<Object> lista = null;

                    try {
                        lista = Tools.GenericConvertObject(ServicesLocator.getDistanciaServices().obtenerDistancias());
                    } catch (SQLException ex) {
                        Logger.getLogger(PrincipalVisual.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //Crear Gestor
                    GestorArchivoGenerico gestor = GestorArchivoGenerico.getGestor(PrincipalVisual.getInstance(), true, new Distancia_IM(null, false), lista, new boolean[]{false, false, false}, "<" + Tools.sub(distanciaa.getText()) + ">");
                    gestor.setVisible(true);

                    //Preguntar si hay datos para eliminar
                    if (gestor.getEliminados().size() > 0) {
                        eliminardistancia(gestor.getEliminados());
                    }

                    //Preguntar si se ha accedido a la Bd para cargar los nuevos datos a la Ram y mostrarlos en el Gestor
                    continuar = gestor.isEstado();
                } while (continuar);
            }
        });
        tipotemporadaa = new JMenuItem("Crear Tipo Temporada"); //archivo.add(tipotemporadaa);
        tipotemporadaa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean continuar = false;
                do {
                    //Cargar los datos de la Bd
                    LinkedList<Object> lista = new LinkedList<Object>();

                    //Crear Gestor
                    GestorArchivoGenerico gestor = GestorArchivoGenerico.getGestor(PrincipalVisual.getInstance(), true, new TipoTemporada_IM(null, false), lista, new boolean[]{true, true, true}, "<" + Tools.sub(tipotemporadaa.getText()) + ">");
                    gestor.setVisible(true);

                    //Preguntar si hay datos para eliminar
                    //Preguntar si se ha accedido a la Bd para cargar los nuevos datos a la Ram y mostrarlos en el Gestor
                    continuar = gestor.isEstado();
                } while (continuar);
            }
        });
        //JmenuItem contrato
        hotelac = new JMenuItem("Hotel");
        contrato.add(hotelac);
        hotelac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean continuar = false;
                do {
                    //Cargar los datos de la Bd
                    LinkedList<Object> lista = null;
                    try {
                        lista = Tools.GenericConvertObject(ServicesLocator.getContratoHotelServices().obtener(AgencyDto.get().serial()));
                    } catch (SQLException ex) {
                        Logger.getLogger(PrincipalVisual.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //Crear Gestor
                    GestorArchivoGenerico gestor = GestorArchivoGenerico.getGestor(PrincipalVisual.getInstance(), true, new ContratoHotel_IM(null, false), lista, new boolean[]{true, true, true}, "<" + "Contrato Hotel" + ">");
                    gestor.setVisible(true);

                    //Preguntar si hay datos para eliminar
                    if (gestor.getEliminados().size() > 0) {
                        eliminarcontrato(gestor.getEliminados());
                    }
                    //Preguntar si se ha accedido a la Bd para cargar los nuevos datos a la Ram y mostrarlos en el Gestor
                    continuar = gestor.isEstado();
                } while (continuar);
            }
        });
        transporteac = new JMenuItem("Transporte");
        contrato.add(transporteac);
        transporteac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean continuar = false;
                do {
                    //Cargar los datos de la Bd
                    LinkedList<Object> lista = null;
                    try {
                        lista = Tools.GenericConvertObject(ServicesLocator.getContratoTransporteServices().obtener(AgencyDto.get().serial()));
                    } catch (SQLException ex) {
                        Logger.getLogger(PrincipalVisual.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //Crear Gestor
                    GestorArchivoGenerico gestor = GestorArchivoGenerico.getGestor(PrincipalVisual.getInstance(), true, new ContratoTransporte_IM(null, false), lista, new boolean[]{true, true, true}, "<" + "Contrato Transporte" + ">");
                    gestor.setVisible(true);

                    //Preguntar si hay datos para eliminar
                    if (gestor.getEliminados().size() > 0) {
                        eliminarcontrato(gestor.getEliminados());
                    }
                    //Preguntar si se ha accedido a la Bd para cargar los nuevos datos a la Ram y mostrarlos en el Gestor
                    continuar = gestor.isEstado();
                } while (continuar);
            }
        });
        serviciocomplementarioac = new JMenuItem("Servicio Complementario");
        contrato.add(serviciocomplementarioac);
        serviciocomplementarioac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean continuar = false;
                do {
                    //Cargar los datos de la Bd
                    LinkedList<Object> lista = null;
                    try {
                        lista = Tools.GenericConvertObject(ServicesLocator.getContratoServComplServices().obtener(AgencyDto.get().serial()));
                    } catch (SQLException ex) {
                        Logger.getLogger(PrincipalVisual.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //Crear Gestor
                    GestorArchivoGenerico gestor = GestorArchivoGenerico.getGestor(PrincipalVisual.getInstance(), true, new ContratoServCompl_IM(null, false), lista, new boolean[]{true, true, true}, "<" + "Contrato Transporte" + ">");
                    gestor.setVisible(true);

                    //Preguntar si hay datos para eliminar
                    if (gestor.getEliminados().size() > 0) {
                        eliminarcontrato(gestor.getEliminados());
                    }
                    //Preguntar si se ha accedido a la Bd para cargar los nuevos datos a la Ram y mostrarlos en el Gestor
                    continuar = gestor.isEstado();
                } while (continuar);
            }
        });
        //JmenuItem Reportes
        listadotemporadasr = new JMenuItem("Listado de Temporadas");
        reportes.add(listadotemporadasr);
        listadohotelesactivosr = new JMenuItem("Listado de Hoteles Activos");
        reportes.add(listadohotelesactivosr);
        listadohotelesactivosr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiciosReportes.reports.CargarHoteles();
            }
        });
        listadoprogramapaquetesr = new JMenuItem("Listado de Programas de Paquetes Turísticos");
        reportes.add(listadoprogramapaquetesr);
        listadoprogramapaquetesr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ServiciosReportes.reports.CargarPaqueteTuristico();
            }
        });
        plandeingresos = new JMenuItem("Plan de Ingresos por Concepto de Ventas de Paquetes Turísticos");
        reportes.add(plandeingresos);

        //JmenuItem Listado Contrato
        hotelr = new JMenuItem("Hotel");
        listadocontratos.add(hotelr);
        hotelr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiciosReportes.reports.CargarContratoHotel();
            }
        });
        serviciocomplementarior = new JMenuItem("Servicio Complementario");
        listadocontratos.add(serviciocomplementarior);
        serviciocomplementarior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiciosReportes.reports.CargarServiciosComplementario();
            }
        });
        transporter = new JMenuItem("Transporte");
        listadocontratos.add(transporter);
        transporter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiciosReportes.reports.CargarCONTRATOTRANSPORTE();
            }
        });
        //JmenuItem actualizar
        vehiculospaquetes = new JMenuItem("Vehículos de Paquetes");
        actualizar.add(vehiculospaquetes);
        vehiculospaquetes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desocuparlosvehiculos();
            }
        });
        vigenciacontratos = new JMenuItem("Vigencia de Contratos"); //actualizar.add(vigenciacontratos);
        refreshuser(usuario, rol);
        refreshitem();
        menu.add(micuenta);
    }

    public void refreshitem() {
        ocultar();
        mostrar();
        espacio.setText(establecerespacio(cerrarsesion));
        espacio.setEnabled(false);
    }

    //Patron Singelton
    public static PrincipalVisual getVentanaPrincipal(UserDto us, RoleDto ro, JFrame login) {
        if (ventanaprincipal == null) {
            ventanaprincipal = new PrincipalVisual(us, ro, login);
        } else {
            PrincipalVisual.getInstance().refreshuser(us, ro);
            PrincipalVisual.getInstance().refreshitem();
        }
        return ventanaprincipal;
    }

    public static PrincipalVisual getInstance() {
        return ventanaprincipal;
    }

    private void mostrar() {
        iniciarmenues();
        if (rol.isTrabajador()) {
            archivo.setVisible(true);
            menues += (archivo.getText());
            paqueteturisticoa.setVisible(true);
            actualizar.setVisible(true);
            menues += (actualizar.getText());
            vehiculospaquetes.setVisible(true);
        } else if (rol.isInformatico()) {
            archivo.setVisible(true);
            menues += (archivo.getText());
            usuarioa.setVisible(true);
        } else if (rol.isGerente()) {
            archivo.setVisible(true);
            menues += (archivo.getText());
            contrato.setVisible(true);
            hotelac.setVisible(true);
            serviciocomplementarioac.setVisible(true);
            transporteac.setVisible(true);
            //actualizar.setVisible(true);
            menues += (actualizar.getText());
            //vigenciacontratos.setVisible(true);
        } else if (rol.isConsultor()) {
            reportes.setVisible(true);
            menues += (reportes.getText());
            listadocontratos.setVisible(true);
            hotelr.setVisible(true);
            serviciocomplementarior.setVisible(true);
            transporter.setVisible(true);
            listadotemporadasr.setVisible(true);
            listadohotelesactivosr.setVisible(true);
            listadoprogramapaquetesr.setVisible(true);
            plandeingresos.setVisible(true);
        } else if (rol.isAdministrador()) {
            archivo.setVisible(true);
            menues += (archivo.getText());
            hotela.setVisible(true);
            distanciaa.setVisible(true);
            tipotemporadaa.setVisible(true);
        }
    }

    private void ocultar() {
        limpiarmenues();
        archivo.setVisible(false);
        paqueteturisticoa.setVisible(false);
        usuarioa.setVisible(false);
        contrato.setVisible(false);
        hotelac.setVisible(false);
        serviciocomplementarioac.setVisible(false);
        transporteac.setVisible(false);
        hotela.setVisible(false);
        distanciaa.setVisible(false);
        tipotemporadaa.setVisible(false);

        reportes.setVisible(false);
        listadocontratos.setVisible(false);
        hotelr.setVisible(false);
        serviciocomplementarior.setVisible(false);
        transporter.setVisible(false);
        listadotemporadasr.setVisible(false);
        listadohotelesactivosr.setVisible(false);
        listadoprogramapaquetesr.setVisible(false);
        plandeingresos.setVisible(false);

        actualizar.setVisible(false);
        vehiculospaquetes.setVisible(false);
        vigenciacontratos.setVisible(false);
    }

    public UserDto getUsuario() {
        return usuario;
    }

    public RoleDto getRol() {
        return rol;
    }

    public void setUsuario(UserDto usuario) {
        this.usuario = usuario;
    }

    public void setRol(RoleDto rol) {
        this.rol = rol;
        if (rol.isTrabajador()) {
            setTitle(titulo + " (Frontend)");
        } else {
            setTitle(titulo + " (Backend)");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de Paquetes Turísticos");
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Refrescar

    public void refreshuser(UserDto usuario, RoleDto rol) {
        setUsuario(usuario);
        setRol(rol);
        Tools.tema(usuario.getTema());
    }

    //Establecer espacio para colocar un JMenu al final de la barra de Menues
    private String establecerespacio(AbstractButton ultimo) {
        String espacio = "";
        float widthcadena = getWidth() / 4.3f;
        int cantespaciocadena = (int) (widthcadena - (menues.length() + ultimo.getText().length()));
        for (int i = 0; i < cantespaciocadena; i++) {
            espacio += " ";
        }
        // System.out.println(cantespaciocadena);
        return espacio;
    }

    private void limpiarmenues() {
        menues = "";
    }

    private void iniciarmenues() {
        menues += (ayuda.getText());
    }

    //METODOS DE ELIMINAR
    private void eliminarusuario(LinkedList<String> lista) {
        Iterator<String> iter = lista.iterator();
        while (iter.hasNext()) {
            try {
                ServicesLocator.getAgenciaServices().eliminarUsuario(iter.next());
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalVisual.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void eliminarhotel(LinkedList<String> lista) {
        Iterator<String> iter = lista.iterator();
        while (iter.hasNext()) {
            try {
                ServicesLocator.getHotelServices().eliminar(iter.next());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminarcontrato(LinkedList<String> lista) {
        Iterator<String> iter = lista.iterator();
        while (iter.hasNext()) {
            try {
                ServicesLocator.getAgenciaServices().eliminarContrato(iter.next());
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalVisual.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void eliminardistancia(LinkedList<String> lista) {
        Iterator<String> iter = lista.iterator();
        while (iter.hasNext()) {
            try {
                String str = iter.next();
                int posm = str.indexOf(' ');
                ServicesLocator.getDistanciaServices().eliminar(str.substring(0, posm), str.substring(posm + 1, str.length()));
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalVisual.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void eliminarpaquete(LinkedList<String> lista) {
        Iterator<String> iter = lista.iterator();
        while (iter.hasNext()) {
            try {
                ServicesLocator.getAgenciaServices().eliminarPaquete(iter.next());
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalVisual.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //PROCESOS DE ACTUALIZACIONES   
    private int diferenciaendias(Date mayor, Date menor) {
        long diferenciames = mayor.getTime() - menor.getTime();
        long dias = diferenciames / (1000 * 60 * 60 * 24);
        return (int) dias;
    }

    private java.util.Date sumar(java.util.Date actual, int dias) {
        java.util.Date result = null;
        Calendar c = Calendar.getInstance();
        c.setTime(actual);
        c.add(Calendar.DATE, dias);
        result = (java.util.Date) c.getTime();
        return result;
    }

    public void desocuparlosvehiculos() {
        try {
            LinkedList<PackDto> paquetes = ServicesLocator.getAgenciaServices().obtenerPaquetes(AgencyDto.get().serial());
            LinkedList<ProgramPackDto> programas = new LinkedList<ProgramPackDto>();
            Iterator<PackDto> iter = paquetes.iterator();
            while (iter.hasNext()) {
                programas.add(ServicesLocator.getPaqueteServices().obtenerProgramaPaquete(iter.next().getCodigopaquete()));
            }
            LinkedList<VehicleDto> vehiculos = new LinkedList<VehicleDto>();
            Iterator<ProgramPackDto> iter1 = programas.iterator();
            while (iter1.hasNext()) {
                vehiculos.add(ServicesLocator.getContratoTransporteServices().obtenerVehiculoChapa(iter1.next().getChapavehiculo()));
            }
            int cant = 0;
            for (int i = 0; i < programas.size(); i++) {
                java.util.Date fechafutura = sumar(programas.get(i).getFechainicial(), programas.get(i).getCantdias());
                if (AgencyDto.get().getFechaactual().after(fechafutura)) {
                    VehicleDto v = vehiculos.get(i);
                    if (ServicesLocator.getContratoTransporteServices().isOcupado(v.getChapa())) {
                        ServicesLocator.getContratoTransporteServices().desocuparVehiculo(v.getChapa());
                        ++cant;
                    }
                }
            }
            Tools.decoracion(false);
            Cargando cargando = new Cargando(null, true, "", 2);
            Tools.decoracion(true);
            if (cant == 0) {
                JOptionPane.showMessageDialog(this, "Todos los Vehiculos estan desocupados");
            } else {
                JOptionPane.showMessageDialog(this, "Se desocuparon " + cant + " Vehiculos en el Sistema");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PrincipalVisual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


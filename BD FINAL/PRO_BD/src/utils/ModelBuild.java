/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ActivityDto;
import model.ContractHotelDto;
import model.ContractServComplDto;
import model.ContractTransportDto;
import model.DistanceDto;
import model.HotelDto;
import model.PackDto;
import model.ServiceLodginDto;
import model.SeasonDto;
import model.TypeSeasonDto;
import model.UserDto;
import services.ServicesLocator;

/**
 *
 * @author Victor
 */
public class ModelBuild {
    private DefaultTableModel vacio;
    private DefaultTableModel paquete;
    private DefaultTableModel usuario;
    private DefaultTableModel contratohotel;
    private DefaultTableModel contratoservcompl;
    private DefaultTableModel contratotransporte;
    private DefaultTableModel hotel;
    private DefaultTableModel distancia;
    private DefaultTableModel tipotemporada;
  
    public ModelBuild(){
        construirmodelos();
    }    
    public DefaultTableModel clear(){
        return vacio;
    } 
    public DefaultTableModel actualizarmodelo(LinkedList<Object> lista,JTable tabla){
        DefaultTableModel result=null;
        
        if(lista.getFirst() instanceof PackDto){
            result=crearpaquete(lista, tabla);
        }else
        if(lista.getFirst() instanceof UserDto){
            result=crearusuario(lista,tabla); 
        }else
        if(lista.getFirst() instanceof ContractHotelDto){
            result = crearcontratohotel(lista, tabla);
        }else
        if(lista.getFirst() instanceof ContractServComplDto){
            result = crearcontratoservcompl(lista, tabla);
        }else    
        if(lista.getFirst() instanceof ContractTransportDto){
            result=crearcontratotrasnporte(lista, tabla);
        }else    
        if(lista.getFirst() instanceof HotelDto){    
            result=crearhotel(lista, tabla);
        }else
        if(lista.getFirst() instanceof DistanceDto){
            result=creardistancia(lista, tabla);
        }else
        if(lista.getFirst() instanceof TypeSeasonDto){
            result=creartipotemporada(lista, tabla);
        }    
        
        
        return result;
    }
    
    //Todos los MODELOS de los datos independientes de la Bd
    private void construirmodelos() { 
        vacio = new DefaultTableModel(new Object[]{"-------------- Registro Vacío --------------"}, 0x0){
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            }
        };
        
        paquete = new DefaultTableModel(new Object[]{"Cod. Paquete","Nombre Paquete","Cant. Pax","Costo Total","Precio Total"}, 0x0){
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            }
        };
        
        usuario = new DefaultTableModel(new Object[]{"Id","Nombre","Primer A.","Segundo A.","Nick","Rol"}, 0x0){
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            }
        };
        
        contratohotel = new DefaultTableModel(new Object[]{"Cod. Contrato","F. Inicio","F. Terminación","F. Conciliación","Nombre Hotel","Nombre Temp."}, 0x0){
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            }
        };
        
        contratoservcompl = new DefaultTableModel(new Object[]{"Cod. Contrato","F. Inicio","F. Terminación","F. Conciliación","Nombre Act.","Costo por Pax"}, 0x0){
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            }
        };
    
        contratotransporte = new DefaultTableModel(new Object[]{"Cod. Contrato","F. Inicio","F. Terminación","F. Conciliación","Tipo Prestario"}, 0x0){
            public boolean isCellEditable(int rowIndex,int columnIndex){//
                return false;
            }
        };
        
        hotel = new DefaultTableModel(new Object[]{"Fecha","Nombre","Cadena H.","Teltefono","Fax","Email","Dist. Ciud.","Dist. Aerop","Cant. de Hab.","Cant. de Pis.","Localización","Prov.","Categ."}, 0x0){
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            }
        };
        
        distancia = new DefaultTableModel(new Object[]{"Prov. Inicial","Prov. Final","Dist. en Km"}, 0x0){
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            }
        };
        
        tipotemporada = new DefaultTableModel(new Object[]{"Nombre Temporada","Porciento de Variación"}, 0x0){
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            }
        };
    }
    
    //LLenar Modelos en Dependencia con los objetos hijos
    
    public DefaultTableModel crearpaquete(LinkedList<Object> lista,JTable tabla){
        Tools.borrartabla(tabla, paquete);
        Iterator<Object> iter = lista.iterator();
        while(iter.hasNext()){
            PackDto o = (PackDto)iter.next();
            paquete.addRow(new Object[]{o.getCodigopaquete(),o.getNombrepaquete(),o.getCantpax(),o.getCostototal(),o.getPreciototal()});
        }
        return paquete;
    }

    private DefaultTableModel crearusuario(LinkedList<Object> lista, JTable tabla) {
        Tools.borrartabla(tabla, usuario);
        Iterator<Object> iter = lista.iterator();
        while(iter.hasNext()){
            UserDto o = (UserDto)iter.next();
            usuario.addRow(new Object[]{o.getId(),o.getNombre(),o.getPrimerapll(),o.getSegundoapll(),o.getNick(),o.getRol()});
        }
        return usuario;
    }
    
    private DefaultTableModel crearcontratotrasnporte(LinkedList<Object> lista, JTable tabla) {
        Tools.borrartabla(tabla, contratotransporte);
        Iterator<Object> iter = lista.iterator();
        while(iter.hasNext()){
            ContractTransportDto o = (ContractTransportDto)iter.next();
    
            String diafi = String.valueOf(o.getFechainicio().getDate());
            String mesfi = String.valueOf(o.getFechainicio().getMonth()+1);
            String annofi = String.valueOf(o.getFechainicio().getYear()+1900);
            
            String diaft = String.valueOf(o.getFechaterminacion().getDate());
            String mesft = String.valueOf(o.getFechaterminacion().getMonth()+1);
            String annoft = String.valueOf(o.getFechaterminacion().getYear()+1900);
            
            String diafc = String.valueOf(o.getFechaconciliacion().getDate());
            String mesfc = String.valueOf(o.getFechaconciliacion().getMonth()+1);
            String annofc = String.valueOf(o.getFechaconciliacion().getYear()+1900);
            
            contratotransporte.addRow(new Object[]{o.getCodigocontrato(),diafi+"/"+mesfi+"/"+annofi,diaft+"/"+mesft+"/"+annoft,diafc+"/"+mesfc+"/"+annofc,o.getTipoprestario()});
        }
        return contratotransporte;
    }
    private DefaultTableModel crearcontratohotel(LinkedList<Object> lista, JTable tabla) {
        Tools.borrartabla(tabla, contratohotel);
        Iterator<Object> iter = lista.iterator();
        while(iter.hasNext()){
            ContractHotelDto o = (ContractHotelDto)iter.next();
    
            String diafi = String.valueOf(o.getFechainicio().getDate());
            String mesfi = String.valueOf(o.getFechainicio().getMonth()+1);
            String annofi = String.valueOf(o.getFechainicio().getYear()+1900);
            
            String diaft = String.valueOf(o.getFechaterminacion().getDate());
            String mesft = String.valueOf(o.getFechaterminacion().getMonth()+1);
            String annoft = String.valueOf(o.getFechaterminacion().getYear()+1900);
            
            String diafc = String.valueOf(o.getFechaconciliacion().getDate());
            String mesfc = String.valueOf(o.getFechaconciliacion().getMonth()+1);
            String annofc = String.valueOf(o.getFechaconciliacion().getYear()+1900);
            
            ServiceLodginDto sa = null;
            SeasonDto temp = null;
            try {//OBTENER SERV. ALOJAMIENTO //OBTENER TEMPORADA
                sa = ServicesLocator.getContratoHotelServices().obtenerServicioAlojamientoxContrato(o.getCodigocontrato());
                temp = ServicesLocator.getContratoHotelServices().obtenerTemporadaxContratoHotel(o.getCodigocontrato());
            } catch (SQLException ex) {
                Logger.getLogger(ModelBuild.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            contratohotel.addRow(new Object[]{o.getCodigocontrato(),diafi+"/"+mesfi+"/"+annofi,diaft+"/"+mesft+"/"+annoft,diafc+"/"+mesfc+"/"+annofc,sa.getNombrehotel(),temp.getNombretemporada()});
        }
        return contratohotel;
    }
    private DefaultTableModel crearcontratoservcompl(LinkedList<Object> lista, JTable tabla) {
        Tools.borrartabla(tabla, contratoservcompl);
        Iterator<Object> iter = lista.iterator();
        while(iter.hasNext()){
            ContractServComplDto o = (ContractServComplDto)iter.next();
    
            String diafi = String.valueOf(o.getFechainicio().getDate());
            String mesfi = String.valueOf(o.getFechainicio().getMonth()+1);
            String annofi = String.valueOf(o.getFechainicio().getYear()+1900);
            
            String diaft = String.valueOf(o.getFechaterminacion().getDate());
            String mesft = String.valueOf(o.getFechaterminacion().getMonth()+1);
            String annoft = String.valueOf(o.getFechaterminacion().getYear()+1900);
            
            String diafc = String.valueOf(o.getFechaconciliacion().getDate());
            String mesfc = String.valueOf(o.getFechaconciliacion().getMonth()+1);
            String annofc = String.valueOf(o.getFechaconciliacion().getYear()+1900);
            
            //Obtener Actividad
            ActivityDto act = null;
            try {
                act = ServicesLocator.getContratoServComplServices().obtenerActividadxContrato(o.getCodigocontrato());
            } catch (SQLException ex) {
                Logger.getLogger(ModelBuild.class.getName()).log(Level.SEVERE, null, ex);
            }
            contratoservcompl.addRow(new Object[]{o.getCodigocontrato(),diafi+"/"+mesfi+"/"+annofi,diaft+"/"+mesft+"/"+annoft,diafc+"/"+mesfc+"/"+annofc,act.getNombre(),o.getCostopax()});
        }
        return contratoservcompl;
    }
    private DefaultTableModel crearhotel(LinkedList<Object> lista, JTable tabla) {
        Tools.borrartabla(tabla, hotel);
        Iterator<Object> iter = lista.iterator();
        while(iter.hasNext()){
            HotelDto o = (HotelDto)iter.next();
            String dia = String.valueOf(o.getFecha().getDate());
            String mes = String.valueOf(o.getFecha().getMonth()+1);
            String anno = String.valueOf(o.getFecha().getYear()+1900);
            hotel.addRow(new Object[]{dia+"/"+mes+"/"+anno,o.getNombre(),o.getCadenahotelera(),o.getTelefono(),o.getFax(),o.getEmail(),String.valueOf(o.getDistanciaciudadcerca()),String.valueOf(o.getDistanciaaeropuerto()),String.valueOf(o.getCantidadhabitaciones()),String.valueOf(o.getCantidadpisos()),o.getLocalizacion(),o.getProvincia(),o.getCategoria()});
        }
        return hotel;
    }
    
    private DefaultTableModel creardistancia(LinkedList<Object> lista, JTable tabla) {
        Tools.borrartabla(tabla, distancia);
        Iterator<Object> iter = lista.iterator();
        while(iter.hasNext()){
            DistanceDto o = (DistanceDto)iter.next();
            distancia.addRow(new Object[]{o.getProvinciaInicial(),o.getProvinciaFinal(),String.valueOf(o.getDistanciakm())});
        }
        return distancia;
    }
    
    private DefaultTableModel creartipotemporada(LinkedList<Object> lista, JTable tabla) {
        Tools.borrartabla(tabla, tipotemporada);
        Iterator<Object> iter = lista.iterator();
        while(iter.hasNext()){
            TypeSeasonDto o = (TypeSeasonDto)iter.next();
            tipotemporada.addRow(new Object[]{o.getNombretemporada(),String.valueOf(o.getPorcientovariacion())});
        }
        return tipotemporada;
    }
    
}

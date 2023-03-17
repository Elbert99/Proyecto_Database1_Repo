/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import model.ContractTransportDto;
import model.ModeCKDto;
import model.ModeHKDto;
import model.ModeREDto;
import model.ServiceTransportDto;
import model.VehicleDto;

/**
 *
 * @author Victor
 */
public class ContratoTransporteServices {
    public void insertar(String tipoprestario, String codigo, Date fechainicio, Date fechaterminacion, Date fechaconciliacion, String descripcion,int llave_agencia,String tipocontrato)throws SQLException{
        String function = "{call \"insertar_contrato_transporte\"(?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,tipoprestario);
        preparedFunction.setString(2,codigo);
        preparedFunction.setDate(3,fechainicio);
        preparedFunction.setDate(4,fechaterminacion);
        preparedFunction.setDate(5,fechaconciliacion);
        preparedFunction.setString(6,descripcion);
        preparedFunction.setInt(7,llave_agencia);
        preparedFunction.setString(8,tipocontrato);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editar(String tipoprestario,String codigoid ,String codigo, Date fechainicio, Date fechaterminacion, Date fechaconciliacion, String descripcion,int llave_agencia,String tipocontrato)throws SQLException{
        String function = "{call \"editar_contrato_transporte\"(?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,tipoprestario);
        preparedFunction.setString(2,codigoid);
        preparedFunction.setString(3,codigo);
        preparedFunction.setDate(4,fechainicio);
        preparedFunction.setDate(5,fechaterminacion);
        preparedFunction.setDate(6,fechaconciliacion);
        preparedFunction.setString(7,descripcion);
        preparedFunction.setInt(8,llave_agencia);
        preparedFunction.setString(9,tipocontrato);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public LinkedList<ContractTransportDto> obtener(int serialagencia)throws SQLException{
        LinkedList<ContractTransportDto> listacontratos = new LinkedList<ContractTransportDto>();
        String function = "{?=call obtener_contratos_transporte(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setInt(2, serialagencia);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listacontratos.add(new ContractTransportDto(resultSet.getString(1),resultSet.getString(2),resultSet.getDate(3),resultSet.getDate(4),resultSet.getDate(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8)));
        }
        preparedFunction.close();
        connection.close();
        return listacontratos;
    }//PRESTARIO
    public LinkedList<String> obtenerPrestarios()throws SQLException{
        LinkedList<String> listatipos = new LinkedList<String>();
        String function = "{?=call obtener_prestarios()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listatipos.add(resultSet.getString(1));
        }
        preparedFunction.close();
        connection.close();
        return listatipos;
    }
    //VEHICULO
    public boolean existeVehiculo(String codigo)throws SQLException{
        boolean retorno = false;
        String function = "{?=call existe_vehiculo(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.BOOLEAN);
        preparedFunction.setString(2,codigo);
        preparedFunction.execute();
        retorno = preparedFunction.getBoolean(1);
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    public boolean isOcupado(String codigo)throws SQLException{
        boolean retorno = false;
        String function = "{?=call isocupado(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.BOOLEAN);
        preparedFunction.setString(2,codigo);
        preparedFunction.execute();
        retorno = preparedFunction.getBoolean(1);
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    public void insertarVehiculo(String chapa, String marca, String color, int capsinequip, int capconequip, int captotal, int annofabricacion, boolean ocupado, String codigocontrato)throws SQLException{
        String function = "{call \"insertar_vehiculo\"(?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,chapa);
        preparedFunction.setString(2,marca);
        preparedFunction.setString(3,color);
        preparedFunction.setInt(4,capsinequip);
        preparedFunction.setInt(5,capconequip);
        preparedFunction.setInt(6,captotal);
        preparedFunction.setInt(7,annofabricacion);
        preparedFunction.setBoolean(8,ocupado);
        preparedFunction.setString(9,codigocontrato);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editarVehiculo(String chapaid,String chapa, String marca, String color, int capsinequip, int capconequip, int captotal, int annofabricacion, boolean ocupado)throws SQLException{
        String function = "{call \"editar_vehiculo\"(?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,chapaid);
        preparedFunction.setString(2,chapa);
        preparedFunction.setString(3,marca);
        preparedFunction.setString(4,color);
        preparedFunction.setInt(5,capsinequip);
        preparedFunction.setInt(6,capconequip);
        preparedFunction.setInt(7,captotal);
        preparedFunction.setInt(8,annofabricacion);
        preparedFunction.setBoolean(9,ocupado);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void eliminarVehiculo(String chapa)throws SQLException{
        String function = "{call \"eliminar_vehiculo\"(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,chapa);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public LinkedList<VehicleDto> obtenerVehiculosxContrato(String codigocontrato)throws SQLException{
        LinkedList<VehicleDto> listavehiculos = new LinkedList<VehicleDto>();
        String function = "{?=call obtener_vehiculos_contrato(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,codigocontrato);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listavehiculos.add(new VehicleDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getBoolean(8),resultSet.getString(9)));
        }
        preparedFunction.close();
        connection.close();
        return listavehiculos;
    }
    public VehicleDto obtenerVehiculoChapa(String chapa)throws SQLException{
        VehicleDto retorno = null;
        String function = "{?=call obtener_vehiculo_chapa(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,chapa);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno = new VehicleDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getBoolean(8),resultSet.getString(9));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    //SERVICIO TRANSPORTE
    public void insertarServicioTransporte(boolean activo, String chapaid)throws SQLException{
        String function = "{call \"insertar_servicio_transporte\"(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setBoolean(1,activo);
        preparedFunction.setString(2,chapaid);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editarServicioTransporte(int serialservicio,boolean activo)throws SQLException{
        String function = "{call \"editar_servicio_transporte\"(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1,serialservicio);
        preparedFunction.setBoolean(2,activo);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public LinkedList<ServiceTransportDto> obtenerServiciosTransporte()throws SQLException{
        LinkedList<ServiceTransportDto> listaservicios = new LinkedList<ServiceTransportDto>();
        String function = "{?=call obtener_servicios_transporte()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listaservicios.add(new ServiceTransportDto(resultSet.getInt(1),resultSet.getBoolean(2),resultSet.getString(3)));
        }
        preparedFunction.close();
        connection.close();
        return listaservicios;
    }
    public ServiceTransportDto obtenerServicioTransportexVehiculo(String chapa)throws SQLException{
        ServiceTransportDto retorno = null;
        String function = "{?=call obtener_servicio_transporte_vehiculo(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,chapa);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno = new ServiceTransportDto(resultSet.getInt(1),resultSet.getBoolean(2),resultSet.getString(3));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    //Modalidades Transporte
    public LinkedList<String> obtenerTiposModalidadTransporte()throws SQLException{
        LinkedList<String> listatipos = new LinkedList<String>();
        String function = "{?=call obtener_tipos_modalidad_transporte()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listatipos.add(resultSet.getString(1));
        }
        preparedFunction.close();
        connection.close();
        return listatipos;
    }
    public void eliminarModalidadTransporte(int serial)throws SQLException{
        String function = "{call \"eliminar_modalidad_transporte\"(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1,serial);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    //Modalidades Derivadas
    //CostoKm
    public void insertarModalidadCostoKm(double costokm, double costokm_idavuelta, double costo_horasesperas,String chapavehiculo, String tipomodalidadtransporte)throws SQLException{
        String function = "{call \"insertar_modalidad_costokm\"(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setDouble(1,costokm);
        preparedFunction.setDouble(2,costokm_idavuelta);
        preparedFunction.setDouble(3,costo_horasesperas);
        preparedFunction.setString(4,chapavehiculo);
        preparedFunction.setString(5,tipomodalidadtransporte);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editarModalidadCostoKm(double costokm, double costokm_idavuelta, double costo_horasesperas,int serialmodalidad)throws SQLException{
        String function = "{call \"editar_modalidad_costokm\"(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setDouble(1,costokm);
        preparedFunction.setDouble(2,costokm_idavuelta);
        preparedFunction.setDouble(3,costo_horasesperas);
        preparedFunction.setInt(4,serialmodalidad);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public ModeCKDto obtenerModalidadCostoKmxVehiculo(String chapa)throws SQLException{
        ModeCKDto retorno = null;
        String function = "{?=call obtener_modalidad_costokm(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,chapa);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno = new ModeCKDto(resultSet.getDouble(1),resultSet.getDouble(2),resultSet.getDouble(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    //HorasKm
    public void insertarModalidadHorasKm(double costokm_recorridos, double costo_horas, double costokm_extras, double costohoras_extras,String chapavehiculo, String tipomodalidadtransporte)throws SQLException{
        String function = "{call \"insertar_modalidad_horaskm\"(?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setDouble(1,costokm_recorridos);
        preparedFunction.setDouble(2,costo_horas);
        preparedFunction.setDouble(3,costokm_extras);
        preparedFunction.setDouble(4,costohoras_extras);
        preparedFunction.setString(5,chapavehiculo);
        preparedFunction.setString(6,tipomodalidadtransporte);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editarModalidadHorasKm(double costokm_recorridos, double costo_horas, double costokm_extras, double costohoras_extras,int serialmodalidad)throws SQLException{
        String function = "{call \"editar_modalidad_horaskm\"(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setDouble(1,costokm_recorridos);
        preparedFunction.setDouble(2,costo_horas);
        preparedFunction.setDouble(3,costokm_extras);
        preparedFunction.setDouble(4,costohoras_extras);
        preparedFunction.setInt(5,serialmodalidad);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public ModeHKDto obtenerModalidadHoraKmxVehiculo(String chapa)throws SQLException{
        ModeHKDto retorno = null;
        String function = "{?=call obtener_modalidad_horaskm(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,chapa);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno = new ModeHKDto(resultSet.getDouble(1),resultSet.getDouble(2),resultSet.getDouble(3),resultSet.getDouble(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    //RecorridosEstablecidos
    public void insertarModalidadRecorrido(String descripcion,double costo_idavuelta, double costo_recorrido,String chapavehiculo, String tipomodalidadtransporte)throws SQLException{
        String function = "{call \"insertar_modalidad_recorridosest\"(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,descripcion);
        preparedFunction.setDouble(2,costo_idavuelta);
        preparedFunction.setDouble(3,costo_recorrido);
        preparedFunction.setString(4,chapavehiculo);
        preparedFunction.setString(5,tipomodalidadtransporte);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editarModalidadRecorrido(String descripcion,double costo_idavuelta, double costo_recorrido,int serialmodalidad)throws SQLException{
        String function = "{call \"editar_modalidad_recorridosest\"(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,descripcion);
        preparedFunction.setDouble(2,costo_idavuelta);
        preparedFunction.setDouble(3,costo_recorrido);
        preparedFunction.setInt(4,serialmodalidad);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }        
    public LinkedList<ModeREDto> obtenerModalidadesRecorridoxVehiculo(String chapa)throws SQLException{
        LinkedList<ModeREDto> retorno = new LinkedList<ModeREDto>();
        String function = "{?=call obtener_modalidades_recorridosest(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,chapa);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno.add(new ModeREDto(resultSet.getString(1),resultSet.getDouble(2),resultSet.getDouble(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6)));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }        
    
    public void ocuparVehiculo(String chapa)throws SQLException{
        String function = "{call \"ocupar_vehiculo\"(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,chapa);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    
    public void desocuparVehiculo(String chapa)throws SQLException{
        String function = "{call \"desocupar_vehiculo\"(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,chapa);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
}
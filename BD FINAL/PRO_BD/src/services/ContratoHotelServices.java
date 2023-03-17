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
import model.ContractHotelDto;
import model.PlainRoomFoodDto;
import model.ServiceLodginDto;
import model.SeasonDto;
import model.TypeSeasonDto;

/**
 *
 * @author Victor
 */
public class ContratoHotelServices {
    public void insertar(String codigo, Date fechainicio, Date fechaterminacion, Date fechaconciliacion, String descripcion, int llave_agencia, String tipocontrato)throws SQLException{
        String function = "{call \"insertar_contrato_hotel\"(?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,codigo);
        preparedFunction.setDate(2,fechainicio);
        preparedFunction.setDate(3,fechaterminacion);
        preparedFunction.setDate(4,fechaconciliacion);
        preparedFunction.setString(5,descripcion);
        preparedFunction.setInt(6,llave_agencia);
        preparedFunction.setString(7,tipocontrato);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editar(String codigoid,String codigo, Date fechainicio, Date fechaterminacion, Date fechaconciliacion, String descripcion, int llave_agencia, String tipocontrato)throws SQLException{
        String function = "{call \"editar_contrato_hotel\"(?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,codigoid);
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
    public LinkedList<ContractHotelDto> obtener(int serialagencia)throws SQLException{
        LinkedList<ContractHotelDto> listacontratos = new LinkedList<ContractHotelDto>();
        String function = "{?=call obtener_contratos_hotel(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setInt(2, serialagencia);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listacontratos.add(new ContractHotelDto(resultSet.getString(1),resultSet.getDate(2),resultSet.getDate(3),resultSet.getDate(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7)));
        }
        preparedFunction.close();
        connection.close();
        return listacontratos;
    }
    //VERIFICAR SI EXISTE OTRO CONTRATO CON EL CODIGO HOTEL
    public boolean existeServicioAlojemientoHotel(String codigo)throws SQLException{
        boolean retorno = false;
        String function = "{?=call existe_servicioalojamiento_hotel(?)}";
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
    //SERVICIO ALOJAMIENTO
    public void insertarServicioAlojamiento(boolean activo, String codigocontratohotel, String nombrehotel)throws SQLException{
        String function = "{call \"insertar_servicio_alojamiento\"(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setBoolean(1,activo);
        preparedFunction.setString(2,codigocontratohotel);
        preparedFunction.setString(3,nombrehotel);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editarServicioAlojamiento(int serialservicio,boolean activo,String nombrehotel)throws SQLException{
        String function = "{call \"editar_servicio_alojamiento\"(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1,serialservicio);
        preparedFunction.setBoolean(2,activo);
        preparedFunction.setString(3,nombrehotel);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public LinkedList<ServiceLodginDto> obtenerServiciosAlojamiento()throws SQLException{
        LinkedList<ServiceLodginDto> listaservicios = new LinkedList<ServiceLodginDto>();
        String function = "{?=call obtener_servicios_alojamiento()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listaservicios.add(new ServiceLodginDto(resultSet.getInt(1),resultSet.getBoolean(2),resultSet.getString(3),resultSet.getString(4)));
        }
        preparedFunction.close();
        connection.close();
        return listaservicios;
    }
    public ServiceLodginDto obtenerServicioAlojamientoxContrato(String codigo)throws SQLException{
        ServiceLodginDto retorno = null;
        String function = "{?=call obtener_servicio_alojamiento_contrato(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,codigo);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno = new ServiceLodginDto(resultSet.getInt(1),resultSet.getBoolean(2),resultSet.getString(3),resultSet.getString(4));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    //TEMPORADA
    public LinkedList<TypeSeasonDto> obtenerTiposTemporada()throws SQLException{
        LinkedList<TypeSeasonDto> listatemporadas = new LinkedList<TypeSeasonDto>();
        String function = "{?=call obtener_tipos_temporada()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listatemporadas.add(new TypeSeasonDto(resultSet.getString(1),resultSet.getDouble(2)));
        }
        preparedFunction.close();
        connection.close();
        return listatemporadas;
    }
    public void editarTipoTemporada(String nombre,double valor)throws SQLException{
        String function = "{call \"editar_tipo_temporada\"(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,nombre);
        preparedFunction.setDouble(2,valor);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void insertarTemporada (Date fechainicio, Date fechafin, String descripciontemporada, String codigocontrato, String nombretemporada)throws SQLException{
        String function = "{call \"insertar_temporada\"(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setDate(1,fechainicio);
        preparedFunction.setDate(2,fechafin);
        preparedFunction.setString(3,descripciontemporada);
        preparedFunction.setString(4,codigocontrato);
        preparedFunction.setString(5,nombretemporada);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editarTemporada (int serialtemporada,Date fechainicio, Date fechafin, String descripciontemporada,String nombretemporada)throws SQLException{
        String function = "{call \"editar_temporada\"(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1,serialtemporada);
        preparedFunction.setDate(2,fechainicio);
        preparedFunction.setDate(3,fechafin);
        preparedFunction.setString(4,descripciontemporada);
        preparedFunction.setString(5,nombretemporada);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public SeasonDto obtenerTemporadaxContratoHotel(String codigo)throws SQLException{
        SeasonDto retorno = null;
        String function = "{?=call obtener_temporada_contrato(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,codigo);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno = new SeasonDto(resultSet.getInt(1),resultSet.getDate(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    //PLAN HABITACION ALIMENTO Gestion sera desde java 
    public void insertarPlanHabitacionAlimento (String codigocontratohotel, String tipohabitacion, String tipoalimento, double precio)throws SQLException{
        String function = "{call \"insertar_plan_habitacion_alimento\"(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,codigocontratohotel);
        preparedFunction.setString(2,tipohabitacion);
        preparedFunction.setString(3,tipoalimento);
        preparedFunction.setDouble(4,precio);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public LinkedList<PlainRoomFoodDto> obtenerPlanesHAxContratoHotel(String codigo)throws SQLException{
        LinkedList<PlainRoomFoodDto> listaplanes = new LinkedList<PlainRoomFoodDto>();
        String function = "{?=call obtener_planes_contrato(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1,java.sql.Types.OTHER);
        preparedFunction.setString(2,codigo);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listaplanes.add(new PlainRoomFoodDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4)));
        }
        preparedFunction.close();
        connection.close();
        return listaplanes;
    }
    public void eliminarPlanesxContrato (String codigo)throws SQLException{
        String function = "{call \"eliminar_planes_contrato\"(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,codigo);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public LinkedList<String> obtenerHabitaciones()throws SQLException{
        LinkedList<String> listahabitaciones = new LinkedList<String>();
        String function = "{?=call obtener_habitaciones()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listahabitaciones.add(resultSet.getString(1));
        }
        preparedFunction.close();
        connection.close();
        return listahabitaciones;
    }
    public LinkedList<String> obtenerAlimentos()throws SQLException{
        LinkedList<String> listaalimentos = new LinkedList<String>();
        String function = "{?=call obtener_alimentos()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listaalimentos.add(resultSet.getString(1));
        }
        preparedFunction.close();
        connection.close();
        return listaalimentos;
    }
    
}
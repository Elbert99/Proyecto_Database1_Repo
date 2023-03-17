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
import model.ActivityDto;
import model.ContractServComplDto;
import model.ServiceActivityDto;

/**
 *
 * @author Victor
 */
public class ContratoServComplServices {
    public void insertar(double costopax,String codigo, Date fechainicio, Date fechaterminacion, Date fechaconciliacion, String descripcion, int llave_agencia, String tipocontrato)throws SQLException{
        String function = "{call \"insertar_contrato_servcompl\"(?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setDouble(1,costopax);
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
    public void editar(double costopax,String codigoid,String codigo, Date fechainicio, Date fechaterminacion, Date fechaconciliacion, String descripcion, int llave_agencia, String tipocontrato)throws SQLException{
        String function = "{call \"editar_contrato_servcompl\"(?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setDouble(1,costopax);
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
    public LinkedList<ContractServComplDto> obtener(int serialagencia)throws SQLException{
        LinkedList<ContractServComplDto> listacontratos = new LinkedList<ContractServComplDto>();
        String function = "{?=call obtener_contratos_servcompl(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setInt(2, serialagencia);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listacontratos.add(new ContractServComplDto(resultSet.getDouble(1),resultSet.getString(2),resultSet.getDate(3),resultSet.getDate(4),resultSet.getDate(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8)));
        }
        preparedFunction.close();
        connection.close();
        return listacontratos;
    }
    //ACTIVIDAD
    public boolean existeActividad(String codigo)throws SQLException{
        boolean retorno = false;
        String function = "{?=call existe_actividad(?)}";
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
    public float obtenerPrecio(String codigo)throws SQLException{
        float retorno = 0.0f;
        String function = "{?=call obtener_precio(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.DOUBLE);
        preparedFunction.setString(2,codigo);
        preparedFunction.execute();
        retorno = (float)preparedFunction.getDouble(1);
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    public void insertarActividad(String nombre, String codigocontrato, String provincia)throws SQLException
    {
        String function = "{call \"insertar_actividad\"(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,nombre);
        preparedFunction.setString(2,codigocontrato);
        preparedFunction.setString(3,provincia);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editarActividad(String nombreid,String nombre, String provincia)throws SQLException
    {
        String function = "{call \"editar_actividad\"(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,nombreid);
        preparedFunction.setString(2,nombre);
        preparedFunction.setString(3,provincia);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public ActivityDto obtenerActividadxContrato(String codigo)throws SQLException{
        ActivityDto retorno = null;
        String function = "{?=call obtener_actividad_contrato(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,codigo);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno = new ActivityDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }//
    public ActivityDto obtenerActividadxNombre(String nombre)throws SQLException{
        ActivityDto retorno = null;
        String function = "{?=call obtener_actividad_nombre(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,nombre);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno = new ActivityDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }
//    public LinkedList<Actividad>  obtenerActividades()throws SQLException{
//        LinkedList<Actividad> listaactividades = new LinkedList<Actividad>();
//        String function = "{?=call obtener_actividades()}";
//        java.sql.Connection connection = ServicesLocator.getConnection();
//        connection.setAutoCommit(false);
//        CallableStatement preparedFunction = connection.prepareCall(function);
//        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
//        preparedFunction.execute();
//        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
//        while(resultSet.next()){
//            listaactividades.add(new Actividad(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
//        }
//        return listaactividades;
//    }
    //SERVICIO ACTIVIDAD 
    public void insertarServicioActividad(boolean activo, String nombreactividad)throws SQLException{
        String function = "{call \"insertar_servicio_actividad\"(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setBoolean(1,activo);
        preparedFunction.setString(2,nombreactividad);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editarServicioActividad(int serialservicio,boolean activo)throws SQLException{
        String function = "{call \"editar_servicio_actividad\"(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1,serialservicio);
        preparedFunction.setBoolean(2,activo);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public LinkedList<ServiceActivityDto> obtenerServiciosActividad()throws SQLException{
        LinkedList<ServiceActivityDto> listaservicios = new LinkedList<ServiceActivityDto>();
        String function = "{?=call obtener_servicios_actividad()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listaservicios.add(new ServiceActivityDto(resultSet.getInt(1),resultSet.getBoolean(2),resultSet.getString(3)));
        }
        preparedFunction.close();
        connection.close();
        return listaservicios;
    }
    public ServiceActivityDto obtenerServicioActividadxActiviad(String codigo)throws SQLException{
        ServiceActivityDto retorno = null;
        String function = "{?=call obtener_servicio_actividad_actividad(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,codigo);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno = new ServiceActivityDto(resultSet.getInt(1),resultSet.getBoolean(2),resultSet.getString(3));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }
}
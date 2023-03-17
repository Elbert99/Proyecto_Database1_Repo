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
import model.ProgramActivityDto;
import model.ProgramPackDto;

/**
 *
 * @author Victor
 */
public class PaqueteServices {
    public void insertarPrograma(Date fechainicial, int cantdias, int cantnoches, double preciototalhotel, double preciotransporteha, double preciotransporteactd, double preciototaltransporte, double preciototalactividades, double preciototalpaquete, String codigopaquete, String tipomodalidadtrasporte, String chapavehiculo, String nombrehotel, String tipoalimento, String tipohabitacion)throws SQLException{
        String function = "{call \"insertar_programa_paquete\"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setDate(1,fechainicial);
        preparedFunction.setInt(2,cantdias);
        preparedFunction.setInt(3,cantnoches);
        preparedFunction.setDouble(4,preciototalhotel);
        preparedFunction.setDouble(5,preciotransporteha);
        preparedFunction.setDouble(6,preciotransporteactd);
        preparedFunction.setDouble(7,preciototaltransporte);
        preparedFunction.setDouble(8,preciototalactividades);
        preparedFunction.setDouble(9,preciototalpaquete);
        preparedFunction.setString(10,codigopaquete);
        preparedFunction.setString(11,tipomodalidadtrasporte);
        preparedFunction.setString(12,chapavehiculo);
        preparedFunction.setString(13,nombrehotel);
        preparedFunction.setString(14,tipoalimento);
        preparedFunction.setString(15,tipohabitacion);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editarPrograma(int serial,Date fechainicial, int cantdias, int cantnoches, double preciototalhotel, double preciotransporteha, double preciotransporteactd, double preciototaltransporte, double preciototalactividades, double preciototalpaquete, String tipomodalidadtrasporte, String chapavehiculo, String nombrehotel, String tipoalimento, String tipohabitacion)throws SQLException{
        String function = "{call \"editar_programa_paquete\"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1,serial);
        preparedFunction.setDate(2,fechainicial);
        preparedFunction.setInt(3,cantdias);
        preparedFunction.setInt(4,cantnoches);
        preparedFunction.setDouble(5,preciototalhotel);
        preparedFunction.setDouble(6,preciotransporteha);
        preparedFunction.setDouble(7,preciotransporteactd);
        preparedFunction.setDouble(8,preciototaltransporte);
        preparedFunction.setDouble(9,preciototalactividades);
        preparedFunction.setDouble(10,preciototalpaquete);
        preparedFunction.setString(11,tipomodalidadtrasporte);
        preparedFunction.setString(12,chapavehiculo);
        preparedFunction.setString(13,nombrehotel);
        preparedFunction.setString(14,tipoalimento);
        preparedFunction.setString(15,tipohabitacion);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public ProgramPackDto obtenerProgramaPaquete(String codigo)throws SQLException{
        ProgramPackDto retorno = null;
        String function = "{?=call obtener_programa_paquete(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,codigo);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno = new ProgramPackDto(resultSet.getInt(1),resultSet.getDate(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getDouble(5),resultSet.getDouble(6),resultSet.getDouble(7),resultSet.getDouble(8),resultSet.getDouble(9),resultSet.getDouble(10),resultSet.getString(11),resultSet.getString(12),resultSet.getString(13),resultSet.getString(14),resultSet.getString(15),resultSet.getString(16));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    public int obtenerPosicionPrograma()throws SQLException{
        int retorno = -1;
        String function = "{?=call ultimoprograma()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.INTEGER);
        preparedFunction.execute();
        retorno = preparedFunction.getInt(1);
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    //Progrma Actividad
    public void insertarProgramaActividad(String nombreactividad, String codigopaquete, Date dia, int hora, String descripcionactividad)throws SQLException{
        String function = "{call \"insertar_programa_actividad\"(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,nombreactividad);
        preparedFunction.setString(2,codigopaquete);
        preparedFunction.setDate(3,dia);
        preparedFunction.setInt(4, hora);
        preparedFunction.setString(5, descripcionactividad);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void eliminarProgramaActividad(String codigopaquete)throws SQLException{
        String function = "{call \"eliminar_programa_actividad_paquete\"(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,codigopaquete);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }        
    public LinkedList<ProgramActivityDto> obtenerProgramaActividadesxPaquete(String codigopaquete)throws SQLException{
        LinkedList<ProgramActivityDto> lista = new LinkedList<ProgramActivityDto>();
        String function = "{?=call obtener_programa_actividades_paquete(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,codigopaquete);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            lista.add(new ProgramActivityDto(resultSet.getString(1),resultSet.getString(2),resultSet.getDate(3),resultSet.getInt(4), resultSet.getString(5)));
        }
        preparedFunction.close();
        connection.close();
        return lista;
    }
}

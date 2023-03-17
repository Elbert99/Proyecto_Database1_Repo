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
import model.DistanceDto;
import model.PackDto;

/**
 *
 * @author Victor
 */
public class DistanciaServices {//insertar_distancia
    public void insertar(String provinciaInicial, String provinciaFinal, double distanciakm)throws SQLException{
        String function = "{call \"insertar_distancia\"(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,provinciaInicial);
        preparedFunction.setString(2,provinciaFinal);
        preparedFunction.setDouble(3,distanciakm);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editar(String provinciaInicial, String provinciaFinal, double distanciakm)throws SQLException{
        String function = "{call \"editar_distancia\"(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,provinciaInicial);
        preparedFunction.setString(2,provinciaFinal);
        preparedFunction.setDouble(3,distanciakm);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void eliminar(String provinciaInicial, String provinciaFinal)throws SQLException{
        String function = "{call \"eliminar_distancia\"(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,provinciaInicial);
        preparedFunction.setString(2,provinciaFinal);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public float obtener(String provinciaInicial, String provinciaFinal)throws SQLException{
        float retorno = 0.0f;
        String function = "{?=call obtener_distancia(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.DOUBLE);
        preparedFunction.setString(2,provinciaInicial);
        preparedFunction.setString(3,provinciaFinal);
        preparedFunction.execute();
        retorno = (float)preparedFunction.getDouble(1);
        preparedFunction.close();
        connection.close();
        return retorno;
    }
     public LinkedList<DistanceDto> obtenerDistancias()throws SQLException{
        LinkedList<DistanceDto> lista = new LinkedList<DistanceDto>();
        String function = "{?=call obtener_distancias()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            lista.add(new DistanceDto(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3)));
        }
        preparedFunction.close();
        connection.close();
        return lista;
    }
     public LinkedList<String> obtenerProvincias()throws SQLException{
        LinkedList<String> listaroles = new LinkedList<String>();
        String function = "{?=call obtener_provincias()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listaroles.add(resultSet.getString(1));
        }
        preparedFunction.close();
        connection.close();
        return listaroles;
    }
}

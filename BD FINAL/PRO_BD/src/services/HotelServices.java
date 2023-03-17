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
import model.HotelDto;
/**
 *
 * @author Victor
 */
public class HotelServices {
    public void insertar(Date fecha, String nombre, String cadenahotelera, String telefono, String fax, String email, double distanciaciudadcerca, double distanciaaeropuerto, int cantidadhabitaciones, int cantidadpisos, String categoria, String localizacion, String provincia)throws SQLException{
        String function = "{call \"insertar_hotel\"(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setDate(1,fecha);
        preparedFunction.setString(2,nombre);
        preparedFunction.setString(3,cadenahotelera);
        preparedFunction.setString(4,telefono);
        preparedFunction.setString(5,fax);
        preparedFunction.setString(6,email);
        preparedFunction.setDouble(7,distanciaciudadcerca);
        preparedFunction.setDouble(8,distanciaaeropuerto);
        preparedFunction.setInt(9,cantidadhabitaciones);
        preparedFunction.setInt(10,cantidadpisos);
        preparedFunction.setString(11,categoria);
        preparedFunction.setString(12,localizacion);
        preparedFunction.setString(13,provincia);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editar(String codigoid,Date fecha, String nombre, String cadenahotelera, String telefono, String fax, String email, double distanciaciudadcerca, double distanciaaeropuerto, int cantidadhabitaciones, int cantidadpisos, String categoria, String localizacion, String provincia)throws SQLException{
        String function = "{call \"editar_hotel\"(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,codigoid);
        preparedFunction.setDate(2,fecha);
        preparedFunction.setString(3,nombre);
        preparedFunction.setString(4,cadenahotelera);
        preparedFunction.setString(5,telefono);
        preparedFunction.setString(6,fax);
        preparedFunction.setString(7,email);
        preparedFunction.setDouble(8,distanciaciudadcerca);
        preparedFunction.setDouble(9,distanciaaeropuerto);
        preparedFunction.setInt(10,cantidadhabitaciones);
        preparedFunction.setInt(11,cantidadpisos);
        preparedFunction.setString(12,categoria);
        preparedFunction.setString(13,localizacion);
        preparedFunction.setString(14,provincia);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void eliminar(String codigo)throws SQLException{
        String function = "{call \"eliminar_hotel\"(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,codigo);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public LinkedList<HotelDto> obtener()throws SQLException{
        LinkedList<HotelDto> listahoteles = new LinkedList<HotelDto>();
        String function = "{?=call obtener_hoteles()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listahoteles.add(new HotelDto(resultSet.getDate(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7),resultSet.getDouble(8),resultSet.getInt(9),resultSet.getInt(10),resultSet.getString(11),resultSet.getString(12),resultSet.getString(13)));
        }
        preparedFunction.close();
        connection.close();
        return listahoteles;
    }
    public LinkedList<HotelDto> obtenerInd()throws SQLException{
        LinkedList<HotelDto> listahoteles = new LinkedList<HotelDto>();
        String function = "{?=call obtener_hoteles_ind()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listahoteles.add(new HotelDto(resultSet.getDate(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7),resultSet.getDouble(8),resultSet.getInt(9),resultSet.getInt(10),resultSet.getString(11),resultSet.getString(12),resultSet.getString(13)));
        }
        preparedFunction.close();
        connection.close();
        return listahoteles;
    }
    public HotelDto obtenerHotelNombre(String nombre)throws SQLException{
        HotelDto retorno = null;
        String function = "{?=call buscar_hotel_nombre(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2, nombre);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno = new HotelDto(resultSet.getDate(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getDouble(7),resultSet.getDouble(8),resultSet.getInt(9),resultSet.getInt(10),resultSet.getString(11),resultSet.getString(12),resultSet.getString(13));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    public boolean existe(String codigo)throws SQLException{
        boolean retorno = false;
        String function = "{?=call existe_hotel(?)}";
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
    public LinkedList<String> obtenerCategorias()throws SQLException{
        LinkedList<String> listacategorias = new LinkedList<String>();
        String function = "{?=call obtener_categorias()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listacategorias.add(resultSet.getString(1));
        }
        preparedFunction.close();
        connection.close();
        return listacategorias;
    }
    public LinkedList<String> obtenerLocalizaciones()throws SQLException{
        LinkedList<String> listalocalizaciones = new LinkedList<String>();
        String function = "{?=call obtener_localizaciones()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listalocalizaciones.add(resultSet.getString(1));
        }
        preparedFunction.close();
        connection.close();
        return listalocalizaciones;
    }
    public void insertarModalidadHotel(String nombrehotel,String nombremodalidad)throws SQLException{
        String function = "{call \"insertar_modalidad_hotel\"(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,nombrehotel);
        preparedFunction.setString(2, nombremodalidad);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void eliminarModalidadHotel(String nombrehotel)throws SQLException{
        String function = "{call \"eliminar_modalidad_hotel\"(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,nombrehotel);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public LinkedList<String> obtenerModalidadesxHotel(String nombrehotel)throws SQLException{
        LinkedList<String> listamodalidades = new LinkedList<String>();
        String function = "{?=call obtener_modalidades_hotel(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,nombrehotel);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listamodalidades.add(resultSet.getString(1));
        }
        preparedFunction.close();
        connection.close();
        return listamodalidades;
    }
    public LinkedList<String> obtenerModalidades()throws SQLException{
        LinkedList<String> listamodalidades = new LinkedList<String>();
        String function = "{?=call obtener_modalidades()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listamodalidades.add(resultSet.getString(1));
        }
        preparedFunction.close();
        connection.close();
        return listamodalidades;
    }
    
}


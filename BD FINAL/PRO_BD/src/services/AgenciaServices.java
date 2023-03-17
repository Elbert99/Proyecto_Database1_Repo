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
import model.AgencyDto;
import model.ContractTransportDto;
import model.PackDto;
import model.UserDto;
/**
 *
 * @author Victor
 */
public class AgenciaServices {
    //***************AGENCIA************************
//    public void insertarAgencia(String nombre,String nombreduennos,String primerapellido,String segundoapellido,String telefono) throws SQLException, ClassNotFoundException {
//		String function = "{call \"insertar_agencia\"(?,?,?,?,?)}"; 
//		java.sql.Connection connection = ServicesLocator.getConnection();
//		connection.setAutoCommit(true);
//		CallableStatement preparedFunction = connection.prepareCall(function);
//		preparedFunction.setString(1,nombre);
//		preparedFunction.setString(2,nombreduennos);
//                preparedFunction.setString(3,primerapellido);
//                preparedFunction.setString(4,segundoapellido); 
//                preparedFunction.setString(5,telefono);
//		preparedFunction.execute();
//		preparedFunction.close();
//		connection.close();
//    }
//    public void editarAgencia(int serial_agencia,String nombre,String nombreduennos,String primerapellido,String segundoapellido,String telefono) throws SQLException, ClassNotFoundException {
//		String function = "{call \"editar_agencia\"(?,?,?,?,?,?)}"; 
//		java.sql.Connection connection = ServicesLocator.getConnection();
//		connection.setAutoCommit(true);
//		CallableStatement preparedFunction = connection.prepareCall(function);
//                preparedFunction.setInt(1,serial_agencia);
//		preparedFunction.setString(2,nombre);
//		preparedFunction.setString(3,nombreduennos);
//                preparedFunction.setString(4,primerapellido);
//                preparedFunction.setString(5,segundoapellido); 
//                preparedFunction.setString(6,telefono);
//		preparedFunction.execute();
//		preparedFunction.close();
//		connection.close();
//    }
//    public void eliminarAgencia(int serial)throws SQLException{
//        String function = "{call \"eliminar_agencia\"(?)}";
//        java.sql.Connection connection = ServicesLocator.getConnection();
//        connection.setAutoCommit(true);
//        CallableStatement preparedFunction = connection.prepareCall(function);
//        preparedFunction.setInt(1,serial);
//        preparedFunction.execute();
//        preparedFunction.close();
//        connection.close();
//    }
    public AgencyDto obtenerAgencia()throws SQLException{
        AgencyDto retorno = null;
        String function = "{?=call obtener_agencia()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        //preparedFunction.setInt(2,serial);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        boolean s=false;
        while(resultSet.next()&&!s){
            retorno = new AgencyDto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),resultSet.getDate(7));
            s=true;
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    public void editarFechaActualAgencia(int serialagencia,Date fechaactual)throws SQLException{
        String function = "{call \"editar_fechaactual_agencia\"(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1,serialagencia);
        preparedFunction.setDate(2,fechaactual);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    //*****PAQUETES************
    public void insertarPaquete(String codigo,String nombre,int cantidadpax,double costototal,double preciototal,int llaveagencia)throws SQLException{
        String function = "{call \"insertar_paquete\"(?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,codigo);
        preparedFunction.setString(2,nombre);
        preparedFunction.setInt(3,cantidadpax);
        preparedFunction.setDouble(4,costototal);
        preparedFunction.setDouble(5,preciototal);
        preparedFunction.setInt(6,llaveagencia);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    
    public void editarPaquete(String codigoid,String codigo,String nombre,int cantidadpax,double costototal,double preciototal,int llaveagencia)throws SQLException{
        String function = "{call \"editar_paquete\"(?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,codigoid);
        preparedFunction.setString(2,codigo);
        preparedFunction.setString(3,nombre);
        preparedFunction.setInt(4,cantidadpax);
        preparedFunction.setDouble(5,costototal);
        preparedFunction.setDouble(6,preciototal);
        preparedFunction.setInt(7,llaveagencia);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void eliminarPaquete(String codigo)throws SQLException{
        String function = "{call \"eliminar_paquete\"(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,codigo);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public LinkedList<PackDto> obtenerPaquetes(int serialagencia)throws SQLException{
        LinkedList<PackDto> lista = new LinkedList<PackDto>();
        String function = "{?=call obtener_paquetes(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setInt(2, serialagencia);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            lista.add(new PackDto(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getInt(6)));
        }
        preparedFunction.close();
        connection.close();
        return lista;
    }

    
    public boolean existePaquete(String codigo)throws SQLException{
        boolean retorno = false;
        String function = "{?=call existe_paquete(?)}";
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
    public boolean existePaqueteNombre(String nombre)throws SQLException{
        boolean retorno = false;
        String function = "{?=call existe_paquete_nombre(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.BOOLEAN);
        preparedFunction.setString(2,nombre);
        preparedFunction.execute();
        retorno = preparedFunction.getBoolean(1);
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    //*****************CONTRATOS**************
    public void eliminarContrato(String codigo)throws SQLException{
        String function = "{call \"eliminar_contrato\"(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,codigo);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public LinkedList<String> obtenerTiposContratos()throws SQLException{
        LinkedList<String> listatipcontratos = new LinkedList<String>();
        String function = "{?=call obtener_tipos_contratos()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listatipcontratos.add(resultSet.getString(1));
        }
        preparedFunction.close();
        connection.close();
        return listatipcontratos;
    }
    public boolean existeContrato(String codigo)throws SQLException{
        boolean retorno = false;
        String function = "{?=call existe_contrato(?)}";
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
    //*****************USUARIOS******************
    public void insertarUsuario(String id, String nombre, String primerapll, String segundoapll, String nick, String contrasenna, int tema, int llave_agencia, String rol)throws SQLException{
        String function = "{call \"insertar_usuario\"(?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,id);
        preparedFunction.setString(2,nombre);
        preparedFunction.setString(3,primerapll);
        preparedFunction.setString(4,segundoapll);
        preparedFunction.setString(5,nick);
        preparedFunction.setString(6,contrasenna);
        preparedFunction.setInt(7,tema);
        preparedFunction.setInt(8,llave_agencia);
        preparedFunction.setString(9,rol);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editarUsuario(String idserial,String id ,String nombre, String primerapll, String segundoapll, String nick, String contrasenna, int tema, int llave_agencia, String rol)throws SQLException{
        String function = "{call \"editar_usuario\"(?,?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, idserial);
        preparedFunction.setString(2,id);
        preparedFunction.setString(3,nombre);
        preparedFunction.setString(4,primerapll);
        preparedFunction.setString(5,segundoapll);
        preparedFunction.setString(6,nick);
        preparedFunction.setString(7,contrasenna);
        preparedFunction.setInt(8,tema);
        preparedFunction.setInt(9,llave_agencia);
        preparedFunction.setString(10,rol);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void editarContrasennaUsuario(String idserial,String pass)throws SQLException{
        String function = "{call \"editar_contrasenna_usuario\"(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, idserial);
        preparedFunction.setString(2, pass);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void eliminarUsuario(String codigo)throws SQLException{
        String function = "{call \"eliminar_usuario\"(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1,codigo);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public LinkedList<UserDto> obtenerUsuarios(int serialagencia)throws SQLException{
        LinkedList<UserDto> listausuarios = new LinkedList<UserDto>();
        String function = "{?=call obtener_usuarios(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setInt(2, serialagencia);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            listausuarios.add(new UserDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getString(9)));
        }
        preparedFunction.close();
        connection.close();
        return listausuarios;
    }
    public UserDto obtenerUsuarioxNick(String codigo)throws SQLException{
        UserDto retorno = null;
        String function = "{?=call obtener_usuario_nick(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
        preparedFunction.setString(2,codigo);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while(resultSet.next()){
            retorno = new UserDto(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getString(9));
        }
        preparedFunction.close();
        connection.close();
        return retorno;
    }
    public boolean existeUsuario(String codigo)throws SQLException{
        boolean retorno = false;
        String function = "{?=call existe_usuario(?)}";
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
    public boolean existeNickUsuario(String codigo)throws SQLException{
        boolean retorno = false;
        String function = "{?=call existe_nick_usuario(?)}";
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
    public LinkedList<String> obtenerRoles()throws SQLException{
        LinkedList<String> listaroles = new LinkedList<String>();
        String function = "{?=call obtener_roles()}";
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
    //Base Datos
    public void vaciarBD()throws SQLException{
        String function = "{call \"vaciar_bd\"()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    public void llenarBD()throws SQLException{
        String function = "{call \"llenar_bd\"()}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        connection.setAutoCommit(true);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    
}
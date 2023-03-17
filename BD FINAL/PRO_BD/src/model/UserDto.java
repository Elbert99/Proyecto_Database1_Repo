/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServicesLocator;

/**
 *
 * @author Victor
 */
public class UserDto {
    private String id;
    private String nombre;
    private String primerapll;
    private String segundoapll;
    private String nick;
    private String contrasenna;
    private int tema;
    private int llave_agencia;
    private String rol;

    public UserDto(String id, String nombre, String primerapll, String segundoapll, String nick, String contrasenna, int tema, int llave_agencia, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.primerapll = primerapll;
        this.segundoapll = segundoapll;
        this.nick = nick;
        this.contrasenna = contrasenna;
        this.tema = tema;
        this.llave_agencia = llave_agencia;
        this.rol = rol;
    }
    //GET
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerapll() {
        return primerapll;
    }

    public String getSegundoapll() {
        return segundoapll;
    }

    public String getNick() {
        return nick;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public int getTema() {
        return tema;
    }

    public int getLlave_agencia() {
        return llave_agencia;
    }

    public String getRol() {
        return rol;
    }
    //SET
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerapll(String primerapll) {
        this.primerapll = primerapll;
    }

    public void setSegundoapll(String segundoapll) {
        this.segundoapll = segundoapll;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public void setTema(int temav) {
        this.tema = temav;
        try {
            ServicesLocator.getAgenciaServices().editarUsuario(id, id, nombre, primerapll, segundoapll, nick, contrasenna, tema, llave_agencia, rol);
        } catch (SQLException ex) {
            Logger.getLogger(UserDto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setLlave_agencia(int llave_agencia) {
        this.llave_agencia = llave_agencia;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
    

    //Metodos publicos
    public boolean isCorrecto(String us, String con) {
        boolean enc=false;
        if(nick.equals(us)&&contrasenna.equals(con))
            enc=true;
        return enc;
    }

    public String toString() {
        return id;
    }
    
}

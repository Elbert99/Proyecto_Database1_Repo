/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Victor
 */
public class AgencyDto {
    private static AgencyDto agencia;
    private int serialagencia;
    private String nombre;
    private String nombreduenno;
    private String primerapellido;
    private String segundoapellido;
    private String telefono;
    private Date fechaactual;

    public AgencyDto(int serialagencia, String nombre, String nombreduenno, String primerapellido, String segundoapellido, String telefono, Date fechaactual) {
        this.serialagencia = serialagencia;
        this.nombre = nombre;
        this.nombreduenno = nombreduenno;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.telefono = telefono;
        this.fechaactual = fechaactual;
    }

    
    
    public static AgencyDto get(){
        return agencia;
    }
    public static void crearAgencia(int serialagencia, String nombre, String nombreduenno, String primerapellido, String segundoapellido, String telefono,Date fechaactual)
    {
        agencia = new AgencyDto(serialagencia,nombre,nombreduenno,primerapellido,segundoapellido,telefono,fechaactual);
    }
  
    //GET
    public int serial() {
        return serialagencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreduenno() {
        return nombreduenno;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFechaactual() {
        return fechaactual;
    }
    //SET

    public static void setAgencia(AgencyDto agencia) {
        AgencyDto.agencia = agencia;
    }

    public void setSerialagencia(int serialagencia) {
        this.serialagencia = serialagencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreduenno(String nombreduenno) {
        this.nombreduenno = nombreduenno;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaactual(Date fechaactual) {
        this.fechaactual = fechaactual;
    }
    
    
    
}

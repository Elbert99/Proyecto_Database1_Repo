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
public class ProgramActivityDto {
    private String nombreactividad;
    private String codigopaquete;
    private Date dia;
    private int hora;
    private String descripcionactividad;

    public ProgramActivityDto(String nombreactividad, String codigopaquete, Date dia, int hora, String descripcionactividad) {
        this.nombreactividad = nombreactividad;
        this.codigopaquete = codigopaquete;
        this.dia = dia;
        this.hora = hora;
        this.descripcionactividad = descripcionactividad;
    }
    
    //GET
    public String getNombreactividad() {
        return nombreactividad;
    }

    public String getCodigopaquete() {
        return codigopaquete;
    }

    public Date getDia() {
        return dia;
    }

    public int getHora() {
        return hora;
    }

    public String getDescripcionactividad() {
        return descripcionactividad;
    }
    //SET
    public void setNombreactividad(String nombreactividad) {
        this.nombreactividad = nombreactividad;
    }

    public void setCodigopaquete(String codigopaquete) {
        this.codigopaquete = codigopaquete;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setDescripcionactividad(String descripcionactividad) {
        this.descripcionactividad = descripcionactividad;
    }
    

  }

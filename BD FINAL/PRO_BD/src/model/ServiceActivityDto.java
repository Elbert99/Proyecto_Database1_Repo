/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;

/**
 *
 * @author Victor
 */
public class ServiceActivityDto {
    private int serial_servicioactividad;
    private boolean activo;
    private String nombreactividad;

    public ServiceActivityDto(int serial_servicioactividad, boolean activo, String nombreactividad) {
        this.serial_servicioactividad = serial_servicioactividad;
        this.activo = activo;
        this.nombreactividad = nombreactividad;
    }
    
    //GET
    public int getSerial_servicioactividad() {
        return serial_servicioactividad;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getNombreactividad() {
        return nombreactividad;
    }
    
    //SET
    public void setSerial_servicioactividad(int serial_servicioactividad) {
        this.serial_servicioactividad = serial_servicioactividad;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setNombreactividad(String nombreactividad) {
        this.nombreactividad = nombreactividad;
    }
    
    public String toString() {
        return String.valueOf(serial_servicioactividad);
    }
}

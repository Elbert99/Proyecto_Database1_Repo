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
public class ServiceTransportDto {
    private int serial_transporte;
    private boolean activo;
    private String chapavehiculo;

    public ServiceTransportDto(int serial_transporte, boolean activo, String chapavehiculo) {
        this.serial_transporte = serial_transporte;
        this.activo = activo;
        this.chapavehiculo = chapavehiculo;
    }
    //GET
    public int getSerial_transporte() {
        return serial_transporte;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getChapavehiculo() {
        return chapavehiculo;
    }
    //SET
    public void setSerial_transporte(int serial_transporte) {
        this.serial_transporte = serial_transporte;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setChapavehiculo(String chapavehiculo) {
        this.chapavehiculo = chapavehiculo;
    }
    
    public String toString() {
        return String.valueOf(serial_transporte);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Victor
 */
public class ServiceLodginDto {
    private int serial_servicioalojamiento;
    private boolean activo;
    private String codigocontratohotel;
    private String nombrehotel;

    public ServiceLodginDto(int serial_servicioalojamiento, boolean activo, String codigocontratohotel, String nombrehotel) {
        this.serial_servicioalojamiento = serial_servicioalojamiento;
        this.activo = activo;
        this.codigocontratohotel = codigocontratohotel;
        this.nombrehotel = nombrehotel;
    }
    //GET
    public int getSerial_servicioalojamiento() {
        return serial_servicioalojamiento;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getCodigocontratohotel() {
        return codigocontratohotel;
    }

    public String getNombrehotel() {
        return nombrehotel;
    }
    
    //SET
    public void setSerial_servicioalojamiento(int serial_servicioalojamiento) {
        this.serial_servicioalojamiento = serial_servicioalojamiento;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setCodigocontratohotel(String codigocontratohotel) {
        this.codigocontratohotel = codigocontratohotel;
    }

    public void setCodigohotel(String nombrehotel) {
        this.nombrehotel = nombrehotel;
    }
    
    public String toString() {
        return String.valueOf(serial_servicioalojamiento);
    }
}

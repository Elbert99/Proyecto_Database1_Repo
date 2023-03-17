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
public class ModeTransportDto {
    protected int serial_modalidadtransporte;
    protected String chapavehiculo;
    protected String tipomodalidadtransporte;

    public ModeTransportDto(int serial_modalidadtransporte, String chapavehiculo, String tipomodalidadtransporte) {
        this.serial_modalidadtransporte = serial_modalidadtransporte;
        this.chapavehiculo = chapavehiculo;
        this.tipomodalidadtransporte = tipomodalidadtransporte;
    }

   //GET
    public int getSerial_modalidadtransporte() {
        return serial_modalidadtransporte;
    }

    public String getChapavehiculo() {
        return chapavehiculo;
    }

    public String getTipomodalidadtransporte() {
        return tipomodalidadtransporte;
    }
    //SET
    public void setSerial_modalidadtransporte(int serial_modalidadtransporte) {
        this.serial_modalidadtransporte = serial_modalidadtransporte;
    }

    public void setChapavehiculo(String chapavehiculo) {
        this.chapavehiculo = chapavehiculo;
    }

    public void setTipomodalidadtransporte(String tipomodalidadtransporte) {
        this.tipomodalidadtransporte = tipomodalidadtransporte;
    }
    
    
    
}

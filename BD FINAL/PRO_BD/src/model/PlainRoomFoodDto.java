/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * @author Victor
 */
public class PlainRoomFoodDto {
    private String codigocontratohotel;
    private String tipohabitacion;
    private String tipoalimento;
    private float precio;

    public PlainRoomFoodDto(String codigocontratohotel, String tipohabitacion, String tipoalimento, double precio) {
        this.codigocontratohotel = codigocontratohotel;
        this.tipohabitacion = tipohabitacion;
        this.tipoalimento = tipoalimento;
        this.precio = (float)precio;
    }

//    Get
    public String getCodigocontratohotel() {
        return codigocontratohotel;
    }

    public String getTipohabitacion() {
        return tipohabitacion;
    }

    public String getTipoalimento() {
        return tipoalimento;
    }

    public float getPrecio() {
        return precio;
    }
    
//    Set
    public void setCodigocontratohotel(String codigocontratohotel) {
        this.codigocontratohotel = codigocontratohotel;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public void setTipoalimento(String tipoalimento) {
        this.tipoalimento = tipoalimento;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
    public String toString() {
        return tipohabitacion + " - " + tipoalimento;
    }
    
    
}

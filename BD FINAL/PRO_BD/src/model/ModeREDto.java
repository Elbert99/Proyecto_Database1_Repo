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
public class ModeREDto extends ModeTransportDto{
    private String descripcion;
    private float costo_idavuelta;
    private float costo_recorrido;

    public ModeREDto(String descripcion,double costo_idavuelta, double costo_recorrido,int serial_modalidadtransporte,String chapavehiculo, String tipomodalidadtransporte) {
        super(serial_modalidadtransporte,chapavehiculo, tipomodalidadtransporte);
        this.costo_idavuelta = (float)costo_idavuelta;
        this.descripcion = descripcion;
        this.costo_recorrido = (float)costo_recorrido;
    }

    //Get
    public float getCosto_idavuelta() {
        return costo_idavuelta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getCosto_recorrido() {
        return costo_recorrido;
    }

    //Set
    public void setCosto_idavuelta(float costo_idavuelta) {
        this.costo_idavuelta = costo_idavuelta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto_recorrido(float costo_recorrido) {
        this.costo_recorrido = costo_recorrido;
    }
    
}

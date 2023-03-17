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
public class ActivityDto {
    private String nombre;
    private String codigocontrato;
    private String provincia;

    public ActivityDto(String nombre, String codigocontrato, String provincia) {
        this.nombre = nombre;
        this.codigocontrato = codigocontrato;
        this.provincia = provincia;
    }

    //GET
    public String getNombre() {
        return nombre;
    }

    public String getCodigocontrato() {
        return codigocontrato;
    }

    public String getProvincia() {
        return provincia;
    }
    
    //SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigocontrato(String codigocontrato) {
        this.codigocontrato = codigocontrato;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
}
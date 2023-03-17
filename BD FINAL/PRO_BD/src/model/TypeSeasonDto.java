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
public class TypeSeasonDto {
    private String nombretemporada;
    private float porcientovariacion;

    public TypeSeasonDto(String nombretemporada, double porcientovariacion) {
        this.nombretemporada = nombretemporada;
        this.porcientovariacion = (float)porcientovariacion;
    }

  
    
    //Get
    public String getNombretemporada() {
        return nombretemporada;
    }

    public float getPorcientovariacion() {
        return porcientovariacion;
    }
    
    //Set
    public void setNombretemporada(String nombretemporada) {
        this.nombretemporada = nombretemporada;
    }

    public void setPorcientovariacion(float porcientovariacion) {
        this.porcientovariacion = porcientovariacion;
    }

    @Override
    
    public String toString() {
        return nombretemporada;
    }
    
    
    
}

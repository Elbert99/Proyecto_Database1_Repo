/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class DistanceDto {
    private String provinciaInicial;
    private String provinciaFinal;
    private float distanciakm;

    public DistanceDto(String provinciaInicial, String provinciaFinal, double distanciakm) {
        this.provinciaInicial = provinciaInicial;
        this.provinciaFinal = provinciaFinal;
        this.distanciakm = (float)distanciakm;
    }
    
//    Get
    public String getProvinciaInicial() {
        return provinciaInicial;
    }

    public String getProvinciaFinal() {
        return provinciaFinal;
    }

    public float getDistanciakm() {
        return distanciakm;
    }
    
//    Set
    public void setProvinciaInicial(String provinciaInicial) {
        this.provinciaInicial = provinciaInicial;
    }

    public void setProvinciaFinal(String provinciaFinal) {
        this.provinciaFinal = provinciaFinal;
    }

    public void setDistanciakm(float distanciakm) {
        this.distanciakm = distanciakm;
    }
    
    @Override
    public String toString() {
        return provinciaInicial+" "+provinciaFinal;
    }
    
}

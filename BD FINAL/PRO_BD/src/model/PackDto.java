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

public class PackDto {
    private String codigopaquete; 
    private String nombrepaquete;
    private int cantpax;
    private float costototal;
    private float preciototal;
    private int llave_agencia;

    public PackDto(String codigopaquete, String nombrepaquete, int cantpax, double costototal, double preciototal, int llave_agencia) {
        this.codigopaquete = codigopaquete;
        this.nombrepaquete = nombrepaquete;
        this.cantpax = cantpax;
        this.costototal = (float)costototal;
        this.preciototal = (float)preciototal;
        this.llave_agencia = llave_agencia;
    }
    //GET
    public String getCodigopaquete() {
        return codigopaquete;
    }

    public String getNombrepaquete() {
        return nombrepaquete;
    }

    public int getCantpax() {
        return cantpax;
    }

    public float getCostototal() {
        return costototal;
    }

    public float getPreciototal() {
        return preciototal;
    }

    public int getLlave_agencia() {
        return llave_agencia;
    }
    //SET
    public void setCodigopaquete(String codigopaquete) {
        this.codigopaquete = codigopaquete;
    }

    public void setNombrepaquete(String nombrepaquete) {
        this.nombrepaquete = nombrepaquete;
    }

    public void setCantpax(int cantpax) {
        this.cantpax = cantpax;
    }

    public void setCostototal(float costototal) {
        this.costototal = costototal;
    }

    public void setPreciototal(float preciototal) {
        this.preciototal = preciototal;
    }

    public void setLlave_agencia(int llave_agencia) {
        this.llave_agencia = llave_agencia;
    }
    
    
    @Override
    public String toString() {
        return codigopaquete;
    }
    
    
}

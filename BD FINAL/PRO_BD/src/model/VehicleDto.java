/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author Victor
 */
public class VehicleDto {
    private String chapa;
    private String marca;
    private String color;
    private int capsinequip;
    private int capconequip;
    private int captotal;
    private int annofabricacion;
    private boolean ocupado;
    private String codigocontrato;

    public VehicleDto(String chapa, String marca, String color, int capsinequip, int capconequip, int captotal, int annofabricacion, boolean ocupado, String codigocontrato) {
        this.chapa = chapa;
        this.marca = marca;
        this.color = color;
        this.capsinequip = capsinequip;
        this.capconequip = capconequip;
        this.captotal = captotal;
        this.annofabricacion = annofabricacion;
        this.ocupado = ocupado;
        this.codigocontrato = codigocontrato;
    }
    //GET
    public String getChapa() {
        return chapa;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public int getCapsinequip() {
        return capsinequip;
    }

    public int getCapconequip() {
        return capconequip;
    }

    public int getCaptotal() {
        return captotal;
    }

    public int getAnnofabricacion() {
        return annofabricacion;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public String getCodigocontrato() {
        return codigocontrato;
    }
    //SET
    public void setChapa(String chapa) {
        this.chapa = chapa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCapsinequip(int capsinequip) {
        this.capsinequip = capsinequip;
    }

    public void setCapconequip(int capconequip) {
        this.capconequip = capconequip;
    }

    public void setCaptotal(int captotal) {
        this.captotal = captotal;
    }

    public void setAnnofabricacion(int annofabricacion) {
        this.annofabricacion = annofabricacion;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setCodigocontrato(String codigocontrato) {
        this.codigocontrato = codigocontrato;
    }

    @Override
    public String toString() {
        return chapa;
    }
    
}
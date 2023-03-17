/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Victor
 */
public class SeasonDto {
    private int serial_temporada;
    private Date fechainicio;
    private Date fechafin;
    private String descripciontemporada;
    private String codigocontrato;
    private String nombretemporada;

    public SeasonDto(int serial_temporada, Date fechainicio, Date fechafin, String descripciontemporada, String codigocontrato, String nombretemporada) {
        this.serial_temporada = serial_temporada;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.descripciontemporada = descripciontemporada;
        this.codigocontrato = codigocontrato;
        this.nombretemporada = nombretemporada;
    }
    
    //GET
    public int getSerial_temporada() {
        return serial_temporada;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public String getDescripciontemporada() {
        return descripciontemporada;
    }

    public String getCodigocontrato() {
        return codigocontrato;
    }

    public String getNombretemporada() {
        return nombretemporada;
    }
    
    //SET
    public void setSerial_temporada(int serial_temporada) {
        this.serial_temporada = serial_temporada;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public void setDescripciontemporada(String descripciontemporada) {
        this.descripciontemporada = descripciontemporada;
    }

    public void setCodigocontrato(String codigocontrato) {
        this.codigocontrato = codigocontrato;
    }

    public void setNombretemporada(String nombretemporada) {
        this.nombretemporada = nombretemporada;
    }
}
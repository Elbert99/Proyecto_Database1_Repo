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
public class ContractDto {
    protected String codigocontrato;
    protected Date fechainicio;
    protected Date fechaterminacion;
    protected Date fechaconciliacion;
    protected String descripcion;
    protected int llave_agencia;
    protected String tipocontrato;

    public ContractDto(String codigocontrato, Date fechainicio, Date fechaterminacion, Date fechaconciliacion, String descripcion, int llave_agencia, String tipocontrato) {
        this.codigocontrato = codigocontrato;
        this.fechainicio = fechainicio;
        this.fechaterminacion = fechaterminacion;
        this.fechaconciliacion = fechaconciliacion;
        this.descripcion = descripcion;
        this.llave_agencia = llave_agencia;
        this.tipocontrato = tipocontrato;
    }
    //GET
    public String getCodigocontrato() {
        return codigocontrato;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public Date getFechaterminacion() {
        return fechaterminacion;
    }

    public Date getFechaconciliacion() {
        return fechaconciliacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getLlave_agencia() {
        return llave_agencia;
    }

    public String getTipocontrato() {
        return tipocontrato;
    }
    //SET
    public void setCodigocontrato(String codigocontrato) {
        this.codigocontrato = codigocontrato;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechaterminacion(Date fechaterminacion) {
        this.fechaterminacion = fechaterminacion;
    }

    public void setFechaconciliacion(Date fechaconciliacion) {
        this.fechaconciliacion = fechaconciliacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLlave_agencia(int llave_agencia) {
        this.llave_agencia = llave_agencia;
    }

    public void setTipocontrato(String tipocontrato) {
        this.tipocontrato = tipocontrato;
    }
    
    
    public String toString() {
        return codigocontrato;
    }
    
    
}

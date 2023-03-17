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
public class ProgramPackDto {
    private int serial_programapaquete;    
    private Date fechainicial;
    private int cantdias;
    private int cantnoches;
    private float preciototalhotel;
    private float preciotransporteha;
    private float preciotransporteactd;
    private float preciototaltransporte;
    private float preciototalactividades;
    private float preciototalpaquete;
    private String codigopaquete;
    private String tipomodalidadtrasporte;
    private String chapavehiculo;
    private String nombrehotel;
    private String tipoalimento;
    private String tipohabitacion;

    public ProgramPackDto(int serial_programapaquete, Date fechainicial, int cantdias, int cantnoches, double preciototalhotel, double preciotransporteha, double preciotransporteactd, double preciototaltransporte, double preciototalactividades, double preciototalpaquete, String codigopaquete, String tipomodalidadtrasporte, String chapavehiculo, String nombrehotel, String tipoalimento, String tipohabitacion) {
        this.serial_programapaquete = serial_programapaquete;
        this.fechainicial = fechainicial;
        this.cantdias = cantdias;
        this.cantnoches = cantnoches;
        this.preciototalhotel = (float)preciototalhotel;
        this.preciotransporteha = (float)preciotransporteha;
        this.preciotransporteactd = (float)preciotransporteactd;
        this.preciototaltransporte = (float)preciototaltransporte;
        this.preciototalactividades = (float)preciototalactividades;
        this.preciototalpaquete = (float)preciototalpaquete;
        this.codigopaquete = codigopaquete;
        this.tipomodalidadtrasporte = tipomodalidadtrasporte;
        this.chapavehiculo = chapavehiculo;
        this.nombrehotel = nombrehotel;
        this.tipoalimento = tipoalimento;
        this.tipohabitacion = tipohabitacion;
    }
    //GET
    public int getSerial_programapaquete() {
        return serial_programapaquete;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public int getCantdias() {
        return cantdias;
    }

    public int getCantnoches() {
        return cantnoches;
    }

    public float getPreciototalhotel() {
        return preciototalhotel;
    }

    public float getPreciotransporteha() {
        return preciotransporteha;
    }

    public float getPreciotransporteactd() {
        return preciotransporteactd;
    }

    public float getPreciototaltransporte() {
        return preciototaltransporte;
    }

    public float getPreciototalactividades() {
        return preciototalactividades;
    }

    public float getPreciototalpaquete() {
        return preciototalpaquete;
    }

    public String getCodigopaquete() {
        return codigopaquete;
    }

    public String getTipomodalidadtrasporte() {
        return tipomodalidadtrasporte;
    }

    public String getChapavehiculo() {
        return chapavehiculo;
    }

    public String getNombrehotel() {
        return nombrehotel;
    }

    public String getTipoalimento() {
        return tipoalimento;
    }

    public String getTipohabitacion() {
        return tipohabitacion;
    }
    //SET
    public void setSerial_programapaquete(int serial_programapaquete) {
        this.serial_programapaquete = serial_programapaquete;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public void setCantdias(int cantdias) {
        this.cantdias = cantdias;
    }

    public void setCantnoches(int cantnoches) {
        this.cantnoches = cantnoches;
    }

    public void setPreciototalhotel(float preciototalhotel) {
        this.preciototalhotel = preciototalhotel;
    }

    public void setPreciotransporteha(float preciotransporteha) {
        this.preciotransporteha = preciotransporteha;
    }

    public void setPreciotransporteactd(float preciotransporteactd) {
        this.preciotransporteactd = preciotransporteactd;
    }

    public void setPreciototaltransporte(float preciototaltransporte) {
        this.preciototaltransporte = preciototaltransporte;
    }

    public void setPreciototalactividades(float preciototalactividades) {
        this.preciototalactividades = preciototalactividades;
    }

    public void setPreciototalpaquete(float preciototalpaquete) {
        this.preciototalpaquete = preciototalpaquete;
    }

    public void setCodigopaquete(String codigopaquete) {
        this.codigopaquete = codigopaquete;
    }

    public void setTipomodalidadtrasporte(String tipomodalidadtrasporte) {
        this.tipomodalidadtrasporte = tipomodalidadtrasporte;
    }

    public void setChapavehiculo(String chapavehiculo) {
        this.chapavehiculo = chapavehiculo;
    }

    public void setNombrehotel(String nombrehotel) {
        this.nombrehotel = nombrehotel;
    }

    public void setTipoalimento(String tipoalimento) {
        this.tipoalimento = tipoalimento;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }
}

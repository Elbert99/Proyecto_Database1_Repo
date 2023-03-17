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
public class HotelDto {
    private Date fecha;
    private String nombre;
    private String cadenahotelera;
    private String telefono;
    private String fax;
    private String email;
    private float distanciaciudadcerca;
    private float distanciaaeropuerto;
    private int cantidadhabitaciones;
    private int cantidadpisos;
    private String categoria;
    private String localizacion;
    private String provincia;

    public HotelDto(Date fecha, String nombre, String cadenahotelera, String telefono, String fax, String email, double distanciaciudadcerca, double distanciaaeropuerto, int cantidadhabitaciones, int cantidadpisos, String categoria, String localizacion, String provincia) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.cadenahotelera = cadenahotelera;
        this.telefono = telefono;
        this.fax = fax;
        this.email = email;
        this.distanciaciudadcerca = (float)distanciaciudadcerca;
        this.distanciaaeropuerto = (float)distanciaaeropuerto;
        this.cantidadhabitaciones = cantidadhabitaciones;
        this.cantidadpisos = cantidadpisos;
        this.categoria = categoria;
        this.localizacion = localizacion;
        this.provincia = provincia;
    }

    //GET

    public Date getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCadenahotelera() {
        return cadenahotelera;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public float getDistanciaciudadcerca() {
        return distanciaciudadcerca;
    }

    public float getDistanciaaeropuerto() {
        return distanciaaeropuerto;
    }

    public int getCantidadhabitaciones() {
        return cantidadhabitaciones;
    }

    public int getCantidadpisos() {
        return cantidadpisos;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public String getProvincia() {
        return provincia;
    }
        
//SET

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCadenahotelera(String cadenahotelera) {
        this.cadenahotelera = cadenahotelera;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDistanciaciudadcerca(float distanciaciudadcerca) {
        this.distanciaciudadcerca = distanciaciudadcerca;
    }

    public void setDistanciaaeropuerto(float distanciaaeropuerto) {
        this.distanciaaeropuerto = distanciaaeropuerto;
    }

    public void setCantidadhabitaciones(int cantidadhabitaciones) {
        this.cantidadhabitaciones = cantidadhabitaciones;
    }

    public void setCantidadpisos(int cantidadpisos) {
        this.cantidadpisos = cantidadpisos;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
   
    @Override
    public String toString() {
        return nombre;
    } 
}

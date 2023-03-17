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
public class ModeHKDto extends ModeTransportDto {
    private float costokm_recorridos;
    private float costo_horas;
    private float costokm_extras;
    private float costohoras_extras;

    public ModeHKDto(double costokm_recorridos, double costo_horas, double costokm_extras, double costohoras_extras,int serial_modalidadtransporte,String chapavehiculo, String tipomodalidadtransporte) {
        super(serial_modalidadtransporte, chapavehiculo, tipomodalidadtransporte);
        this.costokm_recorridos = (float)costokm_recorridos;
        this.costo_horas = (float)costo_horas;
        this.costokm_extras = (float)costokm_extras;
        this.costohoras_extras = (float)costohoras_extras;
    }

    //Get
    public float getCostokm_recorridos() {
        return costokm_recorridos;
    }

    public float getCosto_horas() {
        return costo_horas;
    }

    public float getCostokm_extras() {
        return costokm_extras;
    }

    public float getCostohoras_extras() {
        return costohoras_extras;
    }

    //Set
    public void setCostokm_recorridos(float costokm_recorridos) {
        this.costokm_recorridos = costokm_recorridos;
    }

    public void setCosto_horas(float costo_horas) {
        this.costo_horas = costo_horas;
    }

    public void setCostokm_extras(float costokm_extras) {
        this.costokm_extras = costokm_extras;
    }

    public void setCostohoras_extras(float costohoras_extras) {
        this.costohoras_extras = costohoras_extras;
    }
    
}

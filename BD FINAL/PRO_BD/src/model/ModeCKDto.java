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
public class ModeCKDto extends ModeTransportDto{
    private float costokm;
    private float costokm_idavuelta;
    private float costo_horasesperas;

    public ModeCKDto(double costokm, double costokm_idavuelta, double costo_horasesperas,int serial_modalidadtransporte,String chapavehiculo, String tipomodalidadtransporte) {
        super(serial_modalidadtransporte,chapavehiculo, tipomodalidadtransporte);
        this.costokm = (float)costokm;
        this.costokm_idavuelta = (float)costokm_idavuelta;
        this.costo_horasesperas = (float)costo_horasesperas;
    }

    //Get
    public float getCostokm() {
        return costokm;
    }

    public float getCostokm_idavuelta() {
        return costokm_idavuelta;
    }

    public float getCosto_horasesperas() {
        return costo_horasesperas;
    }

    //Set
    public void setCostokm(float costokm) {
        this.costokm = costokm;
    }

    public void setCostokm_idavuelta(float costokm_idavuelta) {
        this.costokm_idavuelta = costokm_idavuelta;
    }

    public void setCosto_horasesperas(float costo_horasesperas) {
        this.costo_horasesperas = costo_horasesperas;
    }
}

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
public class ContractServComplDto extends ContractDto{
    private float costopax;

    public ContractServComplDto(double costopax,String codigocontrato, Date fechainicio, Date fechaterminacion, Date fechaconciliacion, String descripcion,int llave_agencia,String tipocontrato) {
        super(codigocontrato, fechainicio, fechaterminacion, fechaconciliacion, descripcion, llave_agencia, tipocontrato);
        this.costopax = (float)costopax;
    }
//    Get
    public float getCostopax() {
        return costopax;
    }
    
//    Set
    public void setCostopax(float costopax) {
        this.costopax = costopax;
    }
    
}

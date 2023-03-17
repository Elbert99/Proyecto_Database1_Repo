/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.LinkedList;

/*
 *
 * @author Victor
 */
public class ContractTransportDto extends ContractDto{
    private String tipoprestario;

    public ContractTransportDto(String tipoprestario, String codigocontrato, Date fechainicio, Date fechaterminacion, Date fechaconciliacion, String descripcion,int llave_agencia,String tipocontrato) {
        super(codigocontrato, fechainicio, fechaterminacion, fechaconciliacion, descripcion, llave_agencia, tipocontrato);
        this.tipoprestario = tipoprestario;
    }
//  Get
    public String getTipoprestario() {
        return tipoprestario;
    }
    
//  Set
    public void setTipoprestario(String tipoprestario) {
        this.tipoprestario = tipoprestario;
    }
}

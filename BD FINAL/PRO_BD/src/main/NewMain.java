  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.util.LinkedList;
import model.AgencyDto;
import model.HotelDto;
import services.AgenciaServices;
import services.ServicesLocator;
import utils.Tools;
import visual.IniciarSesion;
/*
user - pass - role
vitty - victor.98 - (Informatico)
juliet - juliet00 - (Gerente)
sergio - sergio00 - (Administrador)
gabriel - gabriel00 - (Trabajador)
elbert - elbert00 - (Consultor)

*/

/*
Error a Modificar 
En la bd cuando se elimina un contrato de hotel da error
pues hay que agregar a la llave de servicioalojamiento en
ProgramaPaquete la opcion de Cascade cuando Update or Delete
*/
/**
 *
 * @author Victor
 */
public class NewMain {

    public static void main(String[] args) {
        try {
            //Crear Agencia
            int serial = ServicesLocator.getAgenciaServices().obtenerAgencia().serial();
            LinkedList<HotelDto> l = ServicesLocator.getHotelServices().obtenerInd();
            for(HotelDto h : l){System.out.println(h.getNombre());}
            ServicesLocator.getAgenciaServices().editarFechaActualAgencia(serial,Tools.fecha());
            AgencyDto a = ServicesLocator.getAgenciaServices().obtenerAgencia();
            AgencyDto.crearAgencia(a.serial(),a.getNombre(),a.getNombreduenno(),a.getPrimerapellido(),a.getSegundoapellido(),a.getTelefono(),a.getFechaactual());
            
            Tools.decoracion(true);
            Tools.tema(1);
            
            IniciarSesion inicio = new IniciarSesion();
            inicio.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

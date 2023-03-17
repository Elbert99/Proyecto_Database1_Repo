/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JDialog;
import javax.swing.JFrame;
import visual.ContratoHotel_IM;
import visual.ContratoServCompl_IM;
import visual.ContratoTransporte_IM;
import visual.Distancia_IM;
import visual.Hotel_IM;
import visual.Paquete_IM;
import visual.TipoTemporada_IM;
import visual.Usuario_IM;

/**
 *
 * @author Victor
 */
public class ViewInterface {
    private static Hotel_IM ventanahotel;
    private static Usuario_IM ventanausuario;
    private static Distancia_IM ventanadistancia;
    private static TipoTemporada_IM ventanatipotemporada;
    private static ContratoHotel_IM ventanacontratohotel;
    private static ContratoServCompl_IM ventanaservcompl;
    private static ContratoTransporte_IM ventanacontratotransp;
    private static Paquete_IM ventanapaquete;
    
    public static void visualizar(JDialog ventana,JDialog back){     
        if(ventana instanceof Hotel_IM){   
            ventanahotel = new Hotel_IM(back, true);
            ventanahotel.mostrar();
        }else
        if(ventana instanceof Usuario_IM){
            ventanausuario = new Usuario_IM(back, true);
            ventanausuario.mostrar();
        }else
        if(ventana instanceof Distancia_IM){
            ventanadistancia = new Distancia_IM(back, true);
            ventanadistancia.mostrar();
        }else
        if(ventana instanceof TipoTemporada_IM){    
            ventanatipotemporada = new TipoTemporada_IM(back, true);
            ventanatipotemporada.mostrar();
        }else
        if(ventana instanceof ContratoHotel_IM){
            ventanacontratohotel = new ContratoHotel_IM(back, true);
            ventanacontratohotel.mostrar();
        }else
        if(ventana instanceof ContratoServCompl_IM){
            ventanaservcompl = new ContratoServCompl_IM(back, true);
            ventanaservcompl.mostrar();
        }else
        if(ventana instanceof ContratoTransporte_IM){    
            ventanacontratotransp = new ContratoTransporte_IM(back, true);
            ventanacontratotransp.mostrar();
        }else
        if(ventana instanceof Paquete_IM){
            ventanapaquete = new Paquete_IM(back, true);
            ventanapaquete.mostrar();
        }    
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.sql.SQLException;
import utils.Connection;


/**
 *
 * @author Victor 
 */
public class ServicesLocator {
    private static AgenciaServices agenciaservices = null;
    private static HotelServices hotelservices = null;     
    private static ContratoHotelServices contratohotelservices = null;
    private static ContratoServComplServices contratoservcomplservices = null;
    private static ContratoTransporteServices contratotrasnporteservices = null;
    private static PaqueteServices paqueteservices = null; 
    private static DistanciaServices distanciaservices = null;
    
    public static AgenciaServices getAgenciaServices(){ 
        if(agenciaservices == null){
            agenciaservices = new AgenciaServices();
        }
        return agenciaservices;
    } 
    public static HotelServices getHotelServices(){ 
        if(hotelservices == null){
            hotelservices = new HotelServices();
        }
        return hotelservices;
    }
    public static ContratoHotelServices getContratoHotelServices(){ 
        if(contratohotelservices == null){
            contratohotelservices = new ContratoHotelServices();
        }
        return contratohotelservices;
    }
    public static ContratoServComplServices getContratoServComplServices(){
        if(contratoservcomplservices == null){
            contratoservcomplservices = new ContratoServComplServices();
        }
        return contratoservcomplservices;
    }  
    public static ContratoTransporteServices getContratoTransporteServices(){
        if(contratotrasnporteservices == null){
            contratotrasnporteservices = new ContratoTransporteServices();
        }
        return contratotrasnporteservices;
    }
    public static PaqueteServices getPaqueteServices(){
        if(paqueteservices == null){
            paqueteservices = new PaqueteServices();
        }
        return paqueteservices;
    }
    public static DistanciaServices getDistanciaServices(){
        if(distanciaservices == null){
            distanciaservices = new DistanciaServices();
        }
        return distanciaservices;
    }
    public static java.sql.Connection getConnection(){
		Connection connection = null;
		try {
			connection = new Connection("localhost", "ControlPaquetesyContratos", "postgres", "postgres");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection.getConnection();
    }
}
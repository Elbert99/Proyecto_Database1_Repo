package reports;

import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;



import services.ServicesLocator;


public class ServiciosReportes {
	public static ServiciosReportes reports= new ServiciosReportes();
	private java.sql.Connection myConecction=null;
	
	public ServiciosReportes(){
		super();
		this.myConecction= ServicesLocator.getConnection();
	}
	
	public  void CargarContratoHotel(){
		try{
			JasperPrint print= JasperFillManager.fillReport("src/reports/reportehotel.jasper", null,myConecction);
			JasperViewer view =new JasperViewer(print,false);
			view.setVisible(true);
		}catch(JRException e2){
			e2.printStackTrace();
		}
	}
	public  void CargarPaqueteTuristico(){
		try{
			JasperPrint print= JasperFillManager.fillReport("src/reports/reporteprograma.jasper", null,myConecction);
			JasperViewer view =new JasperViewer(print,false);
			view.setVisible(true);
		}catch(JRException e2){
			e2.printStackTrace();
		}
	}
		public  void CargarContratoTemporada(){
			try{
				JasperPrint print= JasperFillManager.fillReport("src/reports/reportetemporada.jasper", null,myConecction);
				JasperViewer view =new JasperViewer(print,false);
				view.setVisible(true);
			}catch(JRException e2){
				e2.printStackTrace();
			}
		}
                public  void CargarPaqueteTotal(){
			try{
				JasperPrint print= JasperFillManager.fillReport("src/reports/reportepaquete.jasper", null,myConecction);
				JasperViewer view =new JasperViewer(print,false);
				view.setVisible(true);
			}catch(JRException e2){
				e2.printStackTrace();
			}
		}
		public  void CargarHoteles(){
			try{
				JasperPrint print= JasperFillManager.fillReport("src/reports/reportedatohotel.jasper", null,myConecction);
				JasperViewer view =new JasperViewer(print,false);
				view.setVisible(true);
			}catch(JRException e2){
				e2.printStackTrace();
			}
		}
                public  void CargarServiciosComplementario(){
			try{
				JasperPrint print= JasperFillManager.fillReport("src/reports/reporteactividades.jasper", null,myConecction);
				JasperViewer view =new JasperViewer(print,false);
				view.setVisible(true);
			}catch(JRException e2){
				e2.printStackTrace();
			}
		}
                public  void CargarCONTRATOTRANSPORTE(){
			try{
				JasperPrint print= JasperFillManager.fillReport("src/reports/reportetransporte.jasper", null,myConecction);
				JasperViewer view =new JasperViewer(print,false);
				view.setVisible(true);
			}catch(JRException e2){
				e2.printStackTrace();
			}
		}
		
}

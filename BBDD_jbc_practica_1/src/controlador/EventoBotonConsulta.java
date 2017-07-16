package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.UITablaConsulta;

public class EventoBotonConsulta implements ActionListener{
	
	
	private UITablaConsulta tabla;
	
	public EventoBotonConsulta (UITablaConsulta tabla){
		
		this.setTabla(tabla);
		
	}


	public void actionPerformed(ActionEvent e) {
		
		String seccion;
		String pais;
		
		seccion = getTabla().getCajaSeccion().getSelectedItem().toString();
		
		pais = getTabla().getCajaPais().getSelectedItem().toString();
		
		System.out.println("seccion: " + seccion + " pais: " + pais);
		
		ControladorConsulta cc = new ControladorConsulta();
		
		cc.consultaBaseDatos(getTabla(), seccion, pais);
		
	}


	public UITablaConsulta getTabla() {
		return tabla;
	}


	public void setTabla(UITablaConsulta tabla) {
		this.tabla = tabla;
	}
	
	
	
	
	

}

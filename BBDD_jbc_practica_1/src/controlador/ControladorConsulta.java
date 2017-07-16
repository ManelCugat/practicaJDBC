package controlador;

import java.sql.*;
import java.util.*;

import modelo.ConsultaBBDD;
import vista.UITablaConsulta;


public class ControladorConsulta {
	
	
	private ConsultaBBDD consulta;
	private ResultSet resultado=null;
	
	
	public ControladorConsulta() {
	
		
	}
	
	
	public ArrayList <String> cajaSeccion (){
		
			consulta = new ConsultaBBDD();
		
			resultado = consulta.resultadoCajaSeccion();
		
			ArrayList <String> lista = new ArrayList <String>();

			try {
				while (resultado.next()){
					
					lista.add(resultado.getString(1));
					
				}
				
				consulta.getMiConexion().close();
				
			} catch (SQLException e) {

				e.printStackTrace();
			}

			
		return lista;
		
	}
	
	
	public ArrayList <String> cajaPais (){
		
			consulta = new ConsultaBBDD();
		
			resultado = consulta.resultadoCajaPais();
		
			ArrayList <String> lista = new ArrayList <String>();
		
			try {
				while (resultado.next()){
				
				lista.add(resultado.getString(1));
				}
				
				consulta.getMiConexion().close();
				
			} catch (SQLException e) {

			e.printStackTrace();
			}
		
		return lista;
		
	}
	
	
	public void consultaBaseDatos (UITablaConsulta tabla, String seccion, String pais) {
		

		consulta = new ConsultaBBDD();
		
		resultado = consulta.resultadoConsulta(seccion, pais);
		
		tabla.getAreaTexto().setText(null);
		
		try{
		
		while (resultado.next()){
			
			tabla.getAreaTexto().append(resultado.getString(1) + ", " + resultado.getString(2) +
					" ," + resultado.getString(3) + " ," + resultado.getString(4) + "\n");
			
	
		}
		
		consulta.getMiConexion().close();
		
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
	}
	

}

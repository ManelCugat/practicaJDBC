package modelo;

import java.sql.*;


public class ConsultaBBDD {
	
	private Connection miConexion;
	private ResultSet resultado;
	
	public ConsultaBBDD (){
		
		
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:8889/Curso_SQL", "root", "root");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
	}
	
	
	public ResultSet resultadoCajaSeccion () {
		
		try{
		
			Statement statement = miConexion.createStatement();
			
			statement = miConexion.createStatement();
			
			resultado = statement.executeQuery("SELECT DISTINCT SECCIÓN FROM PRODUCTOS");
			
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
			return resultado;

	}
	


	public ResultSet resultadoCajaPais ()  {
		
		try{
		
			Statement statement = miConexion.createStatement();
		
			statement = miConexion.createStatement();
		
			resultado = statement.executeQuery("SELECT DISTINCT PAÍSDEORIGEN FROM PRODUCTOS");
			
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}

			return resultado;
		
	}
	
	
	public ResultSet resultadoConsulta (String seccion, String pais){
		
		String consultaSeccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
		String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
		String consultaSeccion_Pais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
		String consultaTodo = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS";
		PreparedStatement ps;
		Statement s;
		
		try{
			


			if (!seccion.equalsIgnoreCase("todo") && pais.equalsIgnoreCase("todo")){
				
				ps = miConexion.prepareStatement(consultaSeccion);
				
				ps.setString(1, seccion);
				
				resultado = ps.executeQuery();
				
			} 
			
			
			if (seccion.equalsIgnoreCase("todo") && !pais.equalsIgnoreCase("todo")) {
				
				ps = miConexion.prepareStatement(consultaPais);
				
				ps.setString(1, pais);
				
				resultado = ps.executeQuery();
				
			}
			
			if (!seccion.equalsIgnoreCase("todo") && !pais.equalsIgnoreCase("todo")){
				
				ps = miConexion.prepareStatement(consultaSeccion_Pais);
				
				ps.setString(1, seccion);
				
				ps.setString(2, pais);
				
				resultado = ps.executeQuery();
				
			}
			
			if (seccion.equalsIgnoreCase("todo") && pais.equalsIgnoreCase("todo")){
				
				s = miConexion.createStatement();
				
				resultado = s.executeQuery(consultaTodo);
				
			}
			
			
			
			
			
			
		}catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		return resultado;
	
	}


	public ResultSet getResultado() {
		return resultado;
	}


	public void setResultado(ResultSet resultado) {
		this.resultado = resultado;
	}
	
	
	public Connection getMiConexion() {
		return miConexion;
	}


	public void setMiConexion(Connection miConexion) {
		this.miConexion = miConexion;
	}
	
	

}

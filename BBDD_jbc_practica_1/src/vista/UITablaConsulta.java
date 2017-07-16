package vista;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import controlador.ControladorConsulta;
import controlador.EventoBotonConsulta;

public class UITablaConsulta {
	
	
	
	
	private JComboBox <String> cajaSeccion,cajaPais;



	private JTextArea areaTexto;



	private JButton botonConsulta;
	private JPanel laminaNorte;
	private ControladorConsulta consultaCajas;

	
	public UITablaConsulta(){
		
		consultaCajas = new ControladorConsulta();
	
		Marco marco = new Marco();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
		

	
	}
	
	

	private class Marco extends JFrame{
	
	
		public Marco(){
		
		
			this.setBounds(300, 300, 450, 450);
		
			this.setTitle("Consulta BD");
		
			Lamina lamina=new Lamina();
		
			this.add(lamina);
		

		
		}
	
	
	
	}


	private class Lamina extends JPanel{
	
	
		public Lamina (){
		
		
			//Creación de estructuras de láminas
		
			this.setLayout(new BorderLayout());
		
			laminaNorte = new JPanel ();
		
			laminaNorte.setLayout(new FlowLayout());
		
			this.add(laminaNorte, BorderLayout.NORTH);
		
			//Creación de componentes
		
			cajaSeccion = new JComboBox();
		
			cajaPais = new JComboBox();
		
			areaTexto = new JTextArea(20,10);
		
			botonConsulta = new JButton ("Consulta");
		
			//Distribución de los componentes en las láminas
		
			laminaNorte.add(cajaSeccion);
		
			laminaNorte.add(cajaPais);
		
			this.add(areaTexto,BorderLayout.CENTER);
		
			this.add(botonConsulta, BorderLayout.SOUTH);
		
			//Poner a la escucha el componente
		
			botonConsulta.addActionListener(new EventoBotonConsulta(UITablaConsulta.this));
		
			//Se rellena la caja de seccion
			
			rellenaCajaSeccion(consultaCajas.cajaSeccion());
			
			//Se rellena la caja país
			
			rellenaCajaPais (consultaCajas.cajaPais());

		}
		
	}
	
	

	public void rellenaCajaSeccion (ArrayList <String> s){
		
		Iterator <String> it = s.iterator();
		
		getCajaSeccion().addItem("Todo");
		
		while (it.hasNext()){
			
			String seccion = it.next();
			
			getCajaSeccion().addItem(seccion);
		
		}
	
	}
	
	
	public void rellenaCajaPais (ArrayList <String> s){
		
		Iterator <String> it = s.iterator();
		
		getCajaPais().addItem("Todo");
		
		while (it.hasNext()){
			
			String pais = it.next();
			
			getCajaPais().addItem(pais);
			
		}
		
		
	}
	
	
	public JComboBox<String> getCajaSeccion() {
		return cajaSeccion;
	}


	public void setCajaSeccion(JComboBox<String> cajaSeccion) {
		this.cajaSeccion = cajaSeccion;
	}


	public JComboBox<String> getCajaPais() {
		return cajaPais;
	}


	public void setCajaPais(JComboBox<String> cajaPais) {
		this.cajaPais = cajaPais;
	}
	
	public JTextArea getAreaTexto() {
		return areaTexto;
	}


	public void setAreaTexto(JTextArea areaTexto) {
		this.areaTexto = areaTexto;
	}
	
	

}

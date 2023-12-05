package menu;
import gral.ConexionDB;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import gral.ConexionDB;

@SuppressWarnings("serial")
public class FormularioMain extends JFrame implements ActionListener
{
	JButton btn_1, btn_2, btn_3, salir;
	JLabel titulo;
	JLabel lb_titulo;


	
	public FormularioMain()
	{
		// ************************************************** FORMULARIO INICIAL
		this.setVisible(true);
		this.setBounds(640,480,640,480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("SISTEMA DE SOPORTE DE INCIDENCIAS");
		
		btn_1= this.creaBoton("Area Recursos humanos",200,100, 250,50);
		btn_2 = this.creaBoton("Area comercial",200,170,250,50);
		btn_3 = this.creaBoton("Area de mesa de ayuda",200,240, 250,50);
		salir = this.creaBoton("SALIR",200,320, 250,50);
		salir.setBackground( new Color(200,200,150) );
		
		// ***********************************************   ETIQUETAS
		lb_titulo = creaEtiqueta("M  E  N  U     P  R  I  N  C  I  P  A  L ", 230, 20, 350, 50);
		
		try {
			ConexionDB.conexionDB();
			}
			catch(Exception e) {
		    	
		    System.out.println("Error en ABM de la base de datos MAIN: "+ e);
		    System.out.println(e.fillInStackTrace());
		    }
		
	}
	
	public static void main(String[] args) 
	{
		FormularioMain formularioPrincipal = new FormularioMain();
		
	}
	
	
	private JButton creaBoton(String texto, int posx,int posy,int ancho, int alto)
	{
		 JButton boton = new JButton(texto);
		 boton.setBounds(posx,posy, ancho,alto);
		 boton.setBorder(null);
		 boton.addActionListener(this);
		 this.add(boton);
		 return boton;
	}
	
	private JLabel creaEtiqueta(String texto, int posx,int posy,int ancho, int alto)
	{
		JLabel etiqueta = new JLabel(texto);
		etiqueta.setBounds(posx,posy, ancho,alto);
		etiqueta.setBorder(null);
		this.add(etiqueta);
		return etiqueta;
	}
	




	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btn_1) 
		{
			System.out.println("PRECIONASTE BOTON RRHH" );
			FormularioRRHH menuRRHH = new FormularioRRHH(this);
			this.setVisible(false);
		}
		else if(e.getSource() == btn_2) 
		{
			System.out.println("PRECIONASTE BOTON btn_comercial");
			FormularioAreaComercial formularioAreaComercial = new FormularioAreaComercial(this);
			this.setVisible(false);
		}
		else if(e.getSource() == btn_3) 
		{
			System.out.println("PRECIONASTE BOTON btn_mesaAyuda");
			FormularioMesaAyuda  formularioAreaComercial = new FormularioMesaAyuda(this);
			this.setVisible(false);
		}
		
		else if(e.getSource() == salir) 
		{
			System.out.println("PRECIONASTE BOTON btn_mesaAyuda" + salir);
			System.exit(0);
		}

	}
	




	
	
	
}

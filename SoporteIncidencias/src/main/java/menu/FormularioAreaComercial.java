package menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class FormularioAreaComercial extends JFrame implements ActionListener
{
	JButton btn_1, btn_2, btn_3,salir;
	JLabel titulo;
	JLabel lb_titulo;
	FormularioMain formularioAnterior;


	
	public FormularioAreaComercial(FormularioMain anterior )
	{
		// ************************************************** FORMULARIO INICIAL
		this.setVisible(true);
		this.setBounds(anterior.getBounds());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("SISTEMA DE SOPORTE DE INCIDENCIAS");		
		
		// ***********************************************   BOTONES
		
		btn_1= this.creaBoton("Alta cliente",200,100, 250,50);
		btn_2 = this.creaBoton("Listar cliente",200,170,250,50);
		btn_3 = this.creaBoton("Baja cliente",200,240, 250,50);
		salir = this.creaBoton("VOLVER",200,320, 250,50);
		salir.setBackground( new Color(200,200,150) );
		
		// ***********************************************   ETIQUETAS
		lb_titulo = creaEtiqueta("M  E  N  U    A R E A   C O M E R C I A L ", 220, 20, 350, 50);
		
		this.formularioAnterior = anterior;
	}
	
	
	
	public JButton creaBoton(String texto, int posx,int posy,int ancho, int alto)
	{
		 JButton boton = new JButton(texto);
		 boton.setBounds(posx,posy, ancho,alto);
		 boton.setBorder(null);
		 boton.addActionListener(this);
		 this.add(boton);
		 return boton;
	}
	
	public JLabel creaEtiqueta(String texto, int posx,int posy,int ancho, int alto)
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
			System.out.println("PRECIONASTE BOTON " + btn_1);
		}
		else if(e.getSource() == btn_2) 
		{
			System.out.println("PRECIONASTE BOTON "+ btn_2);
		}
		else if(e.getSource() == btn_3) 
		{
			System.out.println("PRECIONASTE BOTON "+ btn_3);
		}
		
		else if(e.getSource() == salir) 
		{
			System.out.println("PRECIONASTE BOTON "+ salir);
			this.setVisible(false);
			formularioAnterior.setBounds(this.getBounds());
			formularioAnterior.setVisible(true);
		}
		

	}
	




	
	
	
}

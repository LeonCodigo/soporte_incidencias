package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import gral.Tecnico;
import gral.ConexionDB;

import javax.swing.*;

@SuppressWarnings("serial")
public class FormularioCargaTecnico extends JFrame implements ActionListener
{
	JButton btn_Aceptar, salir;
	JTextArea txt1,txt2,txt3,txt6,txt4,txt5;
	JLabel titulo;
	JLabel lb_titulo;
	FormularioRRHH formularioAnterior;
	

	
	public FormularioCargaTecnico(FormularioRRHH anterior )
	{
		// ************************************************** FORMULARIO INICIAL
		this.setVisible(true);
		this.setBounds(anterior.getBounds());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("SISTEMA DE SOPORTE DE INCIDENCIAS");		
		
		// ***********************************************   BOTONES
		btn_Aceptar = this.creaBoton("ACEPTAR",100,300, 80,50);
		salir = this.creaBoton("VOLVER",350,300, 80,50);
		salir.setBackground( new Color(200,200,150) );
		
		// ***********************************************   CAJA TEXTO
	
		txt1 = creaCajaTexto("Cuit nuevo Tecnico: "     ,220,80 ,220, 20);
		txt2 = creaCajaTexto("Codigo deL Soporte:"      ,220,120,220, 20);
		txt3 = creaCajaTexto("Titulo/Profesion/Oficio:" ,220,160,220, 20);
		txt4 = creaCajaTexto("Disponibilidad horaria:"  ,220,200,220, 20);
		txt5 = creaCajaTexto("Estdo (activo/inactivo):" ,220,240,220, 20);
		
		// ***********************************************   ETIQUETAS
		lb_titulo = creaEtiqueta("N U E V O   T E C N I C O", 220, 20, 350, 50,18);
		
		this.formularioAnterior = anterior;
		
		
	}
	
	
	
	public JButton creaBoton(String texto, int posx,int posy,int ancho, int alto)
	{
		 JButton boton = new JButton(texto);
		 boton.setBounds(posx,posy, ancho,alto);
		 boton.setBorder(null);
		 boton.addActionListener(this);
		 boton.setFont(new Font("Comic Sans MS",Font.BOLD,14));
		 this.add(boton);
		 return boton;
	}
	
	public JLabel creaEtiqueta(String texto, int posx,int posy,int ancho, int alto, int tamanio)
	{
		JLabel etiqueta = new JLabel(texto);
		etiqueta.setBounds(posx,posy, ancho,alto);
		etiqueta.setBorder(null);
		etiqueta.setFont(new Font("Comic Sans",Font.BOLD,tamanio));
		this.add(etiqueta);
		return etiqueta;
	}
	
	public JTextArea creaCajaTexto(String texto,int posx,int posy,int ancho, int alto)
	{
		 JTextArea caja = new JTextArea();
		 caja.setBounds(posx,posy, ancho,alto);
		 caja.setFont(new Font("Tahoma",Font.BOLD,12));
		 JLabel textoInformativo = creaEtiqueta(texto,30,posy,200,30,14);
		 this.add(caja);
		 this.add(textoInformativo);
		 return caja;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btn_Aceptar) 
		{
			System.out.println("PRECIONASTE BOTON " + btn_Aceptar);

			String cuitTec = txt1.getText();			
			String codSopo = txt2.getText();			
			String titulo = txt3.getText();		
			String disponibilidad = txt4.getText();			
			String estado = txt5.getText();
			
			Tecnico tec1 = new Tecnico(1,cuitTec,codSopo,titulo,disponibilidad,LocalDate.now(),estado);
			ConexionDB.altaTecnicoDB(tec1);
			
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

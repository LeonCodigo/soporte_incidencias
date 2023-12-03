package menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		salir = this.creaBoton("VOLVER",300,300, 80,50);
		salir.setBackground( new Color(200,200,150) );
		
		// ***********************************************   CAJA TEXTO
	
		txt1 = creaCajaTexto("CUIT nuevo Tecnico: ",300,80,200, 30);
		txt2 = creaCajaTexto("CODIGO deL Soporte",300,120,200, 30);
		txt3 = creaCajaTexto("TITULO/PROFESION/OFICIO:",300,160,200, 30);
		txt4 = creaCajaTexto("DISPONIBILIDAD horaria",300,200,200, 30);
		txt5 = creaCajaTexto("ESTADO activo/inactivo:",300,240,200, 30);
		
		// ***********************************************   ETIQUETAS
		lb_titulo = creaEtiqueta("N U E V O   T E C N I C O", 220, 20, 350, 50);
		
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
	
	public JTextArea creaCajaTexto(String texto,int posx,int posy,int ancho, int alto)
	{
		 JTextArea caja = new JTextArea();
		 caja.setBounds(posx,posy, ancho,alto);
		 caja.setBorder(null);
		 JLabel textoInformativo = creaEtiqueta(texto,30,posy,200,30);
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
			
			Tecnico tec1 = new Tecnico(1,cuitTec,codSopo,titulo,disponibilidad,estado);
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

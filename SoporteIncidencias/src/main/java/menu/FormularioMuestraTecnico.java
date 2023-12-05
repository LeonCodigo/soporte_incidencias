package menu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import gral.Tecnico;
import gral.ConexionDB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class FormularioMuestraTecnico extends JFrame implements ActionListener
{
	private JButton btn_Buscar, salir;
	private JTextArea txt1;
	private JLabel lb_titulo;
	private FormularioRRHH formularioAnterior;
	private DefaultTableModel modelo;
	private JTable tbTecnicos;

	
	public FormularioMuestraTecnico(FormularioRRHH anterior )
	{
		// ************************************************** FORMULARIO INICIAL
		this.setVisible(true);
		this.setBounds(anterior.getBounds());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("SISTEMA DE SOPORTE DE INCIDENCIAS");		
		
		// ***********************************************   BOTONES
		btn_Buscar = this.creaBoton("BUSCAR",100,350, 80,50);
		salir = this.creaBoton("VOLVER",350,350, 80,50);
		salir.setBackground( new Color(200,200,150) );
		
		// ***********************************************   CAJA TEXTO
	
		txt1 = creaCajaTexto("Buscar tecnico por CUIT: ",220,80 ,220, 20);
	
		
		// ***********************************************   ETIQUETAS
		lb_titulo = creaEtiqueta("B U S Q U E D A   T E C N I C O", 220, 20, 350, 50,18);
		
		
		
		Container contenedor = this.getContentPane();
		tbTecnicos = new JTable(); 
	//	tbTecnicos.setBounds(10,120,600,200);
		tbTecnicos.setFont(txt1.getFont());
		JScrollPane jsp = new JScrollPane(tbTecnicos);
		jsp.setBounds(10,120,600,200);
		contenedor.add(jsp);
		modelo = (DefaultTableModel) tbTecnicos.getModel();
		modelo.addColumn("ID");
		modelo.addColumn("CUIT");
		modelo.addColumn("CODIGO SOPORTE");
		modelo.addColumn("TITULO");
		modelo.addColumn("DISPONIBILIDAD");
		modelo.addColumn("ALTA");
		modelo.addColumn("ESTADO");
		
		this.formularioAnterior = anterior;
	
	}
	
	
	
	private JButton creaBoton(String texto, int posx,int posy,int ancho, int alto)
	{
		 JButton boton = new JButton(texto);
		 boton.setBounds(posx,posy, ancho,alto);
		 boton.setBorder(null);
		 boton.addActionListener(this);
		 boton.setFont(new Font("Comic Sans MS",Font.BOLD,14));
		 this.add(boton);
		 return boton;
	}
	
	private JLabel creaEtiqueta(String texto, int posx,int posy,int ancho, int alto, int tamanio)
	{
		JLabel etiqueta = new JLabel(texto);
		etiqueta.setBounds(posx,posy, ancho,alto);
		etiqueta.setBorder(null);
		etiqueta.setFont(new Font("Comic Sans",Font.BOLD,tamanio));
		this.add(etiqueta);
		return etiqueta;
	}
	
	private JTextArea creaCajaTexto(String texto,int posx,int posy,int ancho, int alto)
	{
		 JTextArea caja = new JTextArea();
		 caja.setBounds(posx,posy, ancho,alto);
		 caja.setFont(new Font("Tahoma",Font.BOLD,12));
		 JLabel textoInformativo = creaEtiqueta(texto,30,posy,200,30,14);
		 this.add(caja);
		 this.add(textoInformativo);
		 return caja;
	}
	

	
	 public void borraFilas()
	   {
		
		int cant = modelo.getRowCount();
		int i=0;
		while(i < cant)
		{
			 modelo.removeRow(0);
			i++;
		}
		   
	   }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btn_Buscar) 
		{
            String cuitBuscado = txt1.getText();
			ArrayList<Tecnico> listaTecnicos  = new ArrayList<Tecnico>();
			listaTecnicos  = ConexionDB.listarTecnico(cuitBuscado);
			borraFilas();
			listaTecnicos.stream().forEach(( tecnico )  -> modelo.addRow(new Object[] 
			{tecnico.getIdTecnico(),tecnico.getCuitEmpleado(),tecnico.getCodSoporte(),tecnico.getTituloTecnico(),
			tecnico.getDispoTecnico(),tecnico.getAltaTecnico(),tecnico.getEstadoTecnico()}));
			
		}
		
		else if(e.getSource() == salir) 
		{
			this.setVisible(false);
			formularioAnterior.setBounds(this.getBounds());
			formularioAnterior.setVisible(true);
		}
		
		
		

	}
	




	
	
	
}

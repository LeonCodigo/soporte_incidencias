import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Principal
{
	
	static Scanner teclado = new Scanner(System.in);
	
	
	public static void main(String[] argumentos)
	{
		
		int opciones = 99;
		
		try {
			
			ConexionDB.conexionDB();		
			

			while(opciones != 0) 
			{
				System.out.println("\n\n\n   --  M E N U -- \n" );
				System.out.println("| 1 | -> Area RRHH" ); //
				System.out.println("| 2 | -> Area comercial");
				System.out.println("| 3 | -> Area Mesa de ayuda");
			
				System.out.println("\n| 0 | -> S A L I R");
				
				opciones = teclado.nextInt();
				
				switch(opciones)
				{
				
				case 1: String[] menuOPciones = {"Alta tecnico", "Listar tecnicos", "Baja tecnico"};
				menuRRHH( creaMenu("-- MENU RRHH -- ", menuOPciones) );					
				break;
				
				case 2: String[] menuOPciones2 = {"Alta cliente", "Listar cliente", "Baja cliente"};
			    menuAreaComercial( creaMenu( "-- MENU AREA COMERCIAL --", menuOPciones2 ) );					
				break;
				
				case 3: String[] menuOPciones3 = {"Alta incidente", "Listar incidente", "Baja incidente"};
			    menuRRHH( creaMenu("-- MENU MESA DE AYUDA -- ", menuOPciones3) );						
				break;
				
				default : System.out.println("Seleccione una opcion valida" ); 
				
				}
			}
			
			teclado.close();
		   
	      
	              
		}
		catch(Exception obj) {
		    	
		    System.out.println("Error en ABM de la base de datos MAIN: "+ obj);
		    System.out.println(obj.fillInStackTrace());
		    }
		
		
		
	}  // Fin MAIN
	
	
	
	static public short creaMenu(String nombre, String[] menuOpciones)
	{		
		System.out.println(nombre + "\n");		
			for (int i = 0; i < menuOpciones.length; i++) 
			{
				System.out.println("|"+ (i+1) +"| -> " + menuOpciones[i]);
			}
			System.out.println("|0| -> Volver al menu anterior");						
	
			return teclado.nextShort();
	}
	
	
	
	static public void menuRRHH(short opcion)
	{
		// {"Alta tecnico", "Listar tecnicos", "Baja tecnico", "Modificar tecnico"};
		switch(opcion)
		{
		case 1:  Tecnico tec1 = Tecnico.altaTecnico();  
		         ConexionDB.altaTecnicoDB(tec1);
			break;
		
		case 2: ConexionDB.listarTecnico();;

			break;
		case 3:  System.out.print("\n Seleccione el id del Tecnico a dar de baja: ");
			String id = teclado.next();
			ConexionDB.bajaTecnicoId(id);
			break;
			
		default : System.out.println("Seleccione una opcion valida" ); 
		
	    }  // fin switch
	}
	
	
	static public void menuAreaComercial(short opcion)
	{
		// {"Alta cliente", "Listar cliente", "Baja cliente", "Modificar cliente"};
		switch(opcion)
		{
		case 1:  	Cliente cli1 = Cliente.altaCliente(); ConexionDB.altaClienteDB(cli1);
			break;
		
		case 2:

			break;
		case 3:

			break;
		
		default : System.out.println("Seleccione una opcion valida" ); 
	    }  // fin switch
	}
	
	static public void menuMesaAyuda(short opcion)
	{
		// {"Alta incidente", "Listar incidente", "Baja incidente", "Modificar incidente"};
		switch(opcion)
		{
		case 1: Incidente inc1 = Incidente.altaIncidente();
		        ConexionDB.altaIncidenteDB(inc1);
			break;
		
		case 2:

			break;
		case 3:

			break;

		default : System.out.println("Seleccione una opcion valida" ); 
	    }  // fin switch
	}
	
	
	/*
	static public void menuRRHH(short opcion)
	{
		// {"Alta ", "Listar ", "Baja ", "Modificar "};
		switch(opcion)
		{
		case 1:  
			break;
		
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;		
	    }  // fin switch
	}
	
	*/
	

}// fin clase Principal

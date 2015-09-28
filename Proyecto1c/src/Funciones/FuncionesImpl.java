package Funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FuncionesImpl {

	private File f1, f2;
	private boolean iguales = true;
	
	public FuncionesImpl(){
		//DECLARACIÓN DE 2 FICHEROS
		f1 = new File("fichero1.txt");
		f2 = new File("fichero2.txt");
		
		//METODOS QUE EJECUTARAN LAS FUNCIONES
		
		this.compararContenido(f1, f2);
		int resultado = this.buscarPalabra(f1, "dam2", true);
		
		//Mostramos por consola el resultado
		System.out.println(resultado);
	}
	
	
	public boolean compararContenido(File fichero1, File fichero2){
		
		String cadena1=null, cadena2=null;
		try{
			
			FileReader fr1 = new FileReader(f1);
			FileReader fr2 = new FileReader(f2);
			BufferedReader bf1 = new BufferedReader(fr1);
			BufferedReader bf2 = new BufferedReader(fr2);
			
			//Empezamos a leer 
			cadena1 = bf1.readLine();
			cadena2 = bf2.readLine();
			
			while ((cadena1!=null) && (cadena2!=null) && iguales==true) {
				//Comprobación de si ambas lineas son iguales o no
				
				  if (cadena1.equals(cadena2)==true){
					  //Si las dos lineas coinciden y son iguales seguimos leyendo para comprobar
					  cadena1=bf1.readLine();
					  cadena2=bf2.readLine();
				  } 
				  else{
					   //Las dos cadenas son diferentes, por tanto, modificamos iguales a false para posteriormente condicionarlo y devolvemos false
					  	iguales = false;
				  		return false;
				  }  
			}
		}
		catch(IOException error){
			System.err.println("Error al comparar los ficheros.");
		}
		
		//Ponemos condiciones a los resultados para mostrar por consola
		if(cadena1==null && cadena2==null && iguales==true){
			System.out.println("Ficheros iguales");
		}
		else{
			System.out.println("Ficheros no iguales");
		}
		
		//En caso de ser iguales devolvemos true por defecto
		return true;
	}
	
	
	/*Este método recibe un fichero, una palabra a buscar en el, y un tercer parámetro cuya función es de mostrar por consola,
	  en caso de ser true, la primera linea donde se ha encontrado la palabra y en caso contrario, si es false, la última. */
	
	public int buscarPalabra(File fichero, String palabra, boolean boleano){
		//Uso de variables que he considerado necesarias:
		String cadena=null;
		boolean palabraEncontrada=false;
		int contadorLineas=0;
		ArrayList<String> lineas = new ArrayList<String>();
		
		try{
			//Si el fichero no existe el programa devuelve -1
			if(fichero.exists()==false){
				System.out.println("El fichero no existe.");
				return -1;
			}
			else{
				//En caso de existir, se procede a leer el archivo y encontrar la palabra pasada por parámetro
				FileReader fr1 = new FileReader(fichero);
				@SuppressWarnings("resource")
				BufferedReader bf1 = new BufferedReader(fr1);
				//Empezamos a leer sobre el ficheros
				cadena = bf1.readLine();
				
				while(cadena!=null){
					//Incrementamos el contador de lineas
					contadorLineas++;
					
		            if(cadena.equals(palabra)==true){
		            	//Si se encuentra la palabra, aunque sea por primera vez, se activa el boleano
		            	palabraEncontrada=true;
		            	//Salida por pantalla informativa
		            	System.out.println("Se ha encontrado la palabra '"+cadena+"' en la linea: "+contadorLineas);
		            	//Añadimos la linea donde se ha encontrado la palabra que buscamos a un ArrayList<String> realizando un casting
		            	lineas.add(String.valueOf(contadorLineas));
		            	//"""
		            	cadena = bf1.readLine();
		            }
		            else{
		            	cadena = bf1.readLine();
		            } 
				}
				//Insertamos un salto de linea para mostrar la información claramente al usuario
				System.out.println("\n");
			}
		}
		catch(IOException error){
			//En caso de fallo, capturamos el error y mostramos por consola
			System.err.println("Error al encontrar la palabra");
		}
		
		//Condicionamos los resultados para mostrar por consola
		if (palabraEncontrada==true && boleano==true){
			System.out.println("Primera palabra encontrada en la linea: "+lineas.get(0));
			return Integer.parseInt(lineas.get(0));
		}
		else if (palabraEncontrada==true && boleano==false) {
			System.out.println("Ultima palabra encontrada en la linea: "+lineas.get(lineas.size()-1));
			return Integer.parseInt(lineas.get(lineas.size()-1));
		}
		else {
			//Si no se encuentra la palabra, mostramos por consola e informamos al usuario
			System.out.println("No se ha encontrado la palabra en ninguna linea. ");
			return -1;
		}	
	}
}

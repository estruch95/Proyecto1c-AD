package Funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FuncionesImpl {

	private File f1, f2;
	private boolean iguales = true;
	
	public FuncionesImpl(){
		//DECLARACIÓN DE 2 FICHEROS
		f1 = new File("fichero1.txt");
		f2 = new File("fichero2.txt");
		
		//this.compararContenido(f1, f2);
		this.buscarPalabra(f1, "uno", true);
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
				//Compración de si ambas lineas son iguales o no
				
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
		
		if(cadena1==null && cadena2==null && iguales==true){
			System.out.println("Ficheros iguales");
		}
		else{
			System.out.println("Ficheros no iguales");
		}
		
		return true;
	}
	
	
	
	public int buscarPalabra(File fichero, String palabra, boolean boleano){
		
		String cadena=null;
		boolean palabraEncontrada=false;
		try{
			
			if(fichero.exists()==false){
				System.out.println("El fichero no existe.");
				return -1;
			}
			else{
				
				FileReader fr1 = new FileReader(fichero);
				BufferedReader bf1 = new BufferedReader(fr1);
				
				cadena = bf1.readLine();
				
				while(cadena!=null){
					
		            if(cadena.equals(palabra)==true){
		            	palabraEncontrada=true;
		            	break;
		            }
		            else{
		            	cadena = bf1.readLine();
		            } 
				}
			}
		}
		catch(IOException error){
			System.err.println("Error al encontrar la palabra");
		}
		
		if(palabraEncontrada==true){
			System.out.println("Se ha encontrado la palabra: "+palabra);
		}
		else{
			System.out.println("No se ha encontrado la palabra: "+palabra);
		}
		
		return 5;
	}
}

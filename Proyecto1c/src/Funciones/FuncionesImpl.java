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
		//DECLARACIÓN DE 2 FICHEROS VACIOS
		
		f1 = new File("fichero1.txt");
		f2 = new File("fichero2.txt");
		
		//this.compararContenido(f1, f2);
		this.buscarPalabra(f2, "Hola", true);
	}
	
	
	public boolean compararContenido(File fichero1, File fichero2){
		
		try{
			
			FileReader fr1 = new FileReader(f1);
			FileReader fr2 = new FileReader(f2);
			
			
			BufferedReader bf1 = new BufferedReader(fr1);
			BufferedReader bf2 = new BufferedReader(fr2);
			
			String cadena1, cadena2;
			
			cadena1 = bf1.readLine();
			cadena2 = bf2.readLine();
			
			while ((cadena1!=null) && (cadena2!=null) && iguales==true) {
				//COMPROBAMOS QUE LAS LINEAS NO SON IGUALES
				  if (cadena1.equals(cadena2)==false){
					  	iguales = false;
					  	System.out.println("Ficheros no iguales.");
				  		return false;
				 } 
				  else{
					  System.out.println("Ficheros iguales.");
				  }
				  //SEGUIMOS LEYENDO
				  cadena1=bf1.readLine();
				  cadena2=bf2.readLine();
			}
		}
		catch(IOException error){
			System.err.println("Error al comparar los ficheros.");
		}
		
		return true;
	}
	
	public int buscarPalabra(File fichero, String palabra, boolean boleano){
		
		try{
			FileReader fr1 = new FileReader(f1);
			BufferedReader bf1 = new BufferedReader(fr1);
			
			String linea = bf1.readLine();
			
			while(linea!=null){
	            System.out.println(linea);
	            
	            if(linea.equals(palabra)==true){
	            	System.out.println(linea+" - Palabra encontrada.");
	            	break;
	            }
	            linea = bf1.readLine();
			}
		}
		catch(IOException error){
			System.err.println("Error al encontrar la palabra");
		}
		
		return 5;
	}
}

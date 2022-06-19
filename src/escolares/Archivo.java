package escolares;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class Archivo {

	private LinkedList<Integer> datosDeAlumnosArray = new LinkedList<Integer>();
    private LinkedList<Integer> datosFilaDeAlumnosCompleta;
    Alumno escolares; 
	
	public void LeerArchivo() {
	
		FileReader archivoEscolares = null;
		BufferedReader archivoEscolaresCompleto = null;
		
		try {
			
		File archivo = new File("escolar.in");
	    archivoEscolares = new FileReader(archivo);
		archivoEscolaresCompleto = new BufferedReader(archivoEscolares);
		
		String lineaDeArchivo = archivoEscolaresCompleto.readLine();

		while(lineaDeArchivo != null) {
		  Integer datosAlumnos;
		  
		  datosAlumnos = Integer.parseInt(lineaDeArchivo);
		  datosDeAlumnosArray.add(datosAlumnos);
		  
		  lineaDeArchivo = archivoEscolaresCompleto.readLine();

		}
		 escolares = new Alumno(datosDeAlumnosArray);
		 
		}catch(IOException ex) {
			   System.out.println(ex.getMessage());
		} catch(NumberFormatException ex) {
			   System.out.println(ex.getMessage() + " Hay un elemento en blanco");
		} finally {
			try {
				archivoEscolaresCompleto.close();
			} catch (IOException e) {
			    System.out.println(e.getMessage());
			} catch(NullPointerException ex) {
				System.out.println(ex.getMessage() + " no se encontro datos en el archivo");
			}
		}
	}
	
	public void EscribirArchivo() {

		File file = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		int contador = 0;
		FilaAlumno datosFila = new FilaAlumno(); 
		
		try {
			try {
				 this.datosFilaDeAlumnosCompleta =  datosFila.getDatosFilaDeAlumnosCompleta();
				 
			}catch(NullPointerException ex) {
				System.out.println(ex.getLocalizedMessage() + " los datos no se pueden leer, porque hubo una falla en la carga de datos");
				System.exit(0);
			}
			
			file = new File("escolar.out");
			fw = new FileWriter(file);
			pw = new PrintWriter(fw);
			
			ListIterator<Integer> iterador = datosFilaDeAlumnosCompleta.listIterator();
			
			while(iterador.hasNext()) {		
				    pw.print(iterador.next());
				    pw.println();
				    contador++;
				    
				  if(contador == 2) {
		    	    pw.print(iterador.next());
		    	    pw.print(" ");
		    	    pw.print(FilaAlumno.getPosicionFilaDeAlumnoMasBajo());
		    	    pw.println();
			    }
			}
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
			
		} catch(NoSuchElementException ex) {
			System.out.println(ex.getMessage() + " elementos vacios");
		} finally {
			try {
				if(pw != null) {
					pw.close();
				}
			}catch(Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}

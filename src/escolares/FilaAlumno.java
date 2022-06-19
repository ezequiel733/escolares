package escolares;

import java.util.LinkedList;


public class FilaAlumno {

  private int alumnoMasAlto = 0, alumnoMasbajo = 0, mayorDiferenciaEntreAlumnosMAsAltoConsecutivos, promedioAlturas;
  private static int posicionFilaDeAlumnoMasBajo;
  protected LinkedList<Integer> datosFilaDeAlumnosCompleta = new LinkedList<Integer>();
  private Alumno alumno = new Alumno();
  
  public FilaAlumno() {
	  this.setCalcularAlumnoMasAlto();
	  this.setCalcularAlumnoMasBajo();
	  this.setCalcularMayorDiferenciaEntreAlumnosMAsAltoConsecutivos();
	  this.setCalcularPromedioAlturas();
  }
  
  public void setCalcularAlumnoMasAlto(){
	  
	  try {
		  
		  boolean verificarDatosAlturaCorrecta =  this.verificarDatosAlturaCorrecta();
		 
		  for(int i = 0; i < alumno.getObtenerCantidadDeAlumno(); i++) {
			  if(verificarDatosAlturaCorrecta == true) {
			   if(alumno.getObtenerCantidadDeAlumno() >= 2 && alumno.getObtenerCantidadDeAlumno() <= 1000) { 
			         if(this.getAlumnoMasAlto() < alumno.getAlumnoEspecifico(i)) {
				        this.setAlumnoMasAlto(alumno.getAlumnoEspecifico(i));
			         }
			} else {
				 System.out.println("la cantidad de alumnos ingresados sobrepasa los limite");
			     System.exit(0);
			}
		  }  else {
			     System.out.println("no se podra ejecutar el programa, porque los datos superan la altura especificada ");
			     System.exit(0);
		  }
		}
		  
		  this.datosFilaDeAlumnosCompleta.add(this.getAlumnoMasAlto());
		  
	  }catch(ArrayIndexOutOfBoundsException ex) {
		  System.out.println(ex.getMessage());
		  System.exit(0);
	  }
  }
  
  public void setCalcularAlumnoMasBajo() {
	  try {
	  this.setAlumnoMasBajo(alumno.getAlumnoEspecifico(1));
	 
	  for(int i = 0; i < alumno.getObtenerCantidadDeAlumno(); i++) {
		  if(this.getValidarCero(i) == false) {
		  if(this.getAlumnoMasbajo() > alumno.getAlumnoEspecifico(i)) {
			  this.setAlumnoMasBajo(alumno.getAlumnoEspecifico(i));
			  this.setPosicionFilaDeAlumnoMasBajo(i+1);
		  }
		}
	  }
	    this.datosFilaDeAlumnosCompleta.add(this.getAlumnoMasbajo());
	  }catch(IndexOutOfBoundsException ex) {
		  System.out.println(ex.getMessage());
	  }
  }
  
  public void setCalcularMayorDiferenciaEntreAlumnosMAsAltoConsecutivos() {
	  
	  Integer diferenciaMasgrande = 0;
	  
	  try {
		  
	  if( alumno.getAlumnoEspecifico(0) >= alumno.getAlumnoEspecifico(1)) 
	     diferenciaMasgrande = alumno.getAlumnoEspecifico(0) - alumno.getAlumnoEspecifico(1);
	  else
		  diferenciaMasgrande = alumno.getAlumnoEspecifico(1) - alumno.getAlumnoEspecifico(0);
	  
	  for(int i = 2; i < alumno.getObtenerCantidadDeAlumno()-1; i++) {
		  if(alumno.getAlumnoEspecifico(i) >= alumno.getAlumnoEspecifico(i+1)) {
		     if(diferenciaMasgrande < alumno.getAlumnoEspecifico(i) - alumno.getAlumnoEspecifico(i+1))
			     diferenciaMasgrande = alumno.getAlumnoEspecifico(i) - alumno.getAlumnoEspecifico(i+1);
		  } else {
			     if(diferenciaMasgrande < alumno.getAlumnoEspecifico(i+1) - alumno.getAlumnoEspecifico(i))
				    diferenciaMasgrande = alumno.getAlumnoEspecifico(i+1) - alumno.getAlumnoEspecifico(i);
		  }
	  }
	   this.datosFilaDeAlumnosCompleta.add(diferenciaMasgrande);
	} catch(IndexOutOfBoundsException ex) {
		System.out.println(ex.getMessage() + " no hay elementos");
	}
  }
  
  public void setCalcularPromedioAlturas() {

	  Integer valorTotalDeAlumnos = 0, resultado = 0, cantidadAlumnos = alumno.getObtenerCantidadDeAlumno();
	  
	  try {
	  for(int i = 0; i < alumno.getObtenerCantidadDeAlumno(); i++) {
		  valorTotalDeAlumnos += alumno.getAlumnoEspecifico(i);
	  }
	     resultado =  valorTotalDeAlumnos / cantidadAlumnos;
    	 this.datosFilaDeAlumnosCompleta.add(resultado);
    	 
	 } catch(ArithmeticException ex){
		 System.out.println(ex.getMessage());
	 }
  }
  
  public boolean verificarDatosAlturaCorrecta() {
	  
	  boolean datoValidado = true;
	  this.datosFilaDeAlumnosCompleta.add(alumno.getObtenerCantidadDeAlumno());	  
	  
	  for(int i = 0; i < alumno.getObtenerCantidadDeAlumno(); i++) {
	      if(i < alumno.getObtenerCantidadDeAlumno() -1) {
	    	  if(this.getValidarCero(i) == false) {
	    		  if(alumno.getAlumnoEspecifico(i) >= 60 && alumno.getAlumnoEspecifico(i) <= 200)
	    			  datoValidado = true;
	    		  else return false;
	    	  } else return false;
	      }   
	  }
	  return datoValidado;
  }
  
public boolean getValidarCero(Integer alumno) {
	boolean alumnoValidado = false;
	
	if(this.alumno.getAlumnoEspecifico(alumno) == 0)
		return true;
	
	return alumnoValidado;
}

@Override
public String toString() {
	return "Alumnos [alumnoMasAlto=" + alumnoMasAlto + ", alumnoMasbajo=" + alumnoMasbajo
			+ ", posicionFilaDeAlumnoMasBajo=" + posicionFilaDeAlumnoMasBajo
			+ ", mayorDiferenciaEntreAlumnosMAsAltoConsecutivos=" + mayorDiferenciaEntreAlumnosMAsAltoConsecutivos
			+ ", promedioAlturas=" + promedioAlturas + "]";
}

LinkedList<Integer> getDatosFilaDeAlumnosCompleta() {
	return datosFilaDeAlumnosCompleta;
}

public void setDatosFilaDeAlumnosCompleta(LinkedList<Integer> datosFilaDeAlumnosCompleta) {
	this.datosFilaDeAlumnosCompleta = datosFilaDeAlumnosCompleta;
}

public int getAlumnoMasAlto() {
	return alumnoMasAlto;
}

public void setAlumnoMasAlto(int alumnoMasAlto) {
	this.alumnoMasAlto = alumnoMasAlto;
}

public int getAlumnoMasbajo() {
	return alumnoMasbajo;
}

public void setAlumnoMasBajo(int alumnoMasbajo) {
	this.alumnoMasbajo = alumnoMasbajo;
}

public static int getPosicionFilaDeAlumnoMasBajo() {
	return posicionFilaDeAlumnoMasBajo;
}

public void setPosicionFilaDeAlumnoMasBajo(int posicionFilaDeAlumnoMasBajo) {
	FilaAlumno.posicionFilaDeAlumnoMasBajo = posicionFilaDeAlumnoMasBajo;
}

public int getMayorDiferenciaEntreAlumnosMAsAltoConsecutivos() {
	return mayorDiferenciaEntreAlumnosMAsAltoConsecutivos;
}

public void setMayorDiferenciaEntreAlumnosMAsAltoConsecutivos(int mayorDiferenciaEntreAlumnosMAsAltoConsecutivos) {
	this.mayorDiferenciaEntreAlumnosMAsAltoConsecutivos = mayorDiferenciaEntreAlumnosMAsAltoConsecutivos;
}

public int getPromedioAlturas() {
	return promedioAlturas;
}

public void setPromedioAlturas(int promedioAlturas) {
	this.promedioAlturas = promedioAlturas;
}
	
}

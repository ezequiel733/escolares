package escolares;

import java.util.LinkedList;

public class Alumno {

	private Integer CantidadDeAlumno = null;
	private static LinkedList<Integer> datosDeAlumnosArray = new LinkedList<Integer>();
	
	public Alumno(LinkedList<Integer> datosDeAlumnosArray ) {
		Alumno.datosDeAlumnosArray = datosDeAlumnosArray;
		
	}
	public Alumno() {
		 this.setObtenerCantidadDeAlumno(Alumno.datosDeAlumnosArray.size() -1);
	}
	
	public Integer getAlumnoEspecifico(Integer alumnoABuscar) {
		return datosDeAlumnosArray.get(alumnoABuscar);
	}
	
	public Integer getObtenerCantidadDeAlumno() {
		return this.CantidadDeAlumno;
	}
	
	public void setObtenerCantidadDeAlumno(Integer cantidadAlumnos) {
		this.CantidadDeAlumno = cantidadAlumnos;
	}
}

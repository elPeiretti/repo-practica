package isi.died.parcial01.ejercicio02.app;

public class MateriaConCupoLlenoException extends Exception {
	public MateriaConCupoLlenoException() {
		System.out.println("LA MATERIA EN LA QUE SE QUIERE AGREGAR UNA INSCRIPCION NO LE QUEDAN CUPOS");
	}
}

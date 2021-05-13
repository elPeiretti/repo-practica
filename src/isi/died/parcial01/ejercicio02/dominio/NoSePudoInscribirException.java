package isi.died.parcial01.ejercicio02.dominio;

public class NoSePudoInscribirException extends Exception{
	public NoSePudoInscribirException(Exception e){
		super("Error al inscribir el alumno por problema en la BD. "+e.getMessage());
	}
}

package isi.died.parcial01.ejercicio1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Empleado {
	protected Integer CUIL;
	protected String nombre;
	protected String apellido;
	protected LocalDate fechaIngreso;
	protected Double sueldoBasico;
	
	public abstract Double calcularSueldo();
	public boolean esElAniversario() {
		return ChronoUnit.DAYS.between(this.fechaIngreso,LocalDate.now())%365 == 0;
	}
}

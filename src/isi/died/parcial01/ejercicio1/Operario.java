package isi.died.parcial01.ejercicio1;


import java.util.List;
import java.util.stream.Collectors;

public class Operario extends Empleado{
	private List<Viajante> viajantesAtendidos;
	
	
	public Double calcularSueldo() {
		Double bonus=1d;
		
		if(this.esElAniversario()) bonus=1.5;// si es el aniversario
		
		return this.sueldoBasico*bonus + 0.05*this.calcularVentasDeViajantesAtendidos(); 
	}
	
	public Double calcularVentasDeViajantesAtendidos() {
		return this.viajantesAtendidos.stream().map(v->v.calcularVentas()).collect(Collectors.summingDouble(Double::doubleValue));
	}
}

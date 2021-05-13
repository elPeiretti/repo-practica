package isi.died.parcial01.ejercicio1;


import java.util.List;
import java.util.stream.Collectors;

public class Viajante extends Empleado {
	
	private List<Gasto> listaDeGastos;
	private List<Venta> listaDeVentas;
	
	public Double calcularSueldo() {
		Double bonus=1d;
		
		if(this.esElAniversario()) bonus=1.5;// si es el aniversario
		
		return this.sueldoBasico*bonus + this.calcularGastos() + this.calcularVentas()*0.15;
	}
	
	public Double calcularGastos() {
		return this.listaDeGastos.stream().map(g->g.getValorTotal()).collect(Collectors.summingDouble(Double::doubleValue));
	}
	public Double calcularVentas(){
		return this.listaDeVentas.stream().map(v->v.getValorTotal()).collect(Collectors.summingDouble(Double::doubleValue));
	}
}

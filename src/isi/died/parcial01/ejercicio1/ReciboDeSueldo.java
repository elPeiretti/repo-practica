package isi.died.parcial01.ejercicio1;

public class ReciboDeSueldo {
	
	private Integer numero;
	private Integer mes;
	private Double valorTotal;
	private Empleado empleado;
	
	public ReciboDeSueldo(Integer n, Integer mes, Empleado e) {
		this.numero = n;
		this.mes=mes;
		this.empleado=e;
		this.valorTotal=e.calcularSueldo();
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}

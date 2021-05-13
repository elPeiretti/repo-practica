package isi.died.parcial01.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class TestUnitario {

	public static void main(String[] args) {
		
	
		Empleado e1 = new Operario();
		e1.setSueldoBasico(3000d);
		
		ReciboDeSueldo r1 = new ReciboDeSueldo(1,2,e1);
		
		RRHH rrhh=new RRHH();
		List<Empleado> lista = new ArrayList<Empleado>();
		lista.add(e1);
		
		List<ReciboDeSueldo> listaRecibos= rrhh.getRecibosDeSueldos(lista);
	}
	
}

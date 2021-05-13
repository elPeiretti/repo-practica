package isi.died.parcial01.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class RRHH {
	
	private List<ReciboDeSueldo> recibosDeSueldo;
	
	public List<ReciboDeSueldo> getRecibosDeSueldos(List<Empleado> empleados){
		List<ReciboDeSueldo> res = new ArrayList<ReciboDeSueldo>();
		
		for(Empleado e: empleados) {
			for(ReciboDeSueldo r: recibosDeSueldo) {
				if(e.equals(r.getEmpleado())) res.add(r);
			}
		}
		return res;
	}
}

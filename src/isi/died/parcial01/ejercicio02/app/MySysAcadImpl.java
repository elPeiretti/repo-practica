package isi.died.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import isi.died.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died.parcial01.ejercicio02.dominio.Inscripcion.Estado;
import isi.died.parcial01.ejercicio02.dominio.*;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) throws NoSePudoInscribirException, MateriaConCupoLlenoException {
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		
		
		
		if(m.getCupoRestante()==0) throw new MateriaConCupoLlenoException();
		m.addInscripcion(insc);
		d.agregarInscripcion(insc);
		a.addCursada(insc);
		
		
		// DESCOMENTAR Y gestionar excepcion
		try {
			DB.guardar(insc);
		} catch (BaseDeDatosExcepcion e) {
			d.getInscriptos().remove(insc);
			a.getMateriasCursadas().remove(insc);
			m.getInscripciones().remove(insc);
			throw new NoSePudoInscribirException(e);
		}
		
		
		
		
		
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(e);
	}
	
	
	public void registrarNota(Examen e,Integer nota) {
		e.setNota(nota);
		if(nota>5) {
			List<Inscripcion> cursadas = e.getAlumno().getCursadas();
			cursadas = cursadas.stream().filter(m -> m.getMateria().equals(e.getMateria())).collect(Collectors.toList());
			// se setea promocionado en la ultima inscripcion
			cursadas.get(cursadas.size()-1).setEstado(Estado.PROMOCIONADO);
					
		}
	}


	@Override
	public Double promedioAprobados(Materia m) {
		List<Examen> aprobados = m.getExamenes().stream().filter(e -> e.getNota()>5).collect(Collectors.toList());
		return (double) aprobados.stream()
						.map(e -> e.getNota())
						.collect(Collectors.summingInt(Integer::intValue)) / (double) aprobados.size();
	}

	
	public List<Alumno> inscriptos(Materia m, Integer ciclo){
		return m.getInscripciones().stream()
							.map(t -> t.getInscripto())
							.sorted((a,b) -> a.getNombre().compareTo(b.getNombre()))
							.collect(Collectors.toList());
	}
	
}

package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Curso;
@Service
public class CursosServiceImpl implements CursosService {
	private static List<Curso> cursos=new ArrayList<>(List.of(new Curso("Java 21","ProgramaciÃ³n",100,200),
			new Curso("InglÃ©s","Idiomas",200,340),
			new Curso("FrancÃ©s","Idiomas",150,320),
			new Curso("Python","ProgramaciÃ³n",60,110)
			));
	@Override
	public boolean alta(Curso curso) {
		if(buscarCurso(curso.getNombre())==null) {
			cursos.add(curso);
			return true;
		}
		return false;
		
	}
	@Override
	public void eliminar(String nombre) {

		cursos.removeIf(c->c.getNombre().equals(nombre));
	}
	@Override
	public void modificarDatos(Curso curso) {
		for(Curso c:cursos) {
			if(c.getNombre().equals(curso.getNombre())) {
				c.setArea(curso.getArea());
				c.setDuracion(curso.getDuracion());
				c.setPrecio(curso.getPrecio());
				break;// salimos del bucle for, ya que no necesitamos que se recorre mÃ¡s. ya hemos encontrado el curso y modicado.
			}
		}
	}

	@Override
	public Curso buscarCurso(String nombre) {
		return 
				cursos.stream().
				filter(c->c.getNombre().equals(nombre))
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Curso> devuelveCursos() {		
		return cursos;
	} 
}


 
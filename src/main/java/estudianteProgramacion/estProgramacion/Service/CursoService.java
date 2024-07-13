package estudianteProgramacion.estProgramacion.Service;

import estudianteProgramacion.estProgramacion.Model.Curso;
import estudianteProgramacion.estProgramacion.Model.Tema;
import estudianteProgramacion.estProgramacion.Repository.ICursoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private ICursoRepository cursoRepo;

    @Override
    public void crearCuros(Curso curso) {
        cursoRepo.save(curso);
    }

    @Override
    public List<Curso> mostrarCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public Curso buscarCurso(Long idCurso) {
        Curso curso = cursoRepo.findById(idCurso).orElse(null);
        return curso;
    }

    @Override
    public void editarCurso(Long id_actual, Long idNueva, String nombreNuevo, String modalidadNueva, String fechaNueva) {
        Curso curso = this.buscarCurso(id_actual);

        curso.setId_curso(idNueva);
        curso.setNombre(nombreNuevo);
        curso.setModalidad(modalidadNueva);
        curso.setFecha_finalizacion(fechaNueva);

        this.crearCuros(curso);
    }

    @Override
    public List<Tema> mostrarTemasCurso(Long idCurso) {
        Curso curso = this.buscarCurso(idCurso);

        List<Tema> listaTemas = curso.getListaDeTemas();

        return listaTemas;
    }

    @Override
    public List<Curso> cursosJava() {
        List<Curso> listaDeCursos = this.mostrarCursos();
        List<Curso> listaDeCursosJava = new ArrayList<Curso>();

        for (Curso curso : listaDeCursos) {
            if (curso.getNombre().contains("Java")) {
                listaDeCursosJava.add(curso);
            }
        }
        return listaDeCursosJava;
    }

    @Override
    public void editarCurso(Curso curso) {
        this.crearCuros(curso);
    }

}

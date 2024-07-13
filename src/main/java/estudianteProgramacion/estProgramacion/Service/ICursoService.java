package estudianteProgramacion.estProgramacion.Service;

import estudianteProgramacion.estProgramacion.Model.Curso;
import estudianteProgramacion.estProgramacion.Model.Tema;
import java.util.List;

public interface ICursoService {

    public void crearCuros(Curso curso);

    public List<Curso> mostrarCursos();

    public Curso buscarCurso(Long idCurso);

    public void editarCurso(Long id_actual, Long idNueva, String nombreNuevo, String modalidadNueva, String fechaNueva);

    public List<Tema> mostrarTemasCurso(Long idCurso);

    public List<Curso> cursosJava();

    public void editarCurso(Curso curso);

}

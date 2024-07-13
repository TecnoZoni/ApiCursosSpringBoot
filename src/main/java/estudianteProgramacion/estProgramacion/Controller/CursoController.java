package estudianteProgramacion.estProgramacion.Controller;

import estudianteProgramacion.estProgramacion.Model.Curso;
import estudianteProgramacion.estProgramacion.Model.Tema;
import estudianteProgramacion.estProgramacion.Service.ICursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {

    @Autowired
    private ICursoService cursoService;

    @PostMapping("/curso/crear")
    public ResponseEntity<String> crearCurso(@RequestBody Curso curso) {
        try {
            cursoService.crearCuros(curso);
            return new ResponseEntity<>("El Curso se creo Correctamente ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No pudo crearse el Curso " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/curso/traer")
    public List<Curso> crearCurso() {
        return cursoService.mostrarCursos();
    }

    @GetMapping("/curso/traer/{id}")
    public List<Tema> temasCurso(@PathVariable Long id) {
        return cursoService.mostrarTemasCurso(id);
    }

    @PutMapping("/curso/editar/{id_actual}")
    public void editarCurso(@PathVariable Long id_actual,
            @RequestParam(required = false, name = "idNueva") Long idNueva,
            @RequestParam(required = false, name = "nombreNuevo") String nombreNuevo,
            @RequestParam(required = false, name = "modalidadNueva") String modalidadNueva,
            @RequestParam(required = false, name = "fechaNueva") String fechaNueva) {

        cursoService.editarCurso(id_actual, idNueva, nombreNuevo, modalidadNueva, fechaNueva);
    }
    
    @PutMapping("/curso/editar")
    public void editarCurso(@RequestBody Curso curso) {
        
        cursoService.editarCurso(curso);
    }
    
    @GetMapping("/curso/traer/java")
    public List<Curso> cursosJava() {
        return cursoService.cursosJava();
    }

}

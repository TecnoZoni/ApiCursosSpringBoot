package estudianteProgramacion.estProgramacion.Controller;

import estudianteProgramacion.estProgramacion.Model.Tema;
import estudianteProgramacion.estProgramacion.Service.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {

    @Autowired
    private ITemaService temaService;

    @PostMapping("tema/crear")
    public ResponseEntity<String> temaCrear(@RequestBody Tema tema) {
        try {
            temaService.crearTema(tema);
            return new ResponseEntity<>("El tema se creo Correctamente ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No pudo crearse el Tema " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("tema/editar/{id_actual}")
    public ResponseEntity<String> temaEditar(@PathVariable Long id_actual,
            @RequestParam(required = false, name = "idNueva") Long idNueva,
            @RequestParam(required = false, name = "nombreNuevo") String nombreNuevo,
            @RequestParam(required = false, name = "descripcionNueva") String descripcionNueva) {

        try {
            temaService.editarTema(id_actual, idNueva, nombreNuevo, nombreNuevo);
            return new ResponseEntity<>("El tema se edito Correctamente ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No pudo editarse el Tema " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

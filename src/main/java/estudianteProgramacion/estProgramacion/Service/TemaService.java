package estudianteProgramacion.estProgramacion.Service;

import estudianteProgramacion.estProgramacion.Model.Tema;
import estudianteProgramacion.estProgramacion.Repository.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService {

    @Autowired
    private ITemaRepository temaRepo;

    @Override
    public void crearTema(Tema tema) {
        temaRepo.save(tema);
    }

    @Override
    public Tema buscarTema(Long idTema) {
        Tema tema = temaRepo.findById(idTema).orElse(null);
        return tema;
    }

    @Override
    public void editarTema(Long id_actual, Long idNueva, String nombreNuevo, String descripcionNueva) {
        Tema tema = this.buscarTema(id_actual);

        tema.setId_tema(idNueva);
        tema.setNombre(nombreNuevo);
        tema.setDescripcion(descripcionNueva);

        this.crearTema(tema);
    }

}

package estudianteProgramacion.estProgramacion.Service;

import estudianteProgramacion.estProgramacion.Model.Tema;

public interface ITemaService {

    public void crearTema(Tema tema);

    public Tema buscarTema(Long idTema);

    public void editarTema(Long id_actual, Long idNueva, String nombreNuevo, String descripcionNueva);

}

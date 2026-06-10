package cl.duoc.tutorias_service.service;

import cl.duoc.tutorias_service.clients.AsignaturaClient;
import cl.duoc.tutorias_service.clients.DocenteClient;
import cl.duoc.tutorias_service.clients.EstudianteClient;
import cl.duoc.tutorias_service.dto.AsignaturaDTO;
import cl.duoc.tutorias_service.dto.DocenteDTO;
import cl.duoc.tutorias_service.dto.EstudianteDTO;
import cl.duoc.tutorias_service.dto.TutoriaDTO;
import cl.duoc.tutorias_service.exception.NotFoundException;
import cl.duoc.tutorias_service.mapper.TutoriaMapper;
import cl.duoc.tutorias_service.model.Tutoria;
import cl.duoc.tutorias_service.repository.TutoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutoriaService {

    @Autowired
    private TutoriaRepository tutoriaRepository;

    @Autowired
    private TutoriaMapper tutoriaMapper;

    @Autowired
    private EstudianteClient estudianteClient;

    @Autowired
    private DocenteClient docenteClient;

    @Autowired
    private AsignaturaClient asignaturaClient;

    public List<TutoriaDTO> listarTodos() {
        List<Tutoria> tutorias = tutoriaRepository.findAll();
        return tutorias.stream()
                .map(tutoria -> {
                    TutoriaDTO tutoriaDTO = tutoriaMapper.toDTO(tutoria);

                    EstudianteDTO estudianteDTO = estudianteClient.buscarEstudiantePorId(tutoria.getEstudiante());
                    DocenteDTO docenteDTO = docenteClient.buscarDocentePorId(tutoria.getDocente());
                    AsignaturaDTO asignaturaDTO = asignaturaClient.buscarAsignaturaPorId(tutoria.getAsignatura());

                    tutoriaDTO.setEstudiante(estudianteDTO.getNombre());
                    tutoriaDTO.setDocente(docenteDTO.getNombre());
                    tutoriaDTO.setAsignatura(asignaturaDTO.getNombre());

                    return tutoriaDTO;
                })
                .toList();
    }

    // Guardar o actualizar un tutoria
    public TutoriaDTO guardar(Tutoria tutoria) {
        return tutoriaMapper.toDTO(tutoriaRepository.save(tutoria));
    }

    // Buscar un tutoria por su ID
    public TutoriaDTO buscarPorId(Long id) {
        Tutoria tutoria = tutoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tutoria no encontrado"));

        EstudianteDTO estudianteDTO = estudianteClient.buscarEstudiantePorId(tutoria.getEstudiante());
        DocenteDTO docenteDTO = docenteClient.buscarDocentePorId(tutoria.getDocente());
        AsignaturaDTO asignaturaDTO = asignaturaClient.buscarAsignaturaPorId(tutoria.getAsignatura());

        TutoriaDTO tutoriaDTO = tutoriaMapper.toDTO(tutoria);
        tutoriaDTO.setEstudiante(estudianteDTO.getNombre());
        tutoriaDTO.setDocente(docenteDTO.getNombre());
        tutoriaDTO.setAsignatura(asignaturaDTO.getNombre());

        return tutoriaDTO;
    }

    // Eliminar un tutoria por su ID
    public void eliminar(Long id) {
        tutoriaRepository.deleteById(id);
    }

}

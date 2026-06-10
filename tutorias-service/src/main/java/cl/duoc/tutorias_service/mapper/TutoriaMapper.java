package cl.duoc.tutorias_service.mapper;

import cl.duoc.tutorias_service.dto.EstudianteDTO;
import cl.duoc.tutorias_service.dto.TutoriaDTO;
import cl.duoc.tutorias_service.model.Tutoria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TutoriaMapper {
    public TutoriaDTO toDTO(Tutoria tutoria) {
        if (tutoria == null) return null;
        TutoriaDTO tutoriaDTO = new TutoriaDTO();
        tutoriaDTO.setFecha(tutoria.getFecha());
        tutoriaDTO.setHora_inicio(tutoria.getHora());
        tutoriaDTO.setHora_fin(tutoria.getHora().plusMinutes(tutoria.getDuracion()));

        return tutoriaDTO;
    }
}

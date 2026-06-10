package cl.duoc.tutorias_service.clients;

import cl.duoc.tutorias_service.dto.EstudianteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "estudiantes-service", path ="/api/v1/estudiantes")
public interface EstudianteClient {

    @GetMapping("/{id}")
    EstudianteDTO buscarEstudiantePorId(@PathVariable Long id);
}

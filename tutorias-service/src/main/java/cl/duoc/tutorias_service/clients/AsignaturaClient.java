package cl.duoc.tutorias_service.clients;

import cl.duoc.tutorias_service.dto.AsignaturaDTO;
import cl.duoc.tutorias_service.dto.EstudianteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asignaturas-service", path ="/api/v1/asignaturas")
public interface AsignaturaClient {

    @GetMapping("/{id}")
    AsignaturaDTO buscarAsignaturaPorId(@PathVariable Long id);
}

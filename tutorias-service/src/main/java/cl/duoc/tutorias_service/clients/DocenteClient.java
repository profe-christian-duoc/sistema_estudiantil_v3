package cl.duoc.tutorias_service.clients;

import cl.duoc.tutorias_service.dto.DocenteDTO;
import cl.duoc.tutorias_service.dto.EstudianteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "docentes-service", path ="/api/v1/docentes")
public interface DocenteClient {

    @GetMapping("/{id}")
    DocenteDTO buscarDocentePorId(@PathVariable Long id);
}

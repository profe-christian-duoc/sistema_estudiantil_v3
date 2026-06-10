package cl.duoc.asignaturas_service.service;

import cl.duoc.asignaturas_service.exception.NotFoundException;
import cl.duoc.asignaturas_service.model.Asignatura;
import cl.duoc.asignaturas_service.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<Asignatura> listarTodos() {
        return asignaturaRepository.findAll();
    }

    // Guardar o actualizar un asignatura
    public Asignatura guardar(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    // Buscar un asignatura por su ID
    public Asignatura buscarPorId(Long id) {
        return asignaturaRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Asignatura no encontrado"));
    }

    // Eliminar un asignatura por su ID
    public void eliminar(Long id) {
        asignaturaRepository.deleteById(id);
    }
}

package cl.duoc.docentes_service.service;

import cl.duoc.docentes_service.exception.NotFoundException;
import cl.duoc.docentes_service.model.Docente;
import cl.duoc.docentes_service.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> listarTodos() {
        return docenteRepository.findAll();
    }

    // Guardar o actualizar un docente
    public Docente guardar(Docente docente) {
        return docenteRepository.save(docente);
    }

    // Buscar un docente por su ID
    public Docente buscarPorId(Long id) {
        return docenteRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Docente no encontrado"));
    }

    // Eliminar un docente por su ID
    public void eliminar(Long id) {
        docenteRepository.deleteById(id);
    }
}

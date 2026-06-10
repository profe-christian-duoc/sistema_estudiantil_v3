package cl.duoc.tutorias_service.controller;

import cl.duoc.tutorias_service.dto.TutoriaDTO;
import cl.duoc.tutorias_service.model.Tutoria;
import cl.duoc.tutorias_service.service.TutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tutorias")
public class TutoriaController {

    @Autowired
    private TutoriaService tutoriaService;

    // 1. Obtener todos los tutorias
    @GetMapping
    public ResponseEntity<List<TutoriaDTO>> listarTodos() {
        List<TutoriaDTO> tutorias = tutoriaService.listarTodos();
        return ResponseEntity.ok(tutorias);
    }

    // 2. Obtener un tutoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<TutoriaDTO> buscarPorId(@PathVariable Long id) {
        TutoriaDTO tutoria = tutoriaService.buscarPorId(id);
        return ResponseEntity.ok(tutoria);
    }

    // 3. Crear un nuevo tutoria
    @PostMapping
    public ResponseEntity<TutoriaDTO> crear(@RequestBody Tutoria tutoria) {
        TutoriaDTO nuevoTutoria = tutoriaService.guardar(tutoria);
        return new ResponseEntity<>(nuevoTutoria, HttpStatus.CREATED);
    }

    // 4. Eliminar un tutoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tutoriaService.buscarPorId(id);
        tutoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}

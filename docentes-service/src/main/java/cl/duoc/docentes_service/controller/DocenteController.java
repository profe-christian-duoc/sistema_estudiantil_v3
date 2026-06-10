package cl.duoc.docentes_service.controller;

import cl.duoc.docentes_service.model.Docente;
import cl.duoc.docentes_service.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    // 1. Obtener todos los docentes
    @GetMapping
    public ResponseEntity<List<Docente>> listarTodos() {
        List<Docente> docentes = docenteService.listarTodos();
        return ResponseEntity.ok(docentes);
    }

    // 2. Obtener un docente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Docente> buscarPorId(@PathVariable Long id) {
        Docente docente = docenteService.buscarPorId(id);
        return ResponseEntity.ok(docente);
    }

    // 3. Crear un nuevo docente
    @PostMapping
    public ResponseEntity<Docente> crear(@RequestBody Docente docente) {
        Docente nuevoDocente = docenteService.guardar(docente);
        return new ResponseEntity<>(nuevoDocente, HttpStatus.CREATED);
    }

    // 4. Eliminar un docente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        docenteService.buscarPorId(id);
        docenteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}

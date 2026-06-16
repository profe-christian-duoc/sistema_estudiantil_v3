package cl.duoc.asignaturas_service.controller;

import cl.duoc.asignaturas_service.model.Asignatura;
import cl.duoc.asignaturas_service.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    public ResponseEntity<List<Asignatura>> listarTodos() {
        List<Asignatura> asignaturas = asignaturaService.listarTodos();
        return ResponseEntity.ok(asignaturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> buscarPorId(@PathVariable Long id) {
        Asignatura asignatura = asignaturaService.buscarPorId(id);
        return ResponseEntity.ok(asignatura);
    }

    @PostMapping
    public ResponseEntity<Asignatura> crear(@RequestBody Asignatura asignatura) {
        Asignatura nuevoAsignatura = asignaturaService.guardar(asignatura);
        return new ResponseEntity<>(nuevoAsignatura, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        asignaturaService.buscarPorId(id);
        asignaturaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}

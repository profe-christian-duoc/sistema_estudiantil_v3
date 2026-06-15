package cl.duoc.asignaturas_service.controller;

import cl.duoc.asignaturas_service.model.Asignatura;
import cl.duoc.asignaturas_service.service.AsignaturaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Asignaturas",
        description = "API para gestionar las asignaturas disponibles en el sistema de tutorías de DUOC"
)
@RestController
@RequestMapping("api/v1/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;


    @Operation(
            summary = "Listar todas las asignaturas",
            description = "Obtiene el listado completo de asignaturas registradas en el sistema de tutorías."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Asignaturas encontradas correctamente")
    })
    @GetMapping
    public ResponseEntity<List<Asignatura>> listarTodos() {
        List<Asignatura> asignaturas = asignaturaService.listarTodos();
        return ResponseEntity.ok(asignaturas);
    }

    @Operation(
            summary = "Buscar asignatura por ID",
            description = "Obtiene una asignatura específica según su identificador único."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Asignatura encontrada correctamente"),
            @ApiResponse(responseCode = "404", description = "Asignatura no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> buscarPorId(
            @Parameter(description = "ID de la asignatura a buscar", example = "1")
            @PathVariable Long id) {
        Asignatura asignatura = asignaturaService.buscarPorId(id);
        return ResponseEntity.ok(asignatura);
    }

    @Operation(
            summary = "Crear una nueva asignatura",
            description = "Registra una nueva asignatura en el sistema de tutorías de DUOC."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Asignatura creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    })
    @PostMapping
    public ResponseEntity<Asignatura> crear(@RequestBody Asignatura asignatura) {
        Asignatura nuevoAsignatura = asignaturaService.guardar(asignatura);
        return new ResponseEntity<>(nuevoAsignatura, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Eliminar una asignatura",
            description = "Elimina una asignatura existente según su identificador único."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Asignatura eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Asignatura no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID de la asignatura a eliminar", example = "1")
            @PathVariable Long id) {
        asignaturaService.buscarPorId(id);
        asignaturaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}

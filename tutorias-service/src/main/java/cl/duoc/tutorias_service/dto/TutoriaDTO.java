package cl.duoc.tutorias_service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutoriaDTO {
    private String asignatura;
    private String estudiante;
    private String docente;
    private LocalDate fecha;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
}

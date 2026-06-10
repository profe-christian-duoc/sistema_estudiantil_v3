package cl.duoc.tutorias_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tutorias")
public class Tutoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private LocalTime hora;
    private Integer duracion;
    @Column(name = "id_estudiante")
    private Long estudiante;
    @Column(name = "id_docente")
    private Long docente;
    @Column(name = "id_asignatura")
    private Long asignatura;
}

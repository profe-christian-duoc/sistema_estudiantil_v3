CREATE TABLE tutorias
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha      DATE   NOT NULL,
    hora       TIME   NOT NULL,
    duracion   INT    NOT NULL,
    id_estudiante BIGINT NOT NULL,
    id_docente    BIGINT NOT NULL,
    id_asignatura BIGINT NOT NULL
);
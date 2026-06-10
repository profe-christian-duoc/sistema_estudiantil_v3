package cl.duoc.tutorias_service.repository;

import cl.duoc.tutorias_service.model.Tutoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutoriaRepository extends JpaRepository<Tutoria, Long> {

}

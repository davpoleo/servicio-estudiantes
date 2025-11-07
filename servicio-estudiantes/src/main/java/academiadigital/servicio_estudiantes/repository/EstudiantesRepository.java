package academiadigital.servicio_estudiantes.repository;
//Esta es la capa que habla directamente con la base de datos

import academiadigital.servicio_estudiantes.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Bean que indica que esta es la capa de persistencia
public interface EstudiantesRepository extends JpaRepository<Estudiante, Long> {
}

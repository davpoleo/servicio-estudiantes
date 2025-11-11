package academiadigital.servicio_estudiantes.repository;
//Esta es la capa que habla directamente con la base de datos

import academiadigital.servicio_estudiantes.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //Bean que indica que esta es la capa de persistencia
public interface EstudiantesRepository extends JpaRepository<Estudiante, Long>, JpaSpecificationExecutor<Estudiante>  {
    Optional<Estudiante> findByEmail(String email);
}
/*
* Hacer el uso de Interface indica que se esta usando Spring Data JPA, el cual aplica el patron de programacion
* orientada a interfaces.
* La interfaz actua como un contrato que define que operaciones de acceso a la base de datos estan disponibles
* por ejemplo el uso de un (CRUD), no es necesario escribir una implementacion ya el Spring Data JPA lo hace
* de forma automatica
*
* Un Mock es una implementacion simulada de la interfaz
*
* */

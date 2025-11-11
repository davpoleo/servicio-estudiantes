package academiadigital.servicio_estudiantes.service;
//Esta es la capa que tiene la logica de negocio
//El servicio actua como el traductor entre el controlador (API) y el repositorio (DDBB)

import academiadigital.servicio_estudiantes.dto.EstudianteRequestDto;
import academiadigital.servicio_estudiantes.dto.EstudianteResponseDto;
import academiadigital.servicio_estudiantes.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstudianteService {
    //CREAR ESTUDIANTE
    EstudianteResponseDto crearEstudiante(EstudianteRequestDto request);

    //ACTUALIZAR ESTUDIANTE
    EstudianteResponseDto actualizarEstudiante(Long id, EstudianteRequestDto request);

    //ELIMINAR ESTUDIANTE
    void eliminarEstudiante(Long id);

    //OBTENER ESTUDIANTE POR ID
    Estudiante obtenerEstudiantePorId(Long id);

    //OBTENER TODOS LOS ESTUDIANTES
    List<EstudianteResponseDto> obtenerTodosLosEstudiantes();
}
/*
* Los Objetos Request y Response en la definicion del Service implican el uso del patron de diseño  de
* de aplicaciones (Data Transfer Object - DTO)
*
* Cuando un usuario envia una peticion HTTP a la API, el CONTROLLER recibe los datos Json del cuerpo, se
* convierte esos datos directamente a un objeto EstudianteResponseDto, el CONTROLLER llama al servicio de
* estudiante y le pasa ese request como argumento
* */

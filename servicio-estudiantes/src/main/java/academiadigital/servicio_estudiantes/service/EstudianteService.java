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

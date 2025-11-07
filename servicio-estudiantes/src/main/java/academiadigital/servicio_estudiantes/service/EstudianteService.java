package academiadigital.servicio_estudiantes.service;
//Esta es la capa que tiene la logica de negocio
//El servicio actua como el traductor entre el controlador (API) y el repositorio (DDBB)

import academiadigital.servicio_estudiantes.dto.EstudianteDto;
import academiadigital.servicio_estudiantes.exception.RecursoNoEncontradoException;
import academiadigital.servicio_estudiantes.model.Estudiante;
import academiadigital.servicio_estudiantes.repository.EstudiantesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor // Para que Lombok Creeel contructor para inyectar automaticamente el repository
public class EstudianteService {
    //Inyeccion de Dependencia del repositorio (Conexion a la BBDD)
    private final EstudiantesRepository estudiantesRepository;

    // constructor porque si no le da ansiedad a la inyeccion de dependencia y da error...
    public EstudianteService(EstudiantesRepository estudiantesRepository) {
        this.estudiantesRepository = estudiantesRepository;
    }

    //Metodo para crear un Estudiante
    public EstudianteDto crearEstudiante(Estudiante estudiante){
        estudiante.setFechaCreacion(LocalDateTime.now());
        Estudiante nuevoEstudiante = estudiantesRepository.save(estudiante);
        return mapearADto(nuevoEstudiante);
    }

    //Metodo para obtener un Estudiante por ID
    public EstudianteDto obtenerPorId(Long id){
        Estudiante estudiante = estudiantesRepository.findById(id)
                .orElseThrow(()-> new RecursoNoEncontradoException("Estudiante no encontrado con ID: " + id));
        return mapearADto(estudiante);
    }

    //Metodo para obtener todos los estudiantes
    public List<EstudianteDto> obtenerTodos(){
        return estudiantesRepository.findAll().stream()
                .map(this::mapearADto)
                .collect(Collectors.toList());
    }

    //Conversion de Model a DTO
    private EstudianteDto mapearADto(Estudiante estudiante){
        EstudianteDto dto = new EstudianteDto();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setApellido(estudiante.getApellido());
        dto.setEmail(estudiante.getEmail());
        dto.setFechaCreacion(estudiante.getFechaCreacion());
        return dto;
    }


}

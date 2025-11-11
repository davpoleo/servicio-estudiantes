package academiadigital.servicio_estudiantes.mapper;

import academiadigital.servicio_estudiantes.dto.EstudianteResponseDto;
import academiadigital.servicio_estudiantes.model.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class MapperEstudiante {
    public EstudianteResponseDto mapearAEstudianteDto(Estudiante estudiante){
        return new EstudianteResponseDto(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getEmail()
        );
    }
}

/* *
  //Conversion de Model a DTO viejo dentro del service antes del desacoplamiento
    private EstudianteDto mapearADto(Estudiante estudiante){
        EstudianteDto dto = new EstudianteDto();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setApellido(estudiante.getApellido());
        dto.setEmail(estudiante.getEmail());
        dto.setFechaCreacion(estudiante.getFechaCreacion());
        return dto;
* */
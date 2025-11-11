package academiadigital.servicio_estudiantes.dto;

public record EstudianteResponseDto (
        Long id,
        String nombre,
        String apellido,
        String email
){
}

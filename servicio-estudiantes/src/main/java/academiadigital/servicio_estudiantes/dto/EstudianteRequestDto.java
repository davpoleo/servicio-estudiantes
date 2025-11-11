package academiadigital.servicio_estudiantes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EstudianteRequestDto(
        @NotBlank(message = "El nombre es obligatorio.")
        @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 Caracteres")
        String nombre,

        @NotBlank(message = "El apellido es obligatorio.")
        String apellido,

        @NotBlank(message = "El email es obligatorio.")
        @Email(message = "El formato del email es invalido.")
        String email
) {
}

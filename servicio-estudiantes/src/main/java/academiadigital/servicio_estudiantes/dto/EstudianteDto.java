package academiadigital.servicio_estudiantes.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
//DTO de salida: lo que el cliente recibe.
public class EstudianteDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDateTime fechaCreacion;

    //SETTERS Y GETTERS



    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}

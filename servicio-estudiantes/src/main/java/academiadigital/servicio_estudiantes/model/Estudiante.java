package academiadigital.servicio_estudiantes.model;
//Este model mapeara a una tabla en la base de datos

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity //Esta vaina indica que esta clase es una tabla en la BBDD
@Data //Esto se supone que genera Getters y Setters automaticamente por Lombok, hay que revisarlo.
@Table(name = "estudiantes") //Nombre de la tabla con el uso de jakarta
public class Estudiante {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Configura el auto increment
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;
    private LocalDateTime fechaCreacion;

    // SETTERS Y GETTERS QUE QUIZA NO DEBERIAN ESTA AQUI---- PENDIENTE POR MODIFICAR
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
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getEmail() {
        return email;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}

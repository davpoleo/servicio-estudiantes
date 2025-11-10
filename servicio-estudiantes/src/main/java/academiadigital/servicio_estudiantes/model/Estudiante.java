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

/*
* -   La configuracion en produccion de los Yaml tiene que ponerse en validate, en desarrollo se pone en Update
-   En el modelo usar @Data (trae implicito, setter, getter y los args constructors)
    y dejar el @NoArgsConstructor @AllArgsConstructor
-   En el repository usa el JpaEspecification permite hacer consultas dinamicas y hay que estar pendiente
    de la implementacion de la clase repository.
-   Tambien en el service se usa el polimorfismo con el overrride
-   Dto de errorResponseDto en modo record en ves de Class se usan porque son inmutables, una vez se construyen
    no pueden ser modificados (ver como se puede implementar con tu ResourceNotFoundException)
-   GlobalExepctionHandler, cuando se decora la clase con el bean @ControllerAdvice spring toma esta clase como
    orquestador para manejar repsuestas especificas de los otros errores
-   en el Dto de entrada no recibe TimeStamp porque en el codigo yo lo agrego
-   Los Dtos de Response no se decoran
-   (Es importante evaluar que tipo de datos se usan para enviar la relacion de un campo con otro servicio)
-   Mapper = @Component, revisar que es el mapStrcut, esto de seguro lo pusiste en tu clase Service
    Recordar la implementacion del servicio.
-   El metodo save se usa por la ayuda del JPa, @Transactional, esto es para controlar la integridad de los
    datos agrgando todos los datos para ser insertados en la base de datos, si sale bien que haga el commit,
    esto funciona como un begin transaction de SQL donde hace rollback o hace el commit
-   Wrapper?
-   En el controller usar los @Tag y el @Slf4j, hay que ver la parte de la documentacion y los Logs
-   Spring boot starter Test?


* */

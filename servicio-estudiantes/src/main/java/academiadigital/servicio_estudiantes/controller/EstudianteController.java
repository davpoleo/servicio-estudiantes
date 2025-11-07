package academiadigital.servicio_estudiantes.controller;
//Esta es la capa que recibe las peticiones HTTP y usa el servicio.


import academiadigital.servicio_estudiantes.dto.CrearEstudianteDto;
import academiadigital.servicio_estudiantes.dto.EstudianteDto;
import academiadigital.servicio_estudiantes.model.Estudiante;
import academiadigital.servicio_estudiantes.service.EstudianteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estudiantes")
//@RequiredArgsConstructor
public class EstudianteController {
    private final EstudianteService estudianteService;

    //Igual si no pongo el constructor la inyeccion le sigue dando ansiedad.
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //Con el @valid: Spring verifica las anotaciones del DTO (not Blank, email, etc) antes de ejecutar el metodo
    public EstudianteDto crearEstudiante(@RequestBody @Valid CrearEstudianteDto crearDto){

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(crearDto.getNombre());
        estudiante.setApellido(crearDto.getApellido());
        estudiante.setEmail(crearDto.getEmail());

        return estudianteService.crearEstudiante(estudiante);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EstudianteDto obtenerPorId(@PathVariable Long id){
        return estudianteService.obtenerPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EstudianteDto> obtenerTodos(){
        return estudianteService.obtenerTodos();
    }
}

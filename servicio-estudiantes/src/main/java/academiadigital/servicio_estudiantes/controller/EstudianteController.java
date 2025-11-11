package academiadigital.servicio_estudiantes.controller;
//Esta es la capa que recibe las peticiones HTTP y usa el servicio.


import academiadigital.servicio_estudiantes.dto.EstudianteDto;
import academiadigital.servicio_estudiantes.dto.EstudianteRequestDto;
import academiadigital.servicio_estudiantes.dto.EstudianteResponseDto;
import academiadigital.servicio_estudiantes.model.Estudiante;
import academiadigital.servicio_estudiantes.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estudiantes")
public class EstudianteController {
    private final EstudianteService estudianteService;

    //Igual si no pongo el constructor la inyeccion le sigue dando ansiedad.
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    //Con el @valid: Spring verifica las anotaciones del DTO (not Blank, email, etc) antes de ejecutar el metodo
    public ResponseEntity<EstudianteResponseDto> crearEstudiante(@Valid @RequestBody EstudianteRequestDto request){
        EstudianteResponseDto estudianteCreado = estudianteService.crearEstudiante(request);
        //deberia retornar 201 Created con el objetos creado.
        return new ResponseEntity<>(estudianteCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id){
        return ResponseEntity.ok(estudianteService.obtenerEstudiantePorId(id));
    }

    @GetMapping
    public ResponseEntity<List<EstudianteResponseDto>> obtenerTodos(){
        return ResponseEntity.ok(estudianteService.obtenerTodosLosEstudiantes());
    }
}

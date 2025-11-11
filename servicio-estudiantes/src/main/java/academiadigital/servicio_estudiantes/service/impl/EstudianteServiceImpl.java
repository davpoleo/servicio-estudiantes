package academiadigital.servicio_estudiantes.service.impl;

import academiadigital.servicio_estudiantes.dto.EstudianteRequestDto;
import academiadigital.servicio_estudiantes.dto.EstudianteResponseDto;
import academiadigital.servicio_estudiantes.exception.RecursoDuplicadoException;
import academiadigital.servicio_estudiantes.exception.RecursoNoEncontradoException;
import academiadigital.servicio_estudiantes.mapper.MapperEstudiante;
import academiadigital.servicio_estudiantes.model.Estudiante;
import academiadigital.servicio_estudiantes.repository.EstudiantesRepository;
import academiadigital.servicio_estudiantes.service.EstudianteService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudiantesRepository estudiantesRepository;
    private final MapperEstudiante mapperEstudiante;
    //Pendiente que aqui hay que agregar un posible Mapper

    public EstudianteServiceImpl(EstudiantesRepository estudiantesRepository, MapperEstudiante mapperEstudiante) {
        this.estudiantesRepository = estudiantesRepository;
        this.mapperEstudiante = mapperEstudiante;
    }

    @Override
    @Transactional
    public EstudianteResponseDto crearEstudiante(EstudianteRequestDto request) {
        estudiantesRepository.findByEmail(request.email()).ifPresent(Estd->{
            throw new RecursoDuplicadoException("El email '" + request.email() + "' ya esta en uso.");
        });

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(request.nombre());
        estudiante.setApellido(request.apellido());
        estudiante.setEmail(request.email());
        estudiante.setFechaCreacion(LocalDateTime.now());

        //Crea un bojeto estudiante para pasaselo a un mapper, antes lo tenia en el mismo codigo ahora esta en un
        //paquete aparte y una clase mapper desacoplada, la relacion del mapper la hace en a inyeccion mas arriba.
        Estudiante nuevoEstudiante = estudiantesRepository.save(estudiante);

        return mapperEstudiante.mapearAEstudianteDto(nuevoEstudiante);
    }

    @Override
    public EstudianteResponseDto actualizarEstudiante(Long id, EstudianteRequestDto request) {
        Estudiante actualizarEstudiante = obtenerEstudiantePorId(id);

        estudiantesRepository.findByEmail(request.email()).ifPresent(estudianteExistente ->{
            if(estudianteExistente.getId().equals(id)){
                throw new RecursoDuplicadoException("El email '" + request.email() +"' ya esta en uso.");
            }
        });
        actualizarEstudiante.setNombre(request.nombre());
        actualizarEstudiante.setApellido(request.apellido());
        actualizarEstudiante.setEmail(request.email());
        //considerar agregar campo updatedAt en el modelo

        return mapperEstudiante.mapearAEstudianteDto(actualizarEstudiante);
    }

    @Override
    @Transactional
    public void eliminarEstudiante(Long id) {
        Estudiante eliminarEstudiante = obtenerEstudiantePorId(id);
        estudiantesRepository.delete(eliminarEstudiante);
    }

    public Estudiante obtenerEstudiantePorId(Long id) {
        return estudiantesRepository.findById(id)
                .orElseThrow(()-> new RecursoNoEncontradoException("Estudiante no encontrado con id: " + id));
    }

    @Override
    public List<EstudianteResponseDto> obtenerTodosLosEstudiantes() {
        return estudiantesRepository.findAll().stream()
                .map(mapperEstudiante::mapearAEstudianteDto)
                .collect(Collectors.toList());
    }
}

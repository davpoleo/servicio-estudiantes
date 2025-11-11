package academiadigital.servicio_estudiantes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Heredar de RuntimeException permite que el codigo no se rompa, pero que Spring pueda detectarla
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoException extends RuntimeException{
    //Costructor que recibe el mensaje de error
    public RecursoNoEncontradoException(String mensaje){
        super(mensaje);
    }
}

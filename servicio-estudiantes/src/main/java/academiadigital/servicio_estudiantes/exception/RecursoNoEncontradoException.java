package academiadigital.servicio_estudiantes.exception;

//Heredar de RuntimeException permite que el codigo no se rompa, pero que Spring pueda detectarla
public class RecursoNoEncontradoException extends RuntimeException{

    //Costructor que recibe el mensaje de error
    public RecursoNoEncontradoException(String mensaje){
        super(mensaje);
    }
}

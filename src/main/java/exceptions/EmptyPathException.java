package exceptions;

public class EmptyPathException extends RuntimeException{

    public EmptyPathException() {
        super("Аннотация Path не заполнена");
    }
}

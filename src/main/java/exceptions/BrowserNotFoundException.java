package exceptions;

public class BrowserNotFoundException extends RuntimeException{

    public BrowserNotFoundException() {
        super("Браузер не найден");
    }
}

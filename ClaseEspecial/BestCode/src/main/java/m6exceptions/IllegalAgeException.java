package m6exceptions;

public class IllegalAgeException extends RuntimeException {

    public IllegalAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}

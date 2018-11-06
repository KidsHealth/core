package es.uma.health.kids.domain;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class FieldTooLongException extends RuntimeException {

    public FieldTooLongException() {
        super();
    }

    public FieldTooLongException(String message) {
        super(message);
    }

    public FieldTooLongException(String message, Throwable cause) {
        super(message, cause);
    }

    public FieldTooLongException(Throwable cause) {
        super(cause);
    }

    public FieldTooLongException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

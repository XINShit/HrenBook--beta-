package hrenbook.Exceptions;

/**
 * Created by Beta on 7/19/14.
 */
public class UserNotFoundByIdException extends Exception {
    public UserNotFoundByIdException() {
    }

    public UserNotFoundByIdException(String message) {
        super(message);
    }

    public UserNotFoundByIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundByIdException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundByIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

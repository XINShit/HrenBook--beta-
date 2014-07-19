package hrenbook.Exceptions;

/**
 * Created by Beta on 7/19/14.
 */
public class UserExcistingException extends Exception {
    public UserExcistingException() {
    }

    public UserExcistingException(String message) {
        super(message);
    }

    public UserExcistingException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExcistingException(Throwable cause) {
        super(cause);
    }

    public UserExcistingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

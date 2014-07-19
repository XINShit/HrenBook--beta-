package hrenbook.Exceptions;

/**
 * Created by Beta on 7/19/14.
 */
public class WrongPasswordEexception extends Exception {
    public WrongPasswordEexception() {
    }

    public WrongPasswordEexception(String message) {
        super(message);
    }

    public WrongPasswordEexception(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongPasswordEexception(Throwable cause) {
        super(cause);
    }

    public WrongPasswordEexception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

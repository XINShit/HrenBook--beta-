package hrenbook.auth.abstracts;

/**
 * Created by student on 7/17/2014.
 */
public abstract class Loginer {
    public abstract long login(String login, String password) throws IllegalArgumentException;
}

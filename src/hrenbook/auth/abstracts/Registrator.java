package hrenbook.auth.abstracts;

/**
 * Created by student on 7/17/2014.
 */
public abstract class Registrator {
    public abstract void reg(String login,String password,
                             String name,String lastname,Integer age) throws IllegalArgumentException;
}

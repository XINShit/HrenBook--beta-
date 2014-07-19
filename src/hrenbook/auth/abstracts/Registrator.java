package hrenbook.auth.abstracts;

import hrenbook.Exceptions.UserExcistingException;

/**
 * Created by student on 7/17/2014.
 */
public abstract class Registrator {
    public abstract void reg(String login,String password,String email,
                             String name,String lastname,Integer age) throws IllegalArgumentException, UserExcistingException;
}

package hrenbook.interfaces.userprofile;

import hrenbook.Exceptions.UserNotFoundByIdException;

import java.net.URL;

/**
 * Created by Beta on 7/19/14.
 */
public interface getGravatarable {
    String  getGravatar(long id) throws UserNotFoundByIdException;
}

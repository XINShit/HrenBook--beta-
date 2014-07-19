package hrenbook.engine;

import hrenbook.Exceptions.UserNotFoundByIdException;
import hrenbook.interfaces.userprofile.getGravatarable;
import hrenbook.utils.MD5Util;

/**
 * Created by Beta on 7/19/14.
 */
public class UserProfileEngine implements getGravatarable {
    private static final String gravatarURL = "http://www.gravatar.com/avatar/";
    @Override
    public String getGravatar(long id) throws UserNotFoundByIdException {
        //TODO захешировать ссылки на граватары, при выходе удалять из хеша!
        return gravatarURL + MD5Util.md5Hex(hrenbook.DB_GLOBAL.neo4j.
                Utils.getProfileInfos(id).getProperty("email"));
    }
}

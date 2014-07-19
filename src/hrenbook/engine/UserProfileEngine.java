package hrenbook.engine;

import hrenbook.DB_GLOBAL.neo4j.Connection;
import hrenbook.Exceptions.UserNotFoundByIdException;
import hrenbook.interfaces.userprofile.getGravatarable;
import hrenbook.utils.MD5Util;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.util.Iterator;
import java.util.Properties;

/**
 * Created by Beta on 7/19/14.
 */
//TODO все функии должны быть не по id а по ssid

public class UserProfileEngine {
    private static final String gravatarURL = "http://www.gravatar.com/avatar/";

    public static String getGravatar(String ssid) throws UserNotFoundByIdException {

        return gravatarURL + MD5Util.md5Hex(getProfileInfos(ssid).getProperty("email"));
    }
    public static Properties getProfileInfos(String ssid) throws UserNotFoundByIdException{
        Long idFromSSID = MainEngine.getIdFromSSID(ssid);
        Properties p =new Properties();
        GraphDatabaseService graphDB = Connection.getGraphDB();
        try (Transaction tx = graphDB.beginTx()) {
            Node nodeById = graphDB.getNodeById(idFromSSID);
            Iterator<String> iterator = nodeById.getPropertyKeys().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                p.put(key,nodeById.getProperty(key));
            }
        }
        return p;
    }
}

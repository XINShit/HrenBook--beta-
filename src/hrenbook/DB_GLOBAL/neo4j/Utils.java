package hrenbook.DB_GLOBAL.neo4j;

import hrenbook.Exceptions.UserNotFoundByIdException;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.sql.*;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by Beta on 7/19/14.
 */
public class Utils {
    /**
     *
     * @param id пользователя
     * @return информацию о пользователе по id
     */
   public static Properties getProfileInfos(long id) throws UserNotFoundByIdException{
       Properties p =new Properties();
       GraphDatabaseService graphDB = Connection.getGraphDB();
       try (Transaction tx = graphDB.beginTx()) {
           Node nodeById = graphDB.getNodeById(id);
           Iterator<String> iterator = nodeById.getPropertyKeys().iterator();
           while (iterator.hasNext()) {
               String key = iterator.next();
               p.put(key,nodeById.getProperty(key));
           }
       }
       return p;
   }
}

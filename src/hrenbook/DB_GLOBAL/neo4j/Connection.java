package hrenbook.DB_GLOBAL.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 * Created by student on 7/17/2014.
 */
public class Connection {
    private static enum RelTypes implements RelationshipType
    {
        FRIENDS_WITH
    }
    public static void run() {
       graphDB = new GraphDatabaseFactory().newEmbeddedDatabase(Constant.DB_PATH);
    }
    public static GraphDatabaseService getGraphDB(){
        if(graphDB==null) {
            throw new NullPointerException();
        }
        return graphDB;
    }
    private static GraphDatabaseService graphDB = null;
}

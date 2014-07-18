package hrenbook.engine;

import hrenbook.DB_GLOBAL.neo4j.Connection;
import hrenbook.friendship.interafaces.AddToFriendable;
import hrenbook.friendship.interafaces.getMyFriendsable;
import hrenbook.friendship.interafaces.removeFromFriendable;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.util.List;

/**
 * Created by student on 7/18/2014.
 */
public class FriendShipEngine implements AddToFriendable,removeFromFriendable,getMyFriendsable {
    @Override
    public void addToFriend(long id) {

    }

    @Override
    public void removeFromFriend(long id) {

    }

    @Override
    public List<Node> getFriends() {
        long myId = 0;
        GraphDatabaseService graphDB = Connection.getGraphDB();
        try (Transaction tx = graphDB.beginTx()) {

        }
        return null;
    }
}

package hrenbook.friendship.interafaces;

import org.neo4j.graphdb.Node;

import java.util.List;

/**
 * Created by student on 7/18/2014.
 */
public interface getMyFriendsable {
    List<Node> getFriends();
}

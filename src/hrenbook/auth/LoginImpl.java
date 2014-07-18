package hrenbook.auth;

import hrenbook.DB_GLOBAL.neo4j.Connection;
import hrenbook.auth.abstracts.Loginer;
import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;

import java.util.Map;

/**
 * Created by student on 7/17/2014.
 */
public class LoginImpl extends Loginer {

    @Override
    public long login(String login, String password) throws IllegalArgumentException {

        GraphDatabaseService graphDB = Connection.getGraphDB();
        try (Transaction tx = graphDB.beginTx()) {
            String querry = "MATCH (u:User) WHERE login=" + login + " AND password=" + password + " return u";
            System.out.println(querry);
            ExecutionEngine executionEngine = new ExecutionEngine(graphDB);
            ResourceIterator<Map<String, Object>> iterator = executionEngine.execute(querry).iterator();
            if (!iterator.hasNext()) {
                throw new IllegalArgumentException("Wrong login or password!");
            }
            Map<String, Object> next = iterator.next();
            long n = ((Node) next.get("n")).getId();

            tx.success();
            return n;
        }

    }
}

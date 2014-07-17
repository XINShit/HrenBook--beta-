package hrenbook.auth;

import hrenbook.DB_GLOBAL.neo4j;
import hrenbook.auth.abstracts.Registrator;
import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.graphdb.*;

import java.util.Map;

/**
 * Created by student on 7/17/2014.
 */
public class RegistrationImpl extends Registrator {


    @Override
    public void reg(String login, String password, String name, String lastname, Integer age) throws IllegalArgumentException {
        GraphDatabaseService graphDB = neo4j.getGraphDB();
        try (Transaction tx = graphDB.beginTx()) {
            /*String querry = "MATCH (u:User) WHERE login=" + login + " return u";
            System.out.println(querry);
            ExecutionEngine executionEngine = new ExecutionEngine(graphDB);
            ResourceIterator<Map<String, Object>> iterator = executionEngine.execute(querry).iterator();
            if (iterator.hasNext()) {
                throw new IllegalArgumentException("Chose please other login!");
            }*/

            Node user = graphDB.createNode(DynamicLabel.label("User"));
            user.setProperty("login", login);
            user.setProperty("password", password);
            user.setProperty("name", name);
            user.setProperty("lastname", lastname);
            user.setProperty("age", age);
            tx.success();
        }
    }
}

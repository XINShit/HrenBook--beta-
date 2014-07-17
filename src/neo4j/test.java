package neo4j;


import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.util.Map;
import java.util.Random;

public class test {
    final static String DB_PATH = "C:\\Users\\student\\Documents\\Neo4j\\default.graphdb";
    private static enum RelTypes implements RelationshipType
    {
        FRIENDS_WITH
    }
    static Random r = new Random();
    static void generate( GraphDatabaseService graphDB) {
        int lenght = r.nextInt(5)+10;
        StringBuilder stringBuilder = new StringBuilder(lenght);
        for(int i=0; i<lenght;i++) {
            char c = (char) (r.nextInt('z'-'a') + 'a');
            stringBuilder.append(c);
        }
        Node user = graphDB.createNode(DynamicLabel.label("User"));
        user.setProperty("name",stringBuilder.toString());
        user.setProperty("lastname",stringBuilder.reverse().toString());
        user.setProperty("age",r.nextInt(70)+5);

    }

    static void generateLinks(GraphDatabaseService graphDB) {
        String querry = "MATCH (n:User) WHERE n.age > 5  return n;";
        ExecutionEngine executionEngine = new ExecutionEngine(graphDB);
        long l = System.nanoTime();
        ExecutionResult execute = executionEngine.execute(querry);
        System.out.println("time = " + (System.nanoTime()-l)/1000000000.0);
        ResourceIterator<Map<String, Object>> iterator = execute.iterator();
        int i = 0 ;
        while (iterator.hasNext() && i++ < 59) {
            Map<String, Object> next = iterator.next();

            for(Map.Entry<String,Object> j : next.entrySet()) {
                System.out.println(((Node)j.getValue()).getProperty("name") +" "
                        + ((Node)j.getValue()).getProperty("lastname") + " " +
                        ((Node)j.getValue()).getProperty("age"));
            }
        }


    }
    public static void main(String[] args) {
        int size = 100000;
        GraphDatabaseService graphDB = new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH);

        try ( Transaction tx = graphDB.beginTx())
        {
            generateLinks(graphDB);

            System.out.println("!");
            tx.success();
        }

    }
}

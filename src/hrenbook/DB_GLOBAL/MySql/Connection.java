package hrenbook.DB_GLOBAL.MySql;

import org.neo4j.graphdb.GraphDatabaseService;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by student on 7/18/2014.
 */
public class Connection {
   private static java.sql.Connection connection = null;
    public static void run()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Constant.MYSQL_PATH,
                    Constant.login, Constant.password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static java.sql.Connection getConnection(){
        if(connection==null) {
            throw new NullPointerException();
        }
        return connection;
    }
}

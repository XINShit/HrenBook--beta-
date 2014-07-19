package hrenbook.auth;

import hrenbook.DB_GLOBAL.MySql.Constant;
import hrenbook.Exceptions.UserExcistingException;
import hrenbook.auth.abstracts.Registrator;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by student on 7/18/2014.
 */
public class RegistrationImpl2 extends Registrator {

    private void reg_login_and_password(String login, String password, long nodeid) throws UserExcistingException {
        Connection connection = hrenbook.DB_GLOBAL.MySql.Connection.getConnection();
        try {

            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT count(*) AS total FROM users where login = ?");
            //preparedStatement.setString(1, Constant.TABLE_USER_NAME);
            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next() && resultSet.getInt("total")>0) {

                throw new UserExcistingException("User exists!Chose other loggin");
            }


            PreparedStatement preparedStatement1
                    = connection.prepareStatement("INSERT INTO users(login, password, id) " +
                    "VALUES(?,?,?)");
            preparedStatement1.setString(1,login);
            preparedStatement1.setString(2,password);
            preparedStatement1.setLong(3,nodeid);
            if(preparedStatement1.executeUpdate()==0) {
                throw new IllegalArgumentException("Can't connect to DB!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Registr user at neo4j
     * @param name name user
     * @param lastname lastname
     * @param age age
     * @return id NODE
     */
    private long reg_at_neo4j(String name,String lastname,String email,Integer age) {
        GraphDatabaseService graphDB = hrenbook.DB_GLOBAL.neo4j.Connection.getGraphDB();
        Long id = -1l;
        try (Transaction tx = graphDB.beginTx()) {
            Node user = graphDB.createNode(DynamicLabel.label("User"));

            user.setProperty("name", name);
            user.setProperty("lastname", lastname);
            user.setProperty("email", email);
            user.setProperty("age", age);
            id = user.getId();
            tx.success();
        }
        if(id == -1) {
            throw new NullPointerException("can't create profile ant Graph DB!");
        }
        return id;
    }
    @Override
    public void reg(String login, String password,String email, String name, String lastname, Integer age) throws IllegalArgumentException, UserExcistingException {
        System.out.println("Regging at neo4j");
        //Reg at neo4j
        long nodeid = reg_at_neo4j(name,lastname,email,age);
        System.out.println("Regging at mysql");
        //Reg at MYSQL
        reg_login_and_password(login,password,nodeid);

    }
}

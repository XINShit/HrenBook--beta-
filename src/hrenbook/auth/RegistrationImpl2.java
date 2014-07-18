package hrenbook.auth;

import hrenbook.DB_GLOBAL.MySql.Constant;
import hrenbook.auth.abstracts.Registrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by student on 7/18/2014.
 */
public class RegistrationImpl2 extends Registrator {

    private void reg_login_and_password(String login,String password) {
        Connection connection = hrenbook.DB_GLOBAL.MySql.Connection.getConnection();
        try {

            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT count(*) AS total FROM users where login = ?");
            //preparedStatement.setString(1, Constant.TABLE_USER_NAME);
            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next() && resultSet.getInt("total")>0) {

                throw new IllegalArgumentException("User exists!Chose other loggin");
            }


            PreparedStatement preparedStatement1
                    = connection.prepareStatement("INSERT INTO users(login, password, id) " +
                    "VALUES(?,?,?)");
            preparedStatement1.setString(1,login);
            preparedStatement1.setString(2,password);
            preparedStatement1.setInt(3,-1);
            if(preparedStatement1.executeUpdate()==0) {
                throw new IllegalArgumentException("Can't connect to DB!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void reg(String login, String password, String name, String lastname, Integer age) throws IllegalArgumentException {
        //Reg at MYSQL
        reg_login_and_password(login,password);
        //Reg at neo4j
    }
}

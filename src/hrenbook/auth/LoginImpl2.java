package hrenbook.auth;

import hrenbook.DB_GLOBAL.MySql.Constant;
import hrenbook.Exceptions.WrongPasswordEexception;
import hrenbook.auth.abstracts.Loginer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by student on 7/18/2014.
 */
public class LoginImpl2 extends Loginer {
    private boolean validate(String login) {
        if(login.contains("'")) {
            return false;
        }
        return true;
    }
    @Override
    public long login(String login, String password) throws IllegalArgumentException, WrongPasswordEexception {

        System.out.println("Loginning...");
        if(!validate(login) || !validate(password)) {
            throw new IllegalArgumentException("Bad symbols!!!");
        }
        System.out.println("Get connections....");
        Connection connection = hrenbook.DB_GLOBAL.MySql.Connection.getConnection();
        try {

            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT id FROM "+ Constant.TABLE_NAME+" where login = ? AND "+
                    "password = ?");
            //preparedStatement.setString(1, Constant.TABLE_USER_NAME);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next() ) {
                return resultSet.getInt("id");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new WrongPasswordEexception("Bad login or password");
    }
}

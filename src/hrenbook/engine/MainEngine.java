package hrenbook.engine;

import hrenbook.auth.LoginImpl2;
import hrenbook.auth.RegistrationImpl2;
import hrenbook.auth.abstracts.Loginer;
import hrenbook.auth.abstracts.Registrator;

import java.util.HashMap;

/**
 * Created by student on 7/18/2014.
 */
public class MainEngine {
    {
        hrenbook.DB_GLOBAL.MySql.Connection.run();
        hrenbook.DB_GLOBAL.neo4j.Connection.run();
        loginer = new LoginImpl2();
        registrator = new RegistrationImpl2();
    }
    private static HashMap<String,Long> idStorage = new HashMap<>();
    public static long getMyId(String jsessionid) {
        return idStorage.get(jsessionid);
    }


    static Loginer loginer = null;
    static Registrator registrator = null;

    public void Register(String login,String password,String name,String lastname,Integer age) {
        registrator.reg(login,password,name,lastname,age);
    }
    public void login(String login,String password,String ssid) {

        long idnode = loginer.login(login, password);
        idStorage.put(ssid,idnode);
    }
    public void logout(String ssid) {

        idStorage.remove(ssid);
    }

}

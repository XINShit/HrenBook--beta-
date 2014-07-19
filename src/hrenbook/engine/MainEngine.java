package hrenbook.engine;

import hrenbook.Exceptions.UserExcistingException;
import hrenbook.Exceptions.WrongPasswordEexception;
import hrenbook.auth.LoginImpl2;
import hrenbook.auth.RegistrationImpl2;
import hrenbook.auth.abstracts.Loginer;
import hrenbook.auth.abstracts.Registrator;

import java.util.HashMap;

/**
 * Created by student on 7/18/2014.
 */
public class MainEngine {
    public static boolean runned = false;
   public static void init()
    {

        System.out.println("Running process in engine...");
        hrenbook.DB_GLOBAL.MySql.Connection.run();
        hrenbook.DB_GLOBAL.neo4j.Connection.run();
        loginer = new LoginImpl2();
        registrator = new RegistrationImpl2();
        runned = true;
    }
    private static HashMap<String,Long> idStorage = new HashMap<>();
    public static long getMyId(String jsessionid) {
        return idStorage.get(jsessionid);
    }


    static Loginer loginer = null;
    static Registrator registrator = null;

    public static  void Register(String login,String password,String email,String name,String lastname,Integer age) throws UserExcistingException {
        System.out.println("try to reg at main engine");
        registrator.reg(login,password,email,name,lastname,age);
    }
    public static void login(String login,String password,String ssid) throws WrongPasswordEexception {
        System.out.println("Try to loggin with : "+login+" "+password+" "+ssid);
        long idnode = loginer.login(login, password);
        idStorage.put(ssid,idnode);
        System.out.println("USER ID = "+idnode);
    }
    public static void logout(String ssid) {

        idStorage.remove(ssid);
    }

}

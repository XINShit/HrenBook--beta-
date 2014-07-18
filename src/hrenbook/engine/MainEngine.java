package hrenbook.engine;



import hrenbook.auth.LoginImpl;
import hrenbook.auth.LoginImpl2;
import hrenbook.auth.RegistrationImpl;
import hrenbook.auth.RegistrationImpl2;
import hrenbook.auth.abstracts.Loginer;
import hrenbook.auth.abstracts.Registrator;

/**
 * Created by student on 7/17/2014.
 */
public class MainEngine {
    public MainEngine()
    {
        hrenbook.DB_GLOBAL.MySql.Connection.run();
        hrenbook.DB_GLOBAL.neo4j.Connection.run();

        loginer = new LoginImpl2();
        registrator = new RegistrationImpl2();
    }
    Loginer loginer = null;
    Registrator registrator = null;

    public void Register(String login,String password,String name,String lastname,Integer age) {
        registrator.reg(login,password,name,lastname,age);
    }
    public long login(String login,String password) {
       return loginer.login(login,password);
    }
}

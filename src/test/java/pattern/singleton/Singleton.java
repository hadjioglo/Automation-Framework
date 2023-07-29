package pattern.singleton;

public class Singleton {
//Only one instance of this class can be created in th project
//    can be used in JDBC connection

    private static final Singleton singleton = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return singleton;
    }
}

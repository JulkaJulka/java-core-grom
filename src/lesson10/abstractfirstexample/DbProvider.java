package lesson10.abstractfirstexample;

/**
 * Created by user on 07.06.2017.
 */
public abstract class  DbProvider {
    private String dbhost;

   // public DbProvider(String dbhost) {
   //     this.dbhost = dbhost;
   // }

    abstract void connectToDb();
       abstract void disconnectFromDb();
    void printDbHost(){
        System.out.println("DB host is " + dbhost);
    }
}

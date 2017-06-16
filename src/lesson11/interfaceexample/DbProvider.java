package lesson11.interfaceexample;

/**
 * Created by user on 07.06.2017.
 */
public interface  DbProvider {
    void connectToDb();
    void disconnectFromDb();
    void encryptData();

}

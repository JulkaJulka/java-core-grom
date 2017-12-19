package lesson35.repository;

import lesson35.model.Entity;
import lesson35.model.User;
import lesson35.model.UserType;
import lesson35.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Created by user on 15.12.2017.
 */
public class GeneralRepository<T> {

    private  static String pathRoomDB = "D:/Ubuntu_backup/dev/RoomDB.txt";
    private  static String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB.txt";
    private  String pathUserDB = "D:/Ubuntu_backup/dev/UserDB.txt";
    private  String pathDB = "";
    private Utils utils = new Utils();

    public String getPathRoomDB() {
        return pathRoomDB;
    }

    public String getPathDB() {
        return pathDB;
    }

    public void setPathDB(String pathDB) {
        this.pathDB = pathDB;
    }

    public String getPathHotelDB() {
        return pathHotelDB;
    }

    public String getPathUserDB() {
        return pathUserDB;
    }

    public void setPathRoomDB(String pathRoomDB) {
        this.pathRoomDB = pathRoomDB;
    }

    public void setPathHotelDB(String pathHotelDB) {
        this.pathHotelDB = pathHotelDB;
    }

    public void setPathUserDB(String pathUserDB) {
        this.pathUserDB = pathUserDB;
    }


    public Entity findEntitylById(Long idFind) throws Exception {
        checkId(idFind);
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                Entity findEntity = new Entity();
                String[] strings = line.split(",");
                long entityId = Long.parseLong(strings[0]);
                if (entityId == idFind) {
                    findEntity.setId(entityId);
                    return findEntity;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathDB + " does not exist");
        }
        return null;
       // throw new Exception("Entity with id " + idFind + " doesn't exist in DB" );
    }

    public <T extends Entity>  void  generateId(T t) throws Exception {
        long generateId;
        Random random = new Random();
        generateId = Math.abs(random.nextLong());

        while (checkPresenceId(generateId)) {
            generateId = Math.abs(random.nextLong());
        }
        t.setId(generateId);

    }
    public boolean checkPresenceId(long id) throws Exception {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                long idDB = Long.parseLong(strings[0]);
                if (idDB == id) {
                    return true;
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathDB + " failed");
        }
       // return false;
    }
    private boolean checkId(Long id) throws Exception {
        if (id == null || id <= 0)
            throw new Exception("Id " + id + " is wrong");
        return true;
    }

}

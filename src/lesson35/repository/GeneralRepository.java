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

    private final String pathRoomDB = "D:/Ubuntu_backup/dev/RoomDB.txt";
    private final String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB.txt";
    private final String pathUserDB = "D:/Ubuntu_backup/dev/UserDB.txt";
    private final String pathDB = "";
    private Utils utils = new Utils();


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
    }

    public <T extends Entity>  void  generateId(T t, String path) throws Exception {
        long generateId;
        Random random = new Random();
        generateId = Math.abs(random.nextLong());

        while (checkPresenceId(generateId, path)) {
            generateId = Math.abs(random.nextLong());
        }
        t.setId(generateId);
    }
    private boolean checkPresenceId(long id, String pathDB) throws Exception {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                long idDB = Long.parseLong(strings[0]);
                if (idDB == id) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathDB + " failed");
        }
        return false;
    }
    private boolean checkId(Long id) throws Exception {
        if (id == null || id <= 0)
            throw new Exception("Id " + id + " is wrong");
        return true;
    }

}
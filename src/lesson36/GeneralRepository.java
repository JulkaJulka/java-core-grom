package lesson36;

import lesson36.model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Created by user on 15.12.2017.
 */
public class GeneralRepository<T> {

   /* private <T extends User>void generateUserId(T t) throws Exception {
        long generateId;
        Random random = new Random();
        generateId = Math.abs(random.nextLong());

        while (checkPresenceId(generateId)) {
            generateId = Math.abs(random.nextLong());
        }
        t.setId(generateId);
    }*/
    private boolean checkPresenceId(long id, String pathDB) throws Exception {
        String line = "";
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

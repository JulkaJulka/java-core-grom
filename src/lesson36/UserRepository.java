package lesson36;

import lesson36.model.User;
import lesson36.model.UserType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Created by user on 30.11.2017.
 */
public class UserRepository {
//UserService userService = new UserService();

    //считывание данных - считывание файлов
    //обработка данных - маппинг данных

    private final String pathUserDB = "D:/Ubuntu_backup/dev/UserDB.txt";
    private Utils utils = new Utils();

    public User registerUser(User user) throws Exception {
        validateInputData(user);

        if (!(findUserByUserName(user) == null)) {
            throw new Exception("User with userName " + user.getUserName() +
                    " has registered already. Try another userName");
        }
        try {
            generateUserId(user);

            StringBuffer bf = new StringBuffer("");
            String string = user.toString();

            bf.append("\r\n");
            bf.append(string);

            utils.writeToFile(pathUserDB, bf);

        } catch (Exception e) {
            throw new IOException("Can't write to userBD " + pathUserDB);
        }
        return user;
    }


    private User findUserByUserName(User user) throws Exception {
        String line = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader(pathUserDB))) {
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                if (strings[1].equals(user.getUserName()))
                    return user;
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathUserDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathUserDB + " failed");
        }
        return null;
    }

    private void generateUserId(User user) throws Exception {
        long generateUserId;
        Random random = new Random();
        generateUserId = Math.abs(random.nextLong());

        while (checkPresenceIdUser(generateUserId)) {
            generateUserId = Math.abs(random.nextLong());
        }
        user.setId(generateUserId);
    }

    private boolean checkPresenceIdUser(long idUser) throws Exception {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathUserDB))) {
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                long idDB = Long.parseLong(strings[0]);
                if (idDB == idUser) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathUserDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathUserDB + " failed");
        }
        return false;
    }

    private boolean validateInputData(User user) throws Exception {
        if (user == null || user.getUserName().isEmpty() || user.getPassword().isEmpty() ||
                user.getCountry().isEmpty()) {
            throw new Exception("You input wrong data. Try again, please");
        }
        if (!(utils.checkWordOnLetAndDigts(user.getUserName())))
            throw new Exception("UserName " + user.getUserName() + " is wrong");
        if (!(utils.checkWordOnLetAndDigts(user.getPassword())))
            throw new Exception("Password must have only letters and digits");
        if (!(utils.checkWordOnLetters(user.getCountry()))) {
            throw new Exception("Country " + user.getCountry() + " must have only letters");
        }
        return true;
    }
    public User findUserlById(Long idFind) throws Exception {
        checkIdUser(idFind);
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathUserDB))) {
            while ((line = br.readLine()) != null) {
                User findUser = new User();
                String[] strings = line.split(",");
                long userId = Long.parseLong(strings[0]);
                if (userId == idFind) {
                    findUser.setId(userId);
                    findUser.setUserName(strings[1]);
                    findUser.setPassword(strings[2]);
                    findUser.setCountry(strings[3]);
                    if(strings[4].equals("ADMIN")){
                    findUser.setUserType(UserType.ADMIN);
                    } else {
                        findUser.setUserType(UserType.USER);
                    }
                    return findUser;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathUserDB + " does not exist");
        }
        return null;
    }
    private boolean checkIdUser(Long idUser) throws Exception {
        if (idUser == null || idUser <= 0)
            throw new Exception("Id " + idUser + " is wrong");
        return true;
    }
}

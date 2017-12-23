package lesson35.repository;

import lesson35.Utils;
import lesson35.model.User;
import lesson35.model.UserType;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by user on 30.11.2017.
 */
public class UserRepository extends GeneralRepository {
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

        generateUserId(user);

        StringBuffer bf = new StringBuffer("");
        String string = user.toString();

        bf.append("\r\n");
        bf.append(string);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathUserDB, true))) {
            bufferedWriter.append(bf);
        } catch (Exception e) {
            throw new IOException("Can't write to userBD " + pathUserDB);
        }
        return user;
    }


    public User findUserByUserName(User user) throws Exception {
        ArrayList<User> userArrayList = userToArrayList(pathUserDB);
        for (User us : userArrayList) {
            if (us.getUserName().equals(user.getUserName()))
                return user;
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
        checkIdUser(idUser);
        ArrayList<User> userToArrayList = userToArrayList(pathUserDB);
        for (User us : userToArrayList){
            if(us.getId() == idUser){
                return true;
            }
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

    public User findUserById(Long idFind) throws Exception {
        checkIdUser(idFind);
        ArrayList<User> users = userToArrayList(pathUserDB);
        for (User us : users) {
            if (us.getId() == idFind) {
                return us;
            }
        }
        return null;
    }


    public ArrayList<User> userToArrayList(String path) throws Exception {
        ArrayList<User> userArrayList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                User user = formUser(strs);
                userArrayList.add(user);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + path + " failed");
        }

        return userArrayList;
    }

    public User formUser(String[] str) throws Exception {
        if (str.length == 0 || str == null || str.length != 5)
            throw new Exception("Error of reading");
        User user = new User();

        long id = Long.parseLong(str[0]);
        String name = str[1];
        String password = str[2];
        String country = str[3];
        String userTypeStr = str[4];

        user.setId(id);
        user.setUserName(name);
        user.setPassword(password);
        user.setCountry(country);
        if (userTypeStr.equals("USER")) {
            user.setUserType(UserType.USER);
        } else {
            user.setUserType(UserType.ADMIN);
        }
        return user;
    }

    private boolean checkIdUser(Long idUser) throws Exception {
        if (idUser == null || idUser <= 0)
            throw new Exception("Id " + idUser + " is wrong");
        return true;
    }
}

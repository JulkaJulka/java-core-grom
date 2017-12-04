package lesson35.repository;

import lesson35.model.User;
import lesson35.model.UserType;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 30.11.2017.
 */
public class UserRepository {
//UserService userService = new UserService();

    //считывание данных - считывание файлов
    //обработка данных - маппинг данных

    private final String pathUserDB = "D:/Ubuntu_backup/dev/UserDB.txt";

    public User registerUser(User user) throws Exception {
       // if (user == null)
        //    throw new Exception("You enter wrong data. Try again");
        validateInputData(user);
        if (!(findUserByUserName(user) == null)) {
            throw new Exception("User with userName " + user.getUserName() +
                    " has registered already. Try another userName");
        }
        try {
            StringBuffer bf = new StringBuffer("");
            long generateUserId;
            Random random = new Random();
            generateUserId = Math.abs(random.nextLong());

            while (checkPresenceIdUser(generateUserId)) {
                generateUserId = Math.abs(random.nextLong());
            }
            user.setId(generateUserId);
            bf.append("\r\n");
            bf.append(generateUserId);
            bf.append(",");
            bf.append(user.getUserName());
            bf.append(",");
            bf.append(user.getPassword());
            bf.append(",");
            bf.append(user.getUserType());

            writeToFile(pathUserDB, bf);

        } catch (Exception e) {
            throw new IOException("Can't write to userBD " + pathUserDB);
        }
        return user;
    }

    public StringBuffer readerData(String path) throws Exception {
        String line = "";
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {

                res.append(line);
                res.append("\r\n");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + path + " failed");
        }
        System.out.println(res.length());
        return res;
    }

    public User findUserByUserName(User user) throws Exception {
        String line = "";
        StringBuffer res = new StringBuffer();
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

    public boolean checkPresenceIdUser(long idUser) throws Exception {
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

    public boolean validateInputData(User user) throws Exception{
        if(user == null || user.getUserName().isEmpty() || user.getPassword().isEmpty() ||
                user.getCountry().isEmpty()){
            throw new Exception("You input wrong data. Try again, please");
        }
        if(!(checkWordOnLetAndDigts(user.getUserName())))
            throw new Exception("UserName " + user.getUserName() + " is wrong");
        if(!(checkWordOnLetAndDigts(user.getPassword())))
            throw new Exception("Password must have only letters and digits");
        if(!(checkWordOnLetters(user.getCountry()))){
            throw new Exception("Country " + user.getCountry() + " must have only letters");}
            return true;

    }

    public void writeToFile(String path, StringBuffer contentToWrite) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);

        } catch (IOException e) {
            throw new IOException("Can't write to file " + path);
        }
    }

    private boolean checkWordOnLetters(String body) {
        char[] chars = body.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch))
                return false;
        }

        return true;
    }
    private boolean checkWordOnLetAndDigts(String body) {
        char[] chars = body.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetterOrDigit(ch))
                return false;
        }

        return true;
    }
    private boolean checkWordOnDigts(String body) {
        char[] chars = body.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch))
                return false;
        }

        return true;
    }
}

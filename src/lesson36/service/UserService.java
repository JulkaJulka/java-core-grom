package lesson36.service;

import lesson36.model.User;
import lesson36.repository.UserRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by user on 30.11.2017.
 */
public class UserService {

   private UserRepository userRepository = new UserRepository();

 public User registerUser(User user) throws Exception{
    //check business logic
     //userRepository.readerData();


     //if logic is ok:
     //return userRepository.registerUser(user);
     return null;
        }

    public StringBuffer readerData(String path) throws Exception {
//String path =
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


}

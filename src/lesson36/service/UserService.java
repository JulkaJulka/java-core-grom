package lesson36.service;

import lesson36.exception.BadRequestException;
import lesson36.model.Entity;
import lesson36.model.User;
import lesson36.repository.UserRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 30.11.2017.
 */
public class UserService {

    private UserRepository userRepository = new UserRepository();
    private User user;
    private boolean loginStatus;


    public UserRepository getUserRepository() {
        return userRepository;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
  public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Entity registerUser(User user) throws Exception {
        userRepository.validateInputData(user);
        Entity ent = (Entity) user;
        return userRepository.addEntity(ent);

    }

    public void login(String userName, String password) throws Exception {
        if (userName == null || password == null || userName.isEmpty() || password.isEmpty())
            throw new Exception("You input wrong data. Try again, please");
        ArrayList<User> userArrayList = getUserRepository().entityToArrayList();

        boolean abcenseUsInDB = true;

        for (int i = 0; i < userArrayList.size() ; i++) {
            if (userArrayList != null && userArrayList.get(i) != null && !userArrayList.get(i).getUserName().equals(userName) &&
                    !userArrayList.get(i).getPassword().equals(password)) {
                userArrayList.get(i).setLoginStatus(true);
                user = userArrayList.get(i);
                abcenseUsInDB = true;
               // break;
            } else{
                abcenseUsInDB = false;
                setLoginStatus(true);
                break;
            }
            }
            if(abcenseUsInDB == true)
                throw new BadRequestException("You didn't sign in. Please try again");

        }

       /* for (User us : userArrayList) {
            System.out.println("********** " + us.toString());
            if (userArrayList != null && us != null &&
                    us.getUserName().equals(userName) &&
                    us.getPassword().equals(password)) {
                us.setLoginStatus(true);
                user = us;
                break;
            }
        }
//        user.setLoginStatus(false);
        throw new BadRequestException("You didn't sign in. Please try again");*/



    public void logout() {
        if (user.isLoginStatus() == true)
            user.setLoginStatus(false);
    }
}

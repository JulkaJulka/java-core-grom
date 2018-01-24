package lesson36.service;

import lesson36.exception.BadRequestException;
import lesson36.model.User;
import lesson36.repository.GeneralRepository;
import lesson36.repository.UserRepository;

import java.util.ArrayList;

import static lesson36.Utils.checkWordOnLetAndDigts;
import static lesson36.Utils.checkWordOnLetters;

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

    public Object registerUser(User user) throws Exception {
        validateInputData(user);
        if (!(userRepository.findUserByUserName(user) == null))
            throw new Exception("User with userName " + user.getUserName() +
                    " has registered already. Try another userName");
        Object o = (Object) user;
        return userRepository.addEntity(o);

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

    public void logout() {
        if (user.isLoginStatus() == true)
            user.setLoginStatus(false);
    }

    public boolean validateInputData(User user) throws Exception {
        if (user == null || user.getUserName().isEmpty() || user.getPassword().isEmpty() ||
                user.getCountry().isEmpty()) {
            throw new Exception("You input wrong data. Try again, please");
        }
        if (!(checkWordOnLetAndDigts(user.getUserName())))
            throw new Exception("UserName " + user.getUserName() + " is wrong");
        if (!(checkWordOnLetAndDigts(user.getPassword())))
            throw new Exception("Password must have only letters and digits");
        if (!(checkWordOnLetters(user.getCountry()))) {
            throw new Exception("Country " + user.getCountry() + " must have only letters");
        }
        return true;
    }
}

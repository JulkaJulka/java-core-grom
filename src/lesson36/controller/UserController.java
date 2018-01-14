package lesson36.controller;

import lesson36.model.*;
import lesson36.repository.UserRepository;
import lesson36.service.UserService;

/**
 * Created by user on 30.11.2017.
 */
public class UserController {

    private UserService userService = new UserService();
   // private boolean login;

    public UserService getUserService() {
        return userService;
    }

    public Entity registerUser(User user) throws Exception {
        return userService.registerUser(user);

    }

    public void login(String userName, String password) throws Exception {
        userService.login(userName, password);
    }

    public void logout() {
        userService.logout();
    }

}

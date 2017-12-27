package lesson36.controller;

import lesson36.model.Filter;
import lesson36.model.Hotel;
import lesson36.model.LoginType;
import lesson36.repository.UserRepository;
import lesson36.service.UserService;
import lesson36.model.User;

/**
 * Created by user on 30.11.2017.
 */
public class UserController extends UserRepository{

    private UserService userService = new UserService();


    /*void login(String userName, String password) throws Exception{

            for (int i = 0; i < userDAO.getArray().length; i++) {
                if (userDAO.getArray() != null &&
                        !(userDAO.getArray()[i]==null) &&
                        userDAO.getArray()[i].getName().equals(name) &&
                        userDAO.getArray()[i].getPassword().equals(password)) {
                    setLoginType(LoginType.AUTH);
                    break;
                } }
        }
        public boolean checkLoginUser(User user) throws Exception{

            if(!(user.getLoginType() == LoginType.AUTH))
                throw new BadRequestException("You are not authorized.Try again please");
            return true;
        }
    void logout(){

    }*/


}

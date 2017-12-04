package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.LoginType;
import lesson35.service.UserService;
import lesson35.model.User;

import java.util.Collection;

/**
 * Created by user on 30.11.2017.
 */
public class UserController {

    private UserService userService = new UserService();

    private User registerUser(User user){

        //return userService.registerUser(user);
        return null;
    }
    private Hotel findHoteByName(String name){
        return null;
    }
    private Hotel findHotelByCity(String city){
        return null;
    }
    private Collection findRooms(Filter filter){
        return null;
    }
    private void bookRoom(long roomId, long userId, long hotelId){

    }
    private void cancelReservation(long roomId, long userId, long hotelId){

    }
    void login(String userName, String password){

    }
    void logout(){

    }


}

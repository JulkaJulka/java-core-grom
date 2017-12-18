package lesson36.controller;

import lesson36.model.Filter;
import lesson36.model.Hotel;
import lesson36.model.User;
import lesson36.service.UserService;

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
    private Hotel findHotelByName(String name){
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

package lesson36.repository;

import lesson36.Utils;
import lesson36.model.Entity;
import lesson36.model.Hotel;
import lesson36.model.User;
import lesson36.model.UserType;


import java.io.*;
import java.util.ArrayList;

/**
 * Created by user on 30.11.2017.
 */
public class HotelRepository extends GeneralRepository {
    private final  String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB";
    private Utils utils = new Utils();

    static {
        setPathDB("D:/Ubuntu_backup/dev/HotelDB");
    }
    static {
        setCountFieldsOfObject(5);
    }

   public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        checkHotelName(name);
        ArrayList<Hotel> findHotels = new ArrayList<>();
        ArrayList<Entity> hotelToArrayList = entityToArrayList();
        for (Entity ent: hotelToArrayList){
            Hotel ht = (Hotel) ent;
            if(ht.getHotelName().equals(name)){
                findHotels.add(ht);
            }
        }
        return findHotels;
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        checkCityOfHotel(city);
        ArrayList<Hotel> hotelFindArrayList = new ArrayList<>();
        ArrayList<Entity> hotelToArrayList = entityToArrayList();
        for(Entity ent : hotelToArrayList){
            Hotel ht = (Hotel) ent;
            if(ht.getCity().equals(city)){
                hotelFindArrayList.add(ht);
            }
        }
        return hotelFindArrayList;
    }

    public  Entity formEntity(String[] str) throws Exception {
        if (str == null || str.length == 0 || str.length != 5)
            throw new Exception("Error of reading: Incorrect data");
        Hotel hotel = new Hotel();
        hotel.setId(Long.parseLong(str[0]));
        hotel.setHotelName(str[1]);
        hotel.setCountry(str[2]);
        hotel.setCity(str[3]);
        hotel.setStreet(str[4]);

        return hotel;
    }

    private boolean checkHotelName(String name) throws Exception {
        if (name == null || name.isEmpty())
            throw new Exception("Enter name of Hotel");
        if (!utils.checkWordOnLetters(name))
            throw new Exception("Name of hotel " + name + " is wrong. Try again, please");
        return true;
    }

    private boolean checkCityOfHotel(String city) throws Exception {
        if (city == null || city.isEmpty())
            throw new Exception("Enter city of Hotel");
        if (!utils.checkWordOnLetters(city))
            throw new Exception("City " + city + " is wrong. Try again, please");
        return true;
    }

}

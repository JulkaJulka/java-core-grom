package lesson36.controller;

import lesson36.model.Hotel;
import lesson36.model.User;
import lesson36.service.HotelService;

import java.util.ArrayList;

/**
 * Created by user on 30.11.2017.
 */
public class HotelController {

    HotelService hotelService = new HotelService();

    public HotelService getHotelService() {
        return hotelService;
    }

   public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        return hotelService.findHotelByCity(city);
    }

    public Object addHotel(Hotel hotel, User user) throws Exception {
        return hotelService.addHotel(hotel, user);
    }

    public void deleteHotel(Long hotelId, User user) throws Exception {
        hotelService.deleteHotel(hotelId, user);
    }
}

package lesson36.service;

import lesson36.Utils;
import lesson36.model.Hotel;
import lesson36.model.User;
import lesson36.model.UserType;
import lesson36.repository.HotelRepository;

import java.util.ArrayList;

import static lesson36.Utils.checkWordOnLetters;
import static lesson36.repository.HotelRepository.validateHotel;

/**
 * Created by user on 30.11.2017.
 */
public class HotelService {

    HotelRepository hotelRepository = new HotelRepository();
    Utils utils = new Utils();

    public HotelRepository getHotelRepository() {
        return hotelRepository;
    }

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        checkWordOnLetters(name);
        return hotelRepository.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        checkWordOnLetters(city);
        return hotelRepository.findHotelByCity(city);
    }

    public Object addHotel(Hotel hotel, User user) throws Exception {
        validateHotel(hotel);
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("You have not rights to add hotel");
        return hotelRepository.addEntity((Object) hotel);
    }

    public void deleteHotel(Long hotelId, User user) throws Exception {
        hotelRepository.validateHotel(hotelId);
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("You have not rights to delete hotel");
        hotelRepository.deleteEntity(hotelId);
    }
}

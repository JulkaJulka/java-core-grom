package lesson36.repository;

import lesson36.Utils;
import lesson36.model.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by user on 30.11.2017.
 */
public class RoomRepository extends GeneralRepository {
    private String pathRoomDB = "D:/Ubuntu_backup/dev/RoomDB";
    private String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB";


    static {
        setPathDB("D:/Ubuntu_backup/dev/RoomDB");
    }

    static {
        setCountFieldsOfObject(7);
    }

    public Collection findRooms(Filter filter) throws Exception {
        ArrayList<Entity> roomArrayList = entityToArrayList();
        ArrayList<Room> findRooms = new ArrayList<>();
        for (Entity ent : roomArrayList) {
            Room rm = (Room) ent;
            if (conformityFilter(rm, filter)) {
                findRooms.add(rm);
            }
        }
        return findRooms;
    }


    public Entity formEntity(String[] str) throws Exception {
        if (str.length == 0 || str.length != 7 || str == null)
            throw new Exception("Error of reading.Incorrect data");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateAvailableFrom = simpleDateFormat.parse(str[5]);

        HotelRepository hotelRepository = new HotelRepository();
        setPathDB(pathHotelDB);
        setCountFieldsOfObject(5);
        Hotel hotel = (Hotel) hotelRepository.findEntityById(Long.parseLong(str[6]));

        setPathDB(pathRoomDB);
        setCountFieldsOfObject(7);
        Room room = new Room(Long.parseLong(str[0]), Integer.parseInt(str[1]), Double.parseDouble(str[2]),
                Boolean.parseBoolean(str[3]), Boolean.parseBoolean(str[4]), dateAvailableFrom, hotel);

        return room;
    }

    public boolean conformityFilter(Room room, Filter filter) {
        if (filter == null)
            return false;
        if (filter.getNumberOfGuests() != 0 && room.getNumberOfGuests() != filter.getNumberOfGuests())
            return false;
        if (filter.getPrice() != 0 && room.getPrice() != filter.getPrice())
            return false;
        if (filter.isBreakfastIncluded() != room.isBreakfastIncluded())
            return false;
        if (filter.isPetsAllowed() != room.isPetsAllowed())
            return false;
        if (filter.getDateAvailableFrom() != null && filter.getDateAvailableFrom().compareTo(room.getDateAvailableFrom()) < 0)
            return false;
        if (room.getHotel() == null || room.getHotel().getCountry() == null || room.getHotel().getCity() == null)
            return false;
        if (filter.getCountry() != null && (room.getHotel() != null && !filter.getCountry().equals(room.getHotel().getCountry())))
            return false;
        if (filter.getCity() != null && (room.getHotel() != null && !filter.getCity().equals(room.getHotel().getCity())))
            return false;
        return true;
    }
}

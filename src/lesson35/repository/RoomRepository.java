package lesson35.repository;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 30.11.2017.
 */
public class RoomRepository {
    private final String pathRoomDB = "D:/Ubuntu_backup/dev/RoomDB.txt";
    private final String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB.txt";

    public Collection findRooms(Filter filter) throws Exception {
        String line = "";
        ArrayList<Room> roomArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathRoomDB))) {
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");

                long roomId = Long.parseLong(strs[0]);
                int numberOfGuests = Integer.parseInt(strs[1]);
                double price = Double.parseDouble(strs[2]);
                boolean breakfastIncluded = Boolean.parseBoolean(strs[3]);
                boolean isPetsAllowed = Boolean.parseBoolean(strs[4]);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date dateAvailableFrom = simpleDateFormat.parse(strs[5]);

                Hotel hotelOfRoom = findHotelById(Long.parseLong(strs[6]));
                if (filter != null && numberOfGuests == filter.getNumberOfGuests() &&
                        price == filter.getPrice() &&
                        breakfastIncluded == filter.isBreakfastIncluded() &&
                        isPetsAllowed == filter.isPetsAllowed() &&
                        dateAvailableFrom.compareTo(filter.getDateAvailableFrom()) <= 0 &&
                        hotelOfRoom != null &&
                        hotelOfRoom.getCountry().equals(filter.getCountry()) &&
                        hotelOfRoom.getCity().equals(filter.getCity())) {
                    Room room = new Room();
                    room.setId(roomId);
                    room.setNumberOfGuests(numberOfGuests);
                    room.setPrice(price);
                    room.setBreakfastIncluded(breakfastIncluded);
                    room.setPetsAllowed(isPetsAllowed);
                    room.setDateAvailableFrom(dateAvailableFrom);
                    room.setHotel(findHotelById(Long.parseLong(strs[6])));
                    roomArrayList.add(room);
                }
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathRoomDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathRoomDB + " failed");
        }
        return roomArrayList;
    }

    void bookRoom(long roomId, long userId, long hotelId) {

    }

    public Hotel findHotelById(Long idFind) throws Exception {
        checkIdHotel(idFind);
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(pathHotelDB))) {
            while ((line = br.readLine()) != null) {
                Hotel findHotel = new Hotel();
                String[] strings = line.split(",");
                long hotelId = Long.parseLong(strings[0]);
                if (hotelId == idFind) {
                    findHotel.setId(hotelId);
                    findHotel.setHotelName(strings[1]);
                    findHotel.setCountry(strings[2]);
                    findHotel.setCity(strings[3]);
                    findHotel.setStreet(strings[4]);
                    return findHotel;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathHotelDB + " does not exist");
        }
        return null;
    }

    public boolean checkIdHotel(Long idHotel) throws Exception {
        if (idHotel == null || idHotel <= 0)
            throw new Exception("Id " + idHotel + " is wrong");
        return true;
    }
}

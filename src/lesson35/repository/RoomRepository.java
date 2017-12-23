package lesson35.repository;

import lesson35.Utils;
import lesson35.model.*;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by user on 30.11.2017.
 */
public class RoomRepository extends GeneralRepository {
    private final String pathRoomDB = "D:/Ubuntu_backup/dev/RoomDB.txt";
    private final String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB.txt";

    public Collection findRooms(Filter filter) throws Exception {
        ArrayList<Room> roomArrayList = roomToArrayList(pathRoomDB);
        ArrayList<Room> findRooms = new ArrayList<>();
        for (Room rm : roomArrayList) {
            if (conformityFilter(rm, filter)) {
                findRooms.add(rm);
            }
        }
        return findRooms;

    }

    public Room addRoom(Room room, User user) throws Exception {
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("Adding of room is not accessible to you");
        if (room == null)
            throw new Exception("You enter wrong room");

            StringBuffer bf = new StringBuffer("");
            generateRoomId(room);
        bf.append("\r\n");
            bf.append(room.toString());

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathRoomDB, true))) {
            bufferedWriter.append(bf);
            return room;
        } catch (IOException e) {
            throw new IOException("Can't write to roomDB " + pathRoomDB);
        }
    }

    public void deleteRoom(Room room, User user) throws Exception {
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("Deleting of room is not accessible to you");
        if (room == null)
            throw new Exception("You didn't enter room");

        ArrayList<Room> roomArrayListBeforeDel = roomToArrayList(pathRoomDB);

        if (!roomArrayListBeforeDel.contains(room.getId()))
            throw new Exception("Room with id " + room.getId() + " does not exist in roomDB");

        StringBuffer res = new StringBuffer();
        StringBuffer resBkp = new StringBuffer();
        for (Room rm : roomArrayListBeforeDel) {

            resBkp.append(rm.toString());
            resBkp.append("\r\n");

            if (rm.getId() != room.getId()) {
                res.append(rm.toString());
                res.append("\r\n");
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathRoomDB, false))) {
            bw.append(res);
        } catch (IOException e) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathRoomDB, false))) {
                bw.append(resBkp);
            }
            throw new IOException("Can't write to file " + pathRoomDB);
        }
    }

    private void generateRoomId(Room room) throws Exception {
        long generateRoomId;
        Random random = new Random();
        generateRoomId = Math.abs(random.nextLong());

        while (checkPresenceIdRoom(generateRoomId)) {
            generateRoomId = Math.abs(random.nextLong());
        }
        room.setId(generateRoomId);
    }

    private boolean checkPresenceIdRoom(long idRoom) throws Exception {
        checkIdRoom(idRoom);
        ArrayList<Room> roomToArrayList = roomToArrayList(pathRoomDB);
        for (Room rm : roomToArrayList){
            if(rm.getId() == idRoom){
                return true;
            }
        }
        return false;
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

    public Room findRoomById(Long idFind) throws Exception {
        checkIdRoom(idFind);
        ArrayList<Room> roomArrayList = roomToArrayList(pathRoomDB);
        for (Room rm : roomArrayList) {
            if (rm.getId() == idFind) {
                return rm;
            }
        }
        return null;
    }

    public Hotel findHotelById(Long idFind) throws Exception {
        checkIdHotel(idFind);
        ArrayList<Hotel> hotelArrayList = hotelToArrayList(pathHotelDB);
        for (Hotel ht : hotelArrayList){
            if(ht.getId() == idFind){
                return ht;
            }

        }
        return null;
    }
    public ArrayList<Hotel> hotelToArrayList(String path) throws Exception {
        ArrayList<Hotel> hotelToArrayList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(pathHotelDB))) {
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                Hotel hotel = createHotel(strs);
                hotelToArrayList.add(hotel);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + path + " failed");
        }

        return hotelToArrayList;
    }

    public Hotel createHotel(String[] str) throws Exception {
        if (str.length == 0 || str == null || str.length != 5)
            throw new Exception("Error of reading");
        Hotel hotel = new Hotel();

        hotel.setId(Long.parseLong(str[0]));
        hotel.setHotelName(str[1]);
        hotel.setCountry(str[2]);
        hotel.setCity(str[3]);
        hotel.setStreet(str[4]);

        return hotel;
    }

    public ArrayList<Room> roomToArrayList(String path) throws Exception {
        ArrayList<Room> roomToArrayList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(pathRoomDB))) {
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                Room room = createRoom(strs);
                roomToArrayList.add(room);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + path + " failed");
        }

        return roomToArrayList;
    }

    public Room createRoom(String[] str) throws Exception {
        if (str.length == 0  || str.length != 7)
            throw new Exception("Error of reading");
    Room room = new Room();

        room.setId(Long.parseLong(str[0]));
        room.setNumberOfGuests(Integer.parseInt(str[1]));
        room.setPrice(Double.parseDouble(str[2]));
        room.setBreakfastIncluded(Boolean.parseBoolean(str[3]));
        room.setPetsAllowed(Boolean.parseBoolean(str[4]));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateAvailableFrom = simpleDateFormat.parse(str[5]);

        room.setDateAvailableFrom(dateAvailableFrom);
        room.setHotel(findHotelById(Long.parseLong(str[6])));

        return room;
    }

    private boolean checkIdHotel(Long idHotel) throws Exception {
        if (idHotel == null || idHotel <= 0)
            throw new Exception("Id " + idHotel + " is wrong");
        return true;
    }

    private boolean checkIdRoom(Long idRoom) throws Exception {
        if (idRoom == null || idRoom <= 0)
            throw new Exception("Id " + idRoom + " is wrong");
        return true;
    }
}

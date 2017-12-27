package lesson36.repository;

import lesson36.Utils;
import lesson36.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by user on 30.11.2017.
 */
public class OrderRepository extends GeneralRepository {
    private final String pathOrderDB = "D:/Ubuntu_backup/dev/OrderDB.txt";
    private final String pathRoomDB = "D:/Ubuntu_backup/dev/RoomDB.txt";
    private final String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB.txt";
    private final String pathUserDB = "D:/Ubuntu_backup/dev/UserDB.txt";
    private Utils utils = new Utils();

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        Room needRoom = findRoomById(roomId);
        User needUser = findUserlById(userId);
        if (needRoom == null)
            throw new Exception("Room with id " + roomId + " does not exist in dB");
        if (findUserlById(userId) == null)
            throw new Exception("User with id " + userId + " does not exist in dB");
        if (needRoom.getHotel() == null)
            throw new Exception("Hotel with id " + hotelId + " does not exist in dB");

        StringBuffer addOrder = new StringBuffer("");
        Order order = new Order();
        generateOrderId(order);
        order.setUser(needUser);
        order.setRoom(needRoom);

        String strOrder = order.toString();
        addOrder.append("\r\n");
        addOrder.append(strOrder);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathOrderDB, true))) {
            bufferedWriter.append(addOrder);

        } catch (Exception e) {
            throw new IOException("Can't write to orderlDB " + pathOrderDB);
        }
    }

    public void cancelReservation(long roomId, long userId, long hotelId) throws Exception {
        Room cancelRoom = findRoomById(roomId);
        if (cancelRoom == null)
            throw new Exception("Room with id " + roomId + " does not exist in dB");
        if (findUserlById(userId) == null)
            throw new Exception("User with id " + userId + " does not exist in dB");
        if (cancelRoom.getHotel() == null)
            throw new Exception("Hotel with id " + hotelId + " does not exist in dB");

        String line;
        StringBuffer res = new StringBuffer();
        StringBuffer dataBeforeChanging = new StringBuffer("");
        try (BufferedReader br = new BufferedReader(new FileReader(pathOrderDB))) {

            while ((line = br.readLine()) != null) {
                dataBeforeChanging.append(line);
                String[] strings = line.split(",");
                long stayRoomId = Long.parseLong(strings[2]);
                long stayUserId = Long.parseLong(strings[1]);

                if (stayUserId == userId && stayRoomId == roomId && findRoomById(stayRoomId) != null &&
                        findRoomById(stayRoomId).getHotel() != null &&
                        findRoomById(stayRoomId).getHotel().getId() == hotelId) {
                    res.append("");

                } else {
                    res.append(line);
                    res.append("\r\n");
                }
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOrderDB,false))){
                    bw.append(res);
                } catch (IOException e) {
                    try( BufferedWriter bw = new BufferedWriter(new FileWriter(pathOrderDB))){
                        bw.append(dataBeforeChanging);}
                    throw new IOException("Can't write to file " + pathOrderDB);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathOrderDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathOrderDB + " failed");
        }

    }
    public ArrayList<Order> orderToArrayList(String path) throws Exception {
        ArrayList<Order> orderArrayList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(pathOrderDB))) {
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                Order order = formOrder(strs);
                orderArrayList.add(order);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + path + " failed");
        }

        return orderArrayList;
    }
    public Order formOrder(String[] str) throws Exception {
        if (str.length == 0  || str.length != 6)
            throw new Exception("Error of reading");
        Order order = new Order();

        order.setId(Long.parseLong(str[0]));
        order.setUser(findUserlById(Long.parseLong(str[1])));
        order.setRoom(findRoomById(Long.parseLong(str[2])));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateFrom = simpleDateFormat.parse(str[3]);
        Date dateTo = simpleDateFormat.parse(str[4]);

        order.setDateFrom(dateFrom);
        order.setDateTo(dateTo);
        order.setMoneyPaid(Double.parseDouble(str[5]));
        return order;
    }

    private void generateOrderId(Order order) throws Exception {
        long generateOrderId;
        Random random = new Random();
        generateOrderId = Math.abs(random.nextLong());

        while (checkPresenceIdOrder(generateOrderId)) {
            generateOrderId = Math.abs(random.nextLong());
        }
        order.setId(generateOrderId);
    }

    private boolean checkPresenceIdOrder(long idOrder) throws Exception {
        checkIdOrder(idOrder);
        ArrayList<Order> orderToArrayList = orderToArrayList(pathOrderDB);
        for (Order or : orderToArrayList){
            if(or.getId() == idOrder){
                return true;
            }
        }
        return false;
    }
    public User findUserlById(Long idFind) throws Exception {
        checkIdUser(idFind);
        ArrayList<User> users = userToArrayList(pathUserDB);
        for (User us : users) {
            if (us.getId() == idFind) {
                return us;
            }
        }
        return null;
    }

    public ArrayList<User> userToArrayList(String path) throws Exception {
        ArrayList<User> userArrayList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                User user = formUser(strs);
                userArrayList.add(user);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + path + " failed");
        }

        return userArrayList;
    }

    public User formUser(String[] str) throws Exception {
        if (str.length == 0  || str.length != 5)
            throw new Exception("Error of reading");
        User user = new User();

        long id = Long.parseLong(str[0]);
        String name = str[1];
        String password = str[2];
        String country = str[3];
        String userTypeStr = str[4];

        user.setId(id);
        user.setUserName(name);
        user.setPassword(password);
        user.setCountry(country);
        if (userTypeStr.equals("USER")) {
            user.setUserType(UserType.USER);
        } else {
            user.setUserType(UserType.ADMIN);
        }
        return user;
    }

    private boolean checkIdUser(Long idUser) throws Exception {
        if (idUser == null || idUser <= 0)
            throw new Exception("Id " + idUser + " is wrong");
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

    private boolean checkIdRoom(Long idRoom) throws Exception {
        if (idRoom == null || idRoom <= 0)
            throw new Exception("Id " + idRoom + " is wrong");
        return true;
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

    private boolean checkIdHotel(Long idHotel) throws Exception {
        if (idHotel == null || idHotel <= 0)
            throw new Exception("Id " + idHotel + " is wrong");
        return true;
    }
    private boolean checkIdOrder(Long idOrder) throws Exception {
        if (idOrder== null || idOrder <= 0)
            throw new Exception("Id " + idOrder + " is wrong");
        return true;
    }
}

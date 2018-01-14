package lesson36.repository;

import lesson36.Utils;
import lesson36.exception.BadRequestException;
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
    private final String pathRoomDB = "D:/Ubuntu_backup/dev/RoomDB";
    private final String pathHotelDB = "D:/Ubuntu_backup/dev/HotelDB";
    private final String pathUserDB = "D:/Ubuntu_backup/dev/UserDB";
  //  private static UserRepository userRepository = new UserRepository();
    private Utils utils = new Utils();

    static {
        setPathDB("D:/Ubuntu_backup/dev/OrderDB.txt");
    }

    static {
        setCountFieldsOfObject(6);
    }

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        if (roomId == 0)
            throw new Exception("You enter wrong roomId. Please, try again");
        if (userId == 0)
            throw new Exception("You enter wrong userId. Please, try again");
        if (hotelId == 0)
            throw new Exception("You enter wrong hotelId. Please, try again");

        String[] str = new String[]{"1", String.valueOf(userId), String.valueOf(roomId), "10-09-2017", "23-09-2017",
                String.valueOf(1000 * 3)};
        Entity order = formEntity(str);
        generateId(order);

        HotelRepository hotelRepository = new HotelRepository();
        setPathDB(pathHotelDB);
        setCountFieldsOfObject(5);

        Hotel hotel = (Hotel) hotelRepository.findEntityById(hotelId);
        if (hotel == null)
            throw new Exception("Hotel with id " + hotelId + " does not exist in DB Hotel");

        Order createOrder = (Order) order;
        if (createOrder.getRoom().getHotel().getId() != hotel.getId())
            throw new Exception("Room with id " + roomId + " does not exist in hotel with id " + hotel.getId());

        setPathDB(pathOrderDB);
        setCountFieldsOfObject(6);
        addEntity(order);
    }

    @Override
    public Entity formEntity(String[] str) throws Exception {
        if (str.length == 0 || str.length != 6)
            throw new Exception("Error of reading");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date dateFrom = simpleDateFormat.parse(str[3]);
        Date dateTo = simpleDateFormat.parse(str[4]);

        RoomRepository roomRepository = new RoomRepository();
        setPathDB(pathRoomDB);
        setCountFieldsOfObject(7);

        Room needRoom = (Room) roomRepository.findEntityById(Long.parseLong(str[2]));

        if (needRoom == null)
            throw new Exception("Room with id " + str[2] + " does not exist in DB Room");

        UserRepository userRepository = new UserRepository();
        setPathDB(pathUserDB);
        setCountFieldsOfObject(5);

        User user = (User) userRepository.findEntityById(Long.parseLong(str[1]));

        if (user == null)
            throw new Exception("User with id " + str[1] + " does not exist in DB User");

        setPathDB(pathOrderDB);
        setCountFieldsOfObject(6);

        Order order = new Order(Long.parseLong(str[0]), user, needRoom, dateFrom, dateTo, Double.parseDouble(str[5]));

        return order;
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        if (roomId == 0)
            throw new Exception("Room with id " + roomId + " does not exist in dB");
        if (userId == 0)
            throw new Exception("User with id " + userId + " does not exist in dB");

        ArrayList<Order> orders = entityToArrayList();
        int count = 0;
        for (Order or : orders) {
            if (or.getRoom().getId() == roomId && or.getUser().getId() == userId) {
                count++;
                deleteEntity(or.getId());
            }
        }
        if (count == 0)
            throw new BadRequestException("Order of userId " + userId + " with roomId " + roomId +
                    " does not exist in DB");
    }
}

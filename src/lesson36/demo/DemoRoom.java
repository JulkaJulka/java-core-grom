package lesson36.demo;

import lesson36.model.*;
import lesson36.repository.GeneralRepository;
import lesson36.repository.RoomRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 30.11.2017.
 */
public class DemoRoom {
    public static void main(String[] args) throws Exception {
        RoomRepository roomRepository = new RoomRepository();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateStr = new String("25-09-2017");
        String dateFiltr = new String("25-10-2017");
        Date date = simpleDateFormat.parse(dateStr);
        Date dateF = simpleDateFormat.parse(dateFiltr);
        System.out.println(date);
        User user1 = new User(1001, "Julia", "qwerty", "Ukraine", UserType.ADMIN);
        user1.setUserType(UserType.ADMIN);
        Hotel hotel1 = new Hotel(333, "Schastie", "Ukraine", "Lviv", "Test");
        Hotel hotel2 = new Hotel(333, "Schastie", "Ukraine", "Lviv", "Test");
        Room room1 = new Room(3263465472588390554l, 2, 1800.00d, true, false, date, hotel2);
        Room room3 = new Room(3l, 2, 1800d, true, false, date, hotel2);
        Room room2 = new Room(7980395348638762038l, 2, 1800.00, true, false, dateF, hotel2);
        Room room4 = new Room(3263465472588390554l, 2, 1800.00, true, false, dateF, hotel2);
        Filter filter = new Filter(2, 1000d, true, false, dateF, "Ukraine", "Rovno");
       // System.out.println(roomRepository.conformityFilter(room1, filter));
      // System.out.println(roomRepository.addRoom(room2, user1));
      //  roomRepository.addRoom(room1,user1);
     // roomRepository.deleteRoom(room3,user1);
       // System.out.println( roomRepository.findHotelById(333l));
      //  System.out.println(roomRepository.roomToArrayList("D:/Ubuntu_backup/dev/RoomDB.txt"));
     // System.out.println(roomRepository.findRoomById(3263465472588390554l));
        GeneralRepository<Room> generalRepository = new GeneralRepository<>();
        generalRepository.deleteEntity(room4,user1);
      //  System.out.println(roomRepository.findRooms(filter));

    }

}

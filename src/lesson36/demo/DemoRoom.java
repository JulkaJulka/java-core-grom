package lesson36.demo;

import lesson36.RoomRepository;
import lesson36.model.*;

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
        Room room1 = new Room(111, 4, 1800.00, true, false, date, hotel1);
        Room room2 = new Room(6137386715093146361l, 4, 1800.00, true, false, date, hotel1);
        Filter filter = new Filter(0, 0, true, false, dateF, "Ukraine", "Lviv");
       // System.out.println(roomRepository.conformityFilter(room1, filter));
       // System.out.println(roomRepository.addRoom(room2, user1));
        //roomRepository.deleteRoom(room2,user1);
        System.out.println(roomRepository.findRoomById(5045396293690611794l));

       // System.out.println(roomRepository.findRooms(filter));

    }

}

package lesson35.demo;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.repository.RoomRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 30.11.2017.
 */
public class DemoRoom {
    public static void main(String[] args)throws Exception {
        RoomRepository roomRepository = new RoomRepository();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateStr = new String("15-10-2017");
        Date date = simpleDateFormat.parse(dateStr);
        System.out.println(date);

        Filter filter = new Filter(2, 1000.00,true,false, date,"Ukraine","Lviv");
        System.out.println(roomRepository.findRooms(filter));
    }
}

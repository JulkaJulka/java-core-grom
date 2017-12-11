package lesson35.repository;

import lesson35.model.Filter;
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

    public Collection findRooms(Filter filter) throws Exception{
        String line = "";
        StringBuffer res = new StringBuffer();
        ArrayList<Room> roomArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathRoomDB))) {
            Room room = new Room();
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");

                long roomId = Long.parseLong(strs[0]);
                int numberOfGuests = Integer.parseInt(strs[1]);
                double price = Double.parseDouble(strs[2]);
                boolean breakfastIncluded = Boolean.parseBoolean(strs[3]);
                boolean isPetsAllowed = Boolean.parseBoolean(strs[4]);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
                Date dateAvailableFrom = simpleDateFormat.parse(strs[5]);
                room.setId(roomId);
                room.setNumberOfGuests(numberOfGuests);
                room.setPrice(price);
                room.setBreakfastIncluded(breakfastIncluded);
                room.setPetsAllowed(isPetsAllowed);


                res.append(line);
                res.append("\r\n");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + pathRoomDB + " does not exist");
        } catch (IOException e) {
            throw new IOException("Reading from filed " + pathRoomDB + " failed");
        }
        System.out.println(res.length());


       return null;
    }
    void bookRoom(long roomId, long userId, long hotelId){

    }
}

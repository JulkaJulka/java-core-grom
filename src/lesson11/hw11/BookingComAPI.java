package lesson11.hw11;

/**
 * Created by user on 13.06.2017.
 */
public class BookingComAPI implements API {
    Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] findRooms = new Room[rooms.length];
        for (int i = 0; i <rooms.length ; i++) {
            if(rooms[i] != null && rooms[i].getPrice() >= price - 100 && rooms[i].getPrice() <= price + 100 &&
                    persons == rooms[i].getPersons() && city == rooms[i].getCityName() &&
                    hotel == rooms[i].getHotelName()){
                findRooms[i] = rooms[i];
            }

        }
        return findRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}

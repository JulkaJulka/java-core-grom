package lesson11.hw11;
public class TripAdvisorAPI implements API{
    Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        if(rooms == null){
            Room[] notFoundRooms = new Room[0];
            return notFoundRooms;
        }
        int countFindRooms = 0;
        for (int i = 0; i < rooms.length ; i++) {
            if(rooms[i] != null && rooms[i].getPersons() >= persons - 1 && rooms[i].getPersons() <= persons + 1 &&
                    price == rooms[i].getPrice() && city.equals(rooms[i].getCityName())  &&
                    hotel.equals(rooms[i].getHotelName())) {
                countFindRooms++;
            }

        }
        Room[] findRooms = new Room[countFindRooms];
        for (int i = 0; i <rooms.length ; i++) {
            if(rooms[i] != null && rooms[i].getPersons() >= persons - 1 && rooms[i].getPersons() <= persons + 1 &&
                    price == rooms[i].getPrice() && city.equals(rooms[i].getCityName())  &&
                    hotel.equals(rooms[i].getHotelName())){
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

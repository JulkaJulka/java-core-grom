package lesson11.hw11;
 public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int countFindRooms = 0;
        if (rooms == null) {
            Room[] notFindRoom = new Room[0];
            return notFindRoom ;
        }
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] != null && rooms[i].getPrice() == price && rooms[i].getPersons() == persons &&
                    rooms[i].getCityName().equals(city)  && rooms[i].getHotelName().equals(hotel)) {
                countFindRooms++;
            }
        }
        Room[] findRooms = new Room[countFindRooms];
            for (int i = 0; i < rooms.length; i++) {
                if (rooms[i] != null && rooms[i].getPrice() == price && rooms[i].getPersons() == persons &&
                        rooms[i].getCityName().equals(city) && rooms[i].getHotelName().equals(hotel)) {
                    findRooms[i] = rooms[i];
                }

            }
        return findRooms;

    }
}

       /* Room[] findRooms = new Room[rooms.length];
        if(rooms == null){
            findRooms = null;
        }
        for (int i = 0; i <rooms.length ; i++) {
            if(rooms[i] == null){
                findRooms[i] = null;
            }
            if(rooms[i] != null && rooms[i].getPrice() == price && rooms[i].getPersons() == persons &&
                    rooms[i].getCityName() == city  && rooms[i].getHotelName() == hotel){
                findRooms[i] = rooms[i];
            }

        }
        return findRooms;*/




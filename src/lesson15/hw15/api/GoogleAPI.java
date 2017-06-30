package lesson15.hw15.api;

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
       Room[] notFindRoom = new Room[0];
       if (rooms.length == 0) {

           return notFindRoom ;
       }
      /* if(price == 0 || persons ==0 || city ==null || hotel == null){
           return notFindRoom;
       }*/

       int countFindRooms = 0;
       for (int i = 0; i < rooms.length; i++) {
           if (rooms[i] != null && rooms[i].getPrice() == price && rooms[i].getPersons() == persons &&
                   rooms[i].getCityName().equals(city)  && rooms[i].getHotelName().equals(hotel)) {
               countFindRooms++;

           }
          // System.out.println(countFindRooms);
       }
       Room[] findRooms = new Room[countFindRooms];
       int indexFindRooms = 0;
           for (int i = 0; i < rooms.length; i++) {
               if (rooms[i] != null && rooms[i].getPrice() == price && rooms[i].getPersons() == persons &&
                       rooms[i].getCityName().equals(city) && rooms[i].getHotelName().equals(hotel)) {
                   findRooms[indexFindRooms] = rooms[i];
                   indexFindRooms++;
                  // System.out.println(findRooms[i] + " ");
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




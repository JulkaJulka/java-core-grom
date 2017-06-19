package lesson11.hw11;

/**
 * Created by user on 14.06.2017.
 */
public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
      /*  Room[] res = new Room[0];

        if (apis.length == 0) {
            return res;
        }
        int countRequestRoom = 0;
        for (int i = 0; i < apis.length; i++) {
            if (apis[i].findRooms(price, persons, city, hotel) != null) {
                countRequestRoom++;
            }
        }
        Room[] requestRoom = new Room[countRequestRoom];
        int index = 0;
        for (int i = 0; i < apis.length; i++) {
            if (apis[i].findRooms(price, persons, city, hotel) != null) {
                for (int j = 0; j < apis[i].findRooms(price, persons, city, hotel).length; j++) {
                    requestRoom[index] = apis[j].findRooms(price, persons, city, hotel);
                    index++;
                }
            }
        }
        return requestRoom;
    }*/


        if(apis.length == 0){
            Room[] res = new Room[0];
            return res;
        }
        int lengthApi = 0;

        Room[] findRoomForApi = new Room[]{};
        for (int i = 0; i < apis.length; i++) {
            findRoomForApi = apis[i].findRooms(price, persons, city, hotel);
            lengthApi = lengthApi + findRoomForApi.length;
        }
       // System.out.println(lengthApi);
        Room[] requestRooms = new Room[lengthApi];
        int index = 0;
        for (API api: apis) {
            if(api != null){
                for (Room room: api.findRooms(price,persons,city,hotel)) {
                    requestRooms[index] = room;
                    //System.out.println(requestRooms[index] + " ");
                    index++;
                }
            }
        }

     /*   for (int i = 0; i < apis.length; i++) {
            if (apis[i].findRooms(price, persons, city, hotel) != null) {
                for (int j = 0; j < findRoomForApi.length; j++) {
                    requestRooms[index] = findRoomForApi[j];
                   // System.out.println(requestRooms[index] + " ");
                }

            }
        }*/
        return requestRooms;

}

    public Room[] check(API api1, API api2) {

        Room[] api1Rooms = api1.getAll();
        Room[] api2Rooms = api2.getAll();

        if (api1Rooms.length == 0 || api2Rooms.length == 0) {
            Room[] res = new Room[0];
            //System.out.println(res);
            return res;

        }
        int countRes = 0;
        for (int i = 0; i < api1Rooms.length; i++) {
            for (int j = 0; j < api2Rooms.length; j++) {

                if (api1Rooms[i].getPrice() == api2Rooms[j].getPrice() &&
                        api1Rooms[i].getPersons() == api2Rooms[j].getPersons() &&
                        api1Rooms[i].getCityName().equals(api2Rooms[j].getCityName()) &&
                        api1Rooms[i].getHotelName().equals(api2Rooms[j].getHotelName())) {
                    countRes++;
                }
            }
        }

        Room[] res = new Room[countRes];
        for (int i = 0; i < api1Rooms.length; i++) {
            for (int j = 0; j < api2Rooms.length; j++) {

                if (api1Rooms[i].getPrice() == api2Rooms[j].getPrice() &&
                        api1Rooms[i].getPersons() == api2Rooms[j].getPersons() &&
                        api1Rooms[i].getCityName().equals(api2Rooms[j].getCityName()) &&
                        api1Rooms[i].getHotelName().equals(api2Rooms[j].getHotelName())) {
                    res[i] = api1Rooms[i];
                    // System.out.println(res[i] + " ");
                }
            }
        }
        return res;

    }
}

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
        if(apis.length == 0){
            return null;
        }
        int lengthApi = 0;

        Room[] findRoomForApi = new Room[]{};
        for (int i = 0; i < apis.length; i++) {

            findRoomForApi = apis[i].findRooms(price, persons, city, hotel);
            lengthApi = lengthApi + findRoomForApi.length;
            // apis[i].findRooms(price, persons, city, hotel);
        }
        Room[] requestRooms = new Room[lengthApi];
        for (int i = 0; i < apis.length; i++) {
            for (int j = 0; j < findRoomForApi.length; j++) {
                requestRooms[i] = findRoomForApi[j];
                System.out.println(requestRooms[i] + " ");
            }

        }
        return requestRooms;
    }
    /*
    public Room[] requestRooms(int price, int persons, String city, String hotel) {
14	        if(apis.length == 0){
15	            return null;
16	        }
17	        int lengthApi = 0;
18
19	        Room[] findRoomForApi = new Room[]{};
20	        //Room[] requestRooms = new Room[apis.];
21	        for (int i = 0; i < apis.length; i++) {
22
23	            findRoomForApi = apis[i].findRooms(price, persons, city, hotel);
24	            lengthApi = lengthApi + findRoomForApi.length;
25	            // apis[i].findRooms(price, persons, city, hotel);
26	        }
27	        Room[] requestRooms = new Room[lengthApi];
28	        for (int i = 0; i < apis.length; i++) {
29	            for (int j = 0; j < findRoomForApi.length; j++) {
30	                requestRooms[i] = findRoomForApi[j];
31	                System.out.println(requestRooms[i] + " ");
32	            }
33
34	        }
35	        return requestRooms;
36	    }
     */

    public Room[] check(API api1, API api2) {

        Room[] api1Rooms = api1.getAll();
        Room[] api2Rooms = api2.getAll();

        if (api1Rooms.length == 0 || api2Rooms.length == 0) {
            Room[] res = new Room[0];
            //System.out.println(res);
            return res;

        }
        int countRes =0;
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

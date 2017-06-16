package lesson11.hw11;

/**
 * Created by user on 14.06.2017.
 */
public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons,String city, String hotel){

        Room[] requestRooms = new Room[]{};
        for (int i = 0; i < apis.length ; i++) {
             apis[i].findRooms(price, persons, city, hotel);
/*if(requestRooms[i] != null){
    requestRooms[i] = */

        }
        return requestRooms;
    }

    public Room[] check(API api1, API api2) {

        Room[] api1Rooms = api1.getAll();
        Room[] api2Rooms = api2.getAll();

        if (api1Rooms.length == 0 || api2Rooms.length == 0) {
            Room[] res = new Room[0];
            System.out.println(res);
            return res;

        }
        Room[] res = new Room[api1Rooms.length];
        for (int i = 0; i < api1Rooms.length; i++) {
            for (int j = 0; j < api2Rooms.length; j++) {

                if (api1Rooms[i].getPrice() == api2Rooms[j].getPrice() &&
                        api1Rooms[i].getPersons() == api2Rooms[j].getPersons() &&
                        api1Rooms[i].getCityName().equals(api2Rooms[j].getCityName()) &&
                        api1Rooms[i].getHotelName().equals(api2Rooms[j].getHotelName())) {
                    res[i] = api1Rooms[i];
                  //  System.out.println(res[i] + " ");
                }
                }
            }
            return res;

    }
}

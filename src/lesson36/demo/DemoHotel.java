package lesson36.demo;

import lesson36.HotelRepository;
import lesson36.model.Hotel;
import lesson36.model.User;
import lesson36.model.UserType;

/**
 * Created by user on 30.11.2017.
 */
public class DemoHotel {
    public static void main(String[] args) throws Exception {
        HotelRepository hotelRepository = new HotelRepository();
       // System.out.println( hotelRepository.findHotelByName("Riviera"));
        System.out.println("-----");
        //System.out.println( hotelRepository.findHotelByCity("Kiev"));
        User user1 = new User(1002l,"Oleg","poiuyt","Ukraine", UserType.USER);
        user1.setUserType(UserType.ADMIN);
        Hotel hotel1 = new Hotel(348l,"Riviera","Belarus","Minsk2","Test2");
        Hotel hotel3 = new Hotel(2835475146381439109l,"Rixonbbbb","Thailand","Phuket","Testova");
       // System.out.println(hotelRepository.findHotelById(4556l));
       // System.out.println(hotelRepository.findHotelByName("Riviera"));
        hotelRepository.deleteHotel(hotel3,user1);
        Hotel hotel2 = new Hotel(3122410684202721229l,"Sup","Thailand","Phuket","Testova");
       // System.out.println(hotelRepository.addHotel(hotel2,user1));
        //System.out.println(hotelRepository.checkPresenceIdHotel(100000000l));


    }
}

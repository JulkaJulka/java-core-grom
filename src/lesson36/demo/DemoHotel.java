package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.model.Hotel;
import lesson36.model.User;
import lesson36.model.UserType;
import lesson36.repository.HotelRepository;

/**
 * Created by user on 30.11.2017.
 */
public class DemoHotel {
    public static void main(String[] args) throws Exception {
        HotelRepository hotelRepository = new HotelRepository();
        //System.out.println( hotelRepository.findHotelByName("Riviera"));
        System.out.println("-----");
        //System.out.println( hotelRepository.findHotelByCity("Kiev"));
        User user1 = new User("Oleg", "poiuyt", "Ukraine", UserType.USER);
       user1.setUserType(UserType.ADMIN);
        Hotel hotel1 = new Hotel("Riviera", "Belarus", "Minsk2", "Test2");
        Hotel hotel3 = new Hotel( "FFFFFF", "Thailand", "Phuket", "Testova");
        System.out.println(hotelRepository.addEntity(hotel3));
        // System.out.println(hotelRepository.findHotelByName("Riviera"));
        //   hotelRepository.deleteHotel(hotel3,user1);
        Hotel hotel2 = new Hotel("Surprise", "Thailand", "Phuket", "Testova");
        Hotel hotel4 = new Hotel("general", "Thailand", "Phuket", "Testova");
        System.out.println(hotelRepository.entityToArrayList().toString());
        //System.out.println(hotelRepository.findEntityById(3530263436118915434l));
      // hotelRepository.deleteEntity(3530263436118915434l);
       // System.out.println(hotelRepository.findHotelByName("general").toString());
        //System.out.println(hotelRepository.entityToArrayList().toString());
       //  System.out.println(hotelRepository.addEntity(hotel2,user1));
        //System.out.println(hotelRepository.checkPresenceIdHotel(100000000l));
       // Entity entity = (Entity) hotel4;
       // GeneralRepository<Hotel> generalRepository = new GeneralRepository();
      //  hotelRepository.readFile();
   // hotelRepository.deleteEntity(6749521926943273009l,user1);
    // System.out.println(hotelRepository.addEntity(hotel4));
    //    hotelRepository.readFile();
      //  System.out.println( generalRepository.entityToArrayList());
     //   System.out.println(hotelRepository.entityToArrayList());
      //  System.out.println( hotelRepository.entityToArrayList());
    //    System.out.println(hotel4.toString());
        // generalRepository.getPathHotelDB();
        // generalRepository.setPathHotelDB(hotel2);
        // generalRepository.setPathDB(generalRepository.getPathHotelDB());
        // System.out.println(generalRepository.getPathDB());
        // System.out.println(hotelRepository.getPathDB());

        //System.out.println(hotelRepository.findHotelByCountryAndCity("Thailand","Phuket"));
        // hotelRepository.deleteHotel(hotel3,user1);
      //  System.out.println(hotelRepository.findEntityById(2655508917254710259l));
       // System.out.println(generalRepository.addEntity(entity));
        //  generalRepository.
        // System.out.println(generalRepository.checkPresenceId(3122410684202721229l));
        //System.out.println(generalRepository.generateId(hotel3));

       /* HotelController hotelController = new HotelController();
        System.out.println(hotelController.getHotelService().getHotelRepository().readFile());
        System.out.println("---");
      // System.out.println(hotelController.addHotel(hotel4,user1));*/
       // hotelController.deleteHotel(4326707008289774079l,user1);
       // System.out.println("---");
      //  System.out.println(hotelController.getHotelService().getHotelRepository().readFile());
    }
}

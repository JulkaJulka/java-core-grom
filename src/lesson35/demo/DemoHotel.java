package lesson35.demo;

import lesson35.repository.HotelRepository;

/**
 * Created by user on 30.11.2017.
 */
public class DemoHotel {
    public static void main(String[] args) throws Exception {
        HotelRepository hotelRepository = new HotelRepository();
        System.out.println( hotelRepository.findHotelByName("Riviera"));
        System.out.println( hotelRepository.findHotelByCity("Kyev"));
    }
}
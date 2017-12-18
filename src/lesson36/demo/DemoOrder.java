package lesson36.demo;

import lesson36.OrderRepository;
import lesson36.model.User;
import lesson36.model.UserType;

/**
 * Created by user on 30.11.2017.
 */
public class DemoOrder {
    public static void main(String[] args) throws Exception {
        User user1 = new User(1001,"Julia","qwerty", "Ukraine", UserType.ADMIN);
        OrderRepository orderRepository = new OrderRepository();
        //Order order = new Order(232l,user1,)
     //  System.out.println(orderRepository.findUserlById(112l));
     //   System.out.println(orderRepository.findRoomById(1401549786401447791l));
     //   System.out.println(orderRepository.findHotelById(3570593990644212812l));
       // orderRepository.bookRoom(5045396293690611794l,1001l,333l);
        orderRepository.cancelReservation(5045396293690611794l,1001l,333l);
    }
}

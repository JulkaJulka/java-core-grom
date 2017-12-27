package lesson36.demo;

import lesson36.model.Order;
import lesson36.model.User;
import lesson36.model.UserType;
import lesson36.repository.OrderRepository;

/**
 * Created by user on 30.11.2017.
 */
public class DemoOrder {
    public static void main(String[] args) throws Exception {
        User user1 = new User(1001,"Julia","qwerty", "Ukraine", UserType.ADMIN);
        OrderRepository orderRepository = new OrderRepository();
        user1.setUserType(UserType.USER);
      //  Order order = new Order(232l,user1);
     //  System.out.println(orderRepository.findUserlById(112l));
     //   System.out.println(orderRepository.findRoomById(1401549786401447791l));
     //   System.out.println(orderRepository.findHotelById(3570593990644212812l));
       orderRepository.bookRoom(3263465472588390554l,1001l,333l);
      // orderRepository.cancelReservation(3263465472588390554l,1001l,333l);

    }
}

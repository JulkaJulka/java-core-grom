package lesson35.demo;

import lesson35.model.Order;
import lesson35.model.User;
import lesson35.model.UserType;
import lesson35.repository.OrderRepository;

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
      // orderRepository.bookRoom(3263465472588390554l,1001l,333l);
        orderRepository.cancelReservation(2949157054379902010l,1001l,333l);

    }
}

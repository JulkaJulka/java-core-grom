package lesson36.demo;

import lesson36.controller.OrderController;
import lesson36.controller.UserController;
import lesson36.model.*;
import lesson36.repository.OrderRepository;
import lesson36.repository.RoomRepository;
import lesson36.repository.UserRepository;
import lesson36.service.UserService;

/**
 * Created by user on 30.11.2017.
 */
public class DemoOrder {
    public static void main(String[] args) throws Exception {
       // RoomRepository roomRepository = new RoomRepository();
       // UserRepository userRepository = new UserRepository();
       // System.out.println(roomRepository.readFile());
       User user1 = new User(1001,"Julia","qwerty", "Ukraine", UserType.ADMIN);
        user1.setUserType(UserType.ADMIN);

       // System.out.println(user1.isLoginStatus());
        OrderController orderController = new OrderController();
        orderController.getUserService().login("Julia", "gwerty");
       // UserController userController = new UserController();
       // userController.
       // UserService userService = new UserService();
      //  orderController.getUserService().login("Julia", "qwerty");
        orderController.bookRoom(3263465472588390554l, 1001l,333);
      //  System.out.println(orderRepository.entityToArrayList());
        //System.out.println(orderRepository.entityToArrayList());
   //  System.out.println(orderRepository.entityToArrayList());
      //  orderRepository.bookRoom(5045396293690611794l, 1001,2156367173470344604l);



        //user1.setUserType(UserType.USER);
      //  Order order = new Order(232l,user1);
  //    System.out.println(orderRepository.findEntityById(112l));
     //   System.out.println(orderRepository.findRoomById(1401549786401447791l));
     //   System.out.println(orderRepository.findHotelById(3570593990644212812l));

       // System.out.println(orderRepository.readFile());
   //     System.out.println( roomRepository.findEntityById(3263465472588390554l));
       // System.out.println(ent);
     //   User user = (User) userRepository.findEntityById(Long.parseLong(str[1]));
  //     orderRepository.bookRoom(3263465472588390554l,1001l,333l);

      // orderRepository.cancelReservation(3263465472588390554l,1001l,333l);

    }
}

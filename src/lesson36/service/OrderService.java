package lesson36.service;

import lesson36.controller.UserController;
import lesson36.model.User;
import lesson36.repository.OrderRepository;

/**
 * Created by user on 30.11.2017.
 */
public class OrderService {

    private OrderRepository orderRepository = new OrderRepository();
    private UserService userService = new UserService();
    private UserController userController = new UserController();

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

   public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        User user = (User) userService.getUserRepository().findEntityById(userId);
        if (!userService.isLoginStatus())
            throw new Exception("Booking room not available to you. Please sign in.");
        orderRepository.bookRoom(roomId, userId,hotelId);
    }
    public  void cancelReservation(long roomId, long userId)throws  Exception{
        User user = (User) userService.getUserRepository().findEntityById(userId);
        if (!user.isLoginStatus())
            throw new Exception("Cancel reservation not available to you. Please sign in.");
        orderRepository.cancelReservation(roomId, userId);
    }
}

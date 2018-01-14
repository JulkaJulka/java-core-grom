package lesson36.controller;

import lesson36.model.User;
import lesson36.service.OrderService;
import lesson36.service.UserService;

/**
 * Created by user on 30.11.2017.
 */
public class OrderController {
    private OrderService orderService = new OrderService();
    private UserService userService = new UserService();
    private UserController userController = new UserController();

    public UserController getUserController() {
        return userController;
    }

    public UserService getUserService() {
        return userService;
    }

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        orderService.bookRoom(roomId, userId,hotelId);
    }
    public  void cancelReservation(long roomId, long userId)throws  Exception{
        orderService.cancelReservation(roomId, userId);
    }
}

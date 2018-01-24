package lesson36.service;

import lesson202.Utils;
import lesson36.controller.UserController;
import lesson36.model.User;
import lesson36.repository.HotelRepository;
import lesson36.repository.OrderRepository;
import lesson36.repository.RoomRepository;
import lesson36.repository.UserRepository;

import static lesson36.Utils.*;
import static lesson36.repository.GeneralRepository.setPathDB;
import static lesson36.repository.RoomRepository.validateRoom;
import static lesson36.repository.HotelRepository.validateHotel;
import static lesson36.repository.UserRepository.validateUser;

/**
 * Created by user on 30.11.2017.
 */
public class OrderService {

    private OrderRepository orderRepository = new OrderRepository();
    private HotelRepository hotelRepository = new HotelRepository();
    private RoomRepository roomRepository = new RoomRepository();
    private UserRepository userRepository = new UserRepository();
    private UserService userService = new UserService();
    private UserController userController = new UserController();

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        userRepository.validateUser(userId);
        setPathDB(pathRoomDB);
        roomRepository.validateRoom(roomId);
        setPathDB(pathHotelDB);
        hotelRepository.validateHotel(hotelId);
        setPathDB(pathUserDB);

        User user = (User) userService.getUserRepository().findEntityById(userId);
        if (!userService.isLoginStatus())
            throw new Exception("Booking room not available to you. Please sign in.");

        orderRepository.bookRoom(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        setPathDB(pathRoomDB);
        roomRepository.validateRoom(roomId);
        setPathDB(pathUserDB);
        userRepository.validateUser(userId);

        User user = (User) userService.getUserRepository().findEntityById(userId);
        if (!user.isLoginStatus())
            throw new Exception("Cancel reservation not available to you. Please sign in.");

        setPathDB(pathOrderDB);
        orderRepository.cancelReservation(roomId, userId);
    }
}

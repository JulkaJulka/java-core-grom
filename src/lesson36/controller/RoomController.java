package lesson36.controller;

import lesson36.model.*;
import lesson36.service.RoomService;

import java.util.Collection;

/**
 * Created by user on 30.11.2017.
 */
public class RoomController {

    private RoomService roomService = new RoomService();

    public RoomService getRoomService() {
        return roomService;
    }

    public Collection<Room> findRooms(Filter filter) throws Exception{
        return roomService.findRooms(filter);
    }
    public Entity addRoom(Room room, User user)throws Exception{
        return roomService.addRoom(room, user);
    }
    public void deleteRoom(Long roomId,User user)throws Exception{
        roomService.deleteRoom(roomId, user);
    }
}

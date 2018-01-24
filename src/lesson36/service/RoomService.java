package lesson36.service;

import lesson36.model.*;
import lesson36.repository.RoomRepository;

import java.util.Collection;

import static lesson36.repository.RoomRepository.validateRoom;

/**
 * Created by user on 30.11.2017.
 */
public class RoomService {

    private RoomRepository roomRepository = new RoomRepository();

    public RoomRepository getRoomRepository() {
        return roomRepository;
    }

    public Collection<Room> findRooms(Filter filter) throws Exception {
        return roomRepository.findRooms(filter);
    }

    public Object addRoom(Room room, User user) throws Exception {
        validateRoom(room);
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("You have not rights to add room");
        return roomRepository.addEntity((Object) room);
    }

    public void deleteRoom(Long roomId, User user) throws Exception {
        roomRepository.validateRoom(roomId);
        if (user.getUserType() != UserType.ADMIN)
            throw new Exception("You have not rights to delete room");
        roomRepository.deleteEntity(roomId);
    }
}

package lesson36.service;

import lesson36.model.*;
import lesson36.repository.RoomRepository;

import java.util.Collection;

/**
 * Created by user on 30.11.2017.
 */
public class RoomService{
    private  RoomRepository roomRepository = new RoomRepository();

    public RoomRepository getRoomRepository() {
        return roomRepository;
    }
    public Collection<Room> findRooms(Filter  filter) throws Exception{
        return roomRepository.findRooms(filter);
    }
    public Entity addRoom(Room room, User user)throws Exception{
        if(user.getUserType() != UserType.ADMIN)
            throw new Exception("You have not rights to add room");
        return roomRepository.addEntity((Entity) room);
    }
    public void deleteRoom(Long roomId,User user)throws Exception{
        if(user.getUserType() != UserType.ADMIN)
            throw new Exception("You have not rights to delete room");
         roomRepository.deleteEntity(roomId);
    }
}

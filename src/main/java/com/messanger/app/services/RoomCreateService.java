package com.messanger.app.services;

import com.messanger.app.Exception.FealdExistException;
import com.messanger.app.models.Room;
import com.messanger.app.models.User;
import com.messanger.app.repositories.RoomRepository;
import com.messanger.app.repositories.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class RoomCreateService {
    public Room createRoom(String roomName, User user, RoomRepository roomRepository) throws FealdExistException {
        if(roomRepository.findByRoomname(roomName)!=null) {
            throw  new FealdExistException();
        }
        Room room = new Room(roomName);
        room.getMembers().add(user);
        user.getRooms().add(room);
        return room;
    }
}

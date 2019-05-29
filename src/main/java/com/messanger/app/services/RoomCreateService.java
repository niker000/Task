package com.messanger.app.services;

import com.messanger.app.Exception.FealdExistException;
import com.messanger.app.Interface.RoomCreateI;
import com.messanger.app.models.Room;
import com.messanger.app.models.User;
import com.messanger.app.repositories.RoomRepository;
import org.springframework.stereotype.Controller;

@Controller
public class RoomCreateService implements RoomCreateI {
    public Room createRoom(String roomName, User user, RoomRepository roomRepository) throws FealdExistException {
        if(roomRepository.findByRoomname(roomName)!=null) {
            throw  new FealdExistException();
        }
        Room room = new Room(roomName);
        user.getRooms().add(room);
        room.getMembers().add(user);

        return room;
    }
}

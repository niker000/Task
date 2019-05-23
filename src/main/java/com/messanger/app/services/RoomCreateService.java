package com.messanger.app.services;

import com.messanger.app.models.Room;
import com.messanger.app.models.User;
import org.springframework.stereotype.Controller;

@Controller
public class RoomCreateService {
    public Room createRoom(String roomName, User user) {
        Room room = new Room(roomName);
        room.getMembers().add(user);
        return room;
    }
}

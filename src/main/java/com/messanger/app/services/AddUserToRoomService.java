package com.messanger.app.services;

import com.messanger.app.Exception.FealdExistException;
import com.messanger.app.Interface.AddUserToRoomI;
import com.messanger.app.models.Room;
import com.messanger.app.models.User;
import com.messanger.app.repositories.RoomRepository;
import com.messanger.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AddUserToRoomService implements AddUserToRoomI {
    private RoomRepository roomRepository;
    private UserRepository userRepository;

    public AddUserToRoomService(RoomRepository roomRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    public boolean addUserToRoom(String roomname, String username) throws FealdExistException{
        if(!isNameValid(username)) {
            return false;
        }
        if(roomRepository.findByRoomname(roomname).getMembers().contains(userRepository.findByUsername(username))){
            return false;
        }

        Room room = roomRepository.findByRoomname(roomname);
        if(room.getMembers().add(userRepository.findByUsername(username))) {
            User user = userRepository.findByUsername(username);
            user.getRooms().add(room);
            roomRepository.save(room);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    private boolean isNameValid(String username) {
        if(userRepository.findByUsername(username)!=null) {
            return true;
        } else {
            return false;
        }
    }
}

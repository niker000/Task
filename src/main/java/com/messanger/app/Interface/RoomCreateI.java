package com.messanger.app.Interface;

import com.messanger.app.Exception.FealdExistException;
import com.messanger.app.models.Room;
import com.messanger.app.models.User;
import com.messanger.app.repositories.RoomRepository;

public interface RoomCreateI  {
    Room createRoom(String roomName, User user, RoomRepository roomRepository)throws FealdExistException;
}

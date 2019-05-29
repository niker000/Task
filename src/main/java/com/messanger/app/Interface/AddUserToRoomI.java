package com.messanger.app.Interface;

import com.messanger.app.Exception.FealdExistException;

public interface AddUserToRoomI {
    boolean addUserToRoom(String roomname, String username) throws FealdExistException;
}

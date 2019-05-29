package com.messanger.app.Interface;

import com.messanger.app.Exception.FealdExistException;
import com.messanger.app.models.User;

public interface RegistrationI {
    User addUser(String username, String password) throws FealdExistException;
}

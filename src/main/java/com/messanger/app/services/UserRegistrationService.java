package com.messanger.app.services;

import com.messanger.app.Exception.UserExistException;
import com.messanger.app.models.User;
import com.messanger.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRepository userRepository;

    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(String username, String password) throws UserExistException {
        if (userRepository.findByUsername(username) != null || username.isEmpty()) {
            throw new UserExistException();
        }
        User user = new User(username, password);
        user.setActive(true);
        return user;
    }
}

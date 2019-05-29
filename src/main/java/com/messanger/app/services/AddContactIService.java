package com.messanger.app.services;

import com.messanger.app.Interface.AddUserToContactI;
import com.messanger.app.models.User;
import com.messanger.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AddContactIService implements AddUserToContactI {
    private UserRepository userRepository;

    public AddContactIService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean addToContact(String username, User user) {
        User userToAdd = userRepository.findByUsername(username);
        if ((!isNameValid(username) || user.getContacts().contains(userToAdd)) && (user.getUsername() != username)) {
            return false;
        }
        user.getContacts().add(userToAdd);
        userRepository.save(user);
        return true;
    }

    private boolean isNameValid(String username) {
        if (userRepository.findByUsername(username) != null) {
            return true;
        } else {
            return false;
        }
    }
}

package com.messanger.app.services;

import com.messanger.app.models.User;
import com.messanger.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchService {

    private UserRepository userRepository;

    public UserSearchService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User searchUser(String search) {
        if (search != null && !search.isEmpty()) {
            return userRepository.findByUsername(search);
        } else {
            return null;
        }
    }
}

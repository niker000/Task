package com.messanger.app.services;

import com.messanger.app.models.User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ShowUserContactService {
    public Set<User> showContacts(User user) {
        return user.getContacts();
    }
}

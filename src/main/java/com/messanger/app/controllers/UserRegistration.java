package com.messanger.app.controllers;

import com.messanger.app.models.User;
import com.messanger.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserRegistration {
    @Autowired
    private UserRepository userRepository;
    public UserRegistration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/addUser")
    public String showAddUserPage() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String username,@RequestParam String password, Map<String, Object> model){
        User user = new User(username, password);
        userRepository.save(user);
        model.put("users", user);
        return "redirect:/login";
    }
}

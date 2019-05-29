package com.messanger.app.controllers;

import com.messanger.app.models.User;
import com.messanger.app.repositories.UserRepository;
import com.messanger.app.services.UserSearchService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class UserSearchController {
    private UserRepository userRepository;

    public UserSearchController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("search")
    public String serchUser(@RequestParam String username, Map<String, Object> model,@AuthenticationPrincipal User user) {
        model.put("users", new UserSearchService(userRepository).searchUser(username));
        return "home";
    }
}

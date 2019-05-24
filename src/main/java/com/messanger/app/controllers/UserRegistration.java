package com.messanger.app.controllers;

import com.messanger.app.Exception.UserExistException;
import com.messanger.app.models.User;
import com.messanger.app.repositories.UserRepository;
import com.messanger.app.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserRegistration {

    private UserRepository userRepository;
    public UserRegistration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/addUser")
    public String showAddUserPage() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String username,@RequestParam String password) throws UserExistException {
        UserRegistrationService userRegistrationService = new UserRegistrationService(userRepository);
        User user = userRegistrationService.addUser(username,password);
        userRepository.save(user);
        return "redirect:/login";
    }

    @ExceptionHandler(UserExistException.class)
    public String handleException(UserExistException uee) {
        return "redirect:/addUser";
    }

}
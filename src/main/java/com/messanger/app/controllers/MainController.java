package com.messanger.app.controllers;

import com.messanger.app.services.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    UserSearchService userSearchService;

    @GetMapping("/hello")
    public String showAll(Model model, String search) {
        model.addAttribute("users", userSearchService.searchUser(search));
        return "hello";
    }
}

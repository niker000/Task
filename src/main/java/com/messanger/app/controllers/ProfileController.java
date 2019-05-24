package com.messanger.app.controllers;

import com.messanger.app.models.Room;
import com.messanger.app.models.User;
import com.messanger.app.repositories.RoomRepository;
import com.messanger.app.repositories.UserRepository;
import com.messanger.app.services.RoomCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProfileController {
        @Autowired
    private RoomRepository roomRepository;
        @Autowired
        private UserRepository userRepository;
    public ProfileController(RoomRepository roomRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/userProfile")
    private String showProfile(Map<String, Object> model) {
        model.put("rooms", roomRepository.findAll());
        return "userProfile";
    }

    @GetMapping("/createRoom")
    public String createRoom() {
        return "createRoom";
    }

    @PostMapping("/createRoom")
    private String createRoom(@RequestParam String roomname, User user, Map<String, Object> model) {System.out.println("CREATE");
        user = userRepository.findByUsername("u1");
        Room room = new RoomCreateService().createRoom(roomname, user);
        roomRepository.save(room);
        Iterable<Room> rooms = roomRepository.findAll();
        return "redirect:/userProfile";
    }
}

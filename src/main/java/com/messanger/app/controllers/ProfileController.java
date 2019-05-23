package com.messanger.app.controllers;

import com.messanger.app.models.Room;
import com.messanger.app.models.User;
import com.messanger.app.repositories.RoomRepository;
import com.messanger.app.services.RoomCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class ProfileController {
    @Autowired
    private RoomRepository roomRepository;

    public ProfileController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/userProfile")
    private String showProfile(Map<String, Object> model) {
        return "userProfile";
    }

    @PostMapping("createRoom")
    private String createRoom(@RequestParam String roomname, User user, Map<String, Object> model) {
        Room room = new RoomCreateService().createRoom(roomname, user);
        roomRepository.save(room);
        Iterable<Room> rooms = roomRepository.findAll();
        model.put("rooms", rooms);
        return "userProfile";
    }
}

package com.messanger.app.controllers;

import com.messanger.app.Exception.FealdExistException;
import com.messanger.app.Interface.AddUserToRoomI;
import com.messanger.app.repositories.RoomRepository;
import com.messanger.app.repositories.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RoomController {
    private AddUserToRoomI addUser;
    private RoomRepository roomRepository;
    private UserRepository userRepository;

    public RoomController(AddUserToRoomI addUser, RoomRepository roomRepository) {
        this.addUser = addUser;
        this.roomRepository = roomRepository;
    }


    @GetMapping("/room/**")
    private String showRoom(@RequestParam(name = "roomname") String roomname,
                            @RequestParam(name = "message", defaultValue = "false") boolean message,
                            Map<String,  Object> model)
    {
        model.put("message", message);
        model.put("members", roomRepository.findByRoomname(roomname).getMembers());
        model.put("roomname", roomname);
        return "room";
    }

    @PostMapping("/room/addUserToRoom")
    private String addUserToRoom(@RequestParam String roomname,@RequestParam String username) throws FealdExistException {
        if(!addUser.addUserToRoom(roomname, username)) {
            return "redirect:/room/"+"?roomname="+roomname+"&"+"message=true";
        }
        return "redirect:/room/"+"?roomname="+roomname;
    }

    @ExceptionHandler(FealdExistException.class)
    public String handleException(FealdExistException uee) {
        return "redirect:/room/";
    }
}

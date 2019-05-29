package com.messanger.app.controllers;

import com.messanger.app.Exception.FealdExistException;
import com.messanger.app.Interface.AddUserToContactI;
import com.messanger.app.Interface.RoomCreateI;
import com.messanger.app.models.Room;
import com.messanger.app.models.User;
import com.messanger.app.repositories.RoomRepository;
import com.messanger.app.repositories.UserRepository;
import com.messanger.app.services.RoomCreateService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProfileController {
    private RoomCreateI roomCreateI;
    private RoomRepository roomRepository;
    private AddUserToContactI addContactService;
    private UserRepository userRepository;

    public ProfileController(RoomCreateI roomCreateI, RoomRepository roomRepository, AddUserToContactI addContactService, UserRepository userRepository) {
        this.roomCreateI = roomCreateI;
        this.roomRepository = roomRepository;
        this.addContactService = addContactService;
        this.userRepository = userRepository;
    }


    @GetMapping("/userProfile/**")
    private String showProfile(@AuthenticationPrincipal User user,
                               @RequestParam(name = "message", defaultValue = "false")boolean message,
                               Map<String, Object> model)
    {
        model.put("message", message);
        model.put("contacts", user.getContacts());
        model.put("rooms", roomRepository.findByMembers(user));
        return "userProfile";
    }

    @GetMapping("/createRoom")
    public String createRoom() {
        return "createRoom";
    }

    @PostMapping("/createRoom")
    public String createRoom(@RequestParam String roomname, @AuthenticationPrincipal User user) throws FealdExistException {
        Room room = roomCreateI.createRoom(roomname, user, roomRepository);
        roomRepository.save(room);
        return "redirect:/userProfile";
    }

    @PostMapping("/userProfile/addContact")
    public String addContact(@RequestParam String username, @AuthenticationPrincipal User user) {
        if(!addContactService.addToContact(username,user)) {
            return "redirect:/userProfile/?message=true";
        }
        return "redirect:/userProfile";
    }

    @GetMapping("/leave")
    public String leave() {
        return "redirect:/userProfile";
    }
    @PostMapping("/leave")
    public String leaveTheRoom(@RequestParam (name="roomname")String roomname, @AuthenticationPrincipal User user) {
        Room room = roomRepository.findByRoomname(roomname);
        user.getRooms().remove(roomRepository.findByRoomname(roomname));
        room.getMembers().remove(user);
        roomRepository.save(room);
        userRepository.save(user);
        return "redirect:/userProfile";
    }

    @ExceptionHandler(FealdExistException.class)
    public String handleException(FealdExistException uee) {
        return "redirect:/createRoom";
    }
}

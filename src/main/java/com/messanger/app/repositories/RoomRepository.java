package com.messanger.app.repositories;

import com.messanger.app.models.Room;
import com.messanger.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
     Room findByRoomname(String roomname);
     List<Room> findByMembers(User user);
}

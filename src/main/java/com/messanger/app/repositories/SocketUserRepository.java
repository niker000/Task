package com.messanger.app.repositories;

import com.messanger.app.models.SocketUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public interface SocketUserRepository extends CrudRepository<SocketUser, String> {
}

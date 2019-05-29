package com.messanger.app.WebSocket;

import com.messanger.app.models.SocketUser;
import com.messanger.app.repositories.SocketUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import java.security.Principal;
import java.util.Arrays;

public class WebSocketConnectionHandler<S> implements ApplicationListener<SessionConnectEvent> {
    private SocketUserRepository socketUserRepository;
    private SimpMessageSendingOperations messageSendingOperations;

    public WebSocketConnectionHandler(SocketUserRepository socketUserRepository, SimpMessageSendingOperations messageSendingOperations) {
        this.socketUserRepository = socketUserRepository;
        this.messageSendingOperations = messageSendingOperations;
    }

    public void onApplicationEvent(SessionConnectEvent event) {
        MessageHeaders headers = event.getMessage().getHeaders();
        Principal user = SimpMessageHeaderAccessor.getUser(headers);
        if(user == null) {
            return;
        }
        String id = SimpMessageHeaderAccessor.getSessionId(headers);
        socketUserRepository.save(new SocketUser(user.getName()));
        messageSendingOperations.convertAndSend("/topic/friends/signin", Arrays.asList(user.getName()));
    }
}

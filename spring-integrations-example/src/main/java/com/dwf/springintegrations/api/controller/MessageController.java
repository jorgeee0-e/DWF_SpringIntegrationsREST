package com.dwf.springintegrations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    @Qualifier("inputChannel")
    private MessageChannel inputChannel;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        inputChannel.send(MessageBuilder.withPayload(message).build());
        return ResponseEntity.ok("Mensaje recibido: "+message);
    }

}

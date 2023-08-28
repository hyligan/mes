package com.goit.mes.controllers;

import com.goit.mes.dto.ChatMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageRestController {
  private final List<ChatMessage> messages = new ArrayList<>();

  @PostMapping("/messages")
  public ResponseEntity<String> postMessage(@RequestBody ChatMessage chatMessage) {
    messages.add(chatMessage);
    return ResponseEntity.ok("Message received");
  }

  @GetMapping("/messages")
  public ResponseEntity<List<ChatMessage>> getMessages() {
    return ResponseEntity.ok(messages);
  }
}

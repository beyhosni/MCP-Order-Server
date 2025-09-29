package com.example.mcporder.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatClient chatClient;

    @Autowired
    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @PostMapping("/ask")
    @ResponseBody
    public String askModel(@RequestBody String userPrompt) {
        return chatClient.prompt()
                .user(userPrompt)
                .call()
                .content();
    }
}

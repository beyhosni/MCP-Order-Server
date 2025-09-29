package com.example.mcporder.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.ai.model.chat.ChatModel;
import org.springframework.ai.model.chat.ChatMessage;
import org.springframework.ai.model.chat.ChatCompletion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatModel chatModel;

    @Autowired
    public ChatController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @PostMapping("/ask")
    public String askModel(@RequestBody String userPrompt) {
        ChatMessage user = ChatMessage.ofUser(userPrompt);
        ChatCompletion completion = chatModel.chat(List.of(user));
        return completion.getMessages().stream()
                .map(m -> m.getContent().toString())
                .reduce("", (a, b) -> a + b + "\n");
    }
}

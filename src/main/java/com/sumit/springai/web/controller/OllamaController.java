package com.sumit.springai.web.controller;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai/ollama")
@CrossOrigin
public class OllamaController {

    private final OllamaChatClient chatClient;

    public OllamaController(OllamaChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/tell-me-a-joke")
    public String tellMeAJoke() {
        ChatResponse response = chatClient.call(
            new Prompt("Tell me a joke.", OllamaOptions.create().withModel("llama2").withTemperature(0.4f))
        );
        return response.getResult().getOutput().getContent();
    }
}

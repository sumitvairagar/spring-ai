package com.sumit.springai.web.controller;

import com.sumit.springai.web.dto.BookRequest;
import java.util.Map;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai/ollama")
@CrossOrigin
public class OllamaController {

    private final OllamaChatClient chatClient;

    public OllamaController(OllamaChatClient chatClient) {
        this.chatClient = chatClient;
    }

    OllamaOptions modelOptions = OllamaOptions.create().withModel("llama3:8b").withTemperature(0.4f);

    @GetMapping("/tell-me-a-joke")
    public String tellMeAJoke() {
        ChatResponse response = chatClient.call(new Prompt("Tell me a joke.", modelOptions));
        return response.getResult().getOutput().getContent();
    }

    @PostMapping("/generate-book")
    public String generateBook(@RequestBody BookRequest bookRequest) {
        var bookFormat =
            """
              The content should be formatted in json text including fields Intro, Preface, Chapters, Outro,
              the Content in Chapters should be well formatted in html
            """;

        var promptTemplate = new PromptTemplate(
            """
            write a book titled "${title}" in the ${genre} genre.
            The book should have ${totalChapters} chapters, and each chapter should be around ${wordsPerChapter} words.
            The book should be engaging and well-structured. ${bookFormat}
            """
        );

        Prompt prompt = promptTemplate.create(
            Map.of(
                "title",
                bookRequest.getTitle(),
                "genre",
                bookRequest.getGenre(),
                "totalChapters",
                bookRequest.getTotalChapters(),
                "wordsPerChapter",
                bookRequest.getWordsPerChapter(),
                "bookFormat",
                bookFormat
            )
        );
        Prompt finalPrompt = new Prompt(prompt.getContents(), modelOptions);

        ChatResponse response = chatClient.call(finalPrompt);
        return response.getResult().getOutput().getContent();
    }
}

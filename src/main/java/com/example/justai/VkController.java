package com.example.justai;

import java.io.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class VkController {
    private final VkApi vkApi = new VkApi();

    @PostMapping
    public @ResponseBody
    String getNewMessage(@RequestBody VkMessageRequest request) throws IOException {
        switch (request.type) {
            case MESSAGE_NEW -> {
                vkApi.sendMessage(request);
                return "OK";
            }
            case CONFIRMATION -> {
                return vkApi.apiConfig.getValidationToken();
            }
            default -> {
                return "OK";
            }
        }
    }
}

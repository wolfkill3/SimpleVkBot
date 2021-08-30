package com.example.justai;

import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class VkController {
    private final VkApi vkApi;

    @Autowired
    VkController() {
        this.vkApi = new VkApi();
    }

    @PostMapping
    public @ResponseBody
    String getNewMessage(@RequestBody VkMessageRequest request) throws IOException {
        vkApi.sendMessage(request);
        return "OK";
    }
}

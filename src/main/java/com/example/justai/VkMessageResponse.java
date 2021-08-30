package com.example.justai;

import java.util.*;

public class VkMessageResponse {
    public String accessToken;
    public Integer groupId;
    public Integer userId;
    public String version;
    public Integer randomId;
    public String message;

    public VkMessageResponse(VkMessageRequest request,
                             String accessToken,
                             String version,
                             String message) {
        this.accessToken = accessToken;
        this.version = version;
        this.message = message;
        Random random = new Random();
        randomId = random.nextInt(1000000);
        groupId = request.groupId;
        userId = request.object.peerId;
    }

    @Override
    public String toString() {
        return "access_token=" + accessToken
               + "&group_id=" + groupId
               + "&user_id=" + userId
               + "&v=" + version
               + "&random_id=" + randomId
               + "&message=" + message;
    }
}

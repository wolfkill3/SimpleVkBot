package com.example.justai;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class VkMessageRequest {
    public Message object;
    public String type;
    @JsonProperty("group_id")
    public Integer groupId;
    @JsonProperty("event_id")
    public String eventId;
}

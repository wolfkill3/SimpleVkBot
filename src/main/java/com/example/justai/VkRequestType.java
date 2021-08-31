package com.example.justai;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VkRequestType {
    MESSAGE_NEW("message_new"),
    CONFIRMATION("confirmation");
    @JsonValue
    public final String type;

    VkRequestType(final String type) {
        this.type = type;
    }
}

package com.example.justai;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Message {
    public Integer id;
    public Integer date;
    @JsonProperty("peer_id")
    public Integer peerId;
    @JsonProperty("from_id")
    public Integer fromId;
    public String text;
    @JsonProperty("random_id")
    public Integer randomId;
    public String ref;
    @JsonProperty("ref_source")
    public String refSource;
    public List<Object> attachment;
    public Boolean important;
    public Object geo;
    public String payload;
    public Object keyboard;
    @JsonProperty("fwd_messages")
    public List<String> fwdMessages;
    @JsonProperty("reply_message")
    public Object replyMessage;
    public Object action;
    @JsonProperty("admin_author_id")
    public Integer adminAuthorId;
    @JsonProperty("conversation_message_id")
    public Integer conversationMessageId;
    @JsonProperty("is_cropped")
    public Boolean isCropped;
    @JsonProperty("members_count")
    public Integer membersCount;
    @JsonProperty("update_time")
    public Integer updateTime;
    @JsonProperty("was_listened")
    public Boolean wasListened;
    @JsonProperty("pinned_at")
    public Integer pinnedAt;
    @JsonProperty("message_tag")
    public String messageTag;
}

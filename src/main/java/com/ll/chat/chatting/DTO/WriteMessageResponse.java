package com.ll.chat.chatting.DTO;

import com.ll.chat.chatting.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WriteMessageResponse {
    //private List<ChatMessage> chatMessages;
    private ChatMessage chatMessage;
    private int totalCount;
}

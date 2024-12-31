package com.ll.chat.chatting.DTO;

import com.ll.chat.chatting.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MessagesResponse {
    List<ChatMessage> chatMessages;
    private int totalCount;
}

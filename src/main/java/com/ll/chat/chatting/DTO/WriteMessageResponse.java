package com.ll.chat.chatting.DTO;

import com.ll.chat.chatting.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class WriteMessageResponse {
    private List<ChatMessage> chatMessages;

}

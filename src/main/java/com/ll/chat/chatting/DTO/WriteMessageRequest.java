package com.ll.chat.chatting.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class WriteMessageRequest {
    private String authorName;
    private String content;
}

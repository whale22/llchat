package com.ll.chat.chatting;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ChatMessage {
    private long id;
    private String authorName;
    private String content;
    private LocalDateTime createDate;

    public ChatMessage(String authorName, String content) {
        this.id = ChatMessageGenerator.generateId();
        this.authorName = authorName;
        this.content = content;
        this.createDate = LocalDateTime.now();
    }

    class ChatMessageGenerator {
        private static long id = 0;
        public static long generateId() {
            return id++;
        }
    }
}

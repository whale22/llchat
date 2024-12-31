package com.ll.chat.chatting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatController {
    @GetMapping("/chat/writeMessage")
    @ResponseBody
    public String getMessage() {
        return "응답입니다.";
    }

    @PostMapping("/chat/writeMessage")
    @ResponseBody
    public String writeMessage() {
        return "응답입니다.";
    }
}

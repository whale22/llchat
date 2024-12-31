package com.ll.chat.chatting;

import com.ll.chat.chatting.DTO.MessagesResponse;
import com.ll.chat.chatting.DTO.WriteMessageRequest;
import com.ll.chat.chatting.DTO.WriteMessageResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private List<ChatMessage> chatMessages = new ArrayList<>();


    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<WriteMessageResponse> writeMessage(@RequestBody WriteMessageRequest writeMessageRequest) {
        ChatMessage cm = new ChatMessage(writeMessageRequest.getAuthorName(), writeMessageRequest.getContent());
        chatMessages.add(cm);

        return new RsData("200", "메세지가 성공적으로 작성되었습니다.", new WriteMessageResponse(chatMessages));
    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<List<ChatMessage>> messages() {
        return new RsData("200","메세지가 성공적으로 로드되었습니다.", new MessagesResponse(chatMessages));
    }
}

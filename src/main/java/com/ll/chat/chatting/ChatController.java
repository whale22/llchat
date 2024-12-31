package com.ll.chat.chatting;

import com.ll.chat.chatting.DTO.MessagesRequest;
import com.ll.chat.chatting.DTO.MessagesResponse;
import com.ll.chat.chatting.DTO.WriteMessageRequest;
import com.ll.chat.chatting.DTO.WriteMessageResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private List<ChatMessage> chatMessages = new ArrayList<>();


    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<WriteMessageResponse> writeMessage(@RequestBody WriteMessageRequest writeMessageRequest) {
        ChatMessage cm = new ChatMessage(writeMessageRequest.getAuthorName(), writeMessageRequest.getContent());
        chatMessages.add(cm);

        return new RsData("200", "메세지가 성공적으로 작성되었습니다.", new WriteMessageResponse(cm, chatMessages.size()));
    }

//    @GetMapping("/messages")
//    @ResponseBody
//    public RsData<List<ChatMessage>> messages() {
//        return new RsData("200","메세지가 성공적으로 로드되었습니다.", new MessagesResponse(chatMessages, chatMessages.size()));
//    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<MessagesResponse> messages(MessagesRequest messagesRequest) {
        List<ChatMessage> messages = chatMessages;

        if (messagesRequest.fromId() != null) {
//            int index = -1;
//            for (int i = 0; i < messages.size(); i++) {
//                if (messages.get(i).getId() == messagesRequest.fromId()) {
//                    index = i;
//                    break;
//                }
//            }

            int index = IntStream.range(0,messages.size())
                    .filter(i-> chatMessages.get(i).getId() == messagesRequest.fromId())
                    .findFirst()
                    .orElse(-1);

            if(index != -1) {
                messages = messages.subList(index+1, messages.size());
            }

        }
//            if (index != -1) {
//                messages = messages.subList(index + 1, messages.size());
//            }
//        }
        return new RsData("200", "메세지 가져오기 성공", new MessagesResponse(messages, chatMessages.size()));
    }
}

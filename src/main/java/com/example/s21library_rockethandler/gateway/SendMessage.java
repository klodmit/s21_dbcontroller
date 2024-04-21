package com.example.s21library_rockethandler.gateway;

import com.example.s21library_rockethandler.dto.message.SendMessageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        url = "https://rocketchat-student.21-school.ru/api/v1",
        name = "sendMessage"
)
public interface SendMessage {
    @PostMapping(value = "/chat.postMessage")
     void sendMessage(@RequestBody SendMessageDto sendMessageDto,
                      @RequestHeader(name = "X-User-Id") String xUserId,
                      @RequestHeader(name = "X-Auth-Token") String xAuthToken);
}

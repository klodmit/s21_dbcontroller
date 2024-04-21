package com.example.s21library_rockethandler.service;

import com.example.s21library_rockethandler.dto.Auth.AuthDto;
import com.example.s21library_rockethandler.dto.UserDto;
import com.example.s21library_rockethandler.dto.message.SendMessageDto;
import com.example.s21library_rockethandler.gateway.AuthRequest;
import com.example.s21library_rockethandler.gateway.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class SendMessageService {
    private final AuthRequest authRequest;
    private final SendMessage sendMessage;

    public String getAuth(String nickName) {
        UserDto userDto = UserDto.builder().username("rhaellaa").password("9G3CR7XgNE").build();
        System.out.println(userDto);
        AuthDto authDto =  authRequest.getAccess(userDto);
        System.out.println(authDto);
        String generatedString = generateCode();
        SendMessageDto sendMessageDto = SendMessageDto.builder()
                .channel("@" + nickName)
                .text(generatedString)
                .build();
        System.out.println(sendMessageDto);
        sendMessage.sendMessage(sendMessageDto,
                                authDto.getData().getUserId(),
                                authDto.getData().getAuthToken());
        return generatedString;
    }

    private String generateCode() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 5;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String returnBookNotification(String nickName, String text) {
        UserDto userDto = UserDto.builder().username("rhaellaa").password("9G3CR7XgNE").build();
        System.out.println(userDto);
        AuthDto authDto =  authRequest.getAccess(userDto);
        System.out.println(authDto);

        SendMessageDto sendMessageDto = SendMessageDto.builder()
                .channel("@" + nickName)
                .text(text)
                .build();
        System.out.println(sendMessageDto);
        sendMessage.sendMessage(sendMessageDto,
                authDto.getData().getUserId(),
                authDto.getData().getAuthToken());
        return "Success";
    }
}

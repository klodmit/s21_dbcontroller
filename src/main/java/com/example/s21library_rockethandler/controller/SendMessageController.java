package com.example.s21library_rockethandler.controller;

import com.example.s21library_rockethandler.dto.S21User;
import com.example.s21library_rockethandler.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMessageController {
    private final SendMessageService service;
    @PostMapping("/registrationRequest")
    public String getTest(@RequestBody S21User s21User) {

        return service.getAuth(s21User.getNickName());
    }
}

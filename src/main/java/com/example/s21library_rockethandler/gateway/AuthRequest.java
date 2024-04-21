package com.example.s21library_rockethandler.gateway;

import com.example.s21library_rockethandler.dto.Auth.AuthDto;
import com.example.s21library_rockethandler.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        url = "https://rocketchat-student.21-school.ru/api/v1",
        name = "getAuth"
)
public interface AuthRequest {
    @PostMapping(value = "/login")
     AuthDto getAccess(@RequestBody UserDto userDto);
}

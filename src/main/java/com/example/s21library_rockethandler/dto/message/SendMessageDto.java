package com.example.s21library_rockethandler.dto.message;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendMessageDto {
    private String channel;
    private String text;
}

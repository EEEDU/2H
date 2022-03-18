package com.example.postman.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@Builder
public class Message {
    String message;
    String reason;

}

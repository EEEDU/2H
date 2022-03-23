package com.example.postman.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class User {
    private String name;
    private String initial;
    private Integer tries;
}

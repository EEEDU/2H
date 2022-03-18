package com.example.postman.models;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Key {
    Integer size;
    Integer tries;
    String generatedKey;
    Integer lefttries;
}

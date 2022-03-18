package com.examen.DDI.ExamenAPIEduardoGuerrero.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class User {
    String login;
    String password;
    String info;
    String age;
    String name;
    String salary;
    String auth_token;
}

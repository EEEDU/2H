package com.examen.DDI.ExamenAPIEduardoGuerrero.rest;

import com.examen.DDI.ExamenAPIEduardoGuerrero.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/")
public class ExamenRestController {

    @Autowired
    private User user;

    @GetMapping(path = "login")
    public ResponseEntity<User> login(@RequestParam String login, @RequestParam String password){
        this.user.setLogin(login);
        this.user.setPassword(password);
        this.user.setInfo("login success");
        return new ResponseEntity<>(this.user, HttpStatus.OK);
    }

    @PostMapping(path = "/user_info")
    public ResponseEntity<User> user_info() {

        this.user.setAge("11");
        this.user.setName("2000");
        this.user.setSalary("gorka");
        this.user.setAuth_token("7866aee4-a51d-11ec-b909-0242ac120002");
        return new ResponseEntity<>(this.user, HttpStatus.OK);
    }



}

package com.example.postman.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.postman.models.Key;
import com.example.postman.models.Answer;
import com.example.postman.models.Message;

import java.util.Arrays;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/")
public class ExamenRestController {

    @Autowired
    Key key;

    @GetMapping(path = "generateKey")
    public ResponseEntity<Key> generateKey(@RequestBody Key key) {
        key.setGeneratedKey("Edu");
        return new ResponseEntity<>(key, HttpStatus.OK);

    }

    @GetMapping(path = "changeTries")
    public ResponseEntity<Key> changeTries(@RequestParam Integer tries){
        this.key.setTries(tries);
        return new ResponseEntity<>(this.key, HttpStatus.OK);
    }

    @GetMapping(path = "answerSize/{size}")
    public ResponseEntity<Key> answerSize(@PathVariable("size") int size){
        this.key.setSize(size);
        String palabra = "";
        if (size == 3){
            palabra = "rojo,azul,naranja";
        }
        if (size == 5) {
            palabra = "rojo,azul,naranja,rosa,verde";
        }
        if (size == 7){
            palabra = "rojo,azul,naranja,rosa,verde,amarillo,gris";
        }
        this.key.setGeneratedKey(palabra);
        return new ResponseEntity<>(this.key, HttpStatus.OK);
    }

    @GetMapping(path = "checkAnswer")
    public ResponseEntity<Message> checkAnswer(@RequestBody Answer answer){
        String[] arrayKey = this.key.getGeneratedKey().split(",");
        boolean checkAnswer = Arrays.equals(arrayKey, answer.getAnswer());
        if (arrayKey.length != answer.getAnswer().length)
            return new ResponseEntity<>(
                    Message.builder().message("answer size invalid").reason("expected max size: 5").build(),
                    HttpStatus.NOT_ACCEPTABLE);
        else if (checkAnswer)
            return new ResponseEntity<>(Message.builder().message("answer correct").build(), HttpStatus.OK);
        else
            return new ResponseEntity<>(Message.builder().message("answer incorrect").build(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "checkTries")
    public ResponseEntity<Key> checkTries() {

        return new ResponseEntity<>(this.key, HttpStatus.CREATED);
    }

}

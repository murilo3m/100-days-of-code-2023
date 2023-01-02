package com.api.hundreddaysofcode2023.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "", maxAge = 3600)
@RequestMapping("/week-one")
public class WeekOneController {
    @GetMapping("/day-one/{age}")
    public ResponseEntity<Integer> dayOne(@PathVariable Integer age){
        Integer days = age * 365;
        return ResponseEntity.status(HttpStatus.OK).body(days);
    }

    @GetMapping("/day-two/{text}")
    public ResponseEntity<String> dayTwo(@PathVariable String text){
        Integer position = text.toLowerCase().indexOf("nemo");

        String message = "I can't find Nemo";
        if(position >= 0){
            message = "I found Nemo at ".concat(position.toString());
        }

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
package com.api.hundreddaysofcode2023.controllers;

import com.api.hundreddaysofcode2023.services.WeekOneService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "", maxAge = 3600)
@RequestMapping("/week-one")
public class WeekOneController {

    @Autowired
    WeekOneService weekOneService;

    @GetMapping("/day-one/{age}")
    @ApiOperation("Método que retorna idade em dias")
    public ResponseEntity<Integer> dayOne(@PathVariable Integer age){
        Integer days = weekOneService.daysOfAge(age);
        return ResponseEntity.status(HttpStatus.OK).body(days);
    }

    @GetMapping("/day-two/{text}")
    @ApiOperation("Método que procura a palavra Nemo em uma String")
    public ResponseEntity<String> dayTwo(@PathVariable String text){

        String message = weekOneService.findNemo(text);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
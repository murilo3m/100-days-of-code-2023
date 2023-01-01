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
}
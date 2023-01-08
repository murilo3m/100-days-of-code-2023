package com.api.hundreddaysofcode2023.controllers;

import com.api.hundreddaysofcode2023.services.WeekTwoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "", maxAge = 3600)
@RequestMapping("/week-two")
public class WeekTwoController {
    @Autowired
    WeekTwoService weekTwoService;

    @GetMapping("/day8/{digits}")
    @ApiOperation("Método que retorna digitos baseados nos números (como se fosse um celular antigo)")
    public ResponseEntity<ArrayList<String>> dayEight(@PathVariable String digits){
        ArrayList<String> digitsMapping = weekTwoService.digitsMapping(digits);
        return ResponseEntity.status(HttpStatus.OK).body(digitsMapping);
    }
}

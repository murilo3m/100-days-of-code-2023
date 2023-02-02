package com.api.hundreddaysofcode2023.controllers;

import com.api.hundreddaysofcode2023.services.Week04Service;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "", maxAge = 3600)
@RequestMapping("/week-04")
public class Week04Controller {

    @Autowired
    Week04Service week04Service;

    @GetMapping("/day22/{deforestedArea}")
    @ApiOperation(value = "Marcio Mello's Challenge - Método que retorna quantidade de campos de futebol baseado em um número de km²", notes = "Exemplo de input: \"1034\" - Resposta: 100.000 ")
    public ResponseEntity<Integer> dayTwentyTwo(@PathVariable Double deforestedArea){
        int footballFields = week04Service.convertToFootballFields(deforestedArea);
        return ResponseEntity.status(HttpStatus.OK).body(footballFields);
    }
}

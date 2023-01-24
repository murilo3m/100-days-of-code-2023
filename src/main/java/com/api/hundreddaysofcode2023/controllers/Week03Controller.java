package com.api.hundreddaysofcode2023.controllers;

import com.api.hundreddaysofcode2023.services.Week03Service;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "", maxAge = 3600)
@RequestMapping("/week-03")
public class Week03Controller {

    @Autowired
    Week03Service week03Service;

    @GetMapping("/day16/{number}")
    @ApiOperation(value = "NimGame - Método que retorna true or false se se você puder ganhar o jogo assumindo que tanto você como seu amigo joguem de forma ótima", notes = "Exemplo de input: \"anagram\" e \"nagaram\" - Resposta: true")
    public ResponseEntity<Boolean> daySixteen(@PathVariable Integer number){
        Boolean nimGame = week03Service.nimGame(number);
        return ResponseEntity.status(HttpStatus.OK).body(nimGame);
    }

    @GetMapping("/day17/{arr}")
    @ApiOperation(value = "Prison Break - Método que retorna quantidade de presos que podem ser liberados de acordo com regras", notes = "Exemplo de input: \"1, 1, 0, 0, 0, 1, 0\" - Resposta: 4")
    public ResponseEntity<Integer> daySeventeen(@PathVariable Integer[] arr){
        Integer freedPrisoners = week03Service.freedPrisoners(arr);
        return ResponseEntity.status(HttpStatus.OK).body(freedPrisoners);
    }
}

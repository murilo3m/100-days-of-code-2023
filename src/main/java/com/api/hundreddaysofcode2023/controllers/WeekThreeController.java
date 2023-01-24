package com.api.hundreddaysofcode2023.controllers;

import com.api.hundreddaysofcode2023.services.WeekThreeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "", maxAge = 3600)
@RequestMapping("/week-three")
public class WeekThreeController {

    @Autowired
    WeekThreeService weekThreeService;

    @GetMapping("/day16/{number}")
    @ApiOperation(value = "NimGame - Método que retorna true or false se se você puder ganhar o jogo assumindo que tanto você como seu amigo joguem de forma ótima", notes = "Exemplo de input: \"anagram\" e \"nagaram\" - Resposta: true")
    public ResponseEntity<Boolean> daySixteen(@PathVariable Integer number){
        Boolean nimGame = weekThreeService.nimGame(number);
        return ResponseEntity.status(HttpStatus.OK).body(nimGame);
    }
}

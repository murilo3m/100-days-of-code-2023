package com.api.hundreddaysofcode2023.controllers;

import com.api.hundreddaysofcode2023.services.Week04Service;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/day23/{input}")
    @ApiOperation(value = "The Dining Philosophers - Método muito loco de filósofos que não rolou implementar", notes = "")
    public ResponseEntity<String> dayTwentyThree(@PathVariable Integer input){
        String theDinningPhilosophers = week04Service.theDinningPhilosophers(input);
        return ResponseEntity.status(HttpStatus.OK).body(theDinningPhilosophers);
    }

    @GetMapping("/day24/{n}/{i}")
    @ApiOperation(value = "The Josephus Problem - Método que retorna o soldado sobrevivente baseado no input", notes = "Exemplo de input: \"41, 3\" - Resposta: 31")
    public ResponseEntity<Integer> dayTwentyFour(@PathVariable Integer n, @PathVariable Integer i){
        Integer josephus = week04Service.josephus(n, i);
        return ResponseEntity.status(HttpStatus.OK).body(josephus);
    }

    @GetMapping("/day25/{n}")
    @ApiOperation(value = "Coin Trouble - Método que retorna se da pra divir as moedas igualmente para os três filhos", notes = "Exemplo de input: \"[1, 2, 3, 2, 2, 2, 3]\" - Resposta: true")
    public ResponseEntity<Boolean> dayTwentyFive(@PathVariable int[] n){
        Boolean coinsDiv = week04Service.coinsDiv(n);
        return ResponseEntity.status(HttpStatus.OK).body(coinsDiv);
    }

    @GetMapping("/day26/{current}/{target}")
    @ApiOperation(value = "Briefcase Lock - Método que retorna menor número de voltas para transformar a trava", notes = "Exemplo de input: \"4089, 5672\" - Resposta: 9")
    public ResponseEntity<Integer> dayTwentySix(@PathVariable String current, @PathVariable String target){
        Integer minTurns = week04Service.minTurns(current, target);
        return ResponseEntity.status(HttpStatus.OK).body(minTurns);
    }

    @GetMapping("/day27/{tasks}/{n}")
    @ApiOperation(value = "Task Scheduler - Método que retorna menor número de unidades que uma CPU levará para concluir tarefas", notes = "Exemplo de input: \"4089, 5672\" - Resposta: 9")
    public ResponseEntity<Integer> dayTwentySeven(@PathVariable char[] tasks, @PathVariable Integer n){
        Integer leastInterval = week04Service.leastInterval(tasks, n);
        return ResponseEntity.status(HttpStatus.OK).body(leastInterval);
    }

    @GetMapping("/day28/{board}/{words}")
    @ApiOperation(value = "Task Scheduler - Método que retorna menor número de unidades que uma CPU levará para concluir tarefas", notes = "Exemplo de input: \"board = [\n" +
            "  ['o','a','a','n'],\n" +
            "  ['e','t','a','e'],\n" +
            "  ['i','h','k','r'],\n" +
            "  ['i','f','l','v']\n" +
            "]" +
            "words = [\"oath\",\"pea\",\"eat\",\"rain\"]\" - Resposta: \"words = [\\\"oath\\\",\\\"pea\\\",\\\"eat\\\",\\\"rain\\\"]\\\" - Resposta: 9\")\n")
    public ResponseEntity<List<String>> dayTwentyEight(@PathVariable char[][] board, @PathVariable String[] words){
        List<String> findWords = week04Service.findWords(board, words);
        return ResponseEntity.status(HttpStatus.OK).body(findWords);
    }
}

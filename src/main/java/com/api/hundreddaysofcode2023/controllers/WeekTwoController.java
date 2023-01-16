package com.api.hundreddaysofcode2023.controllers;

import com.api.hundreddaysofcode2023.services.WeekTwoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
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

    @GetMapping("/day9/{elevationMap}")
    @ApiOperation(value = "Método que retorna quantidade de água que pode ser retida baseado em um mapa de elevação", notes = "Exemplo de input: 4,2,0,3,2,5 -> Resposta: 9")
    public ResponseEntity<Integer> dayNine(@PathVariable Integer[] elevationMap){
        Integer trap = weekTwoService.trappingRainWeater(elevationMap);
        return ResponseEntity.status(HttpStatus.OK).body(trap);
    }

    @GetMapping("/day10/{n}")
    @ApiOperation(value = "Método que retorna quantas Árvores Binárias de Pesquisa Exclusivas estruturalmente únicos armazenam", notes = "Exemplo de input: 3 -> Resposta: 5")
    public ResponseEntity<Integer> dayTen(@PathVariable Integer n){
        Integer uniqueBSTs = weekTwoService.uniqueBSTs(n);
        return ResponseEntity.status(HttpStatus.OK).body(uniqueBSTs);
    }

    @GetMapping("/day11/{s}")
    @ApiOperation(value = "Método que retorna possíveis IPs IPV4 a partir de uma string", notes = "Exemplo de input: 25525511135 -> Resposta: [\"255.255.11.135\",\"255.255.111.35\"]")
    public ResponseEntity<ArrayList<String>> dayEleven(@PathVariable String s){
        ArrayList<String> ipAddresses = weekTwoService.restoreIpAddresses(s);
        return ResponseEntity.status(HttpStatus.OK).body(ipAddresses);
    }

    @GetMapping("/day12/{arr}")
    @ApiOperation(value = "Método que retorna se é uma \"moutain\", \"valley\" ou \"neither\" base em algumas regras", notes = "Exemplo de input: [3, 4, 5, 4, 3] -> Resposta: mountain")
    public ResponseEntity<String> dayTwelve(@PathVariable Integer[] arr){
        String landscapeType = weekTwoService.landscapeType(arr);
        return ResponseEntity.status(HttpStatus.OK).body(landscapeType);
    }

    @GetMapping("/day13/{arr}/{numBags}")
    @ApiOperation(value = "Método que retorna true ou false se é possível levar as compras nas sacolas, baseado em peso de itens e número de sacolas que você possui", notes = "Exemplo de input: [2, 1, 2, 5, 4, 3, 6, 1, 1, 9, 3, 2] - Resposta: true")
    public ResponseEntity<Boolean> dayThirteen(@PathVariable ArrayList<Integer> arr, @PathVariable Integer numBags){
        Boolean enoughBags = weekTwoService.enoughBags(arr, numBags);
        return ResponseEntity.status(HttpStatus.OK).body(enoughBags);
    }

    @GetMapping("/day14/{str}")
    @ApiOperation(value = "Método que retorna a criptografia de uma palavra baseado em algumas regras", notes = "Exemplo de input: apple - Resposta: 1lpp0aca")
    public ResponseEntity<String> dayFourteen(@PathVariable String str){
        String encrypted = weekTwoService.encrypt(str);
        return ResponseEntity.status(HttpStatus.OK).body(encrypted);
    }

    @GetMapping("/day15/{str}/{strAnagram}")
    @ApiOperation(value = "Método que retorna true or false se a strAnagram é um anagrama valido de str", notes = "Exemplo de input: \"anagram\" e \"nagaram\" - Resposta: true")
    public ResponseEntity<Boolean> dayFifteen(@PathVariable String str, @PathVariable String strAnagram){
        Boolean isAnagram = weekTwoService.isAnagram(str, strAnagram);
        return ResponseEntity.status(HttpStatus.OK).body(isAnagram);
    }

    @GetMapping("/day16/{number}")
    @ApiOperation(value = "NimGame - Método que retorna true or false se se você puder ganhar o jogo assumindo que tanto você como seu amigo joguem de forma ótima", notes = "Exemplo de input: \"anagram\" e \"nagaram\" - Resposta: true")
    public ResponseEntity<Boolean> daySixteen(@PathVariable Integer number){
        Boolean nimGame = weekTwoService.nimGame(number);
        return ResponseEntity.status(HttpStatus.OK).body(nimGame);
    }
}

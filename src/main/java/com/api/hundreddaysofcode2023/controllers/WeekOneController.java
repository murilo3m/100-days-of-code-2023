package com.api.hundreddaysofcode2023.controllers;

import com.api.hundreddaysofcode2023.services.WeekOneService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "", maxAge = 3600)
@RequestMapping("/week-one")
public class WeekOneController {

    @Autowired
    WeekOneService weekOneService;

    @GetMapping("/day1/{age}")
    @ApiOperation("Método que retorna idade em dias")
    public ResponseEntity<Integer> dayOne(@PathVariable Integer age){
        Integer days = weekOneService.daysOfAge(age);
        return ResponseEntity.status(HttpStatus.OK).body(days);
    }

    @GetMapping("/day2/{text}")
    @ApiOperation("Método que procura a palavra Nemo em uma String")
    public ResponseEntity<String> dayTwo(@PathVariable String text){

        String message = weekOneService.findNemo(text);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping("/day3/{skewers}")
    @ApiOperation(value = "Método que recebe uma lista de espetinhos e retorna quantida dos vegetarianos e não vegetarianos", notes = "Exemplo de request: \"--oooo-ooo--\", \"--xx--x--xx--\", \"--o---o--oo--\", \"--xx--x--ox--\", \"--xx--x--ox--\"")
    public ResponseEntity<String> dayThree(@PathVariable String skewers){
        String message = weekOneService.vegeterianSkewer(skewers);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping("/day4/{milesPerDay}")
    @ApiOperation(value = "Método que recebe uma lista de milhas percorridas por um atleta que está treinando para maratona e identifica os dias que houveram progresso", notes = "Exemplo de request: \"3,4,1,2\" ")
    public ResponseEntity<String> dayFour(@PathVariable String milesPerDay){
        String message = weekOneService.isJohnnyMakingProgress(milesPerDay);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping("/day5/{unorganizedSocks}")
    @ApiOperation("Método que recebe uma sequência de meias e devolve quantidade de pares, cada letra representa uma meia e é organizada com suas respectivas iguais")
    public ResponseEntity<Integer> dayFive(@PathVariable String unorganizedSocks){
        Integer pairOfSocks = weekOneService.pairOfSocks(unorganizedSocks);
        return ResponseEntity.status(HttpStatus.OK).body(pairOfSocks);
    }

    @GetMapping("/day6/{number}")
    @ApiOperation("Método que recebe um número inteiro e retorna o próximo número primo")
    public ResponseEntity<Integer> daySix(@PathVariable Integer number){
        Integer prime = weekOneService.nextPrime(number);
        return ResponseEntity.status(HttpStatus.OK).body(prime);
    }

    //Método que faz o merge e ordena dois arrays númericos
    @GetMapping("/day7/{array1}/{array2}")
    @ApiOperation("Método que faz o merge e ordena dois arrays númericos")
    public ResponseEntity<ArrayList<Integer>> daySeven(@PathVariable ArrayList<Integer> array1, @PathVariable ArrayList<Integer> array2){
        ArrayList<Integer> mergedArrays = weekOneService.arrayMerger(array1,array2);
        return ResponseEntity.status(HttpStatus.OK).body(mergedArrays);
    }
}
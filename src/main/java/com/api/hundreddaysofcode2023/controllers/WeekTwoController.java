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
    public ResponseEntity<Integer> dayNine(@PathVariable Integer n){
        Integer uniqueBSTs = weekTwoService.uniqueBSTs(n);
        return ResponseEntity.status(HttpStatus.OK).body(uniqueBSTs);
    }
}

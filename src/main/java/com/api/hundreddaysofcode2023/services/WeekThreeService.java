package com.api.hundreddaysofcode2023.services;

import org.springframework.stereotype.Service;

@Service
public class WeekThreeService {
    //Dado n, o número de pedras na pilha, retorne verdadeiro se você puder ganhar o jogo assumindo que tanto você como seu amigo joguem de forma ótima, caso contrário, retorne falso.
    public boolean nimGame(Integer n) {
        return (n & 1) == 1;
    }
}

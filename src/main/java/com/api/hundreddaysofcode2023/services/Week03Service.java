package com.api.hundreddaysofcode2023.services;

import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class Week03Service {
    //Dado n, o número de pedras na pilha, retorne verdadeiro se você puder ganhar o jogo assumindo que tanto você como seu amigo joguem de forma ótima, caso contrário, retorne falso.
    public boolean nimGame(Integer n) {
        return (n & 1) == 1;
    }

    public Integer freedPrisoners(Integer[] prison) {
        return (int) IntStream.range(0, prison.length)
                .filter(i -> prison[i] == 1)
                .peek(i -> {
                    for (int j = i; j < prison.length; j++) {
                        prison[j] = (prison[j] == 0) ? 1 : 0;
                    }
                })
                .count();
    }
}

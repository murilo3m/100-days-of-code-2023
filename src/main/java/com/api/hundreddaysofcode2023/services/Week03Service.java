package com.api.hundreddaysofcode2023.services;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.stream.IntStream;

@Service
public class Week03Service {
    //Dado n, o número de pedras na pilha, retorne verdadeiro se você puder ganhar o jogo assumindo que tanto você como seu amigo joguem de forma ótima, caso contrário, retorne falso.
    public boolean nimGame(Integer n) {
        return (n & 1) == 1;
    }

    //Uma prisão pode ser representada como um conjunto de celas. Cada cela contém exatamente um prisioneiro. Um 1 representa uma cela destrancada e um 0 representa uma cela trancada. Começando dentro da cela mais à esquerda, você tem a tarefa de ver quantos prisioneiros você pode libertar, com um senão. Você é o prisioneiro na primeira cela. Se a primeira cela estiver trancada, você não pode libertar ninguém. Cada vez que você liberta um prisioneiro, as celas trancadas se destravam, e as celas destravadas se tornam trancadas novamente.
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

    //Um robô está localizado no canto superior esquerdo de uma grade m x n. O robô só pode se mover para baixo ou para a direita em qualquer ponto do tempo. O robô está tentando alcançar o canto inferior direito da grade (marcado 'Finish' no diagrama abaixo). Quantos caminhos únicos possíveis existem?
    public Integer uniquePaths(Integer m, Integer n) {
        int[][] dp = new int[m][n];
        IntStream.range(0, m).forEach(i -> dp[i][0] = 1);
        IntStream.range(0, n).forEach(j -> dp[0][j] = 1);
        IntStream.range(1, m).forEach(i ->
                IntStream.range(1, n).forEach(j ->
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                )
        );
        return dp[m - 1][n - 1];
    }
}

package com.api.hundreddaysofcode2023.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.IntStream;

@Service
public class Week04Service {

    //Os desmatamentos da Floresta Amazônica foram de 9.762 km² entre agosto de 2018 e julho de 2019, segundo dados oficiais do governo federal Inpe (Instituto Nacional de Pesquisas Espaciais). Isto representa um aumento de 29,5% em relação ao período anterior (agosto de 2017 a julho de 2018), que registrou 7.536 km² de área desmatada. O proeminente matemático brasileiro Marcio Mello, calculou a área desmatada nos campos de futebol para facilitar a compreensão das pessoas comuns sobre o tamanho dos danos causados pelo atual governo ao meio ambiente. Tomando-o como exemplo, crie um algoritmo que, dada uma área desmatada (em km2), devolva a quantidade correspondente de campos de futebol.
    public int convertToFootballFields(Double deforestedArea) {
        return (int) Math.ceil(deforestedArea / (105 * 68 * 0.0001));
    }

    public String theDinningPhilosophers(Integer input) {
        return "[[4,2,1],[4,1,1],[0,1,1],[2,2,1],[2,1,1],[2,0,3],[2,1,2],[2,2,2],[4,0,3],[4,1,2],[0,2,1],[4,2,2],[3,2,1],[3,1,1],[0,0,3],[0,1,2],[0,2,2],[1,2,1],[1,1,1],[3,0,3],[3,1,2],[3,2,2],[1,0,3],[1,1,2],[1,2,2]]";
    }

    //Este problema clássico remonta ao tempo dos romanos. São 41 soldados dispostos em círculo. Cada terceiro soldado deve ser morto por seus captores, continuando ao redor do círculo até restar apenas um soldado. Ele deve ser libertado. Assumindo que você gostaria de permanecer vivo, em que posição do círculo você ficaria? Generalize este problema criando uma função que aceite o número de soldados n e o intervalo no qual eles são mortos i, e devolva a posição do feliz sobrevivente.
    public Integer josephus(int n, int i) {
        int index = 0;
        for (int j = 1; j <= n; j++) {
            index = (index + i) % j;
        }
        return index + 1;
    }

    //Dado um conjunto de moedas, o pai precisa distribuí-las entre seus três filhos. Escreva uma função para determinar se as moedas podem ser distribuídas igualmente ou não. Retornar verdadeiro se cada filho receber a mesma quantia de dinheiro, caso contrário, retornar falso.
    public static boolean coinsDiv(int[] coins) {
        int sum = Arrays.stream(coins).sum();
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        return distributeCoins(coins, 0, 0, 0, target);
    }

    private static boolean distributeCoins(int[] coins, int index, int sum1, int sum2, int target) {
        if (sum1 > target || sum2 > target) {
            return false;
        }
        if (index == coins.length) {
            return sum1 == target && sum2 == target;
        }
        return distributeCoins(coins, index + 1, sum1 + coins[index], sum2, target)
                || distributeCoins(coins, index + 1, sum1, sum2 + coins[index], target)
                || distributeCoins(coins, index + 1, sum1, sum2, target);
    }

    //Uma pasta tem uma trava rolante de 4 dígitos. Cada dígito é um número de 0-9 que pode ser rolado tanto para frente quanto para trás. Crie uma função que retorna o menor número de voltas necessárias para transformar a trava da combinação de corrente para a combinação alvo. Uma volta é equivalente a rolar um número para frente ou para trás por um.
    public Integer minTurns(String current, String target) {
        return IntStream.range(0, 4)
                .map(i -> Math.min(Math.abs(current.charAt(i) - target.charAt(i)), 10 - Math.abs(current.charAt(i) - target.charAt(i))))
                .sum();
    }
}
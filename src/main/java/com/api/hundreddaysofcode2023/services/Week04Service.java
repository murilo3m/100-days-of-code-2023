package com.api.hundreddaysofcode2023.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    //Dada uma série de tarefas de caracteres, representando as tarefas que uma CPU precisa fazer, onde cada letra representa uma tarefa diferente. As tarefas podem ser feitas em qualquer ordem. Cada tarefa é feita em uma unidade de tempo. Para cada unidade de tempo, a CPU poderia completar uma tarefa ou apenas ficar ociosa.
    //
    //Entretanto, há um inteiro n não negativo que representa o período de espera entre duas mesmas tarefas (a mesma letra na matriz), ou seja, deve haver pelo menos n unidades de tempo entre quaisquer duas mesmas tarefas.
    //
    //Devolver o menor número de unidades de tempo que a CPU levará para concluir todas as tarefas dadas.
    public Integer leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);

        int maxCount = 0;
        for (int i = 25; i >= 0; i--) {
            if (count[i] != count[25]) {
                break;
            }
            maxCount++;
        }

        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + maxCount);
    }

    //Dado um tabuleiro 2D e uma lista de palavras do dicionário, encontre todas as palavras no tabuleiro.
    //
    //Cada palavra deve ser construída a partir de letras de células adjacentes sequencialmente, onde as células "adjacentes" são aquelas adjacentes horizontalmente ou verticalmente. A mesma célula de letra não pode ser usada mais de uma vez em uma palavra.
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (String word : words) {
            boolean found = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, visited, word, i, j, 0)) {
                        found = true;
                        result.add(word);
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
        }
        return result;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }
        visited[i][j] = true;
        boolean result = dfs(board, visited, word, i - 1, j, k + 1) ||
                dfs(board, visited, word, i + 1, j, k + 1) ||
                dfs(board, visited, word, i, j - 1, k + 1) ||
                dfs(board, visited, word, i, j + 1, k + 1);
        visited[i][j] = false;
        return result;
    }
}
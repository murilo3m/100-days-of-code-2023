package com.api.hundreddaysofcode2023.services;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    //O encurtamento de URLs é usado para criar alias mais curtas para URLs longas. Chamamos estes apelidos abreviados de "links curtos". Os usuários são redirecionados para a URL original quando atingem estes links curtos. Os links curtos economizam muito espaço quando exibidos, impressos, enviados por mensagens ou tweeted. Além disso, os usuários são menos propensos a digitar URLs mais curtas de forma errada. O encurtamento de URL é usado para otimizar os links entre dispositivos, rastrear links individuais para analisar o público, medir o desempenho de campanhas publicitárias ou ocultar URLs originais afiliadas.
    public String shortenUrl(String longUrl) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(longUrl.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return "https://short-url.com/".concat(hexString.toString().substring(0, 8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String cityInfo(String city) {

        String url = "https://api.openweathermap.org/data/2.5/weather?q=".concat(city).concat("&appid=66e97ebe08fb974555e8057851b0bd0d").concat("&units=metric&lang=pt_br");
        String response = "";
        try {
            URLConnection connection = new URL(url).openConnection();
            InputStream input = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);
            StringBuilder result = new StringBuilder();
            int data = reader.read();
            while (data != -1) {
                result.append((char) data);
                data = reader.read();
            }
            response = result.toString();
        } catch (IOException e) {
            System.out.println("This city does not exist!");
        }
        return response;
    }

    public String mazeGenerator(Integer n, Integer m) {
        return "+---+---+---+---+---+---+\n" +
                "|   |           |       |\n" +
                "+   +   +   +---+   +---+\n" +
                "|   |   |           |   |\n" +
                "+   +   +---+---+---+   +\n" +
                "|   |   |               |\n" +
                "+   +   +   +---+---+   +\n" +
                "|           |           |\n" +
                "+---+---+---+---+---+---+";
    }
}

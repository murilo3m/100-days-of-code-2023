package com.api.hundreddaysofcode2023.services;

import org.springframework.stereotype.Service;

@Service
public class Week04Service {

    //Os desmatamentos da Floresta Amazônica foram de 9.762 km² entre agosto de 2018 e julho de 2019, segundo dados oficiais do governo federal Inpe (Instituto Nacional de Pesquisas Espaciais). Isto representa um aumento de 29,5% em relação ao período anterior (agosto de 2017 a julho de 2018), que registrou 7.536 km² de área desmatada. O proeminente matemático brasileiro Marcio Mello, calculou a área desmatada nos campos de futebol para facilitar a compreensão das pessoas comuns sobre o tamanho dos danos causados pelo atual governo ao meio ambiente. Tomando-o como exemplo, crie um algoritmo que, dada uma área desmatada (em km2), devolva a quantidade correspondente de campos de futebol.
    public int convertToFootballFields(Double deforestedArea) {
        return (int) Math.ceil(deforestedArea / (105 * 68 * 0.0001));
    }
}

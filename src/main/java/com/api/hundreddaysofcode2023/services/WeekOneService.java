package com.api.hundreddaysofcode2023.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WeekOneService {

    //Método responsável por retornar idade em dias
    public Integer daysOfAge(Integer age){
        return age * 365;
    }

    //Método responsável por buscar a palavra "nemo" em uma string
    public String findNemo(String text){
        Integer position = text.toLowerCase().indexOf("nemo");

        String message = "I can't find Nemo";
        if(position >= 0){
            message = "I found Nemo at ".concat(position.toString());
        }

        return message;
    }

    //Método responsável por distinguir espetinhos vegetarianos (que contém "-o") e não vegetarianos (que contém "-x")
    public String vegeterianSkewer(String skewers){
        String[] sk = skewers.split(",");
        Integer vegSkewers = 0;
        Integer nonVegSkewers = 0;
        for (String skewer: sk) {
            if (skewer.toLowerCase().indexOf("x") == -1) {
                vegSkewers++;
            } else {
                nonVegSkewers++;
            }
        }
        return String.format("Vegetarian Skewers: %s, non vegetarian skewers: %s", vegSkewers, nonVegSkewers);
    }
}

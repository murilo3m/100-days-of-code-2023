package com.api.hundreddaysofcode2023.services;

import org.springframework.stereotype.Service;

@Service
public class WeekOneService {

    //Método responsável por retornar idade em dias
    public Integer daysOfAge(Integer age){
        return age * 365;
    }

    public String findNemo(String text){
        Integer position = text.toLowerCase().indexOf("nemo");

        String message = "I can't find Nemo";
        if(position >= 0){
            message = "I found Nemo at ".concat(position.toString());
        }

        return message;
    }
}

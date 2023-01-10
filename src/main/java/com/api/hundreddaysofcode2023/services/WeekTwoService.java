package com.api.hundreddaysofcode2023.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WeekTwoService {
    public ArrayList<String> digitsMapping(String digits){

        ArrayList<String> mapping = new ArrayList<String>();
        return mapping;
    }

    //Método que retorna quantidade de água que pode ser retida baseado em um mapa de elevação
    public Integer trappingRainWeater(Integer[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                int minHeight = height[left];
                left++;
                while (left < right && height[left] < minHeight) {
                    maxWater += minHeight - height[left];
                    left++;
                }
            } else {
                int minHeight = height[right];
                right--;
                while (left < right && height[right] < minHeight) {
                    maxWater += minHeight - height[right];
                    right--;
                }
            }
        }
        return maxWater;
    }

}

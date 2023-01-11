package com.api.hundreddaysofcode2023.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WeekTwoService {

    //Dada uma string contendo dígitos de 2 a 9 inclusive, retorne todas as combinações de letras possíveis que o número pode representar. Devolva a resposta em qualquer ordem.
    public ArrayList<String> digitsMapping(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = Character.getNumericValue(digits.charAt(i));
            while (res.get(0).length() == i) {
                String t = res.remove(0);
                for (char s : mapping[num].toCharArray()) {
                    res.add(t + s);
                }
            }
        }
        return res;
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

    //Dado n, quantos BSTs (árvores binárias de busca) estruturalmente únicos armazenam valores 1 ... n?
    public Integer uniqueBSTs(Integer n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    //Dado uma string "s" contendo apenas dígitos, retorne todos os possíveis endereços IP(ipv4) que podem ser obtidos.
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        backtrackIpAddresses(s, 0, new ArrayList<>(), res);
        return res;
    }


    //Função de Apoio day-11
    private void backtrackIpAddresses(String s, int start, ArrayList<String> parts, ArrayList<String> res) {
        if (parts.size() == 4 && start == s.length()) {
            res.add(String.join(".", parts));
            return;
        }

        if (start >= s.length() || parts.size() >= 4) {
            return;
        }

        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String segment = s.substring(start, i + 1);
            if (isValidIpAddresses(segment)) {
                parts.add(segment);
                backtrackIpAddresses(s, i + 1, parts, res);
                parts.remove(parts.size() - 1);
            }
        }
    }

    //Função de Apoio day-11
    private boolean isValidIpAddresses(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}

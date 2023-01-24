package com.api.hundreddaysofcode2023.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Week02Service {

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

    //Método para definir se é uma montanha, valley ou neither.
    public String landscapeType(Integer[] arr) {
        int n = arr.length;
        boolean increasing = true;
        boolean decreasing = true;
        int peak = -1;
        int trough = -1;
        for (int i = 1; i < n - 1; i++) {
            if (increasing && arr[i] > arr[i - 1]) {
                if (decreasing) {
                    decreasing = false;
                    peak = i;
                }
            } else if (decreasing && arr[i] < arr[i - 1]) {
                if (increasing) {
                    increasing = false;
                    trough = i;
                }
            } else {
                return "neither";
            }
        }

        if (peak != -1 && !decreasing) {
            return "mountain";
        } else if (trough != -1 && !increasing) {
            return "valley";
        } else {
            return "neither";
        }
    }

    //Crie uma função que leve dois parâmetros, uma lista dos pesos de cada item e o número de sacolas que você está carregando. Retornar True se houver sacolas suficientes para conter todos os itens, caso contrário, False.
    public Boolean enoughBags(ArrayList<Integer> itemWeights, Integer numBags) {
        int totalWeight = itemWeights.stream().mapToInt(Integer::intValue).sum();
        return totalWeight <= numBags * 10;
    }

    //Função que codifica uma determinada entrada com estas etapas
    public String encrypt(String input) {
        String vowels = "aeiouAEIOU";
        Map<Character, Character> replaceMap = Map.of(
                'a', '0',
                'e', '1',
                'i', '2',
                'o', '3',
                'u', '4',
                'A', '5',
                'E', '6',
                'I', '7',
                'O', '8',
                'U', '9'
        );
        // Step 1: Reverse the input
        String reversed = new StringBuilder(input).reverse().toString();
        // Step 2: Replace vowels
        String encrypted = reversed.chars()
                .mapToObj(c -> (char) c)
                .map(c -> vowels.indexOf(c) != -1 ? replaceMap.get(c) : c)
                .map(String::valueOf)
                .collect(Collectors.joining());

        //Step 3: Add "aca" to the end of the word
        return encrypted.concat("aca");
    }

    //Dadas duas strings s e t , escreva uma função para determinar se t é um anagrama de s.
    public Boolean isAnagram(String s, String t) {
        // Convert the strings to lowercase
        s = s.toLowerCase();
        t = t.toLowerCase();
        // Sort the characters in the strings
        String sortedS = s.chars()
                .sorted()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining());
        String sortedT = t.chars()
                .sorted()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining());
        // Compare the sorted strings
        return sortedS.equals(sortedT);
    }
}

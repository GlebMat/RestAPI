package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Services {
    public StringBuilder countCharInStr(String str) {
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        int count;
        for (char c : str.toCharArray()) {
            count = 1;
            if (characterFrequencyMap.containsKey(c)) {
                count = characterFrequencyMap.get(c);
                count++;
                characterFrequencyMap.put(c, count);
            }
            characterFrequencyMap.put(c, count);
        }
        StringBuilder newStr = new StringBuilder();
        characterFrequencyMap.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).forEach(entry -> newStr.append("\"" + entry.getKey() + "\"" + ":" + entry.getValue() + ", "));
        return newStr;
    }
}

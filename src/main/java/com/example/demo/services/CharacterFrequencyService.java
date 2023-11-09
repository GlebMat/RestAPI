package com.example.demo.services;

import com.example.demo.dto.CharacterFrequencyDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CharacterFrequencyService {
    public List<CharacterFrequencyDTO> getCharacterFrequencies(String str) {
        Map<Character, Integer> characterFrequencyMap = new TreeMap<>();
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

        return characterFrequencyMap.entrySet().stream().map(entry -> new CharacterFrequencyDTO(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingInt(CharacterFrequencyDTO::getFrequency).reversed())
                .collect(Collectors.toList());
    }
}

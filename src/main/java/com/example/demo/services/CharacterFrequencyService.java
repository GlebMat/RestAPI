package com.example.demo.services;

import com.example.demo.dto.CharacterFrequencyDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CharacterFrequencyService {
    public List<CharacterFrequencyDTO> getCharacterFrequencies(String str) {
        Map<Character, Integer> characterFrequencyMap = new TreeMap<>();

        for (char c : str.toCharArray()) {
            int count = characterFrequencyMap.getOrDefault(c, 0);
            characterFrequencyMap.put(c, count + 1);
        }

        return characterFrequencyMap.entrySet().stream().map(entry -> new CharacterFrequencyDTO(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingInt(CharacterFrequencyDTO::getFrequency).reversed())
                .collect(Collectors.toList());
    }
}

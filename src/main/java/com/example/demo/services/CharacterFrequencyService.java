package com.example.demo.services;

import com.example.demo.dto.CharacterFrequencyDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CharacterFrequencyService {
    public String getCharacterFrequencies(String inputString) {
        Map<Character, Integer> characterFrequencyMap = new TreeMap<>();

        for (char c : inputString.toCharArray()) {
            int count = characterFrequencyMap.getOrDefault(c, 0);
            characterFrequencyMap.put(c, count + 1);
        }
        List<CharacterFrequencyDTO> frequencies = characterFrequencyMap.entrySet().stream().map(entry -> new CharacterFrequencyDTO(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingInt(CharacterFrequencyDTO::getFrequency).reversed())
                .collect(Collectors.toList());
        return this.listStringHandler(frequencies);

    }

    private String listStringHandler(List<CharacterFrequencyDTO> frequencies) {
        StringBuilder result = new StringBuilder();
        for (CharacterFrequencyDTO dto : frequencies) {
            result.append("\"").append(dto.getCharacter()).append("\":").append(dto.getFrequency()).append(", ");
        }
        if (result.length() > 1) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }

}

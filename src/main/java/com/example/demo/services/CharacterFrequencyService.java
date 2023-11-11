package com.example.demo.services;

import com.example.demo.dto.CharacterFrequencyDTO;
import com.example.demo.exception.InvalidInputException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CharacterFrequencyService {
    public String getCharacterFrequencies(@NotBlank @Pattern(regexp = "[a-zA-Zа-яА-Я0-9]+") String inputString) {
        try {
            validateInput(inputString);

            Map<Character, Integer> characterFrequencyMap = new TreeMap<>();

            for (char c : inputString.toCharArray()) {
                int count = characterFrequencyMap.getOrDefault(c, 0);
                characterFrequencyMap.put(c, count + 1);
            }
            List<CharacterFrequencyDTO> frequencies = characterFrequencyMap.entrySet().stream().map(entry -> new CharacterFrequencyDTO(entry.getKey(), entry.getValue()))
                    .sorted(Comparator.comparingInt(CharacterFrequencyDTO::getFrequency).reversed())
                    .collect(Collectors.toList());
            return this.listStringHandler(frequencies);
        } catch (InvalidInputException e) {
            return e.getMessage();
        }
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

    private boolean isValidInput(String inputString) {
        return inputString.matches("[a-zA-Zа-яА-Я0-9]+");
    }

    private void validateInput(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new InvalidInputException("Параметр 'inputString' не может быть пустым.");
        }
        if (!isValidInput(inputString)) {
            throw new InvalidInputException("Недопустимые символы во входной строке.");
        }
    }
}

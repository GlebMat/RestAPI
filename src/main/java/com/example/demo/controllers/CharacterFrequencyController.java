package com.example.demo.controllers;

import com.example.demo.dto.CharacterFrequencyDTO;
import com.example.demo.services.CharacterFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TestJobMG")
public class CharacterFrequencyController {
    private final CharacterFrequencyService characterFrequencyService;

    @Autowired
    public CharacterFrequencyController(CharacterFrequencyService characterFrequencyService) {
        this.characterFrequencyService = characterFrequencyService;
    }

    @GetMapping("/charInStr/{Strings}")
    public String getCharacterFrequencies(@PathVariable("Strings") String inputString) {
        List<CharacterFrequencyDTO> frequencies  = characterFrequencyService.getCharacterFrequencies(inputString);
        StringBuilder result = new StringBuilder();
        for (CharacterFrequencyDTO dto:frequencies) {
            result.append("\"").append(dto.getCharacter()).append("\":").append(dto.getFrequency()).append(", ");
        }
        if (result.length()>1){
            result.setLength(result.length()-2);
        }
        return result.toString();
    }

}

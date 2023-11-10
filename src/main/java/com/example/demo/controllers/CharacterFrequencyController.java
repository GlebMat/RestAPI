package com.example.demo.controllers;

import com.example.demo.dto.CharacterFrequencyDTO;
import com.example.demo.services.CharacterFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TestJobMG")
public class CharacterFrequencyController {
    private final CharacterFrequencyService characterFrequencyService;

    @Autowired
    public CharacterFrequencyController(CharacterFrequencyService characterFrequencyService) {
        this.characterFrequencyService = characterFrequencyService;
    }

    @GetMapping("/charInStr")
    public String getCharacterFrequencies(@RequestParam("inputString") String inputString) {
        List<CharacterFrequencyDTO> frequencies = characterFrequencyService.getCharacterFrequencies(inputString);

        return characterFrequencyService.listStringHandler(frequencies);
    }

}

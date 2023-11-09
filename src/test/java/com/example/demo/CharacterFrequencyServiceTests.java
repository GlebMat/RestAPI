package com.example.demo;

import com.example.demo.dto.CharacterFrequencyDTO;
import com.example.demo.services.CharacterFrequencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CharacterFrequencyServiceTests {
    @Autowired
    private CharacterFrequencyService characterFrequencyService;

    @Test
    void testGetCharacterFrequencies() {
        String inputString = "aaaaabcccc";
        List<CharacterFrequencyDTO> expected = new  ArrayList<>();
        expected.add(new CharacterFrequencyDTO('a', 5));
        expected.add(new CharacterFrequencyDTO('c', 4));
        expected.add( new CharacterFrequencyDTO('b', 1));

        List<CharacterFrequencyDTO> result = characterFrequencyService.getCharacterFrequencies(inputString);

        assertEquals(expected.size(), result.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getCharacter(), result.get(i).getCharacter());
            assertEquals(expected.get(i).getFrequency(), result.get(i).getFrequency());
        }
    }
}

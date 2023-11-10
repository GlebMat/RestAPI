package com.example.demo;

import com.example.demo.dto.CharacterFrequencyDTO;
import com.example.demo.services.CharacterFrequencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CharacterFrequencyServiceTests {
    @Autowired
    private CharacterFrequencyService characterFrequencyService;

    @Test
    void testGetCharacterFrequencies() {

        String inputString = "aaaaabcccc";
        String expectedOutput = "\"a\":5, \"c\":4, \"b\":1";

        String result = characterFrequencyService.getCharacterFrequencies(inputString);

        assertEquals(expectedOutput, result);
    }
}

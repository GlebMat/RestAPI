package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CharacterFrequencyControllerTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetCharacterFrequencies() {
        String inputString = "aaaaabcccc";
        String expectedOutput = "\"a\":5, \"c\":4, \"b\":1";

        String result = restTemplate.getForObject("/TestJobMG/charInStr/{Strings}", String.class, inputString);

        assertEquals(expectedOutput, result);
    }
}

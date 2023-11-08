package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCountCharInStr() {
        String inputString = "aaaaabcccc";
        String expectedOutput = "\"a\":5, \"c\":4, \"b\":1,";

        StringBuilder result = restTemplate.getForObject("/TestJobMG/charInStr/{Strings}", StringBuilder.class, inputString);

        assertEquals(expectedOutput, result.toString());
    }


}

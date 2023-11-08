package com.example.demo;

import com.example.demo.services.Services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServicesTests {
    private Services services;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        services = new Services();
    }

    @Test
    void testCountCharInStr() {
        String inputString = "aaaaabcccc";
        StringBuilder expectedResult = new StringBuilder("\"a\":5, \"c\":4, \"b\":1,");

        StringBuilder result = services.countCharInStr(inputString);

        assertEquals(expectedResult.toString(), result.toString());
    }
}

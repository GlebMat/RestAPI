package com.example.demo.controllers;

import com.example.demo.services.CharacterFrequencyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/TestJobMG")
@Validated
public class CharacterFrequencyController {
    private final CharacterFrequencyService characterFrequencyService;

    @Autowired
    public CharacterFrequencyController(CharacterFrequencyService characterFrequencyService) {
        this.characterFrequencyService = characterFrequencyService;
    }

    @GetMapping("/charInStr")
    public String getCharacterFrequencies(@Valid @NotBlank @Pattern(regexp = "[a-zA-Zа-яА-Я0-9]+") @RequestParam("inputString") String inputString) {
        return characterFrequencyService.getCharacterFrequencies(inputString);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(ex.getBindingResult().getFieldError().getDefaultMessage());
    }
}

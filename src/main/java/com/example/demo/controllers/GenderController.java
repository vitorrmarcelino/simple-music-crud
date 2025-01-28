package com.example.demo.controllers;

import com.example.demo.domain.gender.Gender;
import com.example.demo.services.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gender")
@RequiredArgsConstructor
public class GenderController {
    @Autowired
    private GenderService genderService;

    @GetMapping
    public ResponseEntity getAllGenders(){
        List<Gender> allGenders = genderService.getAllGenders();
        return ResponseEntity.ok(allGenders);
    }
}

package com.example.demo.controllers;

import com.example.demo.domain.country.Country;
import com.example.demo.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class ContryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity getAllCountries(){
        List<Country> allCountries = countryService.getAllArtists();
        return ResponseEntity.ok(allCountries);
    }
}

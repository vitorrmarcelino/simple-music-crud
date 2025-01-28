package com.example.demo.services;

import com.example.demo.domain.artist.Artist;
import com.example.demo.domain.country.Country;
import com.example.demo.domain.country.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllArtists(){
        List<Country> countries = countryRepository.findAll();

        return countries;
    }
}

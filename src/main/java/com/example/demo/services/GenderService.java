package com.example.demo.services;

import com.example.demo.domain.gender.Gender;
import com.example.demo.domain.gender.GenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenderService {
    @Autowired
    private GenderRepository genderRepository;

    public List<Gender> getAllGenders(){
        List<Gender> allGenders = genderRepository.findAll();
        return allGenders;
    }
}

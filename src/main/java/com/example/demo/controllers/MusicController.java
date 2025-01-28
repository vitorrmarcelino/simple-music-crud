package com.example.demo.controllers;

import com.example.demo.domain.music.Music;
import com.example.demo.domain.music.RequestMusicDTO;
import com.example.demo.services.MusicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
@RequiredArgsConstructor
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping
    public ResponseEntity getAllMusics(){
        List<Music> allMusics = musicService.getAllMusics();
        return ResponseEntity.ok(allMusics);
    }

    @PostMapping
    public ResponseEntity registerMusic(@RequestBody @Valid RequestMusicDTO data){
        Music newMusic = musicService.registerMusic(data);
        return ResponseEntity.ok(newMusic);
    }
}

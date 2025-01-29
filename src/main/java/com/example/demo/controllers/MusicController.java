package com.example.demo.controllers;

import com.example.demo.domain.music.RequestMusicDTO;
import com.example.demo.domain.music.ResponseMusicDTO;
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
        List<ResponseMusicDTO> allMusics = musicService.getAllMusics();
        return ResponseEntity.ok(allMusics);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMusicById(@PathVariable Integer id){
        ResponseMusicDTO music = musicService.getMusicById(id);
        return ResponseEntity.ok(music);
    }

    @PostMapping
    public ResponseEntity registerMusic(@RequestBody @Valid RequestMusicDTO data){
        ResponseMusicDTO newMusic = musicService.registerMusic(data);
        return ResponseEntity.ok(newMusic);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMusic(@RequestBody @Valid RequestMusicDTO data, @PathVariable Integer id){
        ResponseMusicDTO updatedMusic = musicService.updateMusic(data, id);
        return ResponseEntity.ok(updatedMusic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMusic(@PathVariable Integer id){
        ResponseMusicDTO deletedMusic = musicService.deleteMusic(id);
        return ResponseEntity.ok(deletedMusic);
    }
}

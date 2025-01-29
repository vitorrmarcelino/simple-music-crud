package com.example.demo.controllers;

import com.example.demo.domain.artist.RequestArtistDTO;
import com.example.demo.domain.artist.ResponseArtistDTO;
import com.example.demo.domain.artist.ResponseArtistWithMusicsDTO;
import com.example.demo.services.ArtistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
@RequiredArgsConstructor
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ResponseEntity getAllArtists() {
        List<ResponseArtistDTO> allArtists = artistService.getAllArtists();
        return ResponseEntity.ok(allArtists);
    }

    @GetMapping("/{id}")
    public ResponseEntity getArtistById(@PathVariable Integer id) {
        ResponseArtistWithMusicsDTO artist = artistService.getArtistById(id);
        return ResponseEntity.ok(artist);
    }

    @PostMapping
    public ResponseEntity registerArtist(@RequestBody @Valid RequestArtistDTO data) {
        ResponseArtistDTO newArtist = artistService.registerArtist(data);
        return ResponseEntity.ok(newArtist);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateArtist(@RequestBody @Valid RequestArtistDTO data, @PathVariable Integer id) {
        ResponseArtistDTO updatedArtist = artistService.updateArtist(data, id);
        return ResponseEntity.ok(updatedArtist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteArtist(@PathVariable Integer id) {
        ResponseArtistDTO deletedArtist = artistService.deleteArtist(id);
        return ResponseEntity.ok(deletedArtist);
    }
}
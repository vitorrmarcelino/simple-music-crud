package com.example.demo.controllers;

import com.example.demo.domain.artist.Artist;
import com.example.demo.domain.artist.ArtistRepository;
import com.example.demo.domain.artist.RequestArtistDTO;
import com.example.demo.services.ArtistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artist")
@RequiredArgsConstructor
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ResponseEntity getAllArtists() {
        var allArtists = artistService.getAllArtists();
        return ResponseEntity.ok(allArtists);
    }

    @GetMapping("/{id}")
    public ResponseEntity getArtistById(@PathVariable Integer id) {
        var artist = artistService.getArtistById(id);
        return ResponseEntity.ok(artist);
    }

    @PostMapping
    public ResponseEntity registerArtist(@RequestBody @Valid RequestArtistDTO data) {
        Artist newArtist = artistService.registerArtist(data);
        return ResponseEntity.ok(newArtist);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateArtist(@RequestBody @Valid RequestArtistDTO data, @PathVariable Integer id) {
        Artist updatedArtist = artistService.updateArtist(data, id);
        return ResponseEntity.ok(updatedArtist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteArtist(@PathVariable Integer id) {
        Artist deletedArtist = artistService.deleteArtist(id);
        return ResponseEntity.ok(deletedArtist);
    }
}
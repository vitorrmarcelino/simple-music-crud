package com.example.demo.services;

import com.example.demo.domain.artist.Artist;
import com.example.demo.domain.artist.ArtistRepository;
import com.example.demo.domain.artist.RequestArtistDTO;
import com.example.demo.domain.country.Country;
import com.example.demo.domain.country.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private CountryRepository countryRepository;

    public List<Artist> getAllArtists(){
        List<Artist> artists = artistRepository.findAll();

        return artists;
    }

    public Artist getArtistById(Integer id){
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Artist not found"));;

        return artist;
    }

    public Artist registerArtist(RequestArtistDTO requestArtistDTO){
        Country country = countryRepository.findById(requestArtistDTO.pais_id()).orElseThrow(() -> new IllegalArgumentException("Country not found"));
        Artist newArtist = new Artist();
        newArtist.setNome(requestArtistDTO.nome());
        newArtist.setPais(country);

        return artistRepository.save(newArtist);
    }

    public Artist updateArtist(RequestArtistDTO requestArtistDTO, Integer id){
        Artist updatedArtist = artistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Artist not found"));;
        Country country = countryRepository.findById(requestArtistDTO.pais_id()).orElseThrow(() -> new IllegalArgumentException("Country not found"));

        updatedArtist.setNome(requestArtistDTO.nome());
        updatedArtist.setPais(country);

        return artistRepository.save(updatedArtist);
    }

    public Artist deleteArtist(Integer id){
        Artist deletedArtist = artistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Artist not found"));;

        artistRepository.delete(deletedArtist);

        return deletedArtist;
    }
}

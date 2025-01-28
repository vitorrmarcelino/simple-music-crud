package com.example.demo.services;

import com.example.demo.domain.artist.Artist;
import com.example.demo.domain.artist.ArtistRepository;
import com.example.demo.domain.artist.RequestArtistDTO;
import com.example.demo.domain.artist.ResponseArtistDTO;
import com.example.demo.domain.country.Country;
import com.example.demo.domain.country.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private CountryRepository countryRepository;

    public List<ResponseArtistDTO> getAllArtists(){
        List<Artist> artists = artistRepository.findAll();

        List<ResponseArtistDTO> responseArtists = artists.stream()
                .map(artist -> new ResponseArtistDTO(artist.getId(), artist.getNome(), artist.getPais().getNome()))
                .collect(Collectors.toList());

        return responseArtists;
    }

    public ResponseArtistDTO getArtistById(Integer id){
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Artist not found"));;

        return new ResponseArtistDTO(artist.getId(), artist.getNome(), artist.getPais().getNome());
    }

    public ResponseArtistDTO registerArtist(RequestArtistDTO requestArtistDTO){
        Country country = countryRepository.findById(requestArtistDTO.pais_id()).orElseThrow(() -> new IllegalArgumentException("Country not found"));
        Artist newArtist = new Artist();
        newArtist.setNome(requestArtistDTO.nome());
        newArtist.setPais(country);
        artistRepository.save(newArtist);
        return new ResponseArtistDTO(newArtist.getId(), newArtist.getNome(), newArtist.getPais().getNome());
    }

    public ResponseArtistDTO updateArtist(RequestArtistDTO requestArtistDTO, Integer id){
        Artist updatedArtist = artistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Artist not found"));;
        Country country = countryRepository.findById(requestArtistDTO.pais_id()).orElseThrow(() -> new IllegalArgumentException("Country not found"));

        updatedArtist.setNome(requestArtistDTO.nome());
        updatedArtist.setPais(country);

        return new ResponseArtistDTO(updatedArtist.getId(), updatedArtist.getNome(), updatedArtist.getPais().getNome());
    }

    public ResponseArtistDTO deleteArtist(Integer id){
        Artist deletedArtist = artistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Artist not found"));;

        artistRepository.delete(deletedArtist);

        return new ResponseArtistDTO(deletedArtist.getId(), deletedArtist.getNome(), deletedArtist.getPais().getNome());
    }
}

package com.example.demo.services;

import com.example.demo.domain.artist.Artist;
import com.example.demo.domain.artist.ArtistRepository;
import com.example.demo.domain.gender.Gender;
import com.example.demo.domain.gender.GenderRepository;
import com.example.demo.domain.music.Music;
import com.example.demo.domain.music.MusicRepository;
import com.example.demo.domain.music.RequestMusicDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MusicService {
    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private GenderRepository genderRepository;

    public List<Music> getAllMusics() {
        List<Music> musicas = musicRepository.findAll();
        return musicas;
    }

    public Music registerMusic(RequestMusicDTO requestMusicDTO) {
        Music newMusic = new Music();
        newMusic.setNome(requestMusicDTO.nome());
        newMusic.setLancamento(requestMusicDTO.lancamento());

        List<Artist> artists = artistRepository.findAllById(requestMusicDTO.artistasId());
        List<Gender> genders = genderRepository.findAllById(requestMusicDTO.generosId());

        newMusic.setArtistas(artists);
        newMusic.setGeneros(genders);

        return musicRepository.save(newMusic);
    }

}

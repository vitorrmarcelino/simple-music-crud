package com.example.demo.services;

import com.example.demo.domain.artist.Artist;
import com.example.demo.domain.artist.ArtistRepository;
import com.example.demo.domain.gender.Gender;
import com.example.demo.domain.gender.GenderRepository;
import com.example.demo.domain.music.Music;
import com.example.demo.domain.music.MusicRepository;
import com.example.demo.domain.music.RequestMusicDTO;
import com.example.demo.domain.music.ResponseMusicDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<ResponseMusicDTO> getAllMusics() {
        List<Music> musicas = musicRepository.findAll();

        return musicas.stream()
                .map(musica -> new ResponseMusicDTO(
                        musica.getId(),
                        musica.getNome(),
                        musica.getLancamento(),
                        musica.getArtistas().stream()
                                .map(artist -> new ResponseMusicDTO.ArtistDTO(artist.getNome()))
                                .collect(Collectors.toList()),
                        musica.getGeneros().stream()
                                .map(gender -> new ResponseMusicDTO.GenderDTO(gender.getNome()))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public ResponseMusicDTO getMusicById(Integer id){
        Music music = musicRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Music not found"));

        return new ResponseMusicDTO(music.getId(), music.getNome(), music.getLancamento(),
                music.getArtistas().stream()
                .map(artist -> new ResponseMusicDTO.ArtistDTO(artist.getNome()))
                .collect(Collectors.toList()),
                music.getGeneros().stream()
                        .map(gender -> new ResponseMusicDTO.GenderDTO(gender.getNome()))
                        .collect(Collectors.toList()));
    }

    public ResponseMusicDTO registerMusic(RequestMusicDTO requestMusicDTO) {
        Music newMusic = new Music();
        newMusic.setNome(requestMusicDTO.nome());
        newMusic.setLancamento(requestMusicDTO.lancamento());

        List<Artist> artists = artistRepository.findAllById(requestMusicDTO.artistasId());
        List<Gender> genders = genderRepository.findAllById(requestMusicDTO.generosId());

        newMusic.setArtistas(artists);
        newMusic.setGeneros(genders);

        musicRepository.save(newMusic);

        return new ResponseMusicDTO(
                newMusic.getId(),
                newMusic.getNome(),
                newMusic.getLancamento(),
                newMusic.getArtistas().stream()
                        .map(artist -> new ResponseMusicDTO.ArtistDTO(artist.getNome()))
                        .collect(Collectors.toList()),
                newMusic.getGeneros().stream()
                        .map(gender -> new ResponseMusicDTO.GenderDTO(gender.getNome()))
                        .collect(Collectors.toList()));
    }

    public ResponseMusicDTO updateMusic(RequestMusicDTO requestMusicDTO, Integer id){
        Music updatedMusic = musicRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Music not found"));
        updatedMusic.setNome(requestMusicDTO.nome());
        updatedMusic.setLancamento(requestMusicDTO.lancamento());

        List<Artist> artists = artistRepository.findAllById(requestMusicDTO.artistasId());
        List<Gender> genders = genderRepository.findAllById(requestMusicDTO.generosId());

        updatedMusic.setArtistas(artists);
        updatedMusic.setGeneros(genders);

        musicRepository.save(updatedMusic);

        return new ResponseMusicDTO(
                updatedMusic.getId(),
                updatedMusic.getNome(),
                updatedMusic.getLancamento(),
                updatedMusic.getArtistas().stream()
                        .map(artist -> new ResponseMusicDTO.ArtistDTO(artist.getNome()))
                        .collect(Collectors.toList()),
                updatedMusic.getGeneros().stream()
                        .map(gender -> new ResponseMusicDTO.GenderDTO(gender.getNome()))
                        .collect(Collectors.toList()));
    }

    public ResponseMusicDTO deleteMusic (Integer id){
        Music deletedMusic = musicRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Music not found"));

        ResponseMusicDTO musicDTO = new ResponseMusicDTO(
                deletedMusic.getId(),
                deletedMusic.getNome(),
                deletedMusic.getLancamento(),
                deletedMusic.getArtistas().stream()
                        .map(artist -> new ResponseMusicDTO.ArtistDTO(artist.getNome()))
                        .collect(Collectors.toList()),
                deletedMusic.getGeneros().stream()
                        .map(gender -> new ResponseMusicDTO.GenderDTO(gender.getNome()))
                        .collect(Collectors.toList()));

        musicRepository.delete(deletedMusic);

        return musicDTO;
    }

}

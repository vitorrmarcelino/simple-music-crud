package com.example.demo.domain.artist;

import java.util.List;

public record ResponseArtistWithMusicsDTO(Integer id, String nome, String pais, List<MusicDTO> musicas) {
    public record MusicDTO(String nome){}
}

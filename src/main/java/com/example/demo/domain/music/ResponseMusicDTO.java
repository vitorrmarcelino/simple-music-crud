package com.example.demo.domain.music;



import java.util.Date;
import java.util.List;

public record ResponseMusicDTO(Integer id, String nome, Date lancamento, List<ArtistDTO> artistas, List<GenderDTO> generos) {
    public record ArtistDTO(String nome){}
    public record GenderDTO(String nome){}
}

package com.example.demo.domain.music;

import com.example.demo.domain.artist.Artist;
import com.example.demo.domain.gender.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Table(name = "musica")
@Entity(name = "music")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Music {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private Date lancamento;

    @JsonManagedReference //Exibe lista apenas na ponta com managed, o back não exibe lista
//    @JsonIgnoreProperties("musicas") //Exibe lista nas duas pontas
//    @JsonIgnore // Não exibe lista em nenhuma
    @ManyToMany
    @JoinTable(
            name = "artista_musica",
            joinColumns = @JoinColumn(name = "musica_id"),
            inverseJoinColumns = @JoinColumn(name = "artista_id")
    )
    private List<Artist> artistas;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "genero_musica",
            joinColumns = @JoinColumn(name = "musica_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private List<Gender> generos;
}

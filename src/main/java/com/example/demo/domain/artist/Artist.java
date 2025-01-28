package com.example.demo.domain.artist;

import com.example.demo.domain.country.Country;
import com.example.demo.domain.music.Music;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.sql.results.graph.Fetch;

import java.util.List;


@Table(name = "artista")
@Entity(name = "artist")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Artist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Country pais;

    //@JsonIgnoreProperties("artistas") //Exibe lista nas duas pontas
    @JsonBackReference //Exibe lista apenas na ponta com managed, o back não exibe lista
    //@JsonIgnore // Não exibe lista em nenhuma
    @ManyToMany
    @JoinTable(
            name = "artista_musica",
            joinColumns = @JoinColumn(name = "artista_id"),
            inverseJoinColumns = @JoinColumn(name = "musica_id")
    )
    private List<Music> musicas;

}

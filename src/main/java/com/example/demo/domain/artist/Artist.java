package com.example.demo.domain.artist;

import com.example.demo.domain.country.Country;
import jakarta.persistence.*;
import lombok.*;


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

}

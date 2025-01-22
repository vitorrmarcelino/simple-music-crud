package com.example.demo.domain.country;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "pais")
@Entity(name = "country")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
}

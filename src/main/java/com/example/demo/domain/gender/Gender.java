package com.example.demo.domain.gender;

import jakarta.persistence.*;
import lombok.*;

@Table(name="genero")
@Entity(name="gender")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gender {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
}

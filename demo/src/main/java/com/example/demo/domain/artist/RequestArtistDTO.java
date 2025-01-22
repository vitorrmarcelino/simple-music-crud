package com.example.demo.domain.artist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestArtistDTO(@NotBlank String nome, @NotNull Integer pais_id) {
}

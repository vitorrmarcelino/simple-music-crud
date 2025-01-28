package com.example.demo.domain.music;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public record RequestMusicDTO(@NotBlank String nome, @NotNull List<Integer> artistasId,List<Integer> generosId, Date lancamento) {
}

package com.jhonatan.music.musicsound.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDoArtista(
        @JsonAlias("strArtist") String nome,
        @JsonAlias("strGenre") String genero,
        @JsonAlias("strCountry") String pais
) {}

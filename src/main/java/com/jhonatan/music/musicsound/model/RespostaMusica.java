package com.jhonatan.music.musicsound.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RespostaMusica(
        @JsonAlias("track")
        List<DadosMusica> track
) {}

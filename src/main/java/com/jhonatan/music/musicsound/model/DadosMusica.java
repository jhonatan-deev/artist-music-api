package com.jhonatan.music.musicsound.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMusica(

        @JsonAlias("strTrack")
        String nomeMusica,

        @JsonAlias("strArtist")
        String artista,

        @JsonAlias("strAlbum")
        String album,

        @JsonAlias("intDuration")
        String duracao,

        @JsonAlias("strGenre")
        String genero
) {}
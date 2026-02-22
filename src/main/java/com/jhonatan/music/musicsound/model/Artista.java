package com.jhonatan.music.musicsound.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nomeArtista;
    @Enumerated(EnumType.STRING)
    private TipoArtista tipo;
    @OneToMany(mappedBy = "artista")
    private List<Musica> musicas = new ArrayList<>();
    public Artista() {}// a jpa exige que tenha em construtor padrao desse ou vai gerar esse erro: No default constructor for entity 'com.example.screenmatch.model.Serie'
    public Artista(String nomeArtista, TipoArtista tipo) {
        this.nomeArtista = nomeArtista;
        this.tipo = tipo;
    }
}

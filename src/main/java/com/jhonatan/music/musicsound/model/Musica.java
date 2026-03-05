package com.jhonatan.music.musicsound.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musica")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artista_id")
    private Artista artista;

    public Musica() {}
    public Musica(String nome, Artista artista) {
        this.nome = nome;
        this.artista = artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    @Override
    public String toString() {
        return String.format(
                "ID: %d | Música: %s | Artista: %s",
                id, nome,  artista
        );
    }
}

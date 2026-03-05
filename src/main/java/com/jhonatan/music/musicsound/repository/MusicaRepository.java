package com.jhonatan.music.musicsound.repository;

import com.jhonatan.music.musicsound.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MusicaRepository extends JpaRepository<Musica, Integer> {
        @Query(value = "SELECT m FROM Artista a JOIN a.musicas m WHERE a.nomeArtista ILIKE %:trechoNomeMusica%")
        List<Musica> findByArtistaNomeContainingIgnoreCase(String trechoNomeMusica);
}

package com.jhonatan.music.musicsound.repository;

import com.jhonatan.music.musicsound.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {
}

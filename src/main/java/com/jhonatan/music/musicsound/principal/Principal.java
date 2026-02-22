package com.jhonatan.music.musicsound.principal;

import com.jhonatan.music.musicsound.model.Artista;
import com.jhonatan.music.musicsound.model.TipoArtista;
import com.jhonatan.music.musicsound.repository.ArtistaRepository;
import com.jhonatan.music.musicsound.repository.MusicaRepository;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {
    private final MusicaRepository musicaRepository;
    private final ArtistaRepository artistaRepository;
    public Principal(MusicaRepository musicaRepository, ArtistaRepository artistaRepository) {
        this.musicaRepository = musicaRepository;
        this.artistaRepository = artistaRepository;
    }
    Scanner digitador = new Scanner(System.in);

    public void criarArtista() {
        System.out.println("Criando Artista");
        System.out.println("Digite o nome do artista: ");
        String nomeArtista = digitador.nextLine();
        System.out.println("Digite o tipo de artista (SOLO, DUPLA, BANDA): ");
        String tipoArtista = digitador.nextLine();
        if(nomeArtista.isBlank() || tipoArtista.isBlank() ){
            System.out.println("Nome e tipo não podem estar vazios.");
            return;
        }
        try {
            TipoArtista tipo = TipoArtista.valueOf(tipoArtista.toUpperCase());
            Artista artista = new Artista(nomeArtista, tipo);
            artistaRepository.save(artista);
            System.out.println("Artista Criada com sucesso!");
        }catch (IllegalArgumentException e) {
            System.out.println("Tipo inválido! Use apenas: SOLO, DUPLA ou BANDA.");
        }
    }

    public void executar() {
        criarArtista();
    }
}

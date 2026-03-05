package com.jhonatan.music.musicsound.principal;

import com.jhonatan.music.musicsound.config.TheAudiodbApi;
import com.jhonatan.music.musicsound.model.*;
import com.jhonatan.music.musicsound.repository.ArtistaRepository;
import com.jhonatan.music.musicsound.repository.MusicaRepository;
import com.jhonatan.music.musicsound.service.ConsumoApi;
import com.jhonatan.music.musicsound.service.ConverterDados;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Principal {

    private final MusicaRepository musicaRepository;
    private final ArtistaRepository artistaRepository;
    private final TheAudiodbApi theAudiodbApi;
    private final ConsumoApi consumoApi;
    private final ConverterDados converterDados;

    private final Scanner digitador = new Scanner(System.in);

    public Principal(MusicaRepository musicaRepository,
                     ArtistaRepository artistaRepository,
                     TheAudiodbApi theAudiodbApi,
                     ConsumoApi consumoApi,
                     ConverterDados converterDados) {

        this.musicaRepository = musicaRepository;
        this.artistaRepository = artistaRepository;
        this.theAudiodbApi = theAudiodbApi;
        this.consumoApi = consumoApi;
        this.converterDados = converterDados;
    }

    /* =====================================================
       MENU / EXECUÇÃO
     ===================================================== */

    public void executar() {

        int opcao = -1;

        while (opcao != 9) {

            System.out.println("""
                    
                    1 - Cadastrar artista
                    2 - Cadastrar música
                    3 - Listar artistas
                    4 - Listar músicas
                    5 - Pesquisar dados do artista (API)
                    6 - Buscar Musica Por Artista
                    9 - Sair
                    """);

            opcao = digitador.nextInt();
            digitador.nextLine();

            switch (opcao) {
                case 1 -> cadastrarArtista();
                case 2 -> cadastrarMusicaComArtista();
                case 3 -> mostrarTodosOsArtistas();
                case 4 -> mostrarTodasAsMusicas();
                case 5 -> buscarDadosDoArtista();
                case 6 -> buscarMusicaPorArtista();
                case 9 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }


    public void cadastrarArtista() {

        System.out.println("Digite o nome do artista:");
        String nomeArtista = digitador.nextLine();

        System.out.println("Tipo (SOLO, DUPLA, BANDA):");
        String tipoArtista = digitador.nextLine();

        if (nomeArtista.isBlank() || tipoArtista.isBlank()) {
            System.out.println("Dados inválidos.");
            return;
        }

        try {
            TipoArtista tipo =
                    TipoArtista.valueOf(tipoArtista.toUpperCase());

            artistaRepository.save(
                    new Artista(nomeArtista, tipo)
            );

            System.out.println("Artista cadastrado!");
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo inválido.");
        }
    }

    public void cadastrarMusicaComArtista() {

        System.out.println("Nome da música:");
        String nomeMusica = digitador.nextLine();

        if (nomeMusica.isBlank()) {
            System.out.println("Nome inválido.");
            return;
        }

        mostrarTodosOsArtistas();

        System.out.println("Digite o ID do artista:");
        Long idArtista = digitador.nextLong();
        digitador.nextLine();

        Artista artista =
                artistaRepository.findById(idArtista)
                        .orElse(null);

        if (artista == null) {
            System.out.println("Artista não encontrado.");
            return;
        }

        musicaRepository.save(
                new Musica(nomeMusica, artista)
        );

        System.out.println("Música cadastrada!");
    }


    public void mostrarTodosOsArtistas() {
        artistaRepository.findAll()
                .forEach(System.out::println);
    }

    public void mostrarTodasAsMusicas() {
        musicaRepository.findAll()
                .forEach(System.out::println);
    }


    public void buscarArtistaPorId(Long idArtista) {

        Artista artista =
                artistaRepository.findById(idArtista)
                        .orElse(null);

        if (artista == null) {
            System.out.println("Artista não encontrado.");
            return;
        }

        System.out.println(artista);
    }

    public void buscarMusicaPorArtista(){
        System.out.println("Digite o nome do artista:");
        String nomeArtista = digitador.nextLine();
        List<Musica> musicasEncontradasDesseArtista = musicaRepository.findByArtistaNomeContainingIgnoreCase(nomeArtista);
        musicasEncontradasDesseArtista.forEach(System.out::println);
    }

    public void buscarDadosDoArtista() {

        System.out.println("Nome do artista:");
        String nomeCantor = digitador.nextLine();

        System.out.println("Nome da música:");
        String nomeMusica = digitador.nextLine();

        String url = theAudiodbApi.getUrl();

        String json = consumoApi.obterDados(url + "searchtrack.php?s=" +
                 nomeCantor + "&t=" + nomeMusica
        );

        RespostaMusica resposta =
                converterDados.obterDados(
                        json,
                        RespostaMusica.class
                );

        if (resposta.track() == null ||
                resposta.track().isEmpty()) {

            System.out.println("Música não encontrada.");
            return;
        }

        DadosMusica musica =
                resposta.track().get(0);

        System.out.println(musica);
    }
}
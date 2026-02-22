package com.jhonatan.music.musicsound.model;

public enum TipoArtista {
    SOLO("Artista solo"),
    DUPLA("Dois integrantes"),
    BANDA("Três ou mais Integrantes");
    private String descricao;

    TipoArtista(String descricao) {
        this.descricao = descricao;
    };
    public String getDescricao() {
        return descricao;
    };

    public static TipoArtista obterTipo(String tipoEscrito) {
        for (TipoArtista tipoArtista : TipoArtista.values()) {
            if(tipoEscrito.equalsIgnoreCase(tipoArtista.descricao)) {
                return tipoArtista;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo de artista encontrado!");
    }
}

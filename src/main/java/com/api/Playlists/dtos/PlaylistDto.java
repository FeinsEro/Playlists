package com.api.Playlists.dtos;

import com.api.Playlists.models.Music;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class PlaylistDto {
        @NotBlank
        private String nome;

        private String descricao;

        private Set<Music> musics;

        public String getNome() {
            return nome;
        }

        public void setNome(String Nome) {
            this.nome = Nome;
        }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Music> getMusics() {
        return musics;
    }

    public void setMusics(Set<Music> musics) {
        this.musics = musics;
    }
}

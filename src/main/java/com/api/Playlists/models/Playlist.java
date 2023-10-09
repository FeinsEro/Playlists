package com.api.Playlists.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="TB_PLAYLIST")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column(nullable = false, length = 70)
    private String nome;

    @Column(nullable = false, length = 70)
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playlist")
    private Set<Music> musics;


    public Playlist() {
        // Construtor padrão vazio
    }

    @JsonCreator
    public Playlist(@JsonProperty("nome") String nome, @JsonProperty("descricao") String descricao, @JsonProperty("musics") Set<Music> musics) {
        this.nome = nome;
        this.descricao = descricao;
        this.musics = musics;
    }
    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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


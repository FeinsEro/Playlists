package com.api.Playlists.services;

import com.api.Playlists.models.Playlist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface PlaylistService {
    List<Playlist> findAll();

    Playlist findById(Long id);

    Playlist save(Playlist playlist);

    String delete(Long id);

    Boolean existsByNome(String nome);

    Playlist findByNome(String nome);

    @Modifying
    Playlist update(Playlist playlist);
}

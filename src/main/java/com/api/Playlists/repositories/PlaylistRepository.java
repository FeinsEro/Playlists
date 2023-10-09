package com.api.Playlists.repositories;

import com.api.Playlists.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    boolean existsByNome(String nome);
    Playlist findByNome(String nome);
}

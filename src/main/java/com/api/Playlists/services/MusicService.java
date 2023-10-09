package com.api.Playlists.services;

import com.api.Playlists.models.Music;
import com.api.Playlists.models.Playlist;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface MusicService {
    List<Music> findAll();

    Music findById(Long id);

    Music save(Music music);

    String delete(Long id);
}

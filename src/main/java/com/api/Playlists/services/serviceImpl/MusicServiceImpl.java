package com.api.Playlists.services.serviceImpl;

import com.api.Playlists.models.Music;
import com.api.Playlists.models.Playlist;
import com.api.Playlists.repositories.MusicRepository;
import com.api.Playlists.repositories.PlaylistRepository;
import com.api.Playlists.services.MusicService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService {
    final MusicRepository musicRepository;

    public MusicServiceImpl(MusicRepository musicRepository) {this.musicRepository = musicRepository;}

    @Override
    public List<Music> findAll() { return musicRepository.findAll(); }

    @Override
    public Music findById(Long id) { return musicRepository.findById(id).get(); }

    @Override
    public Music save(Music music) { System.out.println("saved");return musicRepository.save(music); }

    @Override
    public String delete(Long id) {
        musicRepository.deleteById(id);
        return "music deleted";
    }
}

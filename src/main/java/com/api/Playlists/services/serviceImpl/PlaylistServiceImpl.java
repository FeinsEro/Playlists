package com.api.Playlists.services.serviceImpl;

import com.api.Playlists.models.Playlist;
import com.api.Playlists.repositories.PlaylistRepository;
import com.api.Playlists.services.PlaylistService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    final PlaylistRepository playlistRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {this.playlistRepository = playlistRepository;}

    @Override
    public List<Playlist> findAll() { return playlistRepository.findAll(); }

    @Override
    public Playlist findById(Long id) { return playlistRepository.findById(id).get(); }

    @Override
    public Playlist save(Playlist playlist) { return playlistRepository.save(playlist);}

    @Override
    public String delete(Long id){
        playlistRepository.deleteById(id);
        return "playlist deleted";
    }

    @Modifying
    @Override
    public Playlist update(Playlist playlist){
        Playlist oldPlaylist = playlistRepository.findById(playlist.getId()).get();
        oldPlaylist.setNome(playlist.getNome());
        oldPlaylist.setDescricao(playlist.getDescricao());
        oldPlaylist.setMusics(playlist.getMusics());
        return playlistRepository.save(oldPlaylist);
    }
    public Boolean existsByNome(String nome){
        return playlistRepository.existsByNome(nome);
    }

    @Override
    public Playlist findByNome(String nome){
        return playlistRepository.findByNome(nome);
    }
}

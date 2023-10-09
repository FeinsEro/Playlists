package com.api.Playlists.utils;

import com.api.Playlists.models.Music;
import com.api.Playlists.models.Playlist;
import com.api.Playlists.repositories.MusicRepository;
import com.api.Playlists.repositories.PlaylistRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DummyData {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    MusicRepository musicRepository;

    //@PostConstruct
    public void savePlaylists(){
        Playlist playlist = new Playlist();
        playlist.setDescricao("A playlist mais braba de todas");
        playlist.setNome("As musica mais loca");

        playlistRepository.save(playlist);

        Set<Music> musicSet = new HashSet<>();
        Music music1 = new Music();
        music1.setTitulo("Teste 1");
        music1.setAlbum("Aquele lá");
        music1.setArtista("O mais brabo");
        music1.setAno(9999);
        music1.setGenero("O que você mais gosta");
        music1.setPlaylist(playlist);
        musicSet.add(music1);

        Music music2 = new Music();
        music2.setTitulo("Teste 3");
        music2.setAlbum("Aquele lá");
        music2.setArtista("O mais brabo");
        music2.setGenero("O que você mais gosta");
        music2.setAno(9999);
        music2.setPlaylist(playlist);
        musicSet.add(music2);


        Music music3 = new Music();
        music3.setTitulo("Teste 3");
        music3.setAlbum("Aquele lá");
        music3.setArtista("O mais brabo");
        music3.setGenero("O que você mais gosta");
        music3.setAno(9999);
        music3.setPlaylist(playlist);
        musicSet.add(music3);





        for (Music music: musicSet){
            Music musicSaved = musicRepository.save(music);
            System.out.println(musicSaved.getId());
        }

    }
}

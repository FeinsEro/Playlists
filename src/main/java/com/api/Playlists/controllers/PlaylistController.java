package com.api.Playlists.controllers;

import com.api.Playlists.dtos.PlaylistDto;
import com.api.Playlists.models.Music;
import com.api.Playlists.models.Playlist;
import com.api.Playlists.services.MusicService;
import com.api.Playlists.services.PlaylistService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@CrossOrigin
public class PlaylistController {
    @Autowired
    PlaylistService playlistService;

    @Autowired
    MusicService musicService;
    @PostMapping("/lists")
    public ResponseEntity<Object> savePlaylist(@RequestBody @Valid PlaylistDto playlistDto){
        /*if(playlistService.existsByNome(playlistDto.getPlaylistNome())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Playlist already exists");
        }*/
        var playlist = new Playlist();
        BeanUtils.copyProperties(playlistDto, playlist);
        System.out.println(playlistDto.getNome());
        Set<Music> musicSet = playlistDto.getMusics();
        Object response = ResponseEntity.status(HttpStatus.CREATED).body(playlistService.save(playlist));
        for (Music music : musicSet) {
            System.out.println(music.getTitulo());
            musicService.save(music);
        }

        return (ResponseEntity<Object>) response;
    }
    @GetMapping("/lists")
    public ResponseEntity<List<Playlist>> getAllPlaylists(){
        return ResponseEntity.status(HttpStatus.OK).body(playlistService.findAll());
    }

    @GetMapping("/lists/{nome}")
    public ResponseEntity<Object> getOnePlaylist(@PathVariable(value = "nome") String nome){
        Optional<Playlist> playlistOptional = Optional.<Playlist>ofNullable(playlistService.findByNome(nome));
        return playlistOptional.<ResponseEntity<Object>>map(playlist -> ResponseEntity.status(HttpStatus.OK).body(playlist)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist not found"));
    }

    @DeleteMapping("/lists/{nome}")
    public ResponseEntity<Object> deletePlaylist(@PathVariable(value = "nome") String nome){
        Optional<Playlist> playlistOptional = Optional.ofNullable(playlistService.findByNome(nome));
        if (!playlistOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 Not Found");
        }
        playlistService.delete(playlistOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body("Playlist deleted successfully");
    }
}

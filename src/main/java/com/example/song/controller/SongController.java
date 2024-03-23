/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.song.service.SongH2Service;

import java.util.*;
import com.example.song.model.Song;

@RestController
public class SongController {

    @Autowired
    public SongH2Service songService;

    @GetMapping("/songs")
    public ArrayList<Song> getSongList() {
        return songService.getSongList();
    }

    @GetMapping("/songs/{songId}")
    public Song getSong(@PathVariable("songId") int songId) {
        return songService.getSong(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song) {
        return songService.updateSong(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId) {
        songService.deleteSong(songId);
    }
}
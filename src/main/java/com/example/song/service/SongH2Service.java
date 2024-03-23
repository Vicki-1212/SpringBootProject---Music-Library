/*
 * 
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.song.service;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.*;
import com.example.song.repository.SongRepository;

import java.util.*;
import com.example.song.model.Song;
import com.example.song.model.SongRowMapper;

@Service
public class SongH2Service implements SongRepository {

    @Autowired
    public JdbcTemplate db;

    @Override
    public ArrayList<Song> getSongList() {
        List<Song> songList = db.query("SELECT * FROM playlist", new SongRowMapper());
        ArrayList<Song> songs = new ArrayList<>(songList);
        return songs;
    }

    @Override
    public Song getSong(int songId) {
        try {
            Song song = db.queryForObject("SELECT * FROM playlist WHERE songId = ?", new SongRowMapper(), songId);
            return song;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSong(Song song) {
        db.update("INSERT INTO playlist(songName, lyricist, singer, musicDirector) VALUES(?,?,?,?)", song.getSongName(),
                song.getLyricist(), song.getSinger(), song.getMusicDirector());
        Song savedSong = db.queryForObject("SELECT * FROM playlist WHERE songName = ? and lyricist = ?",
                new SongRowMapper(), song.getSongName(), song.getLyricist());
        return savedSong;
    }

    @Override
    public Song updateSong(int songId, Song song) {
        if (song.getSongName() != null) {
            db.update("UPDATE playlist SET songName = ? WHERE songId = ?", song.getSongName(), songId);
        }
        if (song.getLyricist() != null) {
            db.update("UPDATE playlist SET lyricist = ? WHERE songId = ?", song.getLyricist(), songId);
        }
        if (song.getSinger() != null) {
            db.update("UPDATE playlist SET singer = ? WHERE songId = ?", song.getSinger(), songId);
        }
        if (song.getMusicDirector() != null) {
            db.update("UPDATE playlist SET musicDirector = ? WHERE songId = ?", song.getMusicDirector(), songId);
        }
        return getSong(songId);
    }

    @Override
    public void deleteSong(int songId) {
        db.update("DELETE FROM playlist WHERE songId = ?", songId);
    }
}
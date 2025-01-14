// Write your code here
package com.example.song.model;

import java.util.*;

public class Song {

    private int songId;
    private String songName;
    private String lyricist;
    private String singer;
    private String musicDirector;

    public Song(int songId, String songName, String lyricist, String singer, String musicDirector) {
        this.songId = songId;
        this.songName = songName;
        this.lyricist = lyricist;
        this.singer = singer;
        this.musicDirector = musicDirector;
    }

    // Get and Set Method for songId

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getSongId() {
        return this.songId;
    }

    // Get and Set Method of songName

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongName() {
        return this.songName;
    }

    // Get and Set Method of lyricist
    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public String getLyricist() {
        return this.lyricist;
    }

    // Get and Set Method of singer
    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSinger() {
        return this.singer;
    }

    // Get and Set Method of musicDirector

    public void setMusicDirector(String musicDirector) {
        this.musicDirector = musicDirector;
    }

    public String getMusicDirector() {
        return this.musicDirector;
    }
}

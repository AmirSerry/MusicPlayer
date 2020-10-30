package com.amirserry.musicplayer;

import java.io.Serializable;

public class Song implements Serializable {

    String songName;
    String ArtistName;

    public Song(String songName, String artistName) {
        this.songName = songName;
        ArtistName = artistName;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }


    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}

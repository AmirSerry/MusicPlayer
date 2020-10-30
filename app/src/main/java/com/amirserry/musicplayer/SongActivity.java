package com.amirserry.musicplayer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        Song song = (Song) getIntent().getSerializableExtra("song");
        TextView songName = (TextView) findViewById(R.id.song_title_name);
        TextView artistName = (TextView) findViewById(R.id.artist_titlle_name);
        songName.setText(song.getSongName());
        artistName.setText(song.getArtistName());
    }
}

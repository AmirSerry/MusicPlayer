package com.amirserry.musicplayer;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SongAdapter songAdapter;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.song_list_view);
        songAdapter = new SongAdapter(getApplicationContext(), R.layout.song_item);
        listView.setAdapter(songAdapter);

        List<Song> songlist = getSongList();
        for (Song song : songlist) {
            songAdapter.add(song);
        }
    }

    public List<Song> getSongList() {
        List<Song> resultList = new ArrayList<Song>();

        for (int i = 1; i <= 20; i++) {
            Song song = new Song("Song " + i, "Artist " + i);
            resultList.add(song);
        }
        return resultList;
    }
}

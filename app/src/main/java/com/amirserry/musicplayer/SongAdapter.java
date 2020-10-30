package com.amirserry.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {

    private List<Song> songList = new ArrayList<Song>();

    public SongAdapter(@NonNull Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(Song song) {
        songList.add(song);
        super.add(song);
    }

    @Override
    public int getCount() {
        return this.songList.size();
    }

    @Override
    public Song getItem(int index) {
        return this.songList.get(index);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        SongViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.song_item, parent, false);
            viewHolder = new SongViewHolder();
            viewHolder.play = (Button) row.findViewById(R.id.button_play);
            viewHolder.songName = (TextView) row.findViewById(R.id.song_name);
            viewHolder.artistName = (TextView) row.findViewById(R.id.artist_name);
            row.setTag(viewHolder);
        } else {
            viewHolder = (SongViewHolder) row.getTag();
        }
        final Song song = getItem(position);
        viewHolder.songName.setText(song.getSongName());
        viewHolder.artistName.setText(song.getArtistName());
        viewHolder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SongActivity.class);
                intent.putExtra("song", song);
                v.getContext().startActivity(intent);

            }
        });
        return row;
    }

    static class SongViewHolder {
        TextView songName;
        TextView artistName;
        Button play;
    }
}

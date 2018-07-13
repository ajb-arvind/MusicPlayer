package com.official19.ajb.musicplayer;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;


public class PlaylistActivity extends AppCompatActivity {

    ListView SongListLv;
    String[] songArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        init();

        final ArrayList<File> mySongFileArray = findSong(Environment.getExternalStorageDirectory());
        songArray = new String[mySongFileArray.size()];
        for(int i=0; i<mySongFileArray.size(); i++){
            songArray[i] = mySongFileArray.get(i).getName().toString().replace(".mp3","").replace(".wav","");
        }

        ArrayAdapter<String> songListAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.song_layout,R.id.tvsongName,songArray);

        SongListLv.setAdapter(songListAdapter);

        SongListLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class).putExtra("pos", position).putExtra("songList", mySongFileArray));
            }
        });

    }

    ArrayList<File> findSong(File root){
        ArrayList<File> mySongFileArray = new ArrayList<File>();
        File[] files = root.listFiles();
        for(File singleFile : files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                mySongFileArray.addAll(findSong(singleFile));
            }
            else{
                if(singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".MP3")){
                    mySongFileArray.add(singleFile);
                }
            }
        }

        return mySongFileArray;
    }

    void init(){
        SongListLv = (ListView)findViewById(R.id.lvSongList);

    }
}

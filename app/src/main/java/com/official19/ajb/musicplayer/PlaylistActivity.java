package com.official19.ajb.musicplayer;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


public class PlaylistActivity extends AppCompatActivity {

    ListView SongListLv;
    public ArrayList<HashMap<String, String>> songList = new ArrayList<HashMap<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        init();




    }



    void init(){
        SongListLv = (ListView)findViewById(R.id.lvSongList);

    }
}

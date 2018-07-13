package com.official19.ajb.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView SongTitleTv;
    Button PlaylistBtn, BackBtn, PauseBtn, NextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        PlaylistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PlaylistActivity.class));
            }
        });

    }

    void init(){
        SongTitleTv = (TextView) findViewById(R.id.tvSongTitle);
        PlaylistBtn = (Button)findViewById(R.id.btnPlaylist);
        BackBtn = (Button)findViewById(R.id.btnBack);
        PauseBtn= (Button)findViewById(R.id.btnPause);
        NextBtn= (Button)findViewById(R.id.btnNext);


    }
}

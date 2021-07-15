package com.example.eng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Description_Game_Mode_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description__game__mode_2);
    }

    public void game_mod_2(View view) {
        Intent intent = new Intent("Game_Mode_2");
        startActivity(new Intent(Description_Game_Mode_2.this,
                Game_Mode_2.class));
    }
}
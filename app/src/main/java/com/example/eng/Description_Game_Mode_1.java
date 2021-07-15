package com.example.eng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Description_Game_Mode_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_game__mode_1);
    }

    public void game_mod_1(View view) {
        Intent intent = new Intent("Game_Mode_1");
        startActivity(new Intent(Description_Game_Mode_1.this,
                Game_Mode_1.class));
    }
}
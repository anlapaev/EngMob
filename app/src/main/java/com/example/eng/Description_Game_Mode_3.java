package com.example.eng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Description_Game_Mode_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_game_mode3);
    }
    public void game_mod_3(View view) {
        Intent intent = new Intent("Game_Mode_3");
        startActivity(new Intent(Description_Game_Mode_3.this,
                Game_Mode_3.class));
    }
}
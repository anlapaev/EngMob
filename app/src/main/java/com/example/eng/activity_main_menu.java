package com.example.eng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_main_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void description_game_mod_1(View view) {
        Intent intent = new Intent("Description_Game_Mode_1");
        startActivity(new Intent(activity_main_menu.this,
                Description_Game_Mode_1.class));
    }

    public void description_game_mod_2(View view) {
        Intent intent = new Intent("Description_Game_Mode_2");
        startActivity(new Intent(activity_main_menu.this,
                Description_Game_Mode_2.class));
    }

    public void description_game_mod_3(View view) {
        Intent intent = new Intent("Description_Game_Mode_3");
        startActivity(new Intent(activity_main_menu.this,
                Description_Game_Mode_3.class));
    }
    public void description_game_mod_4(View view) {
        Intent intent = new Intent("Description_Game_Mode_4");
        startActivity(new Intent(activity_main_menu.this,
                Description_Game_Mode_4.class));
    }
}
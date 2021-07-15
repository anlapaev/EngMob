package com.example.eng;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Game_Mode_1 extends AppCompatActivity {
    public static final long COUNDTOWN_IN_MS = 30000;
    private ColorStateList cdDefaultColor;
    private CountDownTimer countDownTimer;
    private long timeLeftInMs;

    private TextView tvPravOtv;
    private TextView tvNePravOtv;
    private TextView tvTimer;
    private TextView tvSlovo;
    private EditText etOtvet;
    private Button btnOtv;
    private Button btnTheory;
    private Button btnBack;
    private String[] slova;
    private String[] answers;
    private int[] colors;
    private int count;
    private int countPrOtv;
    private int countNeprOtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__mode_1);

        count = 0;
        countPrOtv = 0;
        countNeprOtv = 0;
        tvPravOtv = findViewById(R.id.tv_pravOtv);
        tvNePravOtv = findViewById(R.id.tv_nePravOtv);
        tvTimer = findViewById(R.id.tv_timer);
        tvSlovo = findViewById(R.id.tv_slovo);
        etOtvet = findViewById(R.id.et_otvet);
        btnOtv = findViewById(R.id.btn_otv);
        btnTheory = findViewById(R.id.btn_theory);
        btnBack = findViewById(R.id.btn_back);
        btnBack.setEnabled(false);
        btnBack.setVisibility(View.INVISIBLE);

        cdDefaultColor = tvTimer.getTextColors();
        //массив слов
        slova = new String[]{"black", "green", "red", "brown"};
        //массив ответов и цветов
        answers = new String[]{"blue", "yellow", "black", "red"};
        colors = new int[]{Color.BLUE, Color.YELLOW, Color.BLACK, Color.RED};
        updateSlovo();

        btnOtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(etOtvet.getText().toString());
                updateSlovo();
            }
        });

        btnTheory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Game_Mode_1.this, TheoryActivity.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void updateSlovo(){
        if(count<slova.length){
        tvSlovo.setText(slova[count]);
        tvSlovo.setTextColor(colors[count]);
        timeLeftInMs = COUNDTOWN_IN_MS;
        startCountDown();
        etOtvet.setText("");
        }
        else{
            tvSlovo.setText("Конец игры");
            etOtvet.setEnabled(false);
            btnBack.setEnabled(true);
            btnBack.setVisibility(View.VISIBLE);
        }
    }

     private void startCountDown(){
        countDownTimer=new CountDownTimer(timeLeftInMs,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMs = millisUntilFinished;
                updateCountDownTv();
            }

            @Override
            public void onFinish() {
                timeLeftInMs = 0;
                updateCountDownTv();
                checkAnswer(etOtvet.getText().toString());
                updateSlovo();
            }
        }.start();
    }

    private void updateCountDownTv(){
        int minutes = (int)(timeLeftInMs/1000)/60;
        int seconds = (int)(timeLeftInMs/1000)%60;

        String timeFormatted = String.format(Locale.getDefault(),"Осталось секунд: "+"%02d:%02d",minutes,seconds);

        tvTimer.setText(timeFormatted);

        if(timeLeftInMs<10000){
            tvTimer.setTextColor(Color.RED);
        } else{
            tvTimer.setTextColor(cdDefaultColor);
        }
    }

    private void checkAnswer(String otv){
        countDownTimer.cancel();
        if(otv.toUpperCase().equals(answers[count].toUpperCase())){
            countPrOtv++;
            tvPravOtv.setText("Правильно: "+countPrOtv);
            Toast.makeText(this, "Правильный ответ!", Toast.LENGTH_SHORT).show();
        }
        else{
            countNeprOtv++;
            tvNePravOtv.setText("Неправильно: "+countNeprOtv);
            Toast.makeText(this, "Неправильный ответ!", Toast.LENGTH_SHORT).show();
        }
        count++;
    }
}
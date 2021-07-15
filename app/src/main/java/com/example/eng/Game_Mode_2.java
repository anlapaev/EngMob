package com.example.eng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

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

public class Game_Mode_2 extends AppCompatActivity {
    public static final long COUNDTOWN_IN_MS = 30000;
    private ColorStateList cdDefaultColor;
    private CountDownTimer countDownTimer;
    private long timeLeftInMs;

    private TextView tvPravOtv;
    private TextView tvNePravOtv;
    private TextView tvTimer;
    private TextView tvMath;
    private EditText etOtvet;
    private Button btnOtv;
    private Button btnTheory;
    private String[] mathTask;
    private String[] answers;
    private int count;
    private int countPrOtv;
    private int countNeprOtv;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__mode_2);
        count = 0;
        countPrOtv = 0;
        countNeprOtv = 0;
        tvPravOtv = findViewById(R.id.tv_pravOtv_gm2);
        tvNePravOtv = findViewById(R.id.tv_nePravOtv_gm2);
        tvTimer = findViewById(R.id.tv_timer_gm2);
        tvMath = findViewById(R.id.tv_math);
        etOtvet = findViewById(R.id.et_otvet_gm2);
        btnOtv = findViewById(R.id.btn_otv_gm2);
        btnTheory = findViewById(R.id.btn_theory_gm2);
        cdDefaultColor = tvTimer.getTextColors();
        mathTask = new String[]{"2+2", "45*2", "60/5", "1000-7"};
        answers = new String[]{"four", "ninety", "twelve", "nine hundred ninety three"};

        btnBack = findViewById(R.id.btn_back);
        btnBack.setEnabled(false);
        btnBack.setVisibility(View.INVISIBLE);

        updateMathTask();

        btnOtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(etOtvet.getText().toString());
                updateMathTask();
            }
        });
        btnTheory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Game_Mode_2.this, Theory_GM2_Activity.class);
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
    private void updateMathTask(){
        if(count<mathTask.length){
            tvMath.setText(mathTask[count]);
            timeLeftInMs = COUNDTOWN_IN_MS;
            startCountDown();
            etOtvet.setText("");
        }
        else{
            tvMath.setText("Конец игры");
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
                updateMathTask();
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
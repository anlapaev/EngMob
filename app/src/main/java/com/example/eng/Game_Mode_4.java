package com.example.eng;

import androidx.appcompat.app.AppCompatActivity;

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

public class Game_Mode_4 extends AppCompatActivity {

    public static final long COUNDTOWN_IN_MS = 30000;
    private ColorStateList cdDefaultColor;
    private CountDownTimer countDownTimer;
    private long timeLeftInMs;
    private Button btnBack;
    private TextView tvPravOtv;
    private TextView tvTimer;
    private TextView tvWord;
    private Button btnOtv1;
    private EditText et_otvet;
    private int count;
    private int countPrOtv;
    private CrossWord crossWord;
    private int crosswordLength;
    private String corrAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode4);
        tvPravOtv = findViewById(R.id.tv_pravOtv_gm4);
        tvTimer = findViewById(R.id.tv_timer_gm4);
        tvWord = findViewById(R.id.tv_word);
        et_otvet = findViewById(R.id.et_otvet4);
        btnOtv1 = findViewById(R.id.btn_otv1_gm4);
        btnBack = findViewById(R.id.btn_back);
        btnBack.setEnabled(false);
        btnBack.setVisibility(View.INVISIBLE);
        countPrOtv = 0;
        tvPravOtv.setText("Счёт: "+countPrOtv);
        count = 0;
        cdDefaultColor = tvTimer.getTextColors();
        crossWord = new CrossWord();
        crosswordLength = crossWord.tasks.length;

        updateTask(count);
        count++;

        btnOtv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_otvet.getText().toString().toUpperCase().equals(corrAnswer.toUpperCase())){
                    countPrOtv++;
                    tvPravOtv.setText("Счёт: "+countPrOtv);
                    countDownTimer.cancel();
                    updateTask(count);
                    count++;
                }
                else{
                    gameOver();
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void updateTask(int a){
        if(count<crosswordLength) {
            tvWord.setText(crossWord.getTask(a));
            corrAnswer = crossWord.getAnswer(a);
            timeLeftInMs = COUNDTOWN_IN_MS;
            startCountDown();
            et_otvet.setText("");
        }
        else{
            gameOver();
        }
    }
    private void gameOver(){
        if(count==crosswordLength){
            countDownTimer.cancel();
            tvWord.setText("Игра окончена!");
            btnOtv1.setEnabled(false);
            et_otvet.setEnabled(false);
            btnBack.setEnabled(true);
            btnBack.setVisibility(View.VISIBLE);
        }
        else {
            countDownTimer.cancel();
            tvWord.setText("Ты проиграл!");
            btnOtv1.setEnabled(false);
            et_otvet.setEnabled(false);
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
                gameOver();
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
        if(otv.toUpperCase() == corrAnswer){
            countPrOtv++;
            tvPravOtv.setText("Счёт: "+countPrOtv);
        }
        else{
            gameOver();
        }
        count++;
    }
}
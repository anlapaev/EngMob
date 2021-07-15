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
import java.util.Random;

public class Game_Mode_3 extends AppCompatActivity {

    public static final long COUNDTOWN_IN_MS = 30000;
    private ColorStateList cdDefaultColor;
    private CountDownTimer countDownTimer;
    private long timeLeftInMs;
    private Button btnBack;
    private TextView tvPravOtv;
    private TextView tvTimer;
    private TextView tvSynonym;
    private Button btnOtv1;
    private Button btnOtv2;
    private int count;
    private int countPrOtv;
    private Synonyms synonyms;
    private int synonymsLength;
    private String corrAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode3);

        tvPravOtv = findViewById(R.id.tv_pravOtv_gm3);
        tvTimer = findViewById(R.id.tv_timer_gm3);
        tvSynonym = findViewById(R.id.tv_sinon);
        btnOtv1 = findViewById(R.id.btn_otv1_gm3);
        btnOtv2 = findViewById(R.id.btn_otv2_gm3);
        countPrOtv = 0;
        count = 0;
        cdDefaultColor = tvTimer.getTextColors();
        synonyms = new Synonyms();
        synonymsLength = synonyms.word.length;
        btnBack = findViewById(R.id.btn_back);
        btnBack.setEnabled(false);
        btnBack.setVisibility(View.INVISIBLE);
        tvPravOtv.setText("Счёт: "+countPrOtv);

        updateWord(count);
        count++;

        btnOtv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnOtv1.getText() == corrAnswer){
                    countPrOtv++;
                    tvPravOtv.setText("Счёт: "+countPrOtv);
                    countDownTimer.cancel();
                    updateWord(count);
                    count++;
                }
                else{
                    gameOver();
                }
            }
        });

        btnOtv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnOtv2.getText() == corrAnswer){
                    countPrOtv++;
                    tvPravOtv.setText("Счёт: "+countPrOtv);
                    countDownTimer.cancel();
                    updateWord(count);
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

    private void updateWord(int a){
        if(count<synonymsLength){
        tvSynonym.setText(synonyms.getWord(a));
        btnOtv1.setText(synonyms.getChoice1(a));
        btnOtv2.setText(synonyms.getChoice2(a));

        corrAnswer = synonyms.getCorrectAnswer(a);
        timeLeftInMs = COUNDTOWN_IN_MS;
        startCountDown();
        }
        else{
            gameOver();
        }
    }

    private void gameOver(){
        if(count==synonymsLength){
        countDownTimer.cancel();
        tvSynonym.setText("Игра окончена!");
        btnOtv1.setEnabled(false);
        btnOtv2.setEnabled(false);
        btnBack.setEnabled(true);
        btnBack.setVisibility(View.VISIBLE);
        }
        else {
            countDownTimer.cancel();
            tvSynonym.setText("Ты проиграл!");
            btnOtv1.setEnabled(false);
            btnOtv2.setEnabled(false);
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
}
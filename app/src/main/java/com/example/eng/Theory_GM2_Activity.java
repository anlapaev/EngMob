package com.example.eng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;

public class Theory_GM2_Activity extends AppCompatActivity {

    ArrayList<TheoryColor> theoryMath = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_gm2);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.tmath_list);
        ColorTheoryAdapter adapter = new ColorTheoryAdapter(this,theoryMath);
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){
        theoryMath.add(new TheoryColor("1"," — one [wʌn]", Color.WHITE));
        theoryMath.add(new TheoryColor("2"," — two [tu:]", Color.WHITE));
        theoryMath.add(new TheoryColor("3"," — three [θri:]", Color.WHITE));
        theoryMath.add(new TheoryColor("4"," — four [fɔ:]", Color.WHITE));
        theoryMath.add(new TheoryColor("5"," — five [faiv]", Color.WHITE));
        theoryMath.add(new TheoryColor("6"," — six [siks]", Color.WHITE));
        theoryMath.add(new TheoryColor("7"," — seven [‘sev(ə)n]", Color.WHITE));
        theoryMath.add(new TheoryColor("8"," — eight [eit]", Color.WHITE));
        theoryMath.add(new TheoryColor("9"," — nine [nain]", Color.WHITE));
        theoryMath.add(new TheoryColor("10"," — ten [ten]", Color.WHITE));
        theoryMath.add(new TheoryColor("11"," — eleven [i’lev(ə)n]", Color.WHITE));
        theoryMath.add(new TheoryColor("12"," — twelve [twelv]", Color.WHITE));
        theoryMath.add(new TheoryColor("13"," — thirteen [͵θɜ:ʹti:n]", Color.WHITE));
        theoryMath.add(new TheoryColor("14"," — fourteen [͵fɔ:ʹti:n]", Color.WHITE));
        theoryMath.add(new TheoryColor("15"," — fifteen [fıfʹti:n]", Color.WHITE));
        theoryMath.add(new TheoryColor("16"," — sixteen [͵sıkʹsti:n]", Color.WHITE));
        theoryMath.add(new TheoryColor("17"," — seventeen [͵sev(ə)nʹti:n]", Color.WHITE));
        theoryMath.add(new TheoryColor("18"," — eighteen [eıʹti:n]", Color.WHITE));
        theoryMath.add(new TheoryColor("19"," — nineteen [͵naınʹti:n]", Color.WHITE));
        theoryMath.add(new TheoryColor("20"," — twenty [ʹtwentı]", Color.WHITE));
        theoryMath.add(new TheoryColor("21"," — twenty one [ʹtwentı] [wʌn]", Color.WHITE));
        theoryMath.add(new TheoryColor("22"," — twenty two [ʹtwentı] [tu:]", Color.WHITE));
        theoryMath.add(new TheoryColor("23"," — twenty three [ʹtwentı] [θri:]", Color.WHITE));
        theoryMath.add(new TheoryColor("30"," — thirty [ʹθɜ:tı]", Color.WHITE));
        theoryMath.add(new TheoryColor("40"," — forty [ʹfɔ:tı]", Color.WHITE));
        theoryMath.add(new TheoryColor("50"," — fifty [ʹfıftı]", Color.WHITE));
        theoryMath.add(new TheoryColor("60"," — sixty [ʹsıkstı]", Color.WHITE));
        theoryMath.add(new TheoryColor("70"," — seventy [ʹsev(ə)ntı]", Color.WHITE));
        theoryMath.add(new TheoryColor("80"," — eighty [ʹeıtı]", Color.WHITE));
        theoryMath.add(new TheoryColor("90"," — ninety [ʹnaıntı]", Color.WHITE));
        theoryMath.add(new TheoryColor("100"," — one hundred [wʌn] [ʹhʌndrəd]", Color.WHITE));
        theoryMath.add(new TheoryColor("200"," — two hundred [tu:] [ʹhʌndrəd]", Color.WHITE));
        theoryMath.add(new TheoryColor("300"," — three hundred [θri:] [ʹhʌndrəd]", Color.WHITE));
        theoryMath.add(new TheoryColor("101"," — one hundred and one [wʌn] [ʹhʌndrəd] [ænd] [wʌn]", Color.WHITE));
        theoryMath.add(new TheoryColor("1000"," — one thousand [wʌn] [ʹθaʋz(ə)nd]", Color.WHITE));
        theoryMath.add(new TheoryColor("1085"," — one thousand and eighty five [wʌn] [ʹθaʋz(ə)nd] [ænd] [ʹeıtı] [faıv]", Color.WHITE));
    }
}
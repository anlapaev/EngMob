package com.example.eng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;

public class TheoryActivity extends AppCompatActivity {

    ArrayList<TheoryColor> theoryColors = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.tcolors_list);
        ColorTheoryAdapter adapter = new ColorTheoryAdapter(this,theoryColors);
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){
        theoryColors.add(new TheoryColor("Yellow"," - жёлтый (Елоу) [ ˈjeləʊ ]", Color.YELLOW));
        theoryColors.add(new TheoryColor("Black"," — чёрный (блэк) [ blæk ]", Color.BLACK));
        theoryColors.add(new TheoryColor("White"," — белый (уайт) [ waɪt ]", Color.WHITE));
        theoryColors.add(new TheoryColor("Green"," — зелёный (грин) [ ɡriːn ]", Color.GREEN));
        theoryColors.add(new TheoryColor("Blue"," — голубой, синий (блю) [ bluː ]", Color.BLUE));
        theoryColors.add(new TheoryColor("Red"," — красный (ред) [ red ]", Color.RED));
    }
}
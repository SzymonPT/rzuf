package com.apple;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button czas_start;
    TextView czasomierz, pukty;
    ImageButton bloczek, bloczek2, bloczek3, bloczek4, bloczek5, bloczek6, bloczek7, bloczek8, bloczek9;
    ArrayList<ImageButton> arrayList;
    TextView punkty, timer;
    rzuf rzuf;
    Integer pkt, nowy_rzuf;
    Boolean czasomierz_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nowy_rzuf = 0;
        czasomierz_start=false;
        pkt = 0;
        czas_start = findViewById(R.id.czas_start);
        czasomierz = findViewById(R.id.czasomierz);
        pukty = findViewById(R.id.pukty);
        bloczek = findViewById(R.id.bloczek);
        bloczek2 = findViewById(R.id.bloczek2);
        bloczek3 = findViewById(R.id.bloczek3);
        bloczek4 = findViewById(R.id.bloczek4);
        bloczek5 = findViewById(R.id.bloczek5);
        bloczek6 = findViewById(R.id.bloczek6);
        bloczek7 = findViewById(R.id.bloczek7);
        bloczek8 = findViewById(R.id.bloczek8);
        bloczek9 = findViewById(R.id.bloczek9);
        arrayList.add(bloczek);
        arrayList.add(bloczek2);
        arrayList.add(bloczek3);
        arrayList.add(bloczek4);
        arrayList.add(bloczek5);
        arrayList.add(bloczek6);
        arrayList.add(bloczek7);
        arrayList.add(bloczek8);
        arrayList.add(bloczek9);

        czas_start.setOnClickListener(view -> clock_start(rzuf));
    }
}
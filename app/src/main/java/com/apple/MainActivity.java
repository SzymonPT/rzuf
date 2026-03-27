package com.apple;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button czas_start;
    TextView czasomierz, pukty;

    ImageButton bloczek, bloczek2, bloczek3, bloczek4, bloczek5, bloczek6, bloczek7, bloczek8, bloczek9;

    ArrayList<ImageButton> arrayList;

    rzuf rzuf;

    int pkt, nowy_rzuf;
    boolean czasomierz_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nowy_rzuf = 0;
        czasomierz_start = false;
        pkt = 0;

        czas_start = findViewById(R.id.czas_start);
        czasomierz = findViewById(R.id.czasomierz);
        pukty = findViewById(R.id.pukty);

        rzuf = new rzuf(czasomierz);

        bloczek = findViewById(R.id.bloczek);
        bloczek2 = findViewById(R.id.bloczek2);
        bloczek3 = findViewById(R.id.bloczek3);
        bloczek4 = findViewById(R.id.bloczek4);
        bloczek5 = findViewById(R.id.bloczek5);
        bloczek6 = findViewById(R.id.bloczek6);
        bloczek7 = findViewById(R.id.bloczek7);
        bloczek8 = findViewById(R.id.bloczek8);
        bloczek9 = findViewById(R.id.bloczek9);

        arrayList = new ArrayList<>();

        arrayList.add(bloczek);
        arrayList.add(bloczek2);
        arrayList.add(bloczek3);
        arrayList.add(bloczek4);
        arrayList.add(bloczek5);
        arrayList.add(bloczek6);
        arrayList.add(bloczek7);
        arrayList.add(bloczek8);
        arrayList.add(bloczek9);

        for (ImageButton box : arrayList) {
            box.setTag("");

            box.setOnClickListener(v -> {

                if (box.getTag().equals("czerwone")) {
                    pkt++;
                    pukty.setText(String.valueOf(pkt));
                    wyczysc();
                    losuj();
                }

                else if (box.getTag().equals("zielone")) {
                    pkt--;
                    pukty.setText(String.valueOf(pkt));
                    wyczysc();
                    losuj();
                }
            });
        }

        czas_start.setOnClickListener(v -> start());
    }

    public void start() {
        if (!czasomierz_start) {
            czasomierz_start = true;

            losuj();
            rzuf.countDownTimer = new CountDownTimer(rzuf.sek * 1000, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    rzuf.sek = (int) millisUntilFinished / 1000;
                    czasomierz.setText(String.valueOf(rzuf.sek));

                    nowy_rzuf++;

                    if (nowy_rzuf == 3) {
                        arrayList.get(rzuf.bloczek_zielony)
                                .setTag("");
                        arrayList.get(rzuf.bloczek_zielony)
                                .setImageResource(R.drawable.bloczek_nic);

                        arrayList.get(rzuf.bloczek_czerwony)
                                .setTag("");
                        arrayList.get(rzuf.bloczek_czerwony)
                                .setImageResource(R.drawable.bloczek_nic);
                        losuj();
                        nowy_rzuf = 0;
                    }
                }
                @Override
                public void onFinish() {
                    wyczysc();

                    czasomierz_start = false;
                    rzuf.sek = 60;
                    czasomierz.setText("60");
                }
            };

            rzuf.countDownTimer.start();
        }
    }
}
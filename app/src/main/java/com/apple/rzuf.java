package com.apple;

import android.os.CountDownTimer;
import android.widget.TextView;

public class rzuf {
    public int sek;
    public CountDownTimer countDownTimer;
    public int bloczek_czerwony;
    public int bloczek_zielony;
    public TextView timer;

    public rzuf(TextView timer) {
        this.sek = 60;
        this.timer = timer;
    }
}

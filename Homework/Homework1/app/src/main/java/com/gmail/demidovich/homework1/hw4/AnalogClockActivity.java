package com.gmail.demidovich.homework1.hw4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.gmail.demidovich.homework1.R;

public class AnalogClockActivity extends AppCompatActivity {
    private static final String EXTRA_CLOCK_TYPE = "CLOCK_TYPE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analog_clock);
        FrameLayout layout = findViewById(R.id.clock_container);
        layout.addView(new AnalogClock(getApplicationContext()));
    }

    public static Intent newIntent(Context context, int type) {
        Intent intent = new Intent(context, AnalogClockActivity.class);
        intent.putExtra(EXTRA_CLOCK_TYPE, type);
        return intent;
    }
}

package com.gmail.demidovich.homework1.hw4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gmail.demidovich.homework1.R;

public class MyAnimationActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myanimation);

        mTextView = findViewById(R.id.text_anim);
    }
}

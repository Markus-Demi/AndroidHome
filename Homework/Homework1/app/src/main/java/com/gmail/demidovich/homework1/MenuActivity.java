package com.gmail.demidovich.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gmail.demidovich.homework1.hw1.TextViewSwitcherActivity;
import com.gmail.demidovich.homework1.hw2.FlagsActivity;
import com.gmail.demidovich.homework1.hw3.ImagesAndGradleActivity;
import com.gmail.demidovich.homework1.hw4.MyAnimationActivity;

public class MenuActivity extends AppCompatActivity {
    private Button mButtonHW1;
    private Button mButtonHW2;
    private Button mButtonHW3;
    private Button mButtonHW4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mButtonHW1 = findViewById(R.id.button_hw1);
        mButtonHW2 = findViewById(R.id.button_hw2);
        mButtonHW3 = findViewById(R.id.button_hw3);
        mButtonHW4 = findViewById(R.id.button_hw4);

        mButtonHW1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,
                        TextViewSwitcherActivity.class));
            }
        });

        mButtonHW2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,
                        FlagsActivity.class));
            }
        });

        mButtonHW3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,
                        ImagesAndGradleActivity.class));
            }
        });

        mButtonHW4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,
                        MyAnimationActivity.class));
                overridePendingTransition(R.anim.left_out, R.anim.right_in);
            }
        });
    }
}

package com.gmail.demidovich.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gmail.demidovich.homework1.hw1.TextViewSwitcherActivity;
import com.gmail.demidovich.homework1.hw2.FlagsActivity;

public class MenuActivity extends AppCompatActivity {
    private Button mButtonHW1;
    private Button mButtonHW2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mButtonHW1 = findViewById(R.id.button_hw1);
        mButtonHW2 = findViewById(R.id.button_hw2);

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
    }
}

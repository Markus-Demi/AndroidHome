package com.gmail.demidovich.classwork1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gmail.demidovich.classwork1.classwork2.Classwork2Activity;
import com.gmail.demidovich.classwork1.classwork2.Singleton;
import com.gmail.demidovich.classwork1.classwork3.Classwork3Activity;
import com.gmail.demidovich.classwork1.classwork4.Classwork4Activity;
import com.gmail.demidovich.classwork1.classwork5.Classwork5Activity;

public class Classwork1Activity extends AppCompatActivity {

    private static final String TAG = Classwork1Activity.class.getCanonicalName();
    private Button button;
    private Button mButtonActivityChanger;
    private Button mButtonClassWork3;
    private Button mButtonClasswork4;
    private Button mButtonClasswork5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork1);
        Log.e(TAG, "onCreate()");

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(Classwork1Activity.this,
                        "button clicked",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL);
                toast.show();
            }
        });
        button.setText(BuildConfig.API_URL);

        mButtonActivityChanger = findViewById(R.id.button2);
        mButtonActivityChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton singleton = Singleton.getInstance();
                singleton.text = "hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";

                Intent intent = new Intent(Classwork1Activity.this,
                        Classwork2Activity.class);
                startActivity(intent);
                //finish(); // its like noHistory attribute but not
                // onPause() -> onStop -> onDestroy()
            }
        });

        mButtonClassWork3 = findViewById(R.id.button_cw3);
        mButtonClassWork3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Classwork1Activity.this,
                        Classwork3Activity.class);
                startActivity(intent);
            }
        });

        mButtonClasswork4 = findViewById(R.id.button_cw4);
        mButtonClasswork4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Classwork1Activity.this,
                        Classwork4Activity.class);
                startActivity(intent);
            }
        });

        mButtonClasswork5 = findViewById(R.id.button_cw5);
        mButtonClasswork5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Classwork1Activity.this,
                        Classwork5Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy()");
    }
}

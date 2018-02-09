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

public class Classwork1Activity extends AppCompatActivity {

    private static final String TAG = Classwork1Activity.class.getCanonicalName();
    private Button button;
    private Button mButtonActivityChanger;

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

        mButtonActivityChanger = findViewById(R.id.button2);
        mButtonActivityChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton singleton = Singleton.getInstance();
                singleton.text = "hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";

                Intent intent = new Intent(Classwork1Activity.this,
                        Classwork2Activity.class);
                intent.putExtra(Classwork2Activity.KEY_TEXT, "putExtraaaaaaaaaa");
                startActivity(intent);
                //finish(); // its like noHistory attribute but not
                // onPause() -> onStop -> onDestroy()
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

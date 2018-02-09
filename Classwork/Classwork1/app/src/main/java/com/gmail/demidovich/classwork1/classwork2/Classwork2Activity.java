package com.gmail.demidovich.classwork1.classwork2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gmail.demidovich.classwork1.R;

/**
 * Intent
 */
public class Classwork2Activity extends AppCompatActivity {

    public static final String KEY_TEXT = "KEY_TEXT";

    private Button mButtonCW2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork2);

        mButtonCW2 = findViewById(R.id.buttoncw2);
        mButtonCW2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = getIntent().getStringExtra(KEY_TEXT);

                if(text.contains("put")) {
                    Log.e("1", "contains");
                } else {
                    Log.e("2", "not contains");
                }
                //onBackPressed();
                finish(); // almost onBackPressed();
            }
        });
    }

}

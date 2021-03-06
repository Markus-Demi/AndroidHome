package com.gmail.demidovich.homework1.hw1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gmail.demidovich.homework1.R;

public class TextViewSwitcherActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView1;
    private TextView mTextView2;
    private Button mButton;
    private Button mButtonBack;
    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textSwapper();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textviewswitcher);

        mTextView1 = findViewById(R.id.textview1);
        mTextView2 = findViewById(R.id.textview2);

        mButton = findViewById(R.id.button);

        // 1 way:
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSwapper();
            }
        });

        // 2 way:
        // mButton.setOnClickListener(mClickListener);

        // 3 way:
        // mButton.setOnClickListener(this);

        mButtonBack = findViewById(R.id.button_back);
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void textSwapper() {
        if (mTextView1.getText().equals("")) {
            mTextView1.setText(mTextView2.getText());
            mTextView2.setText("");
        } else {
            mTextView2.setText(mTextView1.getText());
            mTextView1.setText("");
        }
    }

    @Override
    public void onClick(View v) {
        textSwapper();
    }
}

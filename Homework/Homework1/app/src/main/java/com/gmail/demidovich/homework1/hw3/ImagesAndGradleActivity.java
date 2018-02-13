package com.gmail.demidovich.homework1.hw3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gmail.demidovich.homework1.BuildConfig;
import com.gmail.demidovich.homework1.R;

public class ImagesAndGradleActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Button mButton;
    private EditText mEditText;
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagesandgradle);

        mButton = findViewById(R.id.download_ref_button);
        mEditText = findViewById(R.id.input_ref);
        mImageView = findViewById(R.id.img_view);
        mTextView = findViewById(R.id.text_api);

        mTextView.setText(BuildConfig.API_ENDPOINT);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(ImagesAndGradleActivity.this)
                        .load(mEditText.getText().toString())
                        .apply(RequestOptions.circleCropTransform())
                        .into(mImageView);
            }
        });
    }
}

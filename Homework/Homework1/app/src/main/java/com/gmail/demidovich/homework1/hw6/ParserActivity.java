package com.gmail.demidovich.homework1.hw6;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.gmail.demidovich.homework1.R;

import java.io.IOException;

public class ParserActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Button mButtonDownloadAndParse;
    private DownloadHelper mDownloadHelper;
    private TestFileAdapter mTestFileAdapter = new TestFileAdapter();
    private PeopleBank mPeopleBank = new PeopleBank();
    private ProgressBar mProgressBar;
    private EditText mEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parser);

        mProgressBar = findViewById(R.id.progress_bar);

        mRecyclerView = findViewById(R.id.recycler_view_id);
        mRecyclerView.setAdapter(mTestFileAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        mButtonDownloadAndParse = findViewById(R.id.dw_and_parse_button);
        mButtonDownloadAndParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDownloadHelper = new DownloadHelper();
                mDownloadHelper.execute();
            }
        });

        mEditText = findViewById(R.id.text_finder);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPeopleBank.wordSearch(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    class DownloadHelper extends AsyncTask<String, Void, PeopleBank> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected PeopleBank doInBackground(String... strings) {

            try {
                HttpDownloader.loader(ParserActivity.this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Parser.parse(ParserActivity.this);
        }

        @Override
        protected void onPostExecute(PeopleBank peopleBank) {
            super.onPostExecute(peopleBank);
            if (peopleBank.getPeopleList() != null)
                mTestFileAdapter.setPeopleListAdapter(peopleBank.getPeopleList());

            mProgressBar.setVisibility(View.INVISIBLE);
            mEditText.setVisibility(View.VISIBLE);
        }
    }
}

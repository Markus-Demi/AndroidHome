package com.gmail.demidovich.classwork1.classwork6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.gmail.demidovich.classwork1.R;

import java.util.ArrayList;
import java.util.List;

public class Classwork6Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<User> mUserList;
    private UserListAdapter mUserListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork6);
        mUserList = new ArrayList<>();

        mUserList.add(new User("", "User 1", "Surname 1"));
        mUserList.add(new User("", "User 2", "Surname 2"));
        mUserList.add(new User("", "User 3", "Surname 3"));
        mUserList.add(new User("", "User 4", "Surname 4"));
        mUserList.add(new User("", "User 5", "Surname 5"));
        mUserList.add(new User("", "User 6", "Surname 6"));
        mUserList.add(new User("", "User 7", "Surname 7"));
        mUserList.add(new User("", "User 8", "Surname 8"));
        mUserList.add(new User("", "User 9", "Surname 9"));
        mUserList.add(new User("", "User 10", "Surname 10"));
        mUserList.add(new User("", "User 11", "Surname 11"));
        mUserList.add(new User("", "User 12", "Surname 12"));
        mUserList.add(new User("", "User 13", "Surname 13"));
        mUserList.add(new User("", "User 14", "Surname 14"));
        mUserList.add(new User("", "User 15", "Surname 15"));

        mUserListAdapter = new UserListAdapter();
        mUserListAdapter.setUserList(mUserList);
        mUserListAdapter.setListener(new UserListAdapter.OnUserClickListener() {
            @Override
            public void onClick(User user, int position) {
                Toast.makeText(Classwork6Activity.this,
                        user.getName() + ", position: " + position + ". Yay!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView = findViewById(R.id.recycle_view_cw);
        mRecyclerView.setAdapter(mUserListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setHasFixedSize(true);
    }
}

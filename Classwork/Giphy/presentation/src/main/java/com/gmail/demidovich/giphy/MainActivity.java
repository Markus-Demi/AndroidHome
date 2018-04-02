package com.gmail.demidovich.giphy;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gmail.demidovich.giphy.base.BaseMVVMActivity;
import com.gmail.demidovich.giphy.databinding.ActivityMainBinding;

public class MainActivity extends BaseMVVMActivity<ActivityMainBinding, GifViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public GifViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(GifViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView = mBinding.getRoot().findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new ImageAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

    }
}

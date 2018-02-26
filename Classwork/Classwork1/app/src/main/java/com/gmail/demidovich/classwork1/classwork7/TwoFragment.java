package com.gmail.demidovich.classwork1.classwork7;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.demidovich.classwork1.R;

public class TwoFragment extends Fragment {

    private static final String KEY_VALUE = "KEY_VALUE";

    public static TwoFragment getInstance(FragmentManager fragmentManager, int value) {

        TwoFragment twoFragment = (TwoFragment) fragmentManager.findFragmentByTag(TwoFragment.class.getSimpleName());
        if (twoFragment == null) {
            twoFragment = new TwoFragment();
        }

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_VALUE, value);

        twoFragment.setArguments(bundle);

        return twoFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            int value = bundle.getInt(KEY_VALUE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // View view:
        return getLayoutInflater().inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // data is here (just like activity)

        Log.e("second fragment", "SECOND FRAGMENT");


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

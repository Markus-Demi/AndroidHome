package com.gmail.demidovich.classwork1.classwork7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.gmail.demidovich.classwork1.R;


// Fragments:
public class Classwork7Activity extends AppCompatActivity {

    private boolean isOneFragmentVisible = true;
    private FragmentManager mFragmentManager;

    private static final String SHARED_PREF_NAME = "shared_name_pref";
    private static final String KEY_NAME = "key_name";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork7);

        mFragmentManager = getSupportFragmentManager();

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);


        /*
        getFilesDir(); // return directory of an app
        getExternalFilesDir(); // access to dir w/ pics and other stuff



        findViewById(R.id.fragment_changer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentChanger();
            }
        });

        if (savedInstanceState == null) {
            showFragment(OneFragment.getInstance(mFragmentManager, 2), true);
        }
        */
    }

    @Override
    protected void onPause() {
        super.onPause();
        String text = sharedPreferences.getString(KEY_NAME, "");
        Log.e("SHARED_LOG", "text = " + text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sharedPreferences.edit().putString(KEY_NAME, "HELLO").apply();
    }

    /*
    private void fragmentChanger() {
        if (isOneFragmentVisible) {
            showFragment(TwoFragment.getInstance(mFragmentManager, 15), true);
            isOneFragmentVisible = false;
        } else {
            showFragment(OneFragment.getInstance(mFragmentManager, 16), true);
            isOneFragmentVisible = true;
        }
    }

    public void showFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }
    */
}

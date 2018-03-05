package com.gmail.demidovich.homework1.hw6;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

public class Parser {

    public static PeopleBank parse(Context context) {

        PeopleBank root = new PeopleBank();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(context.getFileStreamPath("test.json")));
            GsonBuilder builder = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateGsonConvertion());
            Gson gson = builder.create();

            root = gson.fromJson(bufferedReader, PeopleBank.class);
            Log.e("PeopleBank", root.toString());


        } catch (Exception e) {
            System.out.println("Something goes wrong with parse: " + e.toString());

        }

        return root;
    }
}

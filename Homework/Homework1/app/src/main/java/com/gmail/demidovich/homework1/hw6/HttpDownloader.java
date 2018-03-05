package com.gmail.demidovich.homework1.hw6;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownloader {

    private static final String LINK = "http://kiparo.ru/t/test.json";
    public static void loader(Context context) throws IOException {
        try {
            URL url = new URL(LINK);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                InputStream inputStream = connection.getInputStream();

                File file = new File(context.getFilesDir(), "test.json");

                FileOutputStream streamOut = new FileOutputStream(file);


                byte[] buffer = new byte[2048];
                int read;
                while ((read = inputStream.read(buffer)) != -1) {
                    streamOut.write(buffer, 0, read);
                }
            } else {
                return;
            }
        } catch (IOException e) {
            e.getMessage();
            return;
        }
    }
}
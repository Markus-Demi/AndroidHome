package com.gmail.demidovich.homework1.hw6;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateGsonConvertion implements JsonDeserializer<Date> {

    private final String[] dateFormat = new String[]{
            "yyyy-MM-dd HH:mm",
            "yyyy-MM-dd"
    };

    @Override
    public Date deserialize(JsonElement json, Type typeOfT,
                            JsonDeserializationContext context) throws JsonParseException {

        for (String format : dateFormat) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                return simpleDateFormat.parse(json.getAsString());
            } catch (Exception ex) {
            }
        }

        return null;
    }
}

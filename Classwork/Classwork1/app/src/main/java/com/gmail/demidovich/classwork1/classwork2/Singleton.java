package com.gmail.demidovich.classwork1.classwork2;

public class Singleton {
    private static Singleton instance = new Singleton();
    public String text;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }


}

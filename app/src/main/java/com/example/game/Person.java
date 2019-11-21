package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

public abstract class Person extends AppCompatActivity {
    public final String name="";
    public final int  age=0;


    public  abstract String Dialog();
    public  abstract String MessegeMaker(int tekDialog);
    public abstract void CreaterButton(int a,int b);


}

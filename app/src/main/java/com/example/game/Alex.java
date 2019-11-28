package com.example.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

public class Alex extends Person {

    private int health=100;
    private int buttonZnach=0;
    private int tekSost=0;

    private boolean weapon=false;

    public void setWeapon(boolean weapon) {
        this.weapon = weapon;
    }

    HashMap<String,Integer> dictionary = new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.malvina_activity);

    }
    public String Ivent(int str,int stl,Malvina mal,Alex al){
        return "12";
    }

    @Override
    public void DictionaryMaker() {

    }


}

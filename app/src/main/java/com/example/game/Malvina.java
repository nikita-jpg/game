package com.example.game;

import android.os.Bundle;

import java.util.HashMap;

public class Malvina extends Person {
    private int health = 100; //здоровье
    private int tekSost = 10;  //скорость

    private boolean weapon = false; // наличие оружия


    public void setWeapon(boolean weapon) {
        this.weapon = weapon;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
    public void DictionaryMaker() {
        dictionary.put("m_6_2", R.string.m_6_2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.malvina_activity);
        DictionaryMaker();
    }

    public String Ivent(int str,int stl,Malvina mal,Alex al){
        String name = "m_" + String.valueOf(str) + "_" + String.valueOf(stl);//строим строку для удобства чтения
        String result="";
        switch (name){
            case"m_4_3": // оружие достаётся Саше
                result="@7@1@";
                break;
            case "m_6_2":
                this.weapon=true;
                MainActivity.firstWeapon =false;
                result = "@7@1@";
                break;
            case "m_7_2":
                if(this.weapon == true) result = "@9@1@";
                else result  = "@8@3@";
                break;
            case "m_8_1":
                if(this.weapon == true) result = "@9@1@";
                else {
                    this.tekSost-=40;
                    result = "@8@3@";
                }
                break;
            case "m_12_1":
                if(this.weapon == true) {
                    result = "@14@1@";
                    this.weapon=false;
                }
                else result = "@13@1@";
                break;
            case "m_15_2":
                this.health-=10;
                result="@16@1@";
                break;
        }
        return result;
    }

}


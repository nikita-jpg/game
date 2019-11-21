package com.example.game;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Malvina extends Person implements View.OnClickListener {
    static public final String name ="Malvina";
    static public final int age=25;
    static int health=100;
    private int buttonZnach=0;
    private int tekSost=0;
    private String tekDialog ="m_1";
    private boolean i = true;
    final int a=1;
    final int b=2;

    public Button butL;
    public Button butR;



    private LinearLayout malvina_Layout;
    private LinearLayout.LayoutParams messegeParams;
    private LinearLayout.LayoutParams malvina_Btn_Params;
    private LinearLayout.LayoutParams malvina_BtnLayPar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.malvina_activity);
        malvina_Layout= findViewById(R.id.malvina_Layout);

        messegeParams=new LinearLayout.LayoutParams(450, ViewGroup.LayoutParams.MATCH_PARENT);
        messegeParams.gravity=Gravity.RIGHT;

        malvina_Btn_Params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        malvina_Btn_Params.gravity=Gravity.CENTER;
        malvina_Btn_Params.setMargins(10,0,10,0);
        malvina_Btn_Params.weight=1;

        malvina_BtnLayPar=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.Dialog();
    }


    public String Dialog(){
        int a=0;
        boolean i = true;

            if (tekSost == 0) {
                switch (tekDialog) {
                    case "m_1":
                        a = R.string.m_1;
                        MessegeMaker(a);
                        tekDialog = "m_2_2";
                    case "m_2_2":
                        a = R.string.m_2_2;
                        MessegeMaker(a);
                        CreaterButton(R.string.m_2_1, R.string.m_2_3); //Кнопка
                        tekSost = 0;
                        break;
                    case "m_2_2L":
                        a=R.string.m_3_1;
                        MessegeMaker(a);
                        tekDialog="m_3_1";
                        break;
                    case "m_2_2R":
                        a=R.string.m_3_3;
                        MessegeMaker(a);
                        CreaterButton(R.string.m_3_2,R.string.m_3_4); //Кнопка
                        tekSost=0;
                        break;
                    case "m_3_3L":
                        a=R.string.m_4_1;
                        MessegeMaker(a);
                        tekDialog="m_4_1";
                }
            }

        return tekDialog;
    }
    public String MessegeMaker(int tekDialog){

            TextView newText=new TextView(this);
            newText.setText(tekDialog);
            malvina_Layout.addView(newText,messegeParams);
            return "2";
        }

    public void CreaterButton(int leftBut,int rightBut){
        Button malvina_Btn_1 = new Button(this);
        Button malvina_Btn_2 = new Button(this);
        LinearLayout malvina_BtnLay = new LinearLayout(this);
        malvina_BtnLay.setOrientation(LinearLayout.HORIZONTAL);


        malvina_Btn_1.setText(leftBut);
        malvina_Btn_2.setText(rightBut);

        malvina_Btn_1.setOnClickListener(this);
        malvina_Btn_2.setOnClickListener(this);
        malvina_Btn_1.setId(a);
        malvina_Btn_2.setId(b);

        butL=malvina_Btn_1;
        butR=malvina_Btn_2;

        malvina_BtnLay.addView(butL,malvina_Btn_Params);
        malvina_BtnLay.addView(butR,malvina_Btn_Params);

        malvina_Layout.addView(malvina_BtnLay,malvina_BtnLayPar);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case a:
                tekSost=0;
                tekDialog=tekDialog.concat("L");
                butL.setBackgroundColor(Color.BLUE);
                butL.setEnabled(false);
                butR.setEnabled(false);
                Dialog();
                break;
            case b:
                tekSost=0;
                tekDialog+="R";
                butR.setBackgroundColor(Color.BLUE);
                butL.setEnabled(false);
                butR.setEnabled(false);
                Dialog();
                break;
        }
    }
}

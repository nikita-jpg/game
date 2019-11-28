package com.example.game;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static boolean firstWeapon =true;

    private String firstLet = "m_";
    private int str = 2;
    private int stl = 1;
    boolean k = true;
    final int a=1;
    final int b=2;
    private int kolDialogs=0;
    private int malKolDialog=17;


    public Button butL;
    public Button butR;

    private TextView scrollText;
    private TextView dialogTitle;
    private LinearLayout dialog_Lay;
    private LinearLayout main_Layout;
    private LinearLayout.LayoutParams messegeParams;
    private LinearLayout.LayoutParams main_Btn_Params;
    private LinearLayout.LayoutParams main_Btn_Lay_Par;

    HashMap<String, Integer> dictionary = new HashMap<String, Integer>();

    Malvina mal;
    Alex al;
    protected void DialogAl () {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        // создаем view из dialog.xml
        dialog_Lay = (LinearLayout) getLayoutInflater()
                .inflate(R.layout.dialog, null);
        // устанавливаем ее, как содержимое тела диалога
        adb.setView(dialog_Lay);
        // находим TexView для отображения кол-ва
        scrollText = (TextView) dialog_Lay.findViewById(R.id.scrollText);
        scrollText.setText("123");
        dialogTitle = (TextView) dialog_Lay.findViewById(R.id.dialogTitle);
        dialogTitle.setText("123");
        adb.setNegativeButton("ОК",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        adb.show();
    }
    private void DialogKreater(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Важное сообщение!")
                .setMessage("Играем за Мальвину")
                .setIcon(R.drawable.dialog)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_Layout = findViewById(R.id.main_Lay);
        messegeParams = new LinearLayout.LayoutParams(650, ViewGroup.LayoutParams.MATCH_PARENT);
        messegeParams.gravity = Gravity.RIGHT;
        messegeParams.setMargins(0,20,0,20);


        main_Btn_Params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        main_Btn_Params.gravity = Gravity.CENTER;
        main_Btn_Params.setMargins(10, 20, 10, 20);
        main_Btn_Params.weight = 1;

        main_Btn_Lay_Par = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        mal=new Malvina();
        al=new Alex();
        kolDialogs=malKolDialog;
        DictionaryMaker();
        Dialog();
    }
    private String TekString(){
        String name = firstLet + String.valueOf(str) + "_" + String.valueOf(stl);
        String tekDialog = getString(dictionary.get(name));
        return tekDialog;
    }
    private String StringCleaner(){
        if(TekString().indexOf('|')==-1)return TekString();
        else return TekString().substring(0,TekString().indexOf('|'));
    }
    private void DictionaryMaker() {
        dictionary.put("m_2_1", R.string.m_2_1);
        dictionary.put("m_2_2", R.string.m_2_2);

        dictionary.put("m_3_1", R.string.m_3_1);
        dictionary.put("m_3_2", R.string.m_3_2);

        dictionary.put("m_4_2", R.string.m_4_2);
        dictionary.put("m_4_3", R.string.m_4_3);

        dictionary.put("m_5_2", R.string.m_5_2);
        dictionary.put("m_6_2", R.string.m_6_2);

        dictionary.put("m_7_1", R.string.m_7_1);
        dictionary.put("m_7_2", R.string.m_7_2);

        dictionary.put("m_8_1", R.string.m_8_1);
        dictionary.put("m_8_3", R.string.m_8_3);
        dictionary.put("m_9_1", R.string.m_9_1);
        dictionary.put("m_10_1", R.string.m_10_1);

        dictionary.put("m_11_1", R.string.m_11_1);
        dictionary.put("m_12_1", R.string.m_12_1);
        dictionary.put("m_12_2", R.string.m_12_2);
        dictionary.put("m_13_1", R.string.m_13_1);

        dictionary.put("m_14_1", R.string.m_14_1);
        dictionary.put("m_14_2", R.string.m_14_2);
        dictionary.put("m_15_1", R.string.m_15_1);
        dictionary.put("m_15_2", R.string.m_15_2);

        dictionary.put("m_16_1", R.string.m_16_1);
        dictionary.put("m_17_1", R.string.m_17_1);
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void MessegeMaker(String tekDialog) {
        TextView newText = new TextView(this);
        newText.setBackground(ContextCompat.getDrawable(this,R.drawable.messege));
        newText.setTextColor(Color.parseColor("#e3e4e8"));

        newText.setGravity(Gravity.CENTER);
        newText.setPadding(10,5,10,5);
        newText.setText(tekDialog);
        main_Layout.addView(newText, messegeParams);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void CreaterButton() {
        Button main_Btn_1 = new Button(this);
        Button main_Btn_2 = new Button(this);

        main_Btn_1.setBackground(ContextCompat.getDrawable(this,R.drawable.btn_do_click));
        main_Btn_2.setBackground(ContextCompat.getDrawable(this,R.drawable.btn_do_click));

        LinearLayout main_BtnLay = new LinearLayout(this);
        main_BtnLay.setOrientation(LinearLayout.HORIZONTAL);
        String leftBtn;
        String rightBtn;

        String leftPerem = getString(dictionary.get(firstLet + String.valueOf(str + 1) + "_" + String.valueOf(stl)));
        if(leftPerem.indexOf('|') == -1) leftBtn=leftPerem;
        else leftBtn = leftPerem.substring(0,leftPerem.indexOf('|'));

        String rightPerem = getString(dictionary.get(firstLet + String.valueOf(str) + "_" + String.valueOf(stl + 1)));
        if(rightPerem.indexOf('|')==-1) rightBtn=rightPerem;
        else rightBtn = rightPerem.substring(0,rightPerem.indexOf('|'));


        main_Btn_1.setText(leftBtn);
        main_Btn_1.setTextColor(Color.parseColor("#e0e1e5"));
        main_Btn_2.setText(rightBtn);
        main_Btn_2.setTextColor(Color.parseColor("#e0e1e5"));

        main_Btn_1.setOnClickListener(this);
        main_Btn_2.setOnClickListener(this);
        main_Btn_1.setId(a);
        main_Btn_2.setId(b);

        butL = main_Btn_1;
        butR = main_Btn_2;

        main_BtnLay.addView(butL, main_Btn_Params);
        main_BtnLay.addView(butR, main_Btn_Params);

        main_Layout.addView(main_BtnLay, main_Btn_Lay_Par);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void Dialog() {
        while (str <= kolDialogs && TekString().indexOf('|') == -1) {
            MessegeMaker(StringCleaner());
            str++;
        }
        if(str <= kolDialogs) {
            MessegeMaker(StringCleaner());
            if (TekString().charAt(TekString().length() - 1) == 'I') {
                String btn = Ivent();
                if (TekString().charAt(TekString().length() - 2) == '&' && btn == "MakeBtn") {
                    CreaterButton();
                }
                else Dialog();
            }//Если ивент
            else if (TekString().charAt(TekString().length() - 2) == '&') {
                CreaterButton();
            }//Если кнопка
            else if (TekString().charAt(TekString().length() - 3) == '@') {
                Quantity(TekString());
                Dialog();
            }//Если перескоко
        }
    }
    private String Ivent() {
        String name = firstLet + String.valueOf(str) + "_" + String.valueOf(stl);
        String result="";
        switch (name.charAt(0)){
            case 'm':
                result= (mal.Ivent(str,stl,mal,al));
                break;
            case 'a':
                result= (al.Ivent(str,stl,mal,al));
                break;
        }
        if(result.indexOf('b')!=-1){
            result="MakeBtn";
        }//Если ивент сказал делать кнопку
        else if( result.indexOf('@')!=-1){
            Quantity(result);
            result="";
        }//Если ивент сказал перемещать диалог
        return result;
    }

    private void Quantity(String tekDIalog) {
        String c = "";
        if(tekDIalog.indexOf('@')!=-1) {
            int i = 0;
            for (i = tekDIalog.indexOf('@') + 1; tekDIalog.charAt(i) != '@'; i++) {
                c = c.concat(String.valueOf(tekDIalog.charAt(i)));
            }
            i++;
            if (c != "") str = Integer.parseInt(c);
            c = "";
            while (tekDIalog.charAt(i) != '@') {
                c = c.concat(String.valueOf(tekDIalog.charAt(i)));
                i++;
            }
            if (c != "") stl = Integer.parseInt(c);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case a:
                str++;
                butL.setBackground(ContextCompat.getDrawable(this,R.drawable.btn_posle_click));
                butL.setEnabled(false);
                butR.setEnabled(false);
                if(TekString().indexOf('|')==-1)
                    str++;
                else {
                    if(TekString().indexOf('I')!=-1) Ivent();
                    else Quantity(TekString());
                }
                break;
            case b:
                stl++;
                butR.setBackground(ContextCompat.getDrawable(this,R.drawable.btn_posle_click));
                butL.setEnabled(false);
                butR.setEnabled(false);
                if(TekString().indexOf('|')==-1)
                    str++;
                else {
                    if(TekString().indexOf('I')!=-1) Ivent();
                    else Quantity(TekString());
                }
                break;
        }
        Dialog();
    }

}

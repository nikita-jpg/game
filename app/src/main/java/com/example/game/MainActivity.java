package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView malvinaText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        malvinaText=findViewById(R.id.malvina);
        malvinaText.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.malvina:
                Intent intent=new Intent(this,Malvina.class);
                startActivity(intent);

        }

    }
}

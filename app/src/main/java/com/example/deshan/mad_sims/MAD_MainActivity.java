package com.example.deshan.mad_sims;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.deshan.mad_sims.Marks.MainMarksActivity;

public class MAD_MainActivity extends AppCompatActivity {

    private static Button button_enterAtt;
    private static Button button_enterMar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad__main);
        onClickButtonListener();
        onClickButtonListner1();
    }

    public void onClickButtonListener(){
        button_enterAtt = (Button)findViewById(R.id.button14);
        button_enterAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(".desMainActivity");
                startActivity(intent1);
            }
        });

    }

    public void onClickButtonListner1(){
        button_enterMar = (Button)findViewById(R.id.button15);
        button_enterMar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MAD_MainActivity.this,MainMarksActivity.class);
                startActivity(intent2);
            }
        });
    }
}

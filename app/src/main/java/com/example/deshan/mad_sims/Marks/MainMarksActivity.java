package com.example.deshan.mad_sims.Marks;

import android.content.Intent;
import android.os.Binder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.deshan.mad_sims.R;

public class MainMarksActivity extends AppCompatActivity {

    private static Button button_enterAddMar;
    private static Button button_enterUpdateMar;
    private static Button button_enterDeleteMar;
    private static Button button_enterviewMar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_marks);

        onClickButtonlistnerAdd();
        onClickButtonListnerUpdate();
        onClickButtonListnerDelete();
        onClickButtonListnerView();
    }

    public void onClickButtonlistnerAdd(){
        button_enterAddMar = (Button)findViewById(R.id.button);
        button_enterAddMar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMarksActivity.this,AddMarksActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClickButtonListnerUpdate(){
        button_enterUpdateMar = (Button)findViewById(R.id.button2);
        button_enterUpdateMar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainMarksActivity.this,UpdateMarksActivity.class);
                startActivity(intent1);
            }
        });
    }

    public void onClickButtonListnerDelete(){
        button_enterDeleteMar = (Button)findViewById(R.id.button3);
        button_enterDeleteMar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainMarksActivity.this,DeleteMarksActivity.class);
                startActivity(intent2);
            }
        });
    }

    public void onClickButtonListnerView(){
        button_enterviewMar = (Button)findViewById(R.id.button4);
        button_enterviewMar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainMarksActivity.this,ViewMarksActivity.class);
                startActivity(intent3);
            }
        });
    }

}

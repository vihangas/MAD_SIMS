package com.example.deshan.mad_sims;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MAD_MainActivity extends AppCompatActivity {

    private static Button button_enterAtt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad__main);
        onClickButtonListener();

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
}

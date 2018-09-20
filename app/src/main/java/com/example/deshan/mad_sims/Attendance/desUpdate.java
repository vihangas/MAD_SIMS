package com.example.deshan.mad_sims.Attendance;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.deshan.mad_sims.R;

import java.util.Calendar;

public class desUpdate extends AppCompatActivity {

    Button btn;
    int year,month,date;
    static  final int dilog_id = 0;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_des_update);

        final Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        date = cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnButtonClick();

        Spinner subjects2 = (Spinner)findViewById(R.id.spinner7);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(desUpdate.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.subs));

        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjects2.setAdapter(myAdapter2);

        Spinner classTypes = (Spinner)findViewById(R.id.spinner4);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(desUpdate.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.types));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classTypes.setAdapter(myAdapter1);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showDialogOnButtonClick(){
        btn = (Button)findViewById(R.id.button12);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(dilog_id);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == dilog_id)
            return new DatePickerDialog(this,dpickerListener,year,month,date);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            year = i;
            month = i1;
            date = i2;

            txt = (TextView)findViewById(R.id.textView18);
            txt.setText(year+"/"+month+"/"+date);
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);

    }
}

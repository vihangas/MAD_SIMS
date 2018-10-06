package com.example.deshan.mad_sims.Marks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.deshan.mad_sims.R;

public class UpdateMarksActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner semID;
    Spinner examID;
    Spinner subID;
    Spinner atten;
    Button update_btn;
    DBHelper mydb;
    EditText marks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_marks);
        mydb = new DBHelper(this);

        semID = (Spinner)findViewById(R.id.spinner11);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.semester_id,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semID.setAdapter(arrayAdapter);

        semID.setOnItemSelectedListener(this);

        examID = (Spinner)findViewById(R.id.spinner12);
        ArrayAdapter<CharSequence>arrayAdapter1 = ArrayAdapter.createFromResource(this,R.array.exam_id,android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        examID.setAdapter(arrayAdapter1);

        examID.setOnItemSelectedListener(this);

        subID = (Spinner)findViewById(R.id.spinner13);
        ArrayAdapter<CharSequence>arrayAdapter2 = ArrayAdapter.createFromResource(this,R.array.subject_id,android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subID.setAdapter(arrayAdapter2);

        subID.setOnItemSelectedListener(this);

        atten = (Spinner)findViewById(R.id.spinner14);
        ArrayAdapter<CharSequence>arrayAdapter3 = ArrayAdapter.createFromResource(this,R.array.attendance,android.R.layout.simple_spinner_item);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        atten.setAdapter(arrayAdapter3);

        atten.setOnItemSelectedListener(this);

        update_btn = (Button)findViewById(R.id.button9);
        marks = (EditText)findViewById(R.id.editText4);

        updateData();
    }

    public void updateData(){
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdated = mydb.updateData(semID.getSelectedItem().toString(),examID.getSelectedItem().toString(),subID.getSelectedItem().toString(),atten.getSelectedItem().toString(),Integer.valueOf(marks.getText().toString()));
                if(isUpdated == true)
                    Toast.makeText(UpdateMarksActivity.this,"Data Successfully Updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(UpdateMarksActivity.this,"Data Not Updated",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onItemSelected(AdapterView<?>parent, View view, int pos, long id){
        String item = parent.getItemAtPosition(pos).toString();
        Toast.makeText(parent.getContext(),item,Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?>parent){
        Toast.makeText(parent.getContext(),"Data not Inserted",Toast.LENGTH_LONG).show();
    }
}

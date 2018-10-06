package com.example.deshan.mad_sims.Marks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deshan.mad_sims.R;

public class AddMarksActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner semID;
    Spinner examID;
    Spinner subID;
    Spinner atten;
    DBHelper mydb;
    Button btn_add;
    EditText marks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_marks);
        mydb = new DBHelper(this);

        semID = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence>arrayAdapter = ArrayAdapter.createFromResource(this,R.array.semester_id,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semID.setAdapter(arrayAdapter);

        semID.setOnItemSelectedListener(this);

        examID = (Spinner)findViewById(R.id.spinner9);
        ArrayAdapter<CharSequence>arrayAdapter1 = ArrayAdapter.createFromResource(this,R.array.exam_id,android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        examID.setAdapter(arrayAdapter1);

        examID.setOnItemSelectedListener(this);

        subID = (Spinner)findViewById(R.id.spinner10);
        ArrayAdapter<CharSequence>arrayAdapter2 = ArrayAdapter.createFromResource(this,R.array.subject_id,android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subID.setAdapter(arrayAdapter2);

        subID.setOnItemSelectedListener(this);

        atten = (Spinner)findViewById(R.id.spinner8);
        ArrayAdapter<CharSequence>arrayAdapter3 = ArrayAdapter.createFromResource(this,R.array.attendance,android.R.layout.simple_spinner_item);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        atten.setAdapter(arrayAdapter3);

        atten.setOnItemSelectedListener(this);

        btn_add = (Button)findViewById(R.id.button5);
        marks = (EditText)findViewById(R.id.editText18);

        addData();
    }

    public void addData(){
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String attendance = atten.getSelectedItem().toString();
                marks = (EditText)findViewById(R.id.editText18);
                if(marks.getText().toString().equals("")){
                    Toast.makeText(AddMarksActivity.this,"Marks cannot be Empty!",Toast.LENGTH_LONG).show();
                }
                else if(attendance.equals("No")){
                    Toast.makeText(AddMarksActivity.this,"Marks cannot be inserted without Attendance!",Toast.LENGTH_LONG).show();
                    return;
                }
                else {

                    boolean isInserted = mydb.insertData(semID.getSelectedItem().toString(), examID.getSelectedItem().toString(), subID.getSelectedItem().toString(), atten.getSelectedItem().toString(), Integer.valueOf(marks.getText().toString()));
                    if (isInserted == true)
                        Toast.makeText(AddMarksActivity.this, "Data Successfully Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(AddMarksActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onItemSelected(AdapterView<?>parent, View view, int pos, long id){
        String item = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?>parent){
        Toast.makeText(parent.getContext(),"Data not Selected",Toast.LENGTH_LONG).show();
    }
}

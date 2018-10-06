package com.example.deshan.mad_sims.Marks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.deshan.mad_sims.R;

public class DeleteMarksActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner semID;
    Spinner examID;
    Spinner subID;
    DBHelper mydb;
    Button delete_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_marks);
        mydb = new DBHelper(this);

        semID = (Spinner)findViewById(R.id.spinner15);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.semester_id,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semID.setAdapter(arrayAdapter);

        semID.setOnItemSelectedListener(this);

        examID = (Spinner)findViewById(R.id.spinner16);
        ArrayAdapter<CharSequence>arrayAdapter1 = ArrayAdapter.createFromResource(this,R.array.exam_id,android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        examID.setAdapter(arrayAdapter1);

        examID.setOnItemSelectedListener(this);

        subID = (Spinner)findViewById(R.id.spinner17);
        ArrayAdapter<CharSequence>arrayAdapter2 = ArrayAdapter.createFromResource(this,R.array.subject_id,android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subID.setAdapter(arrayAdapter2);

        subID.setOnItemSelectedListener(this);

        delete_btn = (Button)findViewById(R.id.button6);

        deleteData();

    }

    public void deleteData(){
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean deletedRow = mydb.deleteData(semID.getSelectedItem().toString(),examID.getSelectedItem().toString(),subID.getSelectedItem().toString());

                if(deletedRow == true)
                    Toast.makeText(DeleteMarksActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DeleteMarksActivity.this,"Data Not Deleted",Toast.LENGTH_LONG).show();
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

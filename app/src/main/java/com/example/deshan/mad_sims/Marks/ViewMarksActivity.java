package com.example.deshan.mad_sims.Marks;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.deshan.mad_sims.R;

public class ViewMarksActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner semID;
    Spinner examID;
    Spinner subID;
    DBHelper mydb;
    Button view_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_marks);
        mydb = new DBHelper(this);

        view_btn = (Button)findViewById(R.id.button7);

        semID = (Spinner)findViewById(R.id.spinner18);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.semester_id,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semID.setAdapter(arrayAdapter);

        semID.setOnItemSelectedListener(this);

        examID = (Spinner)findViewById(R.id.spinner19);
        ArrayAdapter<CharSequence>arrayAdapter1 = ArrayAdapter.createFromResource(this,R.array.exam_id,android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        examID.setAdapter(arrayAdapter1);

        examID.setOnItemSelectedListener(this);

        subID = (Spinner)findViewById(R.id.spinner20);
        ArrayAdapter<CharSequence>arrayAdapter2 = ArrayAdapter.createFromResource(this,R.array.subject_id,android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subID.setAdapter(arrayAdapter2);

        subID.setOnItemSelectedListener(this);

        viewAll();
    }

    public void  viewAll(){
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = mydb.getData(semID.getSelectedItem().toString(),examID.getSelectedItem().toString(),subID.getSelectedItem().toString());
                if(res.getCount()==0){
                    showMessage("Error", "No Data Available");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                   // buffer.append("ID: "+res.getString(0)+"\n");
                    buffer.append("Semester ID: "+res.getString(1)+"\n");
                    buffer.append("Exam ID: "+res.getString(2)+"\n");
                    buffer.append("Subject ID: "+res.getString(3)+"\n");
                    buffer.append("Attendance: "+res.getString(4)+"\n");
                    buffer.append("Marks: "+res.getInt(5)+"\n\n");
                }
                showMessage("Data",buffer.toString());
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

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

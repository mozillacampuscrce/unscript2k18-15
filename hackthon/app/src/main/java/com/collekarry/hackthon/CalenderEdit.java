package com.collekarry.hackthon;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class CalenderEdit extends AppCompatActivity implements View.OnClickListener {

    EditText name,mail,cgpa,branch;
    Button add;
    static String cgpaa;

    DatabaseReference details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_edit);

        name = (EditText) findViewById(R.id.cmpName);
        mail = (EditText) findViewById(R.id.mail);
        cgpa = (EditText) findViewById(R.id.cgpa);
        branch = (EditText) findViewById(R.id.branch);

        add = (Button) findViewById(R.id.adddet);
        details = FirebaseDatabase.getInstance().getReference("company");

        add.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        addDetails();
    }

    public void addDetails(){

        String nameee = name.getText().toString().trim();
        String  mailee=  mail.getText().toString().trim();
        cgpaa = cgpa.getText().toString().trim();
        String branchh = branch.getText().toString().trim();

        if(!TextUtils.isEmpty(nameee) && !TextUtils.isEmpty(mailee) && !TextUtils.isEmpty(cgpaa) && !TextUtils.isEmpty(branchh)){

            String id = details.push().getKey();
            Company store = new Company(id,nameee,mailee,cgpaa,branchh);
            details.child(id).setValue(store);

            Toast.makeText(this, "details Added!!!!", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Enter the details......", Toast.LENGTH_SHORT).show();
    }
}

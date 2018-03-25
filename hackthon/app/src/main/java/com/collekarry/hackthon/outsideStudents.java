package com.collekarry.hackthon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.collekarry.hackthon.ManageEvent.goBack;

public class outsideStudents extends AppCompatActivity implements View.OnClickListener {

    EditText nameEnter,collgEnter,univEnter;
    Button select,payButton;
    TextView selectedEvent;
    String nameDet,collgDet,univDet;
    static int check =0;

    DatabaseReference details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outside_students);

        nameEnter = (EditText) findViewById(R.id.nameEnter);
        collgEnter = (EditText) findViewById(R.id.collgEnter);
        univEnter = (EditText) findViewById(R.id.univEnter);
        selectedEvent = (TextView) findViewById(R.id.eventSelector);

        details = FirebaseDatabase.getInstance().getReference("OutSide");

        selectedEvent.setText(goBack);

        select = (Button) findViewById(R.id.selevtEvent);
        payButton = (Button) findViewById(R.id.payButton);

        select.setOnClickListener(this);
        payButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == select){
            check=1;
            Intent intent = new Intent(getApplicationContext() , ManageEvent.class);
            startActivity(intent);

        }else{

            addDetails();

        }

    }

    public void addDetails() {

        nameDet = nameEnter.getText().toString();
        collgDet = nameEnter.getText().toString();
        univDet = nameEnter.getText().toString();

        if (!TextUtils.isEmpty(nameDet) && !TextUtils.isEmpty(collgDet) && !TextUtils.isEmpty(univDet)) {

            String id = details.push().getKey();
            Outside store = new Outside(id, nameDet, collgDet, univDet, goBack, "PAID");
            details.child(id).setValue(store);

            Toast.makeText(this, "details Added!!!!", Toast.LENGTH_SHORT).show();
        } else {
            Log.i("name:",nameDet);
            Log.i("colg:",collgDet);
            Log.i("univ:",univDet);
            Toast.makeText(this, "Enter the details......", Toast.LENGTH_SHORT).show();
        }
    }
}

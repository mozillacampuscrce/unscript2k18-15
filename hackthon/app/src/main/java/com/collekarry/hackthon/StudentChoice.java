package com.collekarry.hackthon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentChoice extends AppCompatActivity implements View.OnClickListener {

    Button outside,inside,placemnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_choice);

        outside = (Button) findViewById(R.id.outsideButton);
        inside = (Button) findViewById(R.id.insideButton);
        placemnet = (Button) findViewById(R.id.placement);

        outside.setOnClickListener(this);
        inside.setOnClickListener(this);
        placemnet.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == outside){
            Intent intent = new Intent(getApplicationContext() , outsideStudents.class);
            startActivity(intent);
        }
        else if(view == inside){

            Intent intent = new Intent(getApplicationContext() , eventDetails.class);
            startActivity(intent);

        }
        else
        {
            Intent intent = new Intent(getApplicationContext() , GotPlace.class);
            startActivity(intent);
        }


    }
}

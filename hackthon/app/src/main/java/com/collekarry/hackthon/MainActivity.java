package com.collekarry.hackthon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText usrEditText,passEditText;
    Button logCommitee,logStudent,placeLog;
    String name="",pass="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usrEditText = (EditText) findViewById(R.id.usrEditText);
        passEditText = (EditText) findViewById(R.id.passEditText);

        logCommitee = (Button) findViewById(R.id.LoginCommitte);
        logStudent = (Button) findViewById(R.id.StudentLogin);
        placeLog = (Button) findViewById(R.id.placeLog);


        logCommitee.setOnClickListener(this);
        logStudent.setOnClickListener(this);
        placeLog.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        name = usrEditText.getText().toString();
        pass = passEditText.getText().toString();
        if(view == logCommitee){

            if(!name.equals("") && !pass.equals("")){

                Intent intent = new Intent(getApplicationContext() , changeUsr.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Enter the contents", Toast.LENGTH_LONG).show();
            }
        }
        else if (view == logStudent){
            if(!name.equals("") && !pass.equals("")){
                Intent intent = new Intent(getApplicationContext() , StudentChoice.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Enter the contents", Toast.LENGTH_LONG).show();
            }
        }
        else{

            if(!name.equals("") && !pass.equals("")){
                Intent intent = new Intent(getApplicationContext() , CalenderEdit.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Enter the contents", Toast.LENGTH_LONG).show();
            }

        }

    }
}

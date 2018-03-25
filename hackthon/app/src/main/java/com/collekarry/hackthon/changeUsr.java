package com.collekarry.hackthon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class changeUsr extends AppCompatActivity implements View.OnClickListener {

    Button create,manage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_usr);

        create = (Button) findViewById(R.id.create);
        manage = (Button) findViewById(R.id.manage);
        create.setOnClickListener(this);
        manage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == create){

            Intent intent = new Intent(getApplicationContext() , eventDetails.class);
            startActivity(intent);

        }else {

            Intent intent = new Intent(getApplicationContext() , ManageEvent.class);
            startActivity(intent);
        }

    }
}

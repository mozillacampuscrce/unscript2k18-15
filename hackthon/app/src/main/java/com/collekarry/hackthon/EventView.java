package com.collekarry.hackthon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.collekarry.hackthon.ManageEvent.Eventname;
import static com.collekarry.hackthon.ManageEvent.councilname;
import static com.collekarry.hackthon.ManageEvent.rate;
import static com.collekarry.hackthon.ManageEvent.status;

public class EventView extends AppCompatActivity {


    //static String Eventname,councilname,rate,discription,status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);

        TextView v1 = (TextView) findViewById(R.id.v1);
        TextView v2 = (TextView) findViewById(R.id.v2);
        TextView v3 = (TextView) findViewById(R.id.v3);
        TextView v4 = (TextView) findViewById(R.id.v4);

        v1.setText(councilname);
        v2.setText(Eventname);
        v3.setText(rate);
        v4.setText(status);
    }
}

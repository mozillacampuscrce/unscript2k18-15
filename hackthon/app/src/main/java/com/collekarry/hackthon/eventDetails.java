package com.collekarry.hackthon;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class eventDetails extends AppCompatActivity implements View.OnClickListener {

    EditText councilEditText,eventEditText,rateEditText,discripEditText;
    DatabaseReference details;
    Button add,addDate,viewCalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        councilEditText = (EditText) findViewById(R.id.councilEditText);
        eventEditText = (EditText) findViewById(R.id.eventEditText);
        rateEditText = (EditText) findViewById(R.id.rateEditText);
        discripEditText = (EditText) findViewById(R.id.discrpEditText);

        details = FirebaseDatabase.getInstance().getReference("Store");

        add = (Button) findViewById(R.id.addButton);
        addDate = (Button) findViewById(R.id.addDate);
        viewCalender = (Button) findViewById(R.id.viewCalender);

        add.setOnClickListener(this);
        addDate.setOnClickListener(this);
        viewCalender.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(viewCalender == view){
            Intent calIntent = new Intent(Intent.ACTION_INSERT);
            calIntent.setType("vnd.android.cursor.item/event");
            calIntent.putExtra(CalendarContract.Events.TITLE, "My House Party");
            calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "My Beach House");
            calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "A Pig Roast on the Beach");

            GregorianCalendar calDate = new GregorianCalendar(2012, 7, 15);
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                    calDate.getTimeInMillis());
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                    calDate.getTimeInMillis());

            startActivity(calIntent);
        }
        else
            addDetails();
    }

    public void addDetails(){

        String council = councilEditText.getText().toString().trim();
        String event =  eventEditText.getText().toString().trim();
        String rate = rateEditText.getText().toString().trim();
        String dsrip = discripEditText.getText().toString().trim();

        if(!TextUtils.isEmpty(council) && !TextUtils.isEmpty(event) && !TextUtils.isEmpty(rate) && !TextUtils.isEmpty(dsrip)){

            String id = details.push().getKey();
            Store store = new Store(id,council,event,rate,dsrip,"PENDING");
            details.child(id).setValue(store);

            Toast.makeText(this, "details Added!!!!", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Enter the details......", Toast.LENGTH_SHORT).show();
    }
}

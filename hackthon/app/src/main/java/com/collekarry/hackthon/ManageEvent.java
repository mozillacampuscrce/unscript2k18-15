package com.collekarry.hackthon;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.collekarry.hackthon.outsideStudents.check;


public class ManageEvent extends AppCompatActivity {

    static ArrayList<String> arrayList = new ArrayList<>();

    DatabaseReference mDatabaseReference;
    List<Store> uploadList;


    static String goBack,Eventname,councilname,rate,discription,status;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_event);

        uploadList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Store");

        //adding a clicklistener on listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the upload
                Store upload = uploadList.get(i);


                rate = upload.getRate();
                councilname = upload.getCouncilName();
                Eventname = upload.getEventName();
                discription = upload.getDsrip();
                status = upload.getStatus();

                Log.i("DATA:",rate);

                if(check ==1){
                    check=0;
                    goBack = Eventname;
                    Intent intent = new Intent(getApplicationContext() , outsideStudents.class);
                    startActivity(intent);
                }
                else{

                    Intent intent = new Intent(getApplicationContext() , EventView.class);
                    startActivity(intent);
                }

            }
        });

        //retrieving upload data from firebase database
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Store upload = postSnapshot.getValue(Store.class);
                    uploadList.add(upload);
                }

                String[] uploads = new String[uploadList.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = uploadList.get(i).getEventName();
                }

                //displaying it to list
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {



            }
        });

    }
}

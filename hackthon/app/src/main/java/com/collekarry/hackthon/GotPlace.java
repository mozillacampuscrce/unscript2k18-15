package com.collekarry.hackthon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.collekarry.hackthon.CalenderEdit.cgpaa;
import static com.collekarry.hackthon.outsideStudents.check;

public class GotPlace extends AppCompatActivity {

    static ArrayList<String> arrayList = new ArrayList<>();
    int z=0;
    DatabaseReference mDatabaseReference;
    List<Company> uploadList;
    ListView listV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_got_place);

        uploadList = new ArrayList<>();
        listV = (ListView) findViewById(R.id.listview1);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("company");

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             

            }
        });


        //retrieving upload data from firebase database
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Company upload = postSnapshot.getValue(Company.class);
                    uploadList.add(upload);
                }
                System.out.println("Neha");
                Log.i("Neha","Hello");
                String[] uploads = new String[uploadList.size()];
                Log.i("neha",uploadList.get(0).getCgpaa());

                for (int i = 0; i < uploads.length; i++) {

                      uploads[i] = uploadList.get(i).getNameee();
                }

                //displaying it to list
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads);
                listV.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {



            }
        });
    }
}

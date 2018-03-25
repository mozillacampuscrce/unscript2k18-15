package com.collekarry.hackthon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class StudentPermission extends AppCompatActivity {
    EditText studentText,studentCGPA,studentBranch;
    Button studentAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_permission);

        studentText=(EditText)findViewById(R.id.studentText);
        studentCGPA=(EditText)findViewById(R.id.studentCGPA);
        studentBranch=(EditText)findViewById(R.id.studentBranch);
        studentAddButton=(Button)findViewById(R.id.studentAddButton);

        
    }

}

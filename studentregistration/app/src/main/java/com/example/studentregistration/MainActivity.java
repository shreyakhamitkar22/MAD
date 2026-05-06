package com.example.studentregistration;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName, etRoll, etCourse, etEmail;
    Button btnRegister;
    ListView listView;

    ArrayList<String> studentList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etRoll = findViewById(R.id.etRoll);
        etCourse = findViewById(R.id.etCourse);
        etEmail = findViewById(R.id.etEmail);
        btnRegister = findViewById(R.id.btnRegister);
        listView = findViewById(R.id.listView);

        studentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                studentList);

        listView.setAdapter(adapter);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString().trim();
                String roll = etRoll.getText().toString().trim();
                String course = etCourse.getText().toString().trim();
                String email = etEmail.getText().toString().trim();

                if(name.isEmpty() || roll.isEmpty()
                        || course.isEmpty() || email.isEmpty()) {

                    Toast.makeText(MainActivity.this,
                            "Please fill all fields",
                            Toast.LENGTH_SHORT).show();
                }
                else {

                    String studentData =
                            "Name: " + name +
                                    "\nRoll No: " + roll +
                                    "\nCourse: " + course +
                                    "\nEmail: " + email;

                    studentList.add(studentData);
                    adapter.notifyDataSetChanged();

                    Toast.makeText(MainActivity.this,
                            "Student Registered Successfully",
                            Toast.LENGTH_SHORT).show();

                    etName.setText("");
                    etRoll.setText("");
                    etCourse.setText("");
                    etEmail.setText("");
                }
            }
        });
    }
}

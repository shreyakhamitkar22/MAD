package com.example.allcontrolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    ImageButton imgBtn;
    CheckBox checkBox;
    RadioGroup radioGroup;
    ToggleButton toggleButton;
    Spinner spinner;
    RatingBar ratingBar;
    ProgressBar progressBar;

    Button btnSubmit, btnProgress, btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtn = findViewById(R.id.imageButton);
        checkBox = findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        toggleButton = findViewById(R.id.toggleButton);
        spinner = findViewById(R.id.spinner);
        ratingBar = findViewById(R.id.ratingBar);
        progressBar = findViewById(R.id.progressBar);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnProgress = findViewById(R.id.btnProgress);
        btnAlert = findViewById(R.id.btnAlert);

        // Image Button Click
        imgBtn.setOnClickListener(v ->
                Toast.makeText(this, "Image Button Clicked", Toast.LENGTH_SHORT).show());

        // Checkbox
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Unchecked", Toast.LENGTH_SHORT).show();
        });

        // Toggle
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                Toast.makeText(this, "Toggle ON", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Toggle OFF", Toast.LENGTH_SHORT).show();
        });

        // Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        parent.getItemAtPosition(i).toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Rating
        btnSubmit.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            Toast.makeText(this, "Rating: " + rating, Toast.LENGTH_LONG).show();
        });

        // Progress Bar
        btnProgress.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
        });

        // Alert Dialog
        btnAlert.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Alert")
                    .setMessage("Do you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialog, id) -> finish())
                    .setNegativeButton("No", (dialog, id) -> dialog.cancel());

            builder.create().show();
        });
    }
}
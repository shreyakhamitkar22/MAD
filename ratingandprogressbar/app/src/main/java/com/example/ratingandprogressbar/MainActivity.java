package com.example.ratingandprogressbar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ProgressBar;
import android.app.ProgressDialog;

public class MainActivity extends AppCompatActivity {

    RatingBar r;
    Button b, b1;
    ProgressBar p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = findViewById(R.id.ratingBar);
        b = findViewById(R.id.button);
        b1 = findViewById(R.id.button1);
        p = findViewById(R.id.progress);

        // Rating Button
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = String.valueOf(r.getRating());
                Toast.makeText(MainActivity.this,
                        "Rating: " + rating,
                        Toast.LENGTH_LONG).show();

                p.setVisibility(View.VISIBLE);
            }
        });

        // Progress Dialog Button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressDialog progressBar = new ProgressDialog(MainActivity.this);
                progressBar.setCancelable(true);
                progressBar.setMessage("File downloading ...");
                progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressBar.setProgress(0);
                progressBar.setMax(100);
                progressBar.show();
            }
        });
    }
}
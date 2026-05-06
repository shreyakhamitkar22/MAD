package com.example.optionmenu;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
public class MainActivity extends AppCompatActivity {
    RelativeLayout currentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentLayout =(RelativeLayout) findViewById(R.id.a);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.android:
                currentLayout.setBackgroundColor(Color.RED);
                return false;
            case R.id.java:
                currentLayout.setBackgroundColor(Color.GREEN);
                return false;
            case R.id.kotlin:
                currentLayout.setBackgroundColor(Color.BLUE);
                return false;
            default:
                return super.onOptionsItemSelected(item);
        } }}

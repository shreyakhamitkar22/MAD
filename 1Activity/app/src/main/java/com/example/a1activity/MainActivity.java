package com.example.a1activity;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.print("lifecycle onCreate invoked");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked");
        Toast.makeText(getApplicationContext(), "onStart Called",
                Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume invoked");
        Toast.makeText(getApplicationContext(), "onResume Called",
                Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause invoked");
        Toast.makeText(getApplicationContext(), "onPause Called",
                Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked");
        Toast.makeText(getApplicationContext(), "onStop Called",
                Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked");
        Toast.makeText(getApplicationContext(), "onRestart Called",
                Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");
        Toast.makeText(getApplicationContext(), "onDestroy Called",
                Toast.LENGTH_LONG).show();
    }
}

package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSms, btnCall, btnSettings, btnNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSms = findViewById(R.id.btnSms);
        btnCall = findViewById(R.id.btnCall);
        btnSettings = findViewById(R.id.btnSettings);
        btnNetwork = findViewById(R.id.btnNetwork);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE}, 1);

        //Send SMS
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("sms:9876543210"));
                smsIntent.putExtra("sms_body", "Hello from Implicit Intent App");
                startActivity(smsIntent);
            }
        });

        //Make Call
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9876543210"));
                startActivity(callIntent);
            }
        });

        //Open Settings
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(settingsIntent);
            }
        });

        //Fetch Network Details
        btnNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConnectivityManager cm =
                        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

                String networkType = "No Connection";

                if (activeNetwork != null && activeNetwork.isConnected()) {

                    if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                        networkType = "Connected to WiFi";
                    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                        networkType = "Connected to Mobile Data";
                    }
                }

                TelephonyManager tm =
                        (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

                String operatorName = tm.getNetworkOperatorName();

                Toast.makeText(MainActivity.this,
                        networkType + "\nOperator: " + operatorName,
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
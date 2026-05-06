package com.example.allmenusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        // Register Context Menu
        registerForContextMenu(textView);

        // Popup Menu
        button.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, button);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {

                Toast.makeText(this,
                        "Clicked: " + item.getTitle(),
                        Toast.LENGTH_SHORT).show();

                return true;
            });

            popupMenu.show();
        });
    }

    // ================= OPTION MENU =================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // FIXED (NO SWITCH → NO ERROR)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.android) {
            layout.setBackgroundColor(Color.RED);
            return true;

        } else if (id == R.id.java) {
            layout.setBackgroundColor(Color.GREEN);
            return true;

        } else if (id == R.id.kotlin) {
            layout.setBackgroundColor(Color.BLUE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // ================= CONTEXT MENU =================
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Choose Color");

        menu.add(0, 1, 0, "Yellow");
        menu.add(0, 2, 0, "Gray");
        menu.add(0, 3, 0, "Cyan");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == 1) {
            layout.setBackgroundColor(Color.YELLOW);
        } else if (item.getItemId() == 2) {
            layout.setBackgroundColor(Color.GRAY);
        } else if (item.getItemId() == 3) {
            layout.setBackgroundColor(Color.CYAN);
        }

        return true;
    }
}
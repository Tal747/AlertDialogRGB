package com.example.tal.alertdialogrgb;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout LL;
    int r, g, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LL = findViewById(R.id.LL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent t = new Intent(this, CreditsActivity.class);
        if (id == R.id.MenuCredits)
            startActivity(t);
        return super.onOptionsItemSelected(item);
    }

    public void OC_btn1(View view) {
        r = g = b = 0;
        View checkBoxView = View.inflate(this, R.layout.checkbox, null);
        CheckBox cbR = checkBoxView.findViewById(R.id.cbR);
        cbR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    r = 255;
                else
                    r = 0;
            }
        });
        CheckBox cbG = checkBoxView.findViewById(R.id.cbG);
        cbG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    g = 255;
                else
                    g = 0;
            }
        });
        CheckBox cbB = checkBoxView.findViewById(R.id.cbB);
        cbB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    b = 255;
                else
                    b = 0;
            }
        });

        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Change background color");
        adb.setMessage("Please select RGB background color.");
        adb.setView(checkBoxView);
        adb.setNeutralButton("Cancel", null);
        adb.setNegativeButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LL.setBackgroundColor(Color.WHITE);
            }
        });
        adb.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LL.setBackgroundColor(Color.argb(255, r, g, b));
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }
}

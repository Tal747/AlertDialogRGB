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
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout LL;
    int[] color = new int[]{0, 0, 0};

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
        final String[] colors = {"Red", "Green", "Blue"};
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Change background color");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which] = 255;
                LL.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
                dialog.dismiss();
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void OC_btn2(View view) {
        final String[] colors = {"Red", "Green", "Blue"};
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Change background color");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked)
                    color[which] = 255;
                else
                    color[which] = 0;
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LL.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
                dialog.dismiss();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void OC_btn3 (View view) {
        LL.setBackgroundColor(Color.WHITE);
    }
}

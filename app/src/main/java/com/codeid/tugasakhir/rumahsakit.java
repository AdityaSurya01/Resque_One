package com.codeid.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class rumahsakit extends AppCompatActivity {
    ImageView RS1, RS2, RS3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumahsakit);
        RS1 = findViewById(R.id.rs1);
        RS2 = findViewById(R.id.rs2);
        RS3 = findViewById(R.id.rs3);

        RS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(rumahsakit.this, sudirman.class));
            }
        });
        RS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                startActivity(new Intent(rumahsakit.this, medika.class));
            }
        });
        RS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                startActivity(new Intent(rumahsakit.this, sruweng.class));
            }
        });
    }
}
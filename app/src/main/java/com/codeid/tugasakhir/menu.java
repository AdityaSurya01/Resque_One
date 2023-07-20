package com.codeid.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {
ImageView berita, rumahsakit, lapor, history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        berita = findViewById(R.id.berita);
        rumahsakit = findViewById(R.id.rs);
        lapor = findViewById(R.id.lapor);
        history = findViewById(R.id.histori);

        berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(menu.this, berita.class));
            }
        });
        rumahsakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                startActivity(new Intent(menu.this, rumahsakit.class));
            }
        });
        lapor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                startActivity(new Intent(menu.this, laporan.class));
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view3) {
                startActivity(new Intent(menu.this, histori.class));
            }
        });

    }
}
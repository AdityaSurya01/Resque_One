package com.codeid.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = findViewById(R.id.b1);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, login.class);

                // Tambahkan animasi sederhana saat berpindah ke aktivitas lain
                ActivityOptions options = ActivityOptions.makeCustomAnimation(MainActivity.this,
                        R.anim.slide_in_right, R.anim.slide_out_left);
                startActivity(intent, options.toBundle());
            }

        });

        Button daftarButton = findViewById(R.id.b2);
        daftarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }
}
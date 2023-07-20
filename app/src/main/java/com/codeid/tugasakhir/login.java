package com.codeid.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class login extends AppCompatActivity {
private TextView lupapassword;
EditText TxUsername, TxPassword;
Button BtnLogin;
DBhelper dbHelper;
TextView keregis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TxUsername = (EditText)findViewById(R.id.inputnama);
        TxPassword = (EditText)findViewById(R.id.inputpass);
        BtnLogin = (Button)findViewById(R.id.btlog);
        keregis = (TextView)findViewById(R.id.keregis);
        dbHelper = new DBhelper(this);

        keregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, Register.class));
            }
        });

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = TxUsername.getText().toString().trim();
                String password = TxPassword.getText().toString().trim();

                Boolean res = dbHelper.checkUser(null,username,password);
                if (res == true){
                    Toast.makeText(login.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, menu.class));
                }else {
                    Toast.makeText(login.this, "Login gagal cek ulang username dan password anda", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lupapassword = findViewById(R.id.lupapw);
        lupapassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lp = new Intent(login.this, com.codeid.tugasakhir.lupapassword.class);
                startActivity(lp);
            }
        });
        // Menampilkan GIF di ImageView
        ImageView gifImageView = findViewById(R.id.ivlogin);
        Glide.with(this)
                .asGif()
                .load(R.drawable.login)
                .into(gifImageView);
    }
}
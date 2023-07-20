package com.codeid.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText TxPassword2, TxUsername, TxPassword;
    Button BtnRegister;
    DBhelper dbHelper;
    TextView Kelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DBhelper(this);

        TxPassword = (EditText)findViewById(R.id.inputpas);
        TxUsername = (EditText)findViewById(R.id.inputnama);
        TxPassword2 = (EditText)findViewById(R.id.inputpass);
        BtnRegister = (Button)findViewById(R.id.btreg);
        Kelogin = (TextView)findViewById(R.id.kelogin);

        Kelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, login.class));
            }
        });

        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passwordutama = TxPassword.getText().toString().trim();
                String username = TxUsername.getText().toString().trim();
                String password = TxPassword2.getText().toString().trim();

                ContentValues values = new ContentValues();

                if(!passwordutama.equals(password)){
                    Toast.makeText(Register.this, "Pasword tidak sama", Toast.LENGTH_SHORT).show();
                }else if (username.equals("") || password.equals("")){
                    Toast.makeText(Register.this, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else {
                    values.put(DBhelper.row_username, username);
                    values.put(DBhelper.row_password, passwordutama);
                    dbHelper.insertData(values);

                    Toast.makeText(Register.this, "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

        });
    }
}
package com.codeid.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class laporan extends AppCompatActivity {
    Spinner kategori;
    EditText editTextDeskripsi;
    ImageView btnFoto, imgkamera, btnKirimLaporan;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);
        kategori = findViewById(R.id.spinner);
        editTextDeskripsi = findViewById(R.id.editTextDeskripsi);
        btnFoto = findViewById(R.id.btnfoto);
        imgkamera = findViewById(R.id.imgkamera);
        btnKirimLaporan = findViewById(R.id.btnkrmlaporan);
        btnKirimLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getKategori = kategori.getSelectedItem().toString();
                String getDeskripsi = editTextDeskripsi.getText().toString();

                database.child("history").push().setValue(new Modeldata(getKategori, getDeskripsi)).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(laporan.this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(laporan.this, histori.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(laporan.this, "Data gagal disimpan!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
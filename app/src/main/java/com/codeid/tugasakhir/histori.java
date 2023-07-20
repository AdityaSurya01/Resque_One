package com.codeid.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class histori extends AppCompatActivity {
    FloatingActionButton tambah;
    AdapterData adapterData;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<Modeldata> listdata;
    RecyclerView tv_tampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histori);
        tambah = findViewById(R.id.btn_tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(histori.this, laporan.class));
            }
        });
        tv_tampil = findViewById(R.id.tv_tampil);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        tv_tampil.setLayoutManager(mLayout);
        tv_tampil.setItemAnimator(new DefaultItemAnimator());

        tampilData();

    }

    private void tampilData() {
        database.child("history").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listdata = new ArrayList<>();
                for (DataSnapshot item : snapshot.getChildren()){
                    Modeldata data = item.getValue(Modeldata.class);
                    data.setKey(item.getKey());
                    listdata.add(data);
                }
                adapterData = new AdapterData(listdata, histori.this);
                tv_tampil.setAdapter(adapterData);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
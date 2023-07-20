package com.codeid.tugasakhir;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.MyViewHolder> {
    private List<Modeldata> mList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public AdapterData(List<Modeldata>mList, Activity activity){
        this.mList = mList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Modeldata data = mList.get(position);
        holder.tkategori.setText(data.getKategori());
        holder.tdeskripsi.setText(data.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tkategori, tdeskripsi;
        CardView cardhasil;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tkategori = itemView.findViewById(R.id.tkategori);
            tdeskripsi = itemView.findViewById(R.id.tdeskripsi);
            cardhasil = itemView.findViewById(R.id.card_hasil);
        }
    }
}

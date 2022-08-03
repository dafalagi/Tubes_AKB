
// Saeful Anwar Oktariansah
// 10119094
// IF-3

package com.example.tubes_akb;

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

public class AdapterDestinasi extends RecyclerView.Adapter<AdapterDestinasi.MyViewHolder> {
    private List<ListMaps> mList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public AdapterDestinasi(List<ListMaps>mList, Activity activity){
        this.mList = mList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.card_destinasi, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ListMaps data = mList.get(position);
        holder.ListTitle.setText("Nama :" + data.getTitle());
        holder.ListDescription.setText("Deskripsi :" + data.getDesc());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ListTitle, ListDescription;
        CardView ListMap;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ListTitle = itemView.findViewById(R.id.ListTitle);
            ListDescription = itemView.findViewById(R.id.ListDescription);
            ListMap = itemView.findViewById(R.id.ListMap);
        }
    }
}

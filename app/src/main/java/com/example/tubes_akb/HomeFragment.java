
// Nama : Saeful Anwar Oktariansah
// NIM  : 10119094
// Kelas: IF-3

package com.example.tubes_akb;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FloatingActionButton tambahdes;
    AdapterDestinasi adapterDestinasi;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    ArrayList<ListMaps> listDestinasi;
    RecyclerView ListMap;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_home, container, false);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        RecyclerView ListMap = fragment.findViewById(R.id.ListMap);
        listDestinasi = new ArrayList<>();

        adapterDestinasi = new AdapterDestinasi(listDestinasi, getActivity());
        ListMap.setLayoutManager(new LinearLayoutManager(fragment.getContext()));
        ListMap.setAdapter(adapterDestinasi);
        getListMaps();

        FloatingActionButton Address =fragment.findViewById(R.id.floatingbtnAdd);
        Address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAdd();
            }
        });
        return fragment;
    }

    public void toAdd(){
        Intent i = new Intent(getActivity(), AddActivity.class);
        startActivity(i);
    }

    public void getListMaps(){
        listDestinasi.clear();

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                listDestinasi.add(snapshot.getValue(ListMaps.class));
                adapterDestinasi.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                adapterDestinasi.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                adapterDestinasi.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                adapterDestinasi.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

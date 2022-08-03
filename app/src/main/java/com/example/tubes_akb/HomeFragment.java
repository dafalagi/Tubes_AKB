
// Nama : Dafa Rizky Fahreza
// NIM  : 10119113
// Kelas: IF-3

package com.example.tubes_akb;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) fragment.findViewById(R.id.ListMap);
        new DBHelper().readWisata(new DBHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<ListMaps> listMaps, List<String> keys) {
                new AdapterDestinasi().setConfig(recyclerView, fragment.getContext(),
                        listMaps, keys);

            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

        FloatingActionButton Address = fragment.findViewById(R.id.floatingbtnAdd);
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
}

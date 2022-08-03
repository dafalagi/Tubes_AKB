
// Nama : Saeful Anwar Oktariansah
// NIM  : 10119094
// Kelas: IF-3

package com.example.tubes_akb;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FloatingActionButton tambahdess;
    AdapterDestinasi adapterDestinasi;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<ListMaps> listDestinasi;
    RecyclerView ListMap;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_home, container, false);

        FloatingActionButton Adddess =fragment.findViewById(R.id.floatingbtnAdd);
        Adddess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAddnote();
            }
        });
        return fragment;
    }
    public void toAddnote(){
        Intent i = new Intent(getActivity(), AddActivity.class);
        startActivity(i);
    }
}

package com.example.tubes_akb;


//Nama : Dafa Rizky Fahreza
//NIM : 10119113
//Kelas : IF-3

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DBHelper {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private List<ListMaps> listMaps = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<ListMaps> listMaps, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public DBHelper(){
        firebaseDatabase = FirebaseDatabase.getInstance("https://tubes-akb-d4fc6-default-rtdb.asia-southeast1.firebasedatabase.app");
        databaseReference = firebaseDatabase.getReference("listWisata");
    }

    public void readWisata(final DataStatus dataStatus){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listMaps.clear();
                List<String> keys = new ArrayList<>();

                for(DataSnapshot keyNode : snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    ListMaps listMap = keyNode.getValue(ListMaps.class);
                    listMaps.add(listMap);
                }

                dataStatus.DataIsLoaded(listMaps, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void addWisata(ListMaps listMap, final DataStatus dataStatus){
        String key = databaseReference.push().getKey();

        databaseReference.child(key).setValue(listMap).
                addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        dataStatus.DataIsInserted();
                    }
                });
    }

    public void updateWisata(String key, ListMaps listMap, final DataStatus dataStatus){
        databaseReference.child(key).setValue(listMap).
                addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        dataStatus.DataIsUpdated();
                    }
                });
    }

    public void deleteWisata(String key, final DataStatus dataStatus){
        databaseReference.child(key).setValue(null).
                addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        dataStatus.DataIsDeleted();
                    }
                });
    }
}

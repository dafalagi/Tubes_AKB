
// Nama : Saeful Anwar Oktariansah
// NIM  : 10119094
// Kelas: IF-3

package com.example.tubes_akb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;

public class AddActivity extends AppCompatActivity {
    EditText addnama, adddesc, addlatitude, addlongitude;
    Button btn_simpan;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addnama = findViewById(R.id.WisataTitleAdd);
        adddesc = findViewById(R.id.WisataDescAdd);
        addlatitude = findViewById(R.id.WisataLatitudeAdd);
        addlongitude = findViewById(R.id.WisataLongitudeAdd);
        btn_simpan = findViewById(R.id.SaveAdd);


        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNama = addnama.getText().toString();
                String getDesc = adddesc.getText().toString();
                String getLatitude = addlatitude.getText().toString();
                String getLongitude = addlongitude.getText().toString();

                if (getNama.isEmpty()){
                    addnama.setError("Masukan nama destinasi");
                }else if (getDesc.isEmpty()){
                    adddesc.setError("Masukan deskripsi");
                }else if (getLatitude.isEmpty()){
                    addlatitude.setError("Masukan latitude");
                }else if (getLongitude.isEmpty()){
                    addlongitude.setError("Masukan latitude");
                }else{
                    database.child("Destinasi Wisata").push().setValue(new ListMaps(getNama, getDesc, getLatitude, getLongitude)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(AddActivity.this, "Data berhasil ditambah", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddActivity.this, MainActivity.class));
//                            Intent intent = new Intent(AddActivity.this, MainActivity.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddActivity.this, "Data gagal ditambah", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}
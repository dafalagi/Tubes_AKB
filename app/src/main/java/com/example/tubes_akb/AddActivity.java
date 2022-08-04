
// Nama : Dafa Rizky Fahreza
// NIM  : 10119113
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
import java.util.List;

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
                double getLatitude = Double.parseDouble(addlatitude.getText().toString());
                double getLongitude = Double.parseDouble(addlongitude.getText().toString());
                ListMaps listMap = new ListMaps();

                listMap.setTitle(getNama);
                listMap.setDescription(getDesc);
                listMap.setLatitude(getLatitude);
                listMap.setLongitude(getLongitude);

                if (getNama.isEmpty()){
                    addnama.setError("Masukkan nama destinasi");
                }else if (getDesc.isEmpty()){
                    adddesc.setError("Masukkan deskripsi");
                }else if (String.valueOf(getLatitude).isEmpty()){
                    addlatitude.setError("Masukkan latitude");
                }else if (String.valueOf(getLongitude).isEmpty()){
                    addlongitude.setError("Masukkan latitude");
                }else{
                    new DBHelper().addWisata(listMap, new DBHelper.DataStatus() {
                        @Override
                        public void DataIsLoaded(List<ListMaps> listMaps, List<String> keys) {

                        }

                        @Override
                        public void DataIsInserted() {
                            Toast.makeText(AddActivity.this, "Data berhasil dimasukkan!",
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void DataIsUpdated() {

                        }

                        @Override
                        public void DataIsDeleted() {

                        }
                    });
                }
            }
        });

    }
}
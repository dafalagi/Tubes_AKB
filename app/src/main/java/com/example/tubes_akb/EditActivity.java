
package com.example.tubes_akb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EditActivity extends AppCompatActivity {
    private String key;
    private String title;
    private String description;
    private double latitude;
    private double longitude;

    TextView titletxt;
    TextView descriptiontxt;
    TextView latitudetxt;
    TextView longitudetxt;
    Button BtnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        key = getIntent().getStringExtra("key");
        title = getIntent().getStringExtra("title");
        description = getIntent().getStringExtra("description");
        latitude = getIntent().getDoubleExtra("latitude", 0);
        longitude = getIntent().getDoubleExtra("longitude", 0);

        titletxt = (TextView) findViewById(R.id.WisataTitleEdit);
        descriptiontxt = (TextView) findViewById(R.id.WisataDescEdit);
        latitudetxt = (TextView) findViewById(R.id.WisataLatitudeEdit);
        longitudetxt = (TextView) findViewById(R.id.WisataLongitudeEdit);

        BtnEdit = (Button) findViewById(R.id.BtnSaveEdit);

        titletxt.setText(title);
        descriptiontxt.setText(description);
        latitudetxt.setText(String.valueOf(latitude));
        longitudetxt.setText(String.valueOf(longitude));

        BtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListMaps listEdit = new ListMaps();
                listEdit.setTitle(title);
                listEdit.setDescription(description);
                listEdit.setLatitude(latitude);
                listEdit.setLongitude(longitude);
                new DBHelper().updateWisata(key, listEdit, new DBHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<ListMaps> listMaps, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                       Toast.makeText(EditActivity.this,
                               "Data berhasil diubah!", Toast.LENGTH_LONG).show();
                       Intent intent = new Intent(EditActivity.this, MainActivity.class);
                       startActivity(intent);
                       finish();
                       return;
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
    }
}

//Nama : Ikhsan Nurul Rizki
//NIM : 10119097
//Kelas : IF-3
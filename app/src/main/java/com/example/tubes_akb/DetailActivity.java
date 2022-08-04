package com.example.tubes_akb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private String key;
    private String title;
    private String description;
    private double latitude;
    private double longitude;

    TextView titletxt;
    TextView descriptiontxt;
    TextView latitudetxt;
    TextView longitudetxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        key = getIntent().getStringExtra("key");
        title = getIntent().getStringExtra("title");
        description = getIntent().getStringExtra("description");
        latitude = getIntent().getDoubleExtra("latitude", 0);
        longitude = getIntent().getDoubleExtra("longitude", 0);

        titletxt = (TextView) findViewById(R.id.NamaTempatTxt);
        descriptiontxt = (TextView) findViewById(R.id.DeskripsiTxt);
        latitudetxt = (TextView) findViewById(R.id.LatitudeTxt);
        longitudetxt = (TextView) findViewById(R.id.LongitudeTxt);

        titletxt.setText(title);
        descriptiontxt.setText(description);
        latitudetxt.setText(String.valueOf(latitude));
        longitudetxt.setText(String.valueOf(longitude));

        Button editbtn = findViewById(R.id.btnEdit);
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, EditActivity.class);
                intent.putExtra("key", key);
                intent.putExtra("title", title);
                intent.putExtra("description", description);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                startActivity(intent);
            }
        });

        Button deletebtn = findViewById(R.id.btnHapus);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DBHelper().deleteWisata(key, new DBHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<ListMaps> listMaps, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(DetailActivity.this,
                                "Data berhasil dihapus!", Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    }
                });
            }
        });

        Button mapbtn = findViewById(R.id.btnMap);
        mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MapsActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                startActivity(intent);
            }
        });
    }
}
package com.example.tugasakhirkel_29;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;
import java.util.List;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ejenis, Ewarna, Eharga;
    private String Snama, Sjenis, Swarna, Sharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Ewarna = (EditText) findViewById(R.id.create_warna);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                Swarna = String.valueOf(Ewarna.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Nama Kue",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Jenis Kue",
                            Toast.LENGTH_SHORT).show();
                } else if (Swarna.equals("")){
                    Ewarna.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Warna Kue",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Harga Kue",
                            Toast.LENGTH_SHORT).show();

                } else {
                    Enama.setText("");
                    Ejenis.setText("");
                    Ewarna.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateJenisKue(new JenisKue(null, Snama, Sjenis, Swarna, Sharga));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}


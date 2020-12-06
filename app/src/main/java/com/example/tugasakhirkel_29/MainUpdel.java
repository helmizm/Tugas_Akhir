package com.example.tugasakhirkel_29;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sjenis, Swarna, Sharga;
    private EditText Enama, Ejenis, Ewarna, Eharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sjenis = i.getStringExtra("Ijenis");
        Swarna = i.getStringExtra("Iwarna");
        Sharga = i.getStringExtra("Iharga");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Ewarna = (EditText) findViewById(R.id.updel_warna);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Enama.setText(Snama);
        Ejenis.setText(Sjenis);
        Ewarna.setText(Swarna);
        Eharga.setText(Sharga);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                Swarna = String.valueOf(Ewarna.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Nama Kue",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Jenis Kue",
                            Toast.LENGTH_SHORT).show();
                } else if (Swarna.equals("")){
                    Ewarna.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Warna Motor",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Harga Kue",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateJenisKue(new JenisKue(Sid, Snama, Sjenis, Swarna, Sharga));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteJenisKue(new JenisKue(Sid, Snama, Sjenis, Swarna, Sharga));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
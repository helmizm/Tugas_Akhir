package com.example.tugasakhirkel_29;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasakhirkel_29.R;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<JenisKue> Listkue = new ArrayList<JenisKue>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, Listkue );
        mListView = (ListView) findViewById(R.id.list_kue);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        Listkue.clear();
        List<JenisKue> contacts = db.ReadJenisKue();
        for (JenisKue cn : contacts) {
            JenisKue judulModel = new JenisKue();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_jenis(cn.get_jenis());
            judulModel.set_warna(cn.get_warna());
            judulModel.set_harga(cn.get_harga());
            Listkue.add(judulModel);
            if ((Listkue.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        JenisKue obj_itemDetails = (JenisKue)o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sjenis = obj_itemDetails.get_jenis();
        String Swarna = obj_itemDetails.get_warna();
        String Sharga = obj_itemDetails.get_harga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Iwarna", Swarna);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Listkue.clear();
        mListView.setAdapter(adapter_off);
        List<JenisKue> contacts = db.ReadJenisKue();
        for (JenisKue cn : contacts) {
            JenisKue judulModel = new JenisKue();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_jenis(cn.get_jenis());
            judulModel.set_warna(cn.get_warna());
            judulModel.set_harga(cn.get_harga());
            Listkue.add(judulModel);
            if ((Listkue.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}


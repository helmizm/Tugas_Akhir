package com.example.tugasakhirkel_29;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasakhirkel_29.R;

public class Kue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kue);
    }
    public void btn_create(View view){
        Intent a = new Intent(Kue.this, MainCreate.class);
        startActivity(a);
    }
    public void btn_read(View view) {
        Intent b = new Intent(Kue.this, MainRead.class);
        startActivity(b);
    }
}
package com.example.transapp;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Mapa extends AppCompatActivity {

    private EditText txtBuscar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        this.txtBuscar2 = findViewById(R.id.txtBuscar2);

    }
}

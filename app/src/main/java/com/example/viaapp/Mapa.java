package com.example.viaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Mapa extends AppCompatActivity {

    private EditText txtBuscar2;
    private Button btnMenu3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        this.txtBuscar2 = findViewById(R.id.txtBuscar2);
        this.btnMenu3 = findViewById(R.id.btnMenu3);

        this.btnMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Menu.class);
                startActivity(i);
                finish();
            }
        });

    }
}

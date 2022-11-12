package com.example.viaapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Mapa extends AppCompatActivity {

    private Button btnMenu3;
    private SupportMapFragment mapFragment;

    // -20.7821109,-51.6683511 Av. Ranulpho Marques Leal, 3484 - Interlagos, Três Lagoas - MS
    // -20.7749812,-51.698669 Av. Antônio Trajano, 2180 - Centro, Três Lagoas - MS
    private ArrayList<Ponto> pontos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        pontos.add(new Ponto("UFMS", new LatLng(-20.7821109,-51.6683511), "Av. Ranulpho Marques Leal, 3484 - Interlagos, Três Lagoas - MS"));
        pontos.add(new Ponto("Terminal Rodoviário", new LatLng(-20.7749812,-51.698669), "Av. Antônio Trajano, 2180 - Centro, Três Lagoas - MS"));

        this.btnMenu3 = findViewById(R.id.btnMenu3);
        this.mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);

        this.mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final @NonNull GoogleMap googleMap) {
                addMarkers(googleMap);
                googleMap.setInfoWindowAdapter(new InfoPontosAdapter(mapFragment.getContext()));

                googleMap.setOnMapLoadedCallback((new GoogleMap.OnMapLoadedCallback() {
                    @Override
                    public void onMapLoaded() {

                        googleMap.snapshot(new GoogleMap.SnapshotReadyCallback() {
                            @Override
                            public void onSnapshotReady(Bitmap bitmap) {
                                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pontos.get(0).getLatLng(), 13));
                            }
                        });
                    }
                }));
            }
        });

        this.btnMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Menu.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void addMarkers(GoogleMap googleMap){
        for(Ponto p : pontos){
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.title(p.getNome());
            markerOptions.snippet(p.getEndereco());
            markerOptions.position(p.getLatLng());
            markerOptions.icon(BitmapHelper.vetorToBitmap(this, R.drawable.ponto_parada));

            Marker marker = googleMap.addMarker(markerOptions);
            marker.setTag(p);
        }
    }
}

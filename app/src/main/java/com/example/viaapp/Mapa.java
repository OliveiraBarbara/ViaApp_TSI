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

    private TextView txtNomeLinha;
    private TextView txtHorario3;
    private TextView txtHorario4;
    private TextView txtHorario5;
    private Button btnMenu3;
    private SupportMapFragment mapFragment;

    private Linha linha;

    // -20.7821109,-51.6683511 Av. Ranulpho Marques Leal, 3484 - Interlagos, Três Lagoas - MS
    // -20.7749812,-51.698669 Av. Antônio Trajano, 2180 - Centro, Três Lagoas - MS
    private ArrayList<Ponto> pontos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        Intent i = getIntent();
        this.linha = (Linha) i.getSerializableExtra("linha");

        pontos = linha.getPontosParada();

        this.txtNomeLinha = findViewById(R.id.txtNomeLinha);
        txtNomeLinha.setText(linha.getNome());

        this.txtHorario3 = findViewById(R.id.txtHorario3);
        this.txtHorario4 = findViewById(R.id.txtHorario4);
        this.txtHorario5 = findViewById(R.id.txtHorario5);

        txtHorario3.setText(linha.getHorarioFuncionamento().get(0));
        txtHorario4.setText(linha.getHorarioFuncionamento().get(1));
        txtHorario5.setText(linha.getHorarioFuncionamento().get(2));

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
                                LatLng latLng = new LatLng(pontos.get(0).getLatitude(), pontos.get(0).getLongitude());
                                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));
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
            markerOptions.position(new LatLng(p.getLatitude(), p.getLongitude()));
            markerOptions.icon(BitmapHelper.vetorToBitmap(this, R.drawable.ponto_parada));
            Marker marker = googleMap.addMarker(markerOptions);
            marker.setTag(p);
        }
    }
}

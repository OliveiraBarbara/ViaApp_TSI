package com.example.viaapp;


import android.view.View;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;

public class UsuariosAdapter extends FirebaseListAdapter<Usuario> {

    public UsuariosAdapter(FirebaseListOptions options) {
        super(options);
    }

    @Override
    protected void populateView (View v, Usuario u, int position) {


    }
}

package com.example.viaapp;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Utility {
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView );
            if (listItem instanceof ViewGroup) {
                listItem.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            }

            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.setBackground(Drawable.createFromPath("@drawable/edit_table_border"));
    }

    public static ArrayList<String> preencheArrayString(ArrayList<Ponto> arrayList){
        ArrayList<String> arrayString = new ArrayList<>();
        for(Ponto item : arrayList){
            arrayString.add(item.getNome());
        }
        return arrayString;
    }

    public static String concatenaHorarios(Linha linha){
        String horarios = "";
        for(int j = 0; j < linha.getHorarioFuncionamento().size(); j++){
            horarios += linha.getHorarioFuncionamento().get(j) + " / ";
        }
        return horarios;
    }
}
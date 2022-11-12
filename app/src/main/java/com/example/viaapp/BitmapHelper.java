package com.example.viaapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class BitmapHelper {

    public static BitmapDescriptor vetorToBitmap(Context context, @DrawableRes int id){
        Bitmap bitmap;
        Drawable vetor = ResourcesCompat.getDrawable(context.getResources(), id, null);

        if(vetor == null){
            return BitmapDescriptorFactory.defaultMarker();
        }

        bitmap = Bitmap.createBitmap(vetor.getIntrinsicWidth(), vetor.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        vetor.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vetor.draw(canvas);

        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}

package com.example.projectreloj;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiVista(this));
    }

    private class MiVista extends View {
        public MiVista(Context context) {
            super(context);
        }
    }

    //canvas es una clase para graficar en ella
    protected void onDraw(Canvas canvas){}
}
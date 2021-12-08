package com.example.cuadricula;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.core.content.res.ResourcesCompat;

public class CuadriculaActivity extends View {

    private int aBackgroundColor;
    private Path aPath;
    private Paint mPaint;
    private int aDrawColor;
    private Bitmap bitMap;
    private Canvas canvas;
    private Rect frame;
    private Rect nFrame2;
    private int width;
    private int height;

    public CuadriculaActivity(Context context, AttributeSet attrs) {
        super(context);
    }

    public CuadriculaActivity(Context context) {
        super(context, null);

        aBackgroundColor = ResourcesCompat.getColor(getResources(), R.color.opaque_orange, null);
        aDrawColor = ResourcesCompat.getColor(getResources(), R.color.green, null);
        aPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(aDrawColor);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(2);
    }

 @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width  =w;
        height = h;
        bitMap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitMap);
        canvas.drawColor(aBackgroundColor);
        int inset = 2;
        frame = new Rect(inset, inset, w - inset, h - inset);
        nFrame2 = new Rect(inset,inset*100,w-inset,h-inset);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       canvas.drawBitmap(bitMap, 0, 0, null);
       int tam = 100;
       for (int i=0; i<=(height/100);i++){
           canvas.drawLine(0,tam*i,width,tam*i,mPaint);
       }
        for (int i=0; i<=(width/100);i++){
            canvas.drawLine(tam*i,0,tam*i,height,mPaint);
        }

    }
}

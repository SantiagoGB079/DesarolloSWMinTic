package com.example.a53850_canvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.res.ResourcesCompat;

public class MyCanvasView extends View {

    private static final float TOUCH_TOLERANCE = 4;
    private int aBackgroundColor;
    private int aDrawColor;
    private Path aPath;
    private Paint mPaint;
    private Bitmap nExtrasBitmap;
    private Canvas nExtrasCanvas;
    private Rect nFrame;
    private Rect nFrame2;
    private float ax;
    private float ay;

    public MyCanvasView(Context context) {
        this(context, null);
    }

    public MyCanvasView(Context context, AttributeSet attributeSet) {
        super(context);

        aBackgroundColor = ResourcesCompat.getColor(getResources(), R.color.opaque_orange, null);
        aDrawColor = ResourcesCompat.getColor(getResources(), R.color.opaque_yellow, null);
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
        nExtrasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        nExtrasCanvas = new Canvas(nExtrasBitmap);
        nExtrasCanvas.drawColor(aBackgroundColor);
        int inset = 2;
        nFrame = new Rect(inset, inset, w - inset, h - inset);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Dibuja el bitmap que tiene guardado el path
        canvas.drawBitmap(nExtrasBitmap, 0, 0, null);
        canvas.drawRect(nFrame, mPaint);
    }

    private void touchStart(float x, float y) {
        aPath.moveTo(x, y);
        ax = x;
        ay = y;
    }

    private void touchMove(float x, float y) {
        float dx = Math.abs(ax - x);
        float dy = Math.abs(ay - y);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            aPath.quadTo(ax, ay, (x + ax) / 2, (y + ay) / 2);
            ax = x;
            ay = y;
            nExtrasCanvas.drawPath(aPath, mPaint);
        }
    }

    private void touchUp() {
        aPath.reset();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();//coordenadas del toque de la pantalla
        float y = event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                touchStart(x, y);
                break;

            case MotionEvent.ACTION_MOVE:
                touchMove(x, y);
                break;

            case MotionEvent.ACTION_UP:
                touchUp();
                break;
        }
        return true;
    }
}

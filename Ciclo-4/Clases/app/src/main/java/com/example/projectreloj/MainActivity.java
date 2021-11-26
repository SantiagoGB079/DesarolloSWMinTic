package com.example.projectreloj;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends Activity {

    private Paint paint;
    private int width = 0;
    private int height = 0;
    private int padding = 0;
    private int radius = 0;
    private boolean isInit;
    private int numeralSpacing = 0;
    private int fontSize = 0;
    private int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private Rect rect = new Rect();
    double angle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiVista(this));
    }

    private class MiVista extends View {
        public MiVista(Context context) {
            super(context);
        }

        //canvas es una clase para graficar en ella
        @Override
        protected void onDraw(Canvas canvas) {
            setSystemUiVisibility(SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            if (!isInit) {
                initClock();
            }
            canvas.drawColor(Color.LTGRAY);
            drawCircle(canvas);
            drawCenter(canvas);
            drawNumeral(canvas);
            drawHands(canvas);
            postInvalidateDelayed(1000);
        }

        private void drawHands(Canvas canvas) {
            int min = 0;
            int sec = 0;
            int hor = 0;
            Calendar c = Calendar.getInstance();
            sec = c.get(Calendar.SECOND);
            min = c.get(Calendar.MINUTE);
            hor = c.get(Calendar.HOUR);
            Sec(canvas, sec);
            Min(canvas, min);
            Hor(canvas, min, hor);

        }

        private void Sec(Canvas canvas, int sec) {
            String secu = Integer.toString(sec);
            paint.setStrokeWidth(4);
            int rad = 450;
            angle = Math.PI * sec / 30 - Math.PI / 2;
            paint.setColor(Color.RED);
            canvas.drawLine(width / 2, height / 2, (float) (width / 2 + Math.cos(angle) * rad), (float) (height / 2 +
                    Math.sin(angle) * rad), paint);
            paint.setColor(Color.GREEN);
            if (sec < 10) {
                canvas.drawText(" :0" + secu, width / 2 + 5, height / 2 + 70, paint);
            } else {
                canvas.drawText(" :" + secu, width / 2 + 5, height / 2 + 70, paint);
            }
        }

        private void Min(Canvas canvas, int min) {
            String minu = Integer.toString(min);
            paint.setStrokeWidth(10);
            int rad = 420;
            angle = Math.PI * min / 30 - Math.PI / 2;
            paint.setColor(Color.RED);
            canvas.drawLine(width / 2, height / 2, (float) (width / 2 + Math.cos(angle) * rad), (float) (height / 2 +
                    Math.sin(angle) * rad), paint);
            paint.setColor(Color.GREEN);
            if (min < 10) {
                canvas.drawText(" :0" + minu, width / 2 -65, height / 2 + 70, paint);
            } else {
                canvas.drawText(" :" + minu, width / 2 -65, height / 2 + 70, paint);
            }
        }

        private void Hor(Canvas canvas,int min , int hor) {
            String hora = Integer.toString(hor);
            paint.setStrokeWidth(10);
            int rad = 320;
            angle = hor*Math.PI /6-Math.PI/2+min*Math.PI/360;
            paint.setColor(Color.RED);
            canvas.drawLine(width / 2, height / 2, (float) (width / 2 + Math.cos(angle) * rad), (float) (height / 2 +
                    Math.sin(angle) * rad), paint);
            paint.setColor(Color.GREEN);
            if (hor < 10) {
                canvas.drawText(" " + hora, width / 2 -85, height / 2 + 70, paint);
            } else {
                canvas.drawText(" :" + hora, width / 2 -95, height / 2 + 70, paint);
            }
        }

        private void drawNumeral(Canvas canvas) {
            paint.setTextSize(fontSize);
            for (int number : numbers) {
                String tnp = String.valueOf(number);
                paint.getTextBounds(tnp, 0, tnp.length(), rect);
                double angle = Math.PI / 6 * (number - 3);
                int x = (int) (width / 2 + Math.cos(angle) * radius - rect.width() / 2);
                int y = (int) (height / 2 + Math.sin(angle) * radius + rect.height() / 2);
                canvas.drawText(tnp, x, y, paint);
            }
        }

        private void drawCenter(Canvas canvas) {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(width / 2, height / 2, 12, paint);
        }

        private void drawCircle(Canvas canvas) {
            paint.reset();
            paint.setColor(getResources().getColor(android.R.color.black));
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            canvas.drawCircle(width / 2, height / 2, radius + padding - 10, paint);
        }

        private void initClock() {
            height = getHeight();
            width = getWidth();
            padding = numeralSpacing + 50;
            fontSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 13,
                    getResources().getDisplayMetrics());
            int min = Math.min(height, width);
            radius = min / 2 - padding;
            //hardTruncation = min / 20;
            // hourHardTruncation = min / 7;
            paint = new Paint();
            isInit = true;
        }
    }


}
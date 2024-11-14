package com.example.chapter09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Ex extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);

            paint.setStrokeWidth(20);
            paint.setColor(Color.argb(255, 255, 0, 0));
            canvas.drawLine(60, 60, 500, 500, paint);
            paint.setColor(Color.argb(255, 0, 255, 0));
            canvas.drawLine(500, 60, 60, 500, paint);

            RectF rectF = new RectF();

            paint.setStrokeWidth(10);
            paint.setColor(Color.BLACK);
            rectF.set(70, 240, 70 + 100, 255 + 100);
            canvas.drawRect(rectF, paint);

            paint.setColor(Color.argb(255, 0, 0, 255));
            paint.setStyle(Paint.Style.STROKE);
            rectF.set(240, 70, 240 + 100, 70 + 100);
            canvas.drawRect(rectF, paint);

            paint.setColor(Color.GRAY);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeWidth(5);
            rectF.set(430, 240, 430 + 100, 240 + 100);
            canvas.drawRoundRect(rectF, 10, 10, paint);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(10);
            rectF.set(240, 430, 240 + 100, 430 + 100);
            canvas.drawRect(rectF, paint);

            paint.setColor(Color.BLACK);
            rectF.set(280, 700, 280 + 70, 700 + 70);
            canvas.drawArc(rectF, 40, 110, true, paint);

            paint.setStyle(Paint.Style.STROKE);
            rectF.set(120, 650, 120 + 400, 650 + 200);
            canvas.drawOval(rectF, paint);

        }
    }

}

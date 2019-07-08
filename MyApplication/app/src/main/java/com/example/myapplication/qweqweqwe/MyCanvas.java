package com.example.myapplication.qweqweqwe;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyCanvas extends View {

    private Paint paint;
    private RectF rectBackground;
    private RectF rectBlur;

    public MyCanvas(Context context) {
        super(context);
        paint = new Paint();

        rectBackground = new RectF(432,640,640,720);

        rectBlur = new RectF(437,645,635,715);
    }

    public MyCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        setLayerType(View.LAYER_TYPE_SOFTWARE, paint);

//        paint.setMaskFilter(new BlurMaskFilter(32, BlurMaskFilter.Blur.NORMAL));
//        canvas.drawRoundRect(rectBlur, 24, 24, paint);
//
//        paint.setMaskFilter(new BlurMaskFilter(64, BlurMaskFilter.Blur.INNER));
//        canvas.drawRoundRect(rectBackground, 24,24, paint);
//        paint.reset();
//
//        paint.setColor(Color.rgb(253,254,254));
//        canvas.drawRoundRect(rectBackground,24,24, paint);
//        paint.reset();

        paint.setColor(Color.rgb(253, 254, 254));
        paint.setShadowLayer(6, 0, 2, Color.argb(100, 0, 0, 0));
        canvas.drawRoundRect(rectBackground, 24, 24, paint);
        paint.reset();

        paint.setTextSize(50);
        canvas.drawText("750 MB", 450, 700, paint);
        paint.reset();
    }
}
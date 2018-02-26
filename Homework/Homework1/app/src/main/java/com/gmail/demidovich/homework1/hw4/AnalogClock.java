package com.gmail.demidovich.homework1.hw4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.gmail.demidovich.homework1.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class AnalogClock extends View {

    private float cx;
    private float cy;
    private float radius;
    private Paint paint;
    private RectF hourHandRect;
    private RectF minuteHandRect;
    private RectF secondHandRect;
    private RectF dash;
    private float textSize;
    private Date date;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("K:m:s");
    private Handler handler;
    private Runnable task = new Runnable() {
        @Override
        public void run() {
            date = new Date();
            invalidate();
            handler.postDelayed(this, 500);
        }
    };

    public AnalogClock(Context context) {
        super(context);
        init();
    }

    public AnalogClock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AnalogClock(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AnalogClock(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        handler = new Handler();
        date = new Date();
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3:00"));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cx = w / 2;
        cy = h / 2;
        radius = ((float) h > (float) w) ? ((float) w * 0.4f) : ((float) h * 0.4f);
        hourHandRect = new RectF();
        minuteHandRect = new RectF();
        secondHandRect = new RectF();
        dash = new RectF();
        hourHandRect.left = cx - (radius * 0.05f);
        hourHandRect.right = cx + (radius * 0.05f);
        hourHandRect.top = cy - (radius * 0.6f);
        hourHandRect.bottom = cy + (radius * 0.2f);
        minuteHandRect.left = cx - (radius * 0.03f);
        minuteHandRect.right = cx + (radius * 0.03f);
        minuteHandRect.top = cy - (radius * 0.8f);
        minuteHandRect.bottom = cy + (radius * 0.3f);
        secondHandRect.left = cx - (radius * 0.01f);
        secondHandRect.right = cx + (radius * 0.01f);
        secondHandRect.top = cy - (radius * 0.9f);
        secondHandRect.bottom = cy + (radius * 0.4f);
        dash.left = cx - (radius * 0.01f);
        dash.right = cx + (radius * 0.01f);
        dash.top = cy - (radius + radius * 0.03f);
        dash.bottom = cy - (radius - radius * 0.15f);
        textSize = radius / 5;
        paint.setTextSize(textSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(ContextCompat.getColor(getContext(), R.color.orange));
        canvas.drawCircle(cx, cy, radius, paint);
        paint.setColor(Color.BLACK);
        canvas.drawText("12", cx - (textSize / 2), cy - (radius - textSize), paint);
        canvas.drawText("3", cx + (radius - textSize * 0.8f), cy + (textSize / 3), paint);
        canvas.drawText("6", cx - (textSize / 4), cy + (radius - textSize / 5), paint);
        canvas.drawText("9", cx - (radius - textSize / 5), cy + (textSize / 3), paint);
        for (int i = 0; i < 12; i++) {
            if (i % 3 != 0) {
                canvas.drawRect(dash, paint);
            }
            canvas.rotate(30, cx, cy);
        }
        String[] time = simpleDateFormat.format(date).split(":");
        int hours = Integer.valueOf(time[0]);
        int mins = Integer.valueOf(time[1]);
        int secs = Integer.valueOf(time[2]);
        canvas.save();
        canvas.rotate(mins * 6, cx, cy);
        canvas.drawRect(minuteHandRect, paint);
        canvas.restore();
        canvas.save();
        canvas.rotate(secs * 6, cx, cy);
        canvas.drawRect(secondHandRect, paint);
        canvas.restore();
        canvas.save();
        canvas.rotate(hours * 30 + mins / 2, cx, cy);
        canvas.drawRect(hourHandRect, paint);
        canvas.restore();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        handler.post(task);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeCallbacks(task);
    }
}

package com.gmail.demidovich.classwork1.classwork4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyCustomView extends View {

    private Paint mPaint;
    private float radius;
    private float cx, cy;

    private RectF mRectF;

    public MyCustomView(Context context) {
        super(context);
        init();
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        // paint is a pen
        mPaint = new Paint();
        mPaint.setColor(Color.DKGRAY);
        mPaint.setAntiAlias(true);

        mRectF = new RectF();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        cx = w / 2;
        cy = h / 2;
        radius = w > h ? cy / 4 : cx / 4;

        float wRect = w * 0.9f,
                hRect = h * 0.2f;

        mRectF.left = (w - wRect) / 2;
        mRectF.right = w - mRectF.left;
        mRectF.top = (h - hRect) / 2;
        mRectF.bottom = h - mRectF.top;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        //radius = getWidth() > getHeight() ? getHeight() / 2 : getWidth() / 2;
        mPaint.setColor(Color.DKGRAY);
        canvas.drawCircle(cx, cy, radius, mPaint);


        mPaint.setColor(Color.RED);
        canvas.drawLine(0, 0, getWidth(), getHeight(), mPaint);


        //mPaint.setColor(Color.YELLOW);
        //canvas.drawRect(mRectF, mPaint);


        canvas.save();
        canvas.rotate(90, cx, cy);
        canvas.restore();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {

                //mRectF.contains(event.getX(), event.getY());

                break;
            }
            case MotionEvent.ACTION_UP: {

                break;
            }
            case MotionEvent.ACTION_MOVE: {
                cx = event.getX();
                cy = event.getY();
                invalidate();

                return false;
            }
            default: {

                break;
            }
        }

        return true;
    }
}

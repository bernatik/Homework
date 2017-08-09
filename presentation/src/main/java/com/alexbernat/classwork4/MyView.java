package com.alexbernat.classwork4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.alexbernat.homework.R;

/**
 * Created by Александр on 31.07.2017.
 */

public class MyView extends View {

    private Paint myPaint = new Paint(); //Инструмент для рисования
    private Paint secondPaint = new Paint();
    private RectF arcRectF = new RectF(); //Рамка

    int coordX, coordY;

    public MyView(Context context) {
        super(context);
        initialize();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }

    private void initialize(){
        myPaint.setAntiAlias(true); //Сглаживание пикселей
        myPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_yellow));
        myPaint.setStyle(Paint.Style.FILL);

        secondPaint.setAntiAlias(true);
        secondPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_blue));
        secondPaint.setStyle(Paint.Style.FILL);

        Resources resources = getResources();
        float strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                5, resources.getDisplayMetrics()); //Указание значения в ДП - 2 (потому что везде в пикселях здесь)

        secondPaint.setStrokeWidth(strokeWidthInPx);
    }

    /*
        Изменения размера вьюхи (ориентация и проч.)
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = 300;
        canvas.drawCircle(coordX, coordY, radius, myPaint);
        canvas.drawLine(0, 0, getWidth()*2, getHeight()*2, secondPaint);

        arcRectF.left = 0;
        arcRectF.top = 0;
        arcRectF.right = getWidth();
        arcRectF.bottom = getHeight();

        canvas.drawArc(arcRectF, 45, 90, true, secondPaint);

        canvas.drawRect(50, 50, 100, 100, myPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN){
            coordX = (int)event.getX();
            coordY = (int)event.getY();
            invalidate(); //перерисовка - принудительная (как ondraw)
        }

        return true;
    }
}

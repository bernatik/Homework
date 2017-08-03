package com.alexbernat.homework4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.alexbernat.homework.R;

import java.util.Calendar;

/**
 * Created by Александр on 03.08.2017.
 */

public class ClocksView extends View {

    public static final int STROKE_WIDE = 20;
    public static final int STROKE_TALL = 10;

    public static final float TEXT_SIZE = 100;

    public static final int CLOCKS_COLOR = android.R.color.black;
    public static final int ARROWS_COLOR = R.color.color_yellow;
    public static final int NUMBERS_COLOR = android.R.color.white;

    public static final String HOURS_12 = "12";
    public static final String HOURS_3 = "3";
    public static final String HOURS_6 = "6";
    public static final String HOURS_9 = "9";

    private int currentHours;
    private int currrentMinutes;

    private Paint clocksPaint = new Paint();
    private Paint arrowsPaint = new Paint();
    private Paint textPaint = new Paint();

    public ClocksView(Context context) {
        super(context);
        initialize();
    }

    public ClocksView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public ClocksView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    public ClocksView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }

    private void initialize(){

        Calendar calendar = Calendar.getInstance();
        currentHours = calendar.get(Calendar.HOUR);
        currrentMinutes = calendar.get(Calendar.MINUTE);

        clocksPaint.setAntiAlias(true);
        clocksPaint.setColor(ContextCompat.getColor(getContext(), CLOCKS_COLOR));
        clocksPaint.setStyle(Paint.Style.STROKE);
        clocksPaint.setStrokeWidth(STROKE_WIDE);

        arrowsPaint.setAntiAlias(true);
        arrowsPaint.setColor(ContextCompat.getColor(getContext(), ARROWS_COLOR));
        arrowsPaint.setStyle(Paint.Style.STROKE);
        arrowsPaint.setStrokeWidth(STROKE_WIDE);

        textPaint.setAntiAlias(true);
        textPaint.setColor(ContextCompat.getColor(getContext(), NUMBERS_COLOR));
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setTextSize(TEXT_SIZE);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /* initial place where clocks will be drawn */
        float clocksCenterX = getWidth()/2;
        float clocksCenterY = getHeight()/2;
        float radius = Math.min(clocksCenterX, clocksCenterY);

        /* draw clocks */
        canvas.drawCircle(clocksCenterX, clocksCenterY, radius, clocksPaint);

        /* hours */
        for (int i = 0; i < 12; i++){
            /* draw an hour arrow */
            if (i == currentHours){
                canvas.drawLine(clocksCenterX, clocksCenterY - radius*1/2, clocksCenterX, clocksCenterY, arrowsPaint);
            }
            canvas.drawLine(clocksCenterX,
                    clocksCenterY - radius,
                    clocksCenterX,
                    clocksCenterY - radius*6/7,
                    clocksPaint);
            canvas.rotate(360/12, clocksCenterX, clocksCenterY);
        }

        /* draw numbers */
//        canvas.drawText(HOURS_12, clocksCenterX - 50, clocksCenterY - radius*3/4, textPaint);
//        canvas.drawText(HOURS_3, getWidth()- radius*1/4, clocksCenterY + 50, textPaint);
//        canvas.drawText(HOURS_6, clocksCenterX - 50, clocksCenterY + radius*3/4, textPaint);
//        canvas.drawText(HOURS_9, clocksCenterX - radius*3/4, clocksCenterY + 50, textPaint);

        /* minutes - make them taller */
        clocksPaint.setStrokeWidth(STROKE_TALL);
        arrowsPaint.setStrokeWidth(STROKE_TALL);
        for (int i = 0; i < 60; i++){
            /* draw a minutes arrow */
            if (i == currrentMinutes){
                canvas.drawLine(clocksCenterX, clocksCenterY - radius*2/3, clocksCenterX, clocksCenterY, arrowsPaint);
            }
            canvas.drawLine(clocksCenterX,
                    clocksCenterY - radius,
                    clocksCenterX,
                    clocksCenterY - radius*9/10,
                    clocksPaint);
            canvas.rotate(360/60, clocksCenterX, clocksCenterY);
        }

    }
}

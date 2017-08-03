package com.alexbernat.homework4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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

    public static final int STROKE_CLOCKS_WIDE = 20;
    public static final int STROKE_CLOCKS_TALL = 10;
    public static final int WIDTH_HOUR_ARROW = 20;
    public static final int WIDTH_MINUTE_ARROW = 10;
    public static final int WIDTH_SECOND_ARROW = 5;

    public static final float NUMBERS_SIZE = 100;

    public static final int CLOCKS_COLOR = android.R.color.black;
    public static final int ARROWS_COLOR = R.color.color_yellow;
    public static final int CENTER_COLOR = R.color.color_blue;
    public static final int NUMBERS_COLOR = android.R.color.white;

    public static final String HOURS_12 = "12";
    public static final String HOURS_3 = "3";
    public static final String HOURS_6 = "6";
    public static final String HOURS_9 = "9";

    private int currentHours;
    private int currentMinutes;
    private int currentSeconds;

    private Paint clocksPaint = new Paint();
    private Paint arrowsHourPaint = new Paint();
    private Paint arrowsMinutePaint = new Paint();
    private Paint arrowsSecondPaint = new Paint();
    private Paint centerCircle = new Paint();
    private Paint textPaint = new Paint();

    private UpdateClocks updateClocks = new UpdateClocks();
    private boolean isClocksWorking;

    private class UpdateClocks implements Runnable {
        @Override
        public void run() {
            Calendar calendar = Calendar.getInstance();
            currentHours = calendar.get(Calendar.HOUR);
            currentMinutes = calendar.get(Calendar.MINUTE);
            currentSeconds = calendar.get(Calendar.SECOND);
            invalidate();
            if (isClocksWorking){
                postDelayed(this, 1000);
            }
        }
    }

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

        /* get this calendar instance to receive an initial clocks with arrows */
        Calendar calendar = Calendar.getInstance();
        currentHours = calendar.get(Calendar.HOUR);
        currentMinutes = calendar.get(Calendar.MINUTE);
        currentSeconds = calendar.get(Calendar.SECOND);

        clocksPaint.setAntiAlias(true);
        clocksPaint.setColor(ContextCompat.getColor(getContext(), CLOCKS_COLOR));
        clocksPaint.setStyle(Paint.Style.STROKE);
        clocksPaint.setStrokeWidth(STROKE_CLOCKS_WIDE);

        centerCircle.setAntiAlias(true);
        centerCircle.setColor(ContextCompat.getColor(getContext(), CENTER_COLOR));
        centerCircle.setStyle(Paint.Style.FILL_AND_STROKE);

        arrowsHourPaint.setAntiAlias(true);
        arrowsHourPaint.setColor(ContextCompat.getColor(getContext(), ARROWS_COLOR));
        arrowsHourPaint.setStyle(Paint.Style.STROKE);
        arrowsHourPaint.setStrokeWidth(WIDTH_HOUR_ARROW);

        arrowsMinutePaint.setAntiAlias(true);
        arrowsMinutePaint.setColor(ContextCompat.getColor(getContext(), ARROWS_COLOR));
        arrowsMinutePaint.setStyle(Paint.Style.STROKE);
        arrowsMinutePaint.setStrokeWidth(WIDTH_MINUTE_ARROW);

        arrowsSecondPaint.setAntiAlias(true);
        arrowsSecondPaint.setColor(ContextCompat.getColor(getContext(), ARROWS_COLOR));
        arrowsSecondPaint.setStyle(Paint.Style.STROKE);
        arrowsSecondPaint.setStrokeWidth(WIDTH_SECOND_ARROW);

        textPaint.setAntiAlias(true);
        textPaint.setColor(ContextCompat.getColor(getContext(), NUMBERS_COLOR));
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setTextSize(NUMBERS_SIZE);
        textPaint.setTextAlign(Paint.Align.CENTER);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        clocksPaint.setStrokeWidth(STROKE_CLOCKS_WIDE);
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
                canvas.drawLine(clocksCenterX, clocksCenterY - radius*1/2, clocksCenterX, clocksCenterY, arrowsHourPaint);
            }
            canvas.drawLine(clocksCenterX,
                    clocksCenterY - radius,
                    clocksCenterX,
                    clocksCenterY - radius*6/7,
                    clocksPaint);
            canvas.rotate(360/12, clocksCenterX, clocksCenterY);
        }

        /* draw numbers */
        float textHeight = -textPaint.ascent() + textPaint.descent();
        canvas.drawText(HOURS_12, clocksCenterX, clocksCenterY - radius*3/4 + textHeight/2, textPaint);
        canvas.drawText(HOURS_3, clocksCenterX + radius*3/4, clocksCenterY + textHeight/2 - STROKE_CLOCKS_WIDE , textPaint);
        canvas.drawText(HOURS_6, clocksCenterX, clocksCenterY + radius*3/4, textPaint);
        canvas.drawText(HOURS_9, clocksCenterX - radius*3/4, clocksCenterY + textHeight/2 - STROKE_CLOCKS_WIDE, textPaint);

        /* minutes */
        clocksPaint.setStrokeWidth(STROKE_CLOCKS_TALL);
        for (int i = 0; i < 60; i++){
            /* draw a minutes arrow */
            if (i == currentMinutes){
                canvas.drawLine(clocksCenterX, clocksCenterY - radius*2/3, clocksCenterX, clocksCenterY, arrowsMinutePaint);
            }
            /* draw a seconds arrow */
            if (i == currentSeconds){
                canvas.drawLine(clocksCenterX, clocksCenterY - radius*6/7, clocksCenterX, clocksCenterY, arrowsSecondPaint);
            }
            canvas.drawLine(clocksCenterX,
                    clocksCenterY - radius,
                    clocksCenterX,
                    clocksCenterY - radius*9/10,
                    clocksPaint);
            canvas.rotate(360/60, clocksCenterX, clocksCenterY);
        }

        /* draw center circle */
        canvas.drawCircle(clocksCenterX, clocksCenterY, radius/10, centerCircle);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        /* turn On our clocks when attach view to the window */
        isClocksWorking = true;
        postDelayed(updateClocks, 1000);
    }

    @Override
    protected void onDetachedFromWindow() {
        /* turn Off our clocks when view is no longer attached to the window */
        isClocksWorking = false;
        super.onDetachedFromWindow();
    }
}

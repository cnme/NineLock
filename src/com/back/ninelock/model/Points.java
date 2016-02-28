package com.back.ninelock.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class Points extends View {
	private Paint paint;

	public Points(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setFocusable(true);
		paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.WHITE);
	}

	public Points(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFocusable(true);
		paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.WHITE);
	}

	public Points(Context context) {
		super(context);
		setFocusable(true);
		paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.WHITE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawCircle(60, 60, 30, paint);
		super.onDraw(canvas);
	}
	
	

}

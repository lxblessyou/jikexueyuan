package com.example.admin.rulerlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by admin on 2015-07-01.
 */
public class RulerUI extends TextView{
    public RulerUI(Context context) {
        super(context);
    }

    public RulerUI(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float spacing = this.getWidth() * 1.0f / 10;
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        for (int i = 0; i < 10; i++) {
            canvas.drawLine(i*spacing,0,i*spacing,5,paint);
        }
    }
}

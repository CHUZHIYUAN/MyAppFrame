package czy.myappframe.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by george on 2016/12/7.
 */

public class GeorgeView extends View {

    private Paint mPaint = new Paint();

    public GeorgeView(Context context) {
        super(context);
    }

    public GeorgeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int withMeasuMode = MeasureSpec.getMode(widthMeasureSpec);
        int withMeasueSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(withMeasueSize, heightMeasureSize);
    }

    private void initPaint() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPoint(200, 200, mPaint);

        canvas.drawPoints(new float[]{
                500, 500, 500, 600, 500, 700


        }, mPaint);

        canvas.drawLine(200, 300, 700, 800, mPaint);

        RectF rectF = new RectF(100,300,400,500);
//        canvas.drawRoundRect(rectF,90,10,mPaint);

        canvas.drawCircle(500,500,100,mPaint);



        canvas.drawArc(rectF,0,180,false,mPaint);

    }
}

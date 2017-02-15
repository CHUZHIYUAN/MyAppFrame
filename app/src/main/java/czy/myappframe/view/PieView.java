package czy.myappframe.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

import czy.myappframe.model.PieData;

/**
 * Created by george on 2016/12/7.
 * <p>
 * 饼状图
 */

public class PieView extends View {
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    private Paint mPaint;

    private ArrayList<PieData> dataList;
    private int mwidth;
    private int mheight;


    /**
     * 给出值
     *
     * @param data
     */
    public void setData(ArrayList<PieData> data) {
        //总值
        float sunValue = 0;
        for (int i = 0; i < data.size(); i++) {
            PieData pieData = data.get(i);
            sunValue = sunValue + pieData.getValue();
        }

        //给出每个扇形对应的角度，颜色值
        for (int j = 0; j < data.size(); j++) {
            PieData mPieData = data.get(j);
            float angle = mPieData.getValue() / sunValue * 360;
            mPieData.setAngle(angle);
            int colorIndex = j % mColors.length;
            mPieData.setColor(mColors[colorIndex]);
        }
        this.dataList = data;
    }


    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mwidth = w;
        mheight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float startAngle = 0;
        canvas.translate(mwidth / 2, mheight / 2);
        float r = (float) (Math.min(mwidth, mheight) / 2 * 0.8);
        RectF rect = new RectF(-r, -r, r, r);
        for (int i = 0; i < dataList.size(); i++) {
            PieData myPieData = dataList.get(i);
            mPaint.setColor(myPieData.getColor());
            canvas.drawArc(rect, startAngle, myPieData.getAngle(), true, mPaint);
            startAngle += myPieData.getAngle();
        }


    }
}

package text.bwie.com.liuxixin;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * 类描述：自定义view圆
 * 姓名 ：刘希鑫
 */

public class Zhuandong extends View {
    private int mBallColor = Color.BLACK;
    private float mRadius = 10f;
    private PointF mCenterPoint;
    private Paint mPaint;
    private  float circle_x;
    private  float circle_y;
    private  float circle_radius;
    private  Paint paint;


    public Zhuandong(Context context) {
        this(context, null);
    }

    public Zhuandong(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
  init();
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mCenterPoint=new PointF(mRadius,mRadius);

    }
    //重写view类的onDraw（）函数

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mBallColor);
        canvas.drawCircle(mCenterPoint.x, mCenterPoint.y, mRadius, mPaint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = (int) (getPaddingLeft() + 2*mRadius + getPaddingRight());
        int height = (int) (getPaddingTop() + 2*mRadius + getPaddingBottom());

        setMeasuredDimension(width, height);
    }
    public void setBallColor(int mBallColor) {
        this.mBallColor = mBallColor;
    }

    public void setRadius(float radius) {
        this.mRadius = radius;
        mCenterPoint.set(radius, radius);
    }

    public float getRadius() {
        return mRadius;
    }



    public class AroundCircleBall extends RelativeLayout {


        public AroundCircleBall(Context context, AttributeSet attrs) {
            super(context, attrs);

            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AroundCircleBall);
            //设置圆心的x值,如果没有在xml中设置，就使用后面的默认值
            circle_x = a.getDimension(R.styleable.AroundCircleBall_circle_x, 50);
//设置圆心的Y值
            circle_y = a.getDimension(R.styleable.AroundCircleBall_circle_y, 50);
            //设置圆的颜色
            int color = a.getColor(R.styleable.AroundCircleBall_circle_color, Color.BLUE);
//设置圆的半径
            circle_radius = a.getDimension(R.styleable.AroundCircleBall_circle_radius, 100);



            a.recycle();
            //设置画笔
            paint = new Paint();
            //设置颜色
            paint.setColor(color);
            //设置实心或者空心圆
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            //设置空心圆的边线的宽度
            paint.setStrokeWidth(5);
//
// mBall.setBallColor(mBallColor);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            //绘制圆
            canvas.drawCircle(circle_x,circle_y,circle_radius,paint);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            //测量控件宽高
            int width = (int) (getPaddingLeft() + widthMeasureSpec * 2 + heightMeasureSpec * 2 + getPaddingRight());
            int height = (int) (getPaddingTop() + widthMeasureSpec * 2 + heightMeasureSpec * 2 + getPaddingBottom());
            setMeasuredDimension(width, height);
        }
    }




}

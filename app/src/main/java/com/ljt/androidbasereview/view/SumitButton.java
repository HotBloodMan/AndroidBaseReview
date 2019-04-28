package com.ljt.androidbasereview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.ljt.androidbasereview.R;

public class SumitButton extends View{

    private String buttonText="";
    public SumitButton(Context context) {
        super(context);
    }

    public SumitButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SumitButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.SubmitButton, defStyleAttr, 0);
        buttonText=typedArray.getString(R.styleable.SubmitButton_buttonText);
        typedArray.recycle();
        init();
    }

    private void init() {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int withMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

    }
    private OnResultEndListener listener;
    public interface  OnResultEndListener{
        void onResultEnd();
    }

    public void setResultEndListener(OnResultEndListener listener){
        this.listener=listener;
    }


}

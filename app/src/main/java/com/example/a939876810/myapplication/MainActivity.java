package com.example.a939876810.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity  implements View.OnTouchListener{

    ImageView _view;
    LinearLayout _root;
    private int _xDelta;
    private int _yDelta;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _root = (LinearLayout) findViewById(R.id.activity_main);

        _view = (ImageView) findViewById(R.id.imv);
        _view.setScaleType(ImageView.ScaleType.CENTER_CROP);

        _view.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                LinearLayout.LayoutParams lParams = (LinearLayout.LayoutParams) view
                        .getLayoutParams();

                _yDelta = Y - lParams.topMargin;

                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view
                        .getLayoutParams();
                layoutParams.topMargin = Y - _yDelta;
                int height = view.getHeight();
                if(layoutParams.topMargin>0) {
                    layoutParams.topMargin = 0;

                }
                int i = 0 - layoutParams.topMargin;
                double ii = ArithUtii.div(i, height);

                double sub = ArithUtii.sub(1, ii);
                Log.e("fffff","");

                //设置透明度
                view.setAlpha((float) sub);


                view.setLayoutParams(layoutParams);


                break;
            default:
                break;
        }
        _root.invalidate();
        return true;
    }
}

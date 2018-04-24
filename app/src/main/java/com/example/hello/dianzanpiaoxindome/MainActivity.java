package com.example.hello.dianzanpiaoxindome;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DivergeViewSecond mDivergeView;
    private ImageView mImageView;
    private List<Bitmap> mList=new ArrayList<Bitmap>();
    private int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView =findViewById(R.id.iv_start);
        mList = new ArrayList<>();
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a1, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(),R.drawable.a1,null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(),R.drawable.a1,null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(),R.drawable.a1,null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(),R.drawable.a1,null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a1, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a1, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a1, null)).getBitmap());
        //mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a10, null)).getBitmap());
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIndex == 8){
                    mIndex = 0 ;
                }
                mDivergeView.startDiverges(mIndex);
                mIndex ++;
            }
        });
        mDivergeView =findViewById(R.id.divergeView);
        mDivergeView.post(new Runnable() {
            @Override
            public void run() {
                mDivergeView.setEndPoint(new PointF(mDivergeView.getMeasuredWidth()/2,0));
                mDivergeView.setDivergeViewProvider(new Provider());
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mList != null){
            mList.clear();
            mList = null;
        }

    }

    class Provider implements DivergeViewSecond.DivergeViewProvider{

        @Override
        public Bitmap getBitmap(Object obj) {
            return mList == null ? null : mList.get((int)obj);
        }
    }

}

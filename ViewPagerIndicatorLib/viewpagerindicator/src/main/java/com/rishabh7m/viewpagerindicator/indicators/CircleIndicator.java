package com.rishabh7m.viewpagerindicator.indicators;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rishabh7m.viewpagerindicator.R;
import com.rishabh7m.viewpagerindicator.fontawesome.TextAwesome;
import com.rishabh7m.viewpagerindicator.interfaces.PagerIndicator;

import java.util.List;
import java.util.jar.Attributes;

public class CircleIndicator extends LinearLayout implements PagerIndicator {

    private ViewPager mViewPager;
    private int mCount;
    private Context mContext;
    private AttributeSet mAttributeSet;
    private float mRadius = 15;
    private ViewPager.OnPageChangeListener mListener;
    private int mCurrentPos;
    private int mColor;

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mContext = context;
        mColor = getResources().getColor(R.color.DEFAULT_COLOR);
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);
    }

    /**
     * @param radius : radius value in dp
     */
    public void setRadius(float radius) {
        mRadius = radius;
    }

    public int getPixels(float dp) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    @Override
    public void setPager(ViewPager pager) {
        if (pager != null) {
            setOrientation(LinearLayout.HORIZONTAL);
            setGravity(Gravity.CENTER);

            mViewPager = pager;
            mCount = mViewPager.getAdapter().getCount();
            setWeightSum(mCount);
            mViewPager.setOnPageChangeListener(this);
            setView();
        }
    }

    private void setView() {
        for (int i=0; i<mCount; i++) {
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            TextAwesome textAwesome = new TextAwesome(getContext());
            textAwesome.setId(i);
            textAwesome.setLayoutParams(new LayoutParams(0,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            textAwesome.setTextSize(TypedValue.COMPLEX_UNIT_SP, mRadius);
            if(i != 0) {
                textAwesome.setText(getResources().getString(R.string.fa_circle_thin));
            }
            else {
                textAwesome.setText(getResources().getString(R.string.fa_circle));
            }
            textAwesome.setTextColor(mColor);
            if (i != 0) {
                params.setMargins(getPixels(15), 0, 0, 0);
            }
            textAwesome.setLayoutParams(params);
            addView(textAwesome);
        }
    }

    public void setColor(int color) {
        mColor = color;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for(int i=0; i<mCount; i++) {
            TextAwesome textAwesome = (TextAwesome) findViewById(i);
            if(i != position) {
                textAwesome.setText(getResources().getString(R.string.fa_circle_thin));
            }
            else {
                textAwesome.setText(getResources().getString(R.string.fa_circle));
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

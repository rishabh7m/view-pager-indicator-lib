package com.rishabh7m.viewpagerindicator.indicators;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.rishabh7m.viewpagerindicator.interfaces.PagerIndicator;

public class IconIndicator extends LinearLayout implements PagerIndicator {
    
    public IconIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setPager(ViewPager pager) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

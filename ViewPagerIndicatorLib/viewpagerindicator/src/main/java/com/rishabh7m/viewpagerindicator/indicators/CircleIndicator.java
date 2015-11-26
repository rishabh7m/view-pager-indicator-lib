package com.rishabh7m.viewpagerindicator.indicators;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.rishabh7m.viewpagerindicator.interfaces.PagerIndicator;

public class CircleIndicator extends View implements PagerIndicator {

    private ViewPager mViewPager;

    public CircleIndicator(Context context) {
        super(context);
    }

    @Override
    public void setPager(ViewPager pager) {
        mViewPager = pager;
    }
}

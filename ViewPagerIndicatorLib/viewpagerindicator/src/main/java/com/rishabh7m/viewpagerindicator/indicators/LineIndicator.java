package com.rishabh7m.viewpagerindicator.indicators;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rishabh7m.viewpagerindicator.classes.Dimension;
import com.rishabh7m.viewpagerindicator.interfaces.PagerIndicator;

public class LineIndicator extends LinearLayout implements PagerIndicator {

    private ViewPager viewPager;
    private Context context;
    private int count;
    private float length, height;
    private Dimension dimension;
    private int selectedColor, notSelectedColor;
    private float spacing;
    private String base = "#EDE7E9";
    private String black = "#000000";

    public LineIndicator(Context context) {
        super(context);
        this.context = context;
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);
        dimension = new Dimension(context);

        spacing = 15;
        selectedColor = Color.parseColor(black);
        notSelectedColor = Color.parseColor(base);
        length = 30;
        height = 5;
    }

    public LineIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setLength(float length) {
        this.length = dimension.dpToPx(length);
    }

    public void setHeight(float height) {
        this.height = dimension.dpToPx(height);
    }

    public void setSelectedColor(int color) {
        selectedColor = color;
    }

    public void setNotSelectedColor(int color) {
        notSelectedColor = color;
    }

    public void setSpacing(float spacing) {
        this.spacing = spacing;
    }

    @Override
    public void setPager(ViewPager pager) {
        if (pager != null) {
            setOrientation(LinearLayout.HORIZONTAL);
            setGravity(Gravity.CENTER);

            viewPager = pager;
            count = viewPager.getAdapter().getCount();
            setWeightSum(count);
            viewPager.setOnPageChangeListener(this);
            setView();
        }

    }

    private void setView() {
        for (int i=0; i<count; i++) {
            LayoutParams params = new LayoutParams((int)length, (int)height);
            TextView line = new TextView(getContext());
            line.setId(i);
            line.setLayoutParams(new LayoutParams((int) length, (int) height, 1));
            if(i != 0) {
                line.setBackgroundColor(notSelectedColor);
            }
            else {
                line.setBackgroundColor(selectedColor);
            }
            if (i != 0) {
                //params.setMargins((int)dimension.dpToPx(spacing), 0, 0, 0);
            }
            line.setLayoutParams(params);
            addView(line);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for(int i=0; i<count; i++) {
            TextView line = (TextView) findViewById(i);
            if(i != position) {
                line.setBackgroundColor(notSelectedColor);
            }
            else {
                line.setBackgroundColor(selectedColor);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

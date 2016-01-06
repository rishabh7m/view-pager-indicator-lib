package com.rishabh7m.sample.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rishabh7m.sample.R;
import com.rishabh7m.sample.adapters.ViewPagerAdapter;
import com.rishabh7m.viewpagerindicator.indicators.CircleIndicator;
import com.rishabh7m.viewpagerindicator.indicators.LineIndicator;

public class PagerSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_sample);

        ViewPager pager = (ViewPager) findViewById(R.id.activity_pager_sample_view_pager);
        //CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.circle_indicator);
        LineIndicator lineIndicator = (LineIndicator) findViewById(R.id.circle_indicator);

        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        /*circleIndicator.setRadius(8);
        circleIndicator.setColor(getResources().getColor(R.color.colorAccent));
        circleIndicator.setSpacing(5);
        circleIndicator.setPager(pager);*/

        lineIndicator.setSpacing(10);
        lineIndicator.setPager(pager);
    }
}

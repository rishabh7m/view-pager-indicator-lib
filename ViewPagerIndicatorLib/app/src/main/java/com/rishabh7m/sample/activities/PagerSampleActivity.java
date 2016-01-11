package com.rishabh7m.sample.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rishabh7m.sample.R;
import com.rishabh7m.sample.adapters.ViewPagerAdapter;
import com.rishabh7m.viewpagerindicator.indicators.CircleIndicator;
import com.rishabh7m.viewpagerindicator.indicators.LineIndicator;

public class PagerSampleActivity extends AppCompatActivity {

    private CircleIndicator circleIndicator;
    private LineIndicator lineIndicator;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_sample);

        Bundle bundle = getIntent().getExtras();
        int chooser = bundle.getInt(IndicatorChooser.CHOOSER_TAG);

        pager = (ViewPager) findViewById(R.id.activity_pager_sample_view_pager);
        circleIndicator = (CircleIndicator) findViewById(R.id.circle_indicator);
        lineIndicator = (LineIndicator) findViewById(R.id.line_indicator);

        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        switch (chooser) {
            case IndicatorChooser.CIRCLE_INDICATOR_ID:
                showCircleIndicator();
                break;
            case IndicatorChooser.LINE_INDICATOR_ID:
                showLineIndicator();
                break;
        }
    }

    private void showLineIndicator() {
        circleIndicator.setVisibility(View.GONE);
        lineIndicator.setVisibility(View.VISIBLE);

        lineIndicator.setSpacing(10);
        lineIndicator.setLength(20);
        lineIndicator.setSelectedColor(getResources().getColor(R.color.colorPrimaryDark));
        lineIndicator.setNotSelectedColor(getResources().getColor(R.color.colorAccent));
        lineIndicator.setPager(pager);
    }

    private void showCircleIndicator() {
        circleIndicator.setVisibility(View.VISIBLE);
        lineIndicator.setVisibility(View.GONE);

        circleIndicator.setRadius(8);
        circleIndicator.setColor(getResources().getColor(R.color.colorAccent));
        circleIndicator.setSpacing(5);
        circleIndicator.setPager(pager);
    }
}

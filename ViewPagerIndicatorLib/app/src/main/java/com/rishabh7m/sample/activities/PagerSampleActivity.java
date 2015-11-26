package com.rishabh7m.sample.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rishabh7m.sample.R;
import com.rishabh7m.sample.adapters.ViewPagerAdapter;

public class PagerSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_sample);

        ViewPager pager = (ViewPager) findViewById(R.id.activity_pager_sample_view_pager);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }
}

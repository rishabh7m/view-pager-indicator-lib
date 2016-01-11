package com.rishabh7m.sample.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rishabh7m.sample.R;
import com.rishabh7m.viewpagerindicator.indicators.CircleIndicator;

public class IndicatorChooser extends AppCompatActivity implements View.OnClickListener {

    public static final int CIRCLE_INDICATOR_ID = 0;
    public static final int LINE_INDICATOR_ID = 1;

    public static String CHOOSER_TAG = "CHOOSER-TAG";

    private Button circleIndicator, lineIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_chooser);

        circleIndicator = (Button) findViewById(R.id.activity_indicator_chooser_circle);
        lineIndicator = (Button) findViewById(R.id.activity_indicator_chooser_line);

        circleIndicator.setOnClickListener(this);
        lineIndicator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_indicator_chooser_circle:
                circleIndicatorOnClick();
                break;
            case R.id.activity_indicator_chooser_line:
                lineIndicatorOnClick();
                break;
        }
    }

    private void lineIndicatorOnClick() {
        Intent intent = new Intent(this, PagerSampleActivity.class);
        intent.putExtra(CHOOSER_TAG, LINE_INDICATOR_ID);
        startActivity(intent);
    }

    private void circleIndicatorOnClick() {
        Intent intent = new Intent(this, PagerSampleActivity.class);
        intent.putExtra(CHOOSER_TAG, CIRCLE_INDICATOR_ID);
        startActivity(intent);
    }
}

package com.rishabh7m.viewpagerindicator.classes;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class Dimension {

    private Context context;
    private DisplayMetrics displayMetrics;

    public Dimension(Context context) {
        this.context = context;
        displayMetrics = context.getResources().getDisplayMetrics();
    }

    public float dpToPx(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                displayMetrics);
    }
}

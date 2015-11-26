package com.rishabh7m.sample.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rishabh7m.sample.fragments.FirstFragment;
import com.rishabh7m.sample.fragments.SecondFragment;
import com.rishabh7m.sample.fragments.ThirdFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
                return new FirstFragment();
            case 1 :
                return new SecondFragment();
            case 2 :
                return new ThirdFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

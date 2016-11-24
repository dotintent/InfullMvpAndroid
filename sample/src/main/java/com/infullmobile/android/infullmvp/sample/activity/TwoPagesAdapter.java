package com.infullmobile.android.infullmvp.sample.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.infullmobile.android.infullmvp.sample.fragment.SampleFragment;

public class TwoPagesAdapter extends FragmentStatePagerAdapter {

    public TwoPagesAdapter(final FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(final int position) {
        return position == 0
                ? new SampleFragment()
                : new SampleFragment();
    }
}

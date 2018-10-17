package com.infullmobile.android.infullmvp.sample.activity;

import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.infullmobile.android.infullmvp.PresentedActivityView;
import com.infullmobile.android.infullmvp.sample.R;

public class SampleActivityView extends PresentedActivityView<SampleActivityPresenter> {

    protected TextView textField;
    protected ViewPager pager;

    private final FragmentStatePagerAdapter pagerAdapter;

    public SampleActivityView(FragmentStatePagerAdapter pagerAdapter) {
        this.pagerAdapter = pagerAdapter;
    }

    @LayoutRes
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_sample;
    }

    @Override
    protected void bindViews() {
        textField = findView(R.id.textContainer);
        pager = findView(R.id.pagesContainer);
    }

    @Override
    public void onViewsBound() {
        pager.setAdapter(pagerAdapter);
    }

    public void setMessage(String message) {
        textField.setText(message);
    }
}

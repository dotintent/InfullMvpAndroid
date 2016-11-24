package com.infullmobile.android.infullmvp.sample.fragment;

import android.support.annotation.LayoutRes;
import android.widget.TextView;

import com.infullmobile.android.infullmvp.PresentedFragmentView;
import com.infullmobile.infullmvp.sample.R;

public class SampleFragmentView extends PresentedFragmentView<SampleFragmentPresenter> {

    private TextView fragmentTextViewContainer;

    @LayoutRes
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_sample;
    }

    @Override
    protected void bindViews() {
        fragmentTextViewContainer = findView(R.id.fragmentTextContainer);
    }

    @Override
    protected void onViewsBound() {
    }

    public void setText(String message) {
        fragmentTextViewContainer.setText(message);
    }
}

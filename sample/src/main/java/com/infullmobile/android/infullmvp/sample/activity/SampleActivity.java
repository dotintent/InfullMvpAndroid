package com.infullmobile.android.infullmvp.sample.activity;

import android.content.Context;
import android.content.Intent;
import com.infullmobile.android.infullmvp.InFullMvpActivity;
import com.infullmobile.android.infullmvp.sample.activity.di.SampleActivityGraph;
import javax.inject.Inject;

public class SampleActivity extends InFullMvpActivity<SampleActivityPresenter, SampleActivityView> {

    @Inject SampleActivityPresenter sampleActivityPresenter;
    @Inject SampleActivityView sampleActivityView;
    protected SampleActivityGraph sampleActivityGraph = new SampleActivityGraph(this);

    @Override
    public SampleActivityPresenter getPresenter() {
        return sampleActivityPresenter;
    }

    @Override
    public SampleActivityView getPresentedView() {
        return sampleActivityView;
    }

    @Override
    protected void injectIntoGraph() {
        sampleActivityGraph.inject(this);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, SampleActivity.class);
    }
}

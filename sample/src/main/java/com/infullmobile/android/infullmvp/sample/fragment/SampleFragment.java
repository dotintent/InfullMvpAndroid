package com.infullmobile.android.infullmvp.sample.fragment;

import android.os.Bundle;

import com.infullmobile.android.infullmvp.InFullMvpFragment;
import com.infullmobile.android.infullmvp.sample.fragment.di.SampleFragmentGraph;

import javax.inject.Inject;

public class SampleFragment extends InFullMvpFragment<SampleFragmentPresenter, SampleFragmentView> {

    @Inject SampleFragmentPresenter sampleFragmentPresenter;
    @Inject SampleFragmentView sampleFragmentView;

    private SampleFragmentGraph sampleFragmentGraph;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sampleFragmentGraph = new SampleFragmentGraph(this);
    }

    @Override
    protected SampleFragmentPresenter getPresenter() {
        return sampleFragmentPresenter;
    }

    @Override
    protected SampleFragmentView getPresentedView() {
        return sampleFragmentView;
    }

    @Override
    protected void injectIntoGraph() {
        sampleFragmentGraph.inject(this);
    }
}

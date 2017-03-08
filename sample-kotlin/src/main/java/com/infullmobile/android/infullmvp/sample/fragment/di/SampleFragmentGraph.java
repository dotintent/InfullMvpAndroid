package com.infullmobile.android.infullmvp.sample.fragment.di;

import android.support.annotation.VisibleForTesting;

import com.infullmobile.android.infullmvp.sample.fragment.SampleFragment;

import dagger.Component;

public class SampleFragmentGraph {

    private final DaggerSampleFragmentGraph_SampleFragmentComponent.Builder sampleFragmentComponentBuilder;

    public SampleFragmentGraph(SampleFragment sampleFragment) {
        this.sampleFragmentComponentBuilder = DaggerSampleFragmentGraph_SampleFragmentComponent
                .builder()
                .sampleFragmentModule(new SampleFragmentModule(sampleFragment));
    }

    public void inject(SampleFragment sampleFragment) {
        sampleFragmentComponentBuilder.build().inject(sampleFragment);
    }

    @VisibleForTesting
    public void setSampleFragmentModule(SampleFragmentModule sampleFragmentModule) {
        sampleFragmentComponentBuilder.sampleFragmentModule(sampleFragmentModule);
    }

    @SampleFragmentScope
    @Component(
            modules = SampleFragmentModule.class
    )
    interface SampleFragmentComponent {
        void inject(SampleFragment sampleFragment);
    }
}

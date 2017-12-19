package com.infullmobile.android.infullmvp.sample.activity.di;

import android.support.annotation.VisibleForTesting;

import com.infullmobile.android.infullmvp.sample.Navigation;
import com.infullmobile.android.infullmvp.sample.activity.SampleActivity;
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCard;

import dagger.Component;
import dagger.Subcomponent;

public class SampleActivityGraph {

    public final DaggerSampleActivityGraph_SampleActivityComponent.Builder sampleActivityComponentBuilder;

    public SampleActivityGraph(SampleActivity sampleActivity) {
        this.sampleActivityComponentBuilder = DaggerSampleActivityGraph_SampleActivityComponent
                .builder()
                .sampleActivityModule(new SampleActivityModule(sampleActivity));
    }

    public void inject(SampleActivity sampleActivity) {
        sampleActivityComponentBuilder.build().inject(sampleActivity);
    }

    @VisibleForTesting
    public void setAddNewItemModule(SampleActivityModule sampleActivityModule) {
        sampleActivityComponentBuilder.sampleActivityModule(sampleActivityModule);
    }

    @SampleActivityScope
    @Component(
            modules = SampleActivityModule.class
    )
    public interface SampleActivityComponent {
        void inject(SampleActivity sampleActivity);
        Navigation providesNavigation();
    }
}

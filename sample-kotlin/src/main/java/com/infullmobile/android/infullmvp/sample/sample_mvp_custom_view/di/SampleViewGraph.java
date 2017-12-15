package com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view.di;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.util.AttributeSet;
import com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view.SampleMvpCustomView;
import dagger.Component;

public class SampleViewGraph {

    private final DaggerSampleViewGraph_SampleViewComponent.Builder sampleCustomViewComponentBuilder;

    public SampleViewGraph(Context context, AttributeSet attributeSet) {
        this.sampleCustomViewComponentBuilder = DaggerSampleViewGraph_SampleViewComponent
                .builder()
                .sampleViewModule(new SampleViewModule(context, attributeSet));
    }

    public void inject(SampleMvpCustomView sampleMvpCustomView) {
        sampleCustomViewComponentBuilder.build().inject(sampleMvpCustomView);
    }

    @VisibleForTesting
    public void setAddNewItemModule(SampleViewModule sampleViewModule) {
        sampleCustomViewComponentBuilder.sampleViewModule(sampleViewModule);
    }

    @SampleViewScope
    @Component(
            modules = SampleViewModule.class
    )
    interface SampleViewComponent {
        void inject(SampleMvpCustomView sampleMvpCustomView);
    }
}

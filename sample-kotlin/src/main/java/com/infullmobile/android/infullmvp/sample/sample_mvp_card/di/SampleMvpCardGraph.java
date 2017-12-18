package com.infullmobile.android.infullmvp.sample.sample_mvp_card.di;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.util.AttributeSet;
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCard;
import dagger.Component;

public class SampleMvpCardGraph {

    private final DaggerSampleMvpCardGraph_SampleMvpCardComponent.Builder sampleCustomMvpCardComponentBuilder;

    public SampleMvpCardGraph(Context context, AttributeSet attributeSet) {
        this.sampleCustomMvpCardComponentBuilder = DaggerSampleMvpCardGraph_SampleMvpCardComponent
                .builder()
                .sampleMvpCardModule(new SampleMvpCardModule(context, attributeSet));
    }

    public void inject(SampleMvpCard sampleMvpCard) {
        sampleCustomMvpCardComponentBuilder.build().inject(sampleMvpCard);
    }

    @VisibleForTesting
    public void setAddNewItemModule(SampleMvpCardModule sampleMvpCardModule) {
        sampleCustomMvpCardComponentBuilder.sampleMvpCardModule(sampleMvpCardModule);
    }

    @SampleMvpCardScope
    @Component(
            modules = SampleMvpCardModule.class
    )
    interface SampleMvpCardComponent {
        void inject(SampleMvpCard sampleMvpCard);
    }
}

package com.infullmobile.android.infullmvp.sample.sample_mvp_card.di;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import com.infullmobile.android.infullmvp.sample.di_components.HasComponent;
import com.infullmobile.android.infullmvp.sample.mvp_card_activity.di.MvpCardGraph;
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCard;
import dagger.Component;

public class SampleMvpCardGraph {

    private final DaggerSampleMvpCardGraph_SampleMvpCardComponent.Builder sampleCustomMvpCardComponentBuilder;

    private HasComponent<MvpCardGraph.MvpCardComponent> activityWithComponent;

    public SampleMvpCardGraph(Context context) {
        activityWithComponent = (HasComponent<MvpCardGraph.MvpCardComponent>) context;
        this.sampleCustomMvpCardComponentBuilder = DaggerSampleMvpCardGraph_SampleMvpCardComponent
                .builder()
                .sampleMvpCardModule(new SampleMvpCardModule(context));
    }

    public void inject(SampleMvpCard sampleMvpCard) {
        sampleCustomMvpCardComponentBuilder
                .mvpCardComponent(activityWithComponent.getComponent())
                .build()
                .inject(sampleMvpCard);
    }

    @VisibleForTesting
    public void setAddNewItemModule(SampleMvpCardModule sampleMvpCardModule) {
        sampleCustomMvpCardComponentBuilder.sampleMvpCardModule(sampleMvpCardModule);
    }

    @SampleMvpCardScope
    @Component(
            dependencies = MvpCardGraph.MvpCardComponent.class,
            modules = { SampleMvpCardModule.class }
    )
    interface SampleMvpCardComponent {
        void inject(SampleMvpCard sampleMvpCard);
    }
}

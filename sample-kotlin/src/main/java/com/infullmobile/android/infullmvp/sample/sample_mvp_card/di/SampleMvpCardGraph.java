package com.infullmobile.android.infullmvp.sample.sample_mvp_card.di;

import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.infullmobile.android.infullmvp.sample.Navigation;
import com.infullmobile.android.infullmvp.sample.activity.SampleActivity;
import com.infullmobile.android.infullmvp.sample.activity.di.DaggerSampleActivityGraph_SampleActivityComponent;
import com.infullmobile.android.infullmvp.sample.activity.di.SampleActivityGraph;
import com.infullmobile.android.infullmvp.sample.activity.di.SampleActivityModule;
import com.infullmobile.android.infullmvp.sample.activity.di.SampleActivityScope;
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCard;
import dagger.Component;

public class SampleMvpCardGraph {

    private final DaggerSampleMvpCardGraph_SampleMvpCardComponent.Builder sampleCustomMvpCardComponentBuilder;

    private Context context;

    public SampleMvpCardGraph(Context context) {
        this.context = context;
        this.sampleCustomMvpCardComponentBuilder = DaggerSampleMvpCardGraph_SampleMvpCardComponent
                .builder()
                .sampleMvpCardModule(new SampleMvpCardModule(context));
    }

    public void inject(SampleMvpCard sampleMvpCard) {
        sampleCustomMvpCardComponentBuilder
                .sampleActivityComponent(((SampleActivity)context).getSampleActivityGraph().sampleActivityComponentBuilder.build())
                .build().inject(sampleMvpCard);
    }

    @VisibleForTesting
    public void setAddNewItemModule(SampleMvpCardModule sampleMvpCardModule) {
        sampleCustomMvpCardComponentBuilder.sampleMvpCardModule(sampleMvpCardModule);
    }

    @SampleMvpCardScope
    @Component(
            dependencies = SampleActivityGraph.SampleActivityComponent.class,
            modules = { SampleMvpCardModule.class }
    )
    interface SampleMvpCardComponent {
        void inject(SampleMvpCard sampleMvpCard);
    }
}

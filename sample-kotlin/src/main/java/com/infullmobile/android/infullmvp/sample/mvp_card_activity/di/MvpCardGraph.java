package com.infullmobile.android.infullmvp.sample.mvp_card_activity.di;

import android.support.annotation.VisibleForTesting;
import com.infullmobile.android.infullmvp.sample.Navigation;
import com.infullmobile.android.infullmvp.sample.mvp_card_activity.MvpCardActivity;
import dagger.Component;

public class MvpCardGraph {

    private final DaggerMvpCardGraph_MvpCardComponent.Builder builder;
    public MvpCardComponent mvpCardComponent;

    public MvpCardGraph(MvpCardActivity activity) {
        this.builder = DaggerMvpCardGraph_MvpCardComponent
                .builder()
                .mvpCardModule(new MvpCardModule(activity));
    }

    public void inject(MvpCardActivity activity) {
        mvpCardComponent = builder
                .build();
        mvpCardComponent.inject(activity);
    }

    @VisibleForTesting
    public void setMvpCardModule(MvpCardModule module) {
        builder.mvpCardModule(module);
    }

    @MvpCardScope
    @Component(
            modules = MvpCardModule.class
    )
    public interface MvpCardComponent {
        void inject(MvpCardActivity activity);
        Navigation providesNavigation();
    }
}

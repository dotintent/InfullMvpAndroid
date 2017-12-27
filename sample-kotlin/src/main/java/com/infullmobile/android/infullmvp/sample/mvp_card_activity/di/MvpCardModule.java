package com.infullmobile.android.infullmvp.sample.mvp_card_activity.di;

import android.content.Context;
import com.infullmobile.android.infullmvp.sample.Navigation;
import com.infullmobile.android.infullmvp.sample.SampleNavigation;
import com.infullmobile.android.infullmvp.sample.mvp_card_activity.MvpCardActivity;
import com.infullmobile.android.infullmvp.sample.mvp_card_activity.MvpCardPresenter;
import com.infullmobile.android.infullmvp.sample.mvp_card_activity.MvpCardView;
import dagger.Module;
import dagger.Provides;

@Module
public class MvpCardModule {

    private MvpCardActivity activity;

    public MvpCardModule(MvpCardActivity activity) {
        this.activity = activity;
    }

    @MvpCardScope
    @Provides
    Context providesContext() {
        return activity;
    }

    @MvpCardScope
    @Provides
    Navigation providesNavigation() {
        return new SampleNavigation(activity);
    }

    @MvpCardScope
    @Provides
    MvpCardView providesMvpCardView() {
        return new MvpCardView();
    }

    @MvpCardScope
    @Provides
    public MvpCardPresenter providesMvpCardPresenter(
            MvpCardView view
    ) {
        return new MvpCardPresenter(view);
    }
}

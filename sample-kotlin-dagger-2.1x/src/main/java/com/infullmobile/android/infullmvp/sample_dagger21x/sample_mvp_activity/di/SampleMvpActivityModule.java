package com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.di;

import android.content.Context;

import com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.SampleMvpActivity;
import com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.SampleMvpActivityModel;
import com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.SampleMvpActivityPresenter;
import com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.SampleMvpActivityView;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class SampleMvpActivityModule {

    @SampleMvpActivityScope
    @Provides
    static SampleMvpActivityView providesMvpView() {
        return new SampleMvpActivityView();
    }

    @SampleMvpActivityScope
    @Provides
    static SampleMvpActivityModel providesMvpModel() {
        return new SampleMvpActivityModel();
    }

    @SampleMvpActivityScope
    @Provides
    static SampleMvpActivityPresenter providesMvpPresenter(
            SampleMvpActivityModel model,
            SampleMvpActivityView view
    ) {
        return new SampleMvpActivityPresenter(model, view);
    }

    @SampleMvpActivityScope
    @Binds
    abstract Context bindsContext(SampleMvpActivity activity);
}

package com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.di;

import com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity.SampleMvpActivityPresenter;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;

@Module
public class SampleTestMvpActivityModule {

    @SampleMvpActivityScope
    @Provides static SampleMvpActivityPresenter providesPresenter() {
        return Mockito.mock(SampleMvpActivityPresenter.class);
    }
}

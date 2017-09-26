package com.infullmobile.android.infullmvp.sample.fragment.di;

import com.infullmobile.android.infullmvp.sample.Navigation;
import com.infullmobile.android.infullmvp.sample.SampleNavigation;
import com.infullmobile.android.infullmvp.sample.fragment.SampleFragment;
import com.infullmobile.android.infullmvp.sample.fragment.SampleFragmentModel;
import com.infullmobile.android.infullmvp.sample.fragment.SampleFragmentPresenter;
import com.infullmobile.android.infullmvp.sample.fragment.SampleFragmentView;
import dagger.Module;
import dagger.Provides;

@Module
public class SampleFragmentModule {

    private SampleFragment sampleFragment;

    public SampleFragmentModule(SampleFragment sampleFragment) {
        this.sampleFragment = sampleFragment;
    }

    @Provides
    @SampleFragmentScope
    Navigation providesNavigation() {
        return new SampleNavigation(sampleFragment.getActivity(), sampleFragment);
    }

    @Provides
    @SampleFragmentScope
    SampleFragmentView providesSampleFragmentView() {
        return new SampleFragmentView();
    }

    @Provides
    @SampleFragmentScope
    SampleFragmentModel providesSampleFragmentModel() {
        return new SampleFragmentModel();
    }

    @Provides
    @SampleFragmentScope
    SampleFragmentPresenter providesSampleFragmentPresenter(
            SampleFragmentView sampleFragmentView,
            SampleFragmentModel sampleFragmentModel,
            Navigation navigation
    ) {
        return new SampleFragmentPresenter(sampleFragmentView, sampleFragmentModel, navigation);
    }
}

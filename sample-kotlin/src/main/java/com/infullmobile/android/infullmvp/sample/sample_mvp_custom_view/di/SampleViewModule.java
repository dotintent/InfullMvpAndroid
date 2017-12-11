package com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view.di;

import android.content.Context;
import android.util.AttributeSet;
import com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view.SampleMvpCustomView;
import com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view.SampleMvpCustomViewModel;
import com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view.SampleMvpCustomViewPresenter;
import com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view.SampleMvpCustomViewView;
import dagger.Module;
import dagger.Provides;

@Module
public class SampleViewModule {

    private SampleMvpCustomView customView;

    public SampleViewModule(Context context, AttributeSet attributeSet) {
        this.customView = new SampleMvpCustomView(context, attributeSet);
    }

    @Provides
    @SampleViewScope
    Context providesContext() {
        return customView.getParentContext();
    }

    @Provides
    @SampleViewScope
    SampleMvpCustomViewView providesSampleActivityView() {
        return new SampleMvpCustomViewView();
    }

    @Provides
    @SampleViewScope
    SampleMvpCustomViewPresenter providesAddNewItemPresenter(SampleMvpCustomViewView sampleActivityView,
                                                             SampleMvpCustomViewModel sampleActivityModel) {
        return new SampleMvpCustomViewPresenter(sampleActivityView, sampleActivityModel);
    }

    @Provides
    @SampleViewScope
    SampleMvpCustomViewModel providesSampleActivityModel() {
        return new SampleMvpCustomViewModel();
    }
}

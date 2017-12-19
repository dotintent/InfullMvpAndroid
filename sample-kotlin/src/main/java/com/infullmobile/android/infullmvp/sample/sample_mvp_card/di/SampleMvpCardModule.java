package com.infullmobile.android.infullmvp.sample.sample_mvp_card.di;

import android.content.Context;

import com.infullmobile.android.infullmvp.sample.Navigation;
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCardModel;
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCardPresenter;
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCardView;
import dagger.Module;
import dagger.Provides;

@Module
public class SampleMvpCardModule {

    private Context context;

    public SampleMvpCardModule(Context context) {
        this.context = context;
    }

    @Provides
    @SampleMvpCardScope
    Context providesContext() {
        return context;
    }

    @Provides
    @SampleMvpCardScope
    SampleMvpCardView providesSampleActivityView() {
        return new SampleMvpCardView();
    }

    @Provides
    @SampleMvpCardScope
    public SampleMvpCardPresenter providesAddNewItemPresenter(
            SampleMvpCardView sampleActivityView,
            SampleMvpCardModel sampleActivityModel,
            Navigation navigation
    ) {
        return new SampleMvpCardPresenter(sampleActivityView, sampleActivityModel, navigation);
    }

    @Provides
    @SampleMvpCardScope
    public SampleMvpCardModel providesSampleActivityModel() {
        return new SampleMvpCardModel();
    }
}

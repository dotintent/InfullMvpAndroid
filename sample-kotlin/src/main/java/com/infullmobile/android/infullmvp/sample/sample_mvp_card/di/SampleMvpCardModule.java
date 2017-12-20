package com.infullmobile.android.infullmvp.sample.sample_mvp_card.di;

import android.content.Context;
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
    SampleMvpCardView providesSampleMvpCardView() {
        return new SampleMvpCardView();
    }

    @Provides
    @SampleMvpCardScope
    public SampleMvpCardPresenter providesSampleMvpCardPresenter(
            SampleMvpCardView sampleActivityView,
            SampleMvpCardModel sampleActivityModel
    ) {
        return new SampleMvpCardPresenter(sampleActivityView, sampleActivityModel);
    }

    @Provides
    @SampleMvpCardScope
    public SampleMvpCardModel providesSampleMvpCardModel() {
        return new SampleMvpCardModel();
    }
}

package com.infullmobile.android.infullmvp.sample.sample_mvp_card.di;

import android.content.Context;
import android.util.AttributeSet;
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCard;
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCardModel;
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCardPresenter;
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCardView;
import dagger.Module;
import dagger.Provides;

@Module
public class SampleMvpCardModule {

    private SampleMvpCard customView;

    SampleMvpCardModule(Context context, AttributeSet attributeSet) {
        customView = new SampleMvpCard(context, attributeSet);
    }

    public SampleMvpCardModule(SampleMvpCard sampleMvpCard) {
        customView = sampleMvpCard;
    }

    @Provides
    @SampleMvpCardScope
    Context providesContext() {
        return customView.getParentContext();
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
            SampleMvpCardModel sampleActivityModel
    ) {
        return new SampleMvpCardPresenter(sampleActivityView, sampleActivityModel);
    }

    @Provides
    @SampleMvpCardScope
    public SampleMvpCardModel providesSampleActivityModel() {
        return new SampleMvpCardModel();
    }
}

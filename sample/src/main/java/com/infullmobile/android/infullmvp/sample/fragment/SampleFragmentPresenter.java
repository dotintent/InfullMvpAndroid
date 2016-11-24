package com.infullmobile.android.infullmvp.sample.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.infullmobile.android.infullmvp.Presenter;

public class SampleFragmentPresenter extends Presenter<SampleFragmentView> {

    private final SampleFragmentModel sampleFragmentModel;

    public SampleFragmentPresenter(@NonNull final SampleFragmentView presentedView,
                                   @NonNull final SampleFragmentModel sampleFragmentModel) {
        super(presentedView);
        this.sampleFragmentModel = sampleFragmentModel;
    }

    @Override
    protected void bind(@NonNull final Bundle bundle) {
        getPresentedView().setText(sampleFragmentModel.getMessage());
    }
}

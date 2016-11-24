package com.infullmobile.android.infullmvp.sample.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.infullmobile.android.infullmvp.Presenter;

public class SampleActivityPresenter extends Presenter<SampleActivityView> {

    private final SampleActivityModel sampleActivityModel;

    public SampleActivityPresenter(@NonNull SampleActivityView presentedView,
                                   @NonNull SampleActivityModel sampleActivityModel) {
        super(presentedView);
        this.sampleActivityModel = sampleActivityModel;
    }

    @Override
    protected void bind(@NonNull Bundle bundle) {
        getPresentedView().setMessage(sampleActivityModel.getMessage());
    }
}

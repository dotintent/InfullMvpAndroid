package com.infullmobile.android.infullmvp.sample.activity;

import android.os.Bundle;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SampleActivityPresenterTest {

    public static final String TEST_MESSAGE = "testMessage";

    private SampleActivityPresenter sampleActivityPresenter;
    @Mock SampleActivityView sampleActivityView;
    @Mock SampleActivityModel sampleActivityModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sampleActivityPresenter = new SampleActivityPresenter(sampleActivityView, sampleActivityModel);
    }

    @Test
    public void shouldCallPresentedViewToSetMessageOnBind() {
        // given
        when(sampleActivityModel.getMessage()).thenReturn(TEST_MESSAGE);

        // when
        sampleActivityPresenter.bind(new Bundle(), new Bundle(), null);

        // then
        verify(sampleActivityView).setMessage(TEST_MESSAGE);
    }
}
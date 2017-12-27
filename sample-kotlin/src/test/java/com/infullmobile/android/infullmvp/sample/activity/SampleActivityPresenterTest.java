package com.infullmobile.android.infullmvp.sample.activity;

import android.os.Bundle;
import com.infullmobile.android.infullmvp.sample.SampleNavigation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class SampleActivityPresenterTest {

    private static final String TEST_MESSAGE = "testMessage";

    private SampleActivityPresenter sampleActivityPresenter;
    @Mock SampleActivityView sampleActivityView;
    @Mock SampleActivityModel sampleActivityModel;
    @Mock SampleNavigation sampleNavigation;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sampleActivityPresenter = new SampleActivityPresenter(sampleActivityView, sampleActivityModel, sampleNavigation);
    }

    @Test
    public void shouldSetMessageInViewOnBind() {
        // given
        when(sampleActivityModel.getMessage()).thenReturn(TEST_MESSAGE);
        // when
        sampleActivityPresenter.bind(new Bundle(), new Bundle(), null);

        // then
        verify(sampleActivityView).setMessage(TEST_MESSAGE);
    }
}
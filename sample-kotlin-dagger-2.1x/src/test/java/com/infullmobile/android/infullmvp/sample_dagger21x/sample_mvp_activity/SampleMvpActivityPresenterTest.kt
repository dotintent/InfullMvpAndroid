package com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity

import android.os.Bundle
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.verify
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SampleMvpActivityPresenterTest {

    private lateinit var presenter: SampleMvpActivityPresenter
    @Mock private lateinit var model: SampleMvpActivityModel
    @Mock private lateinit var view: SampleMvpActivityView

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter = SampleMvpActivityPresenter(model, view)
    }

    @Test
    fun shouldLoadMessageFromModel() {
        // given
        val expectedMessage = "Excelsior"
        given(model.messageToBeDisplayed).willReturn(expectedMessage)

        // when
        presenter.bind(Bundle(), Bundle(), null)

        // then
        verify(view).displayedText = expectedMessage
    }

}
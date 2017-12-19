package com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view

import android.os.Bundle
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCardModel
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCardPresenter
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCardView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.mockito.Mockito.`when` as whenDo

@RunWith(RobolectricTestRunner::class)
class SampleMvpCustomViewPresenterTest {

    private lateinit var testedPresenter: SampleMvpCardPresenter
    @Mock lateinit var mockedView: SampleMvpCardView
    @Mock lateinit var mockedModel: SampleMvpCardModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        testedPresenter = SampleMvpCardPresenter(
                mockedView,
                mockedModel
        )
    }

    @Test
    fun shouldSetTemperatureOnBind() {
        // given
        val temperature = 42
        whenDo(mockedModel.getCurrentTemperature()).thenReturn(temperature)

        // when
        testedPresenter.bind(Bundle(), Bundle(), null)

        // then
        verify(mockedView).displayTemperature(temperature)
    }
}
package com.infullmobile.android.infullmvp.sample.sample_mvp_card

import android.os.Bundle
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner
import org.mockito.Mockito.`when` as whenDo

@RunWith(RobolectricTestRunner::class)
class SampleMvpCustomViewPresenterTest {

    @get:Rule val rule: MockitoRule = MockitoJUnit.rule()

    @InjectMocks private lateinit var testedPresenter: SampleMvpCardPresenter
    @Mock lateinit var mockedView: SampleMvpCardView
    @Mock lateinit var mockedModel: SampleMvpCardModel

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
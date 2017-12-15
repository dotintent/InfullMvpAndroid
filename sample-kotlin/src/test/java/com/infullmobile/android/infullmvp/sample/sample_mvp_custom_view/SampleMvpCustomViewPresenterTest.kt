package com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view

import android.os.Bundle
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SampleMvpCustomViewPresenterTest {

    private lateinit var testedPresenter: SampleMvpCustomViewPresenter
    @Mock lateinit var mockedView: SampleMvpCustomViewView
    @Mock lateinit var mockedModel: SampleMvpCustomViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        testedPresenter = SampleMvpCustomViewPresenter(mockedView, mockedModel)
    }

    @Test
    fun shouldSetTemperatureOnBind() {
        //given
        val temperature = 3
        `when`(mockedModel.currentTemperature).thenReturn(temperature)

        //when
        testedPresenter.bind(Bundle(), Bundle(), null)

        //then
        verify(mockedView).displayTemperature(temperature)
    }

}
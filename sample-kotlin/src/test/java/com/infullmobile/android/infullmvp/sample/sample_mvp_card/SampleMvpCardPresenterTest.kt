package com.infullmobile.android.infullmvp.sample.sample_mvp_card

import android.os.Bundle
import com.infullmobile.android.infullmvp.sample.SampleNavigation
import com.infullmobile.android.kotlin.navigation.LaunchableIntent
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.spy
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner
import org.mockito.Mockito.`when` as whenDo

@RunWith(RobolectricTestRunner::class)
class SampleMvpCardPresenterTest {

    @get:Rule val rule: MockitoRule = MockitoJUnit.rule()

    @InjectMocks private lateinit var testedPresenter: SampleMvpCardPresenter
    @Mock lateinit var mockedView: SampleMvpCardView
    @Mock lateinit var mockedModel: SampleMvpCardModel
    @Mock lateinit var mockedNavigator: SampleNavigation
    @Mock lateinit var mockedLaunchableIntent: LaunchableIntent

    @Before
    fun setUp() {
        whenDo(mockedNavigator.sampleScreen()).thenReturn(mockedLaunchableIntent)
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

    @Test
    fun shouldNavigateToNextScreen() {
        // when
        testedPresenter.navigateToNextScreen()

        // then
        verify(mockedNavigator).sampleScreen()
        verify(mockedLaunchableIntent).start()
    }
}
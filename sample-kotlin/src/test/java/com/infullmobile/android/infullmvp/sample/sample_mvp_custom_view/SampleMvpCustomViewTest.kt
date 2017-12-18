package com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view

import com.infullmobile.android.infullmvp.basetest.InFullMvpCustomViewBaseTest
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCard
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCardModel
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCardPresenter
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.SampleMvpCardView
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.di.SampleMvpCardGraph
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.di.SampleMvpCardModule
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.di.SampleMvpCardScope
import dagger.Provides
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.mockito.Mockito.`when` as whenDo

@RunWith(RobolectricTestRunner::class)
class SampleMvpCustomViewTest
    : InFullMvpCustomViewBaseTest<
        SampleMvpCard,
        SampleMvpCardPresenter,
        SampleMvpCardView>() {

    @get:Rule val rule: MockitoRule = MockitoJUnit.rule()

    @Mock lateinit var mockedModel: SampleMvpCardModel
    @Mock lateinit var mockedPresenter: SampleMvpCardPresenter
    private val temperatureFromModel = 42

    @Before
    override fun setUp() {
        MockitoAnnotations.initMocks(this)
        super.setUp()
        whenDo(mockedModel.currentTemperature).thenReturn(temperatureFromModel)
    }

    @Test
    fun shouldShowTemperature() {
        // given
        val expectedText = String.format(testedView.temperatureString, mockedModel.currentTemperature)

        // then
        assertThat(testedCustomView.presentedView.temperatureTextView.text).isEqualTo(expectedText)
    }

    override fun provideCustomView(): SampleMvpCard = SampleMvpCard(RuntimeEnvironment.application)

    override fun substituteModules(customView: SampleMvpCard) {
        customView.sampleActivityGraph = SampleMvpCardGraph(RuntimeEnvironment.application, null)
        customView.sampleActivityGraph.setAddNewItemModule(TestSampleMvpCustomViewModule(customView))
    }

    private inner class TestSampleMvpCustomViewModule(customView: SampleMvpCard) : SampleMvpCardModule(customView) {

        @Provides
        @SampleMvpCardScope
        override fun providesAddNewItemPresenter(
                sampleActivityView: SampleMvpCardView?,
                sampleActivityModel: SampleMvpCardModel?
        ): SampleMvpCardPresenter {
            return mockedPresenter
        }

        @Provides
        @SampleMvpCardScope
        override fun providesSampleActivityModel(): SampleMvpCardModel {
            return mockedModel
        }
    }
}
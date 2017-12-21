package com.infullmobile.android.infullmvp.sample.sample_mvp_card

import com.infullmobile.android.infullmvp.basetest.InFullMvpCardBaseTest
import com.infullmobile.android.infullmvp.sample.activity.SampleActivity
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.di.SampleMvpCardModule
import com.infullmobile.android.infullmvp.sample.sample_mvp_card.di.SampleMvpCardScope
import dagger.Provides
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner
import org.mockito.Mockito.`when` as whenDo

@RunWith(RobolectricTestRunner::class)
class SampleMvpCardTest : InFullMvpCardBaseTest<
        SampleMvpCard,
        SampleMvpCardPresenter,
        SampleMvpCardView,
        SampleActivity>() {

    @get:Rule val rule: MockitoRule = MockitoJUnit.rule()

    @Mock lateinit var mockedPresenter: SampleMvpCardPresenter
    override val activityClass = SampleActivity::class.java
    private val temperature = 42

    @Test
    fun shouldShowTemperature() {
        // given
        val expectedText = String.format(testedView.temperatureString, temperature)

        // when
        testedView.displayTemperature(temperature)

        // then
        assertThat(testedView.temperatureTextView.text).isEqualTo(expectedText)
    }

    override fun provideCustomView(parentActivity: SampleActivity) = SampleMvpCard(parentActivity)

    override fun substituteModules(customView: SampleMvpCard) {
        customView.sampleMvpCardGraph.setAddNewItemModule(TestSampleMvpCustomViewModule(customView))
    }

    private inner class TestSampleMvpCustomViewModule(customView: SampleMvpCard) : SampleMvpCardModule(customView.context) {

        @Provides
        @SampleMvpCardScope
        override fun providesSampleMvpCardPresenter(
                sampleActivityView: SampleMvpCardView?,
                sampleActivityModel: SampleMvpCardModel?
        ) = mockedPresenter
    }
}
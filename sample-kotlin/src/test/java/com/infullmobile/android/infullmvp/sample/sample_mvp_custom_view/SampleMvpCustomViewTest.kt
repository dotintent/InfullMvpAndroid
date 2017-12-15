package com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view

import com.infullmobile.android.infullmvp.basetest.InFullMvpCustomViewBaseTest
import com.infullmobile.android.infullmvp.sample.R
import com.infullmobile.android.infullmvp.sample.sample_mvp_custom_view.di.SampleViewModule
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.mockito.Mockito.`when` as whenDo

@RunWith(RobolectricTestRunner::class)
class SampleMvpCustomViewTest : InFullMvpCustomViewBaseTest
                                <SampleMvpCustomView, SampleMvpCustomViewPresenter, SampleMvpCustomViewView>() {

    @get:Rule val rule: MockitoRule = MockitoJUnit.rule()
    @Mock private lateinit var mockedModel: SampleMvpCustomViewModel

    override val layoutResId: Int = R.layout.custom_view_sample
    val temperatureFromModel = 3

    @Before
    override fun setUp() {
        MockitoAnnotations.initMocks(this)
        super.setUp()
        `when`(mockedModel.currentTemperature).thenReturn(temperatureFromModel)
    }

    @Test
    fun shouldShowTemperature() {
        //given
        val expectedText = String.format(testedView.temperatureString, mockedModel.currentTemperature)

        //then
        assertThat(testedCustomView.presentedView.temperatureTextView.text).isEqualTo(expectedText)
    }

    override fun provideCustomView(): SampleMvpCustomView {
        return SampleMvpCustomView(RuntimeEnvironment.application)
    }

    override fun substituteModules(customView: SampleMvpCustomView) {
        customView.injectIntoGraph()
        customView.sampleActivityGraph.setAddNewItemModule(TestSampleMvpCustomViewModule(customView))
    }

    private inner class TestSampleMvpCustomViewModule(customView: SampleMvpCustomView) : SampleViewModule(customView) {

        override fun providesSampleActivityModel(): SampleMvpCustomViewModel {
            return mockedModel
        }
    }
}
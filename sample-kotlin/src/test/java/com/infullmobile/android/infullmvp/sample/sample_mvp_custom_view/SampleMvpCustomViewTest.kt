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
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class SampleMvpCustomViewTest : InFullMvpCustomViewBaseTest<SampleMvpCustomView>() {

    @get:Rule val rule: MockitoRule = MockitoJUnit.rule()

    @Mock private lateinit var mockedView: SampleMvpCustomViewView
    @Mock private lateinit var mockedPresenter: SampleMvpCustomViewPresenter
    @Mock private lateinit var mockedModel: SampleMvpCustomViewModel

    override val layoutResId: Int
        get() = R.layout.custom_view_sample

    @Before
    override fun setUp() {
        super.setUp()

        /*1st way of creating a view*/
        testedCustomView = SampleMvpCustomView(activityController.get())

        /*2nd way of creating a view*/
        //        testedCustomView = LayoutInflater.from(activityController.get()).inflate(
        //                layoutResId,
        //                null
        //        ) as SampleMvpCustomView

        substituteModules(testedCustomView)
        activityController.start().resume().visible()
    }

    @Test
    fun shouldShowTemperature() {
        //given
        val expectedText = mockedView.temperatureString
        val temperatureFromModel = "3* C"

        //when
        `when`(mockedModel.messageToBeDisplayed).thenReturn(temperatureFromModel)

        //then
        assertThat(mockedView.temperature.text).isEqualTo(expectedText)
    }

    override fun provideCustomView(): SampleMvpCustomView {
        return SampleMvpCustomView(RuntimeEnvironment.application)
    }

    override fun substituteModules(customView: SampleMvpCustomView) {
        customView.sampleActivityGraph.setAddNewItemModule(TestSampleMvpCustomViewModule(customView))
    }

    private inner class TestSampleMvpCustomViewModule(customView: SampleMvpCustomView) : SampleViewModule(customView) {

        override fun providesSampleActivityView(): SampleMvpCustomViewView {
            return mockedView
        }

        override fun providesAddNewItemPresenter(
                sampleActivityView: SampleMvpCustomViewView?,
                sampleActivityModel: SampleMvpCustomViewModel?
        ): SampleMvpCustomViewPresenter {
            return mockedPresenter
        }

        override fun providesSampleActivityModel(): SampleMvpCustomViewModel {
            return mockedModel
        }
    }
}
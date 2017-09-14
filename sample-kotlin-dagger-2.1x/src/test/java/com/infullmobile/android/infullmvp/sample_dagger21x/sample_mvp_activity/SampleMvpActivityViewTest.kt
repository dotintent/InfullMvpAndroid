package com.infullmobile.android.infullmvp.sample_dagger21x.sample_mvp_activity

import com.infullmobile.android.infullmvp.basetest.InFullMvpActivityBaseTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SampleMvpActivityViewTest
    : InFullMvpActivityBaseTest<SampleMvpActivity, SampleMvpActivityPresenter, SampleMvpActivityView>() {

    override val testActivityClass: Class<SampleMvpActivity> get() = SampleMvpActivity::class.java

    @Test
    fun shouldDisplayTextCorrectly() {
        // given
        val textWeSet = "Excelsior!!!"

        // when
        testedView.displayedText = textWeSet

        // then
        assertThat(testedView.displayedText).isEqualTo(textWeSet)
    }
}
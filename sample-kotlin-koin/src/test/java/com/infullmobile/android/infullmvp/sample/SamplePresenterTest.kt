package com.infullmobile.android.infullmvp.sample

import com.infullmobile.android.infullmvp.InFullMvpActivity
import com.infullmobile.android.infullmvp.InFullMvpPresenter
import com.infullmobile.android.infullmvp.PresentedView
import com.infullmobile.android.infullmvp.sample.activity.SampleKoinActivity
import com.infullmobile.android.infullmvp.sample.activity.SampleKoinPresenter
import com.infullmobile.android.infullmvp.sample.activity.SampleKoinView
import com.infullmobile.android.infullmvp.sample.activity.sampleKoinActivityModule
import com.infullmobile.android.infullmvp.sample.application.allModules
import com.infullmobile.android.infullmvp.sample.models.SharedPreferencesModel
import org.junit.Test
import org.koin.core.parameter.parametersOf
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.get
import org.koin.test.KoinTest
import org.koin.test.checkModules
import org.koin.test.declareMock
import org.mockito.Mockito


class SamplePresenterTest : KoinTest {

    @Test
    fun `check Sample Presenter`() {
        startKoin(allModules)
        declareMock<SharedPreferencesModel>()

        val sharedPreferencesModelMock = get<SharedPreferencesModel>()

        val systemUnderTest = createTestPresenter<SampleKoinActivity, SampleKoinView, SampleKoinPresenter>()

        systemUnderTest.openCustomViewActivity()

        Mockito.verify(sharedPreferencesModelMock).welcomeText = "test"
    }

    inline fun <reified T : InFullMvpActivity<View, Presenter>,
            reified View : PresentedView<Presenter>,
            reified Presenter : InFullMvpPresenter<View>
            > createTestPresenter(): Presenter {
        declareMock<T>()
        val activityMock = get<T>()
        Mockito.`when`(activityMock.presentedView).then { Mockito.mock(View::class.java) }
        return get<Presenter>("", null) { parametersOf(activityMock) }
    }
}

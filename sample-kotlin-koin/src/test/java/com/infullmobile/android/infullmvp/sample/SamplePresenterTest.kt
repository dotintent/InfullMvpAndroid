package com.infullmobile.android.infullmvp.sample

import com.infullmobile.android.infullmvp.sample.activity.SampleKoinPresenter
import com.infullmobile.android.infullmvp.sample.activity.SampleKoinView
import com.infullmobile.android.infullmvp.sample.activity.sampleKoinActivityModule
import com.infullmobile.android.infullmvp.sample.mvpCardActivity.sampleActivity2Module
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
    fun `check MVP hierarchy`() {
        checkModules(listOf(sampleKoinActivityModule))

//        checkModules(allModules)
        //We can check full project DI also, but this would require RoboElectric to provide Android Context class
    }

    @Test
    fun `check Sample Presenter`() {
        startKoin(allModules)
        declareMock<SharedPreferencesModel>()
        declareMock<SampleKoinView>()
        val sharedPreferencesModelMock = get<SharedPreferencesModel>()
        val viewMock = get<SampleKoinView>()

        val systemUnderTest = get<SampleKoinPresenter>("", null) { parametersOf(viewMock) }

        systemUnderTest.openCustomViewActivity()

        Mockito.verify(sharedPreferencesModelMock).welcomeText = "test"
        Mockito.verify(viewMock).openSample2()
    }
}

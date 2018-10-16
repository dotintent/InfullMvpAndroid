package com.infullmobile.android.infullmvp.sample

import android.app.Application
import android.content.Context
import android.view.View
import com.infullmobile.android.infullmvp.sample.application.allModules
import org.junit.Assert
import org.junit.Test
import org.koin.dsl.module.module
import org.koin.log.Logger
import org.koin.test.KoinTest
import org.koin.test.checkModules
import org.mockito.Mockito.mock

class SampleModuleCheckTest : KoinTest {

    val failOnErrorLogger = object : Logger {
        override fun debug(msg: String) {
        }

        override fun err(msg: String) {
            Assert.fail(msg)
        }

        override fun info(msg: String) {
        }
    }

    @Test
    fun `check MVP hierarchy`() {
        val contextModule = module {
            single { mock(Application::class.java) }
            single { mock(Context::class.java) }
            single { mock(View::class.java) }
        }
        checkModules(listOf(contextModule) + allModules)
        // This check fails because parameter injection is not supported in tests
        // checkModules(listOf(contextModule) + allModules, failOnErrorLogger)
    }

}

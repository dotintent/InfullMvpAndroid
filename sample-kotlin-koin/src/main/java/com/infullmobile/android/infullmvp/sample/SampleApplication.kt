package com.infullmobile.android.infullmvp.sample

import android.app.Application
import com.infullmobile.android.infullmvp.inject
import com.infullmobile.android.infullmvp.sample.activity.sampleActivityModule
import com.infullmobile.android.infullmvp.sample.activity2.sampleActivity2Module
import com.infullmobile.android.infullmvp.sample.customView.customViewModule
import com.infullmobile.android.infullmvp.sample.fragment.sampleFragmentModule
import com.infullmobile.android.infullmvp.sample.models.SharedPreferencesModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

val allModules = listOf(
        module {
            single { SharedPreferencesModel(get()) }
        },
        sampleActivityModule,
        sampleActivity2Module,
        sampleFragmentModule,
        customViewModule
)

class SampleApplication : Application() {

    private val sharedPreferencesModel: SharedPreferencesModel by inject()

    override fun onCreate() {
        super.onCreate()
        // Application has to Start Koin to register injections
        startKoin(this, allModules)

        sharedPreferencesModel.welcomeText = "MVP SAMPLE SHARED PREFS INJECTED TEXT"
    }
}
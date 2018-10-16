package com.infullmobile.android.infullmvp.sample.models

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SharedPreferencesModel(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("sample", 0)

    var welcomeText by sharedPreferences.fieldString("welcomeText")
    val temperature = 3

    private fun SharedPreferences.fieldString(key: String): ReadWriteProperty<Any, String> {
        return object : ReadWriteProperty<Any, String> {
            override fun getValue(thisRef: Any, property: KProperty<*>): String = getString(key, "")!!

            override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
                edit().putString(key, value).apply()
            }
        }
    }
}
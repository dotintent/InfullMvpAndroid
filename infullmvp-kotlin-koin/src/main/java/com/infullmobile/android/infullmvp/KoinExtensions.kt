package com.infullmobile.android.infullmvp

import org.koin.core.KoinContext
import org.koin.core.parameter.ParameterDefinition
import org.koin.core.parameter.emptyParameterDefinition
import org.koin.core.scope.Scope
import org.koin.standalone.StandAloneContext

inline fun <reified T : Any> inject(name: String = "") = lazy { (StandAloneContext.koinContext as KoinContext).get<T>(name) }

inline fun <reified T : Any> inject(
        name: String = "",
        scope: Scope? = null,
        noinline parameters: ParameterDefinition = emptyParameterDefinition()
) = lazy { (StandAloneContext.koinContext as KoinContext).get<T>(name, scope, parameters) }
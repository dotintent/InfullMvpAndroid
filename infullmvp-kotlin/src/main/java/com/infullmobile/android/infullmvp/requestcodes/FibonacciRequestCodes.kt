/*
 * Copyright © ${YEAR} inFullMobile. All rights reserved.
 */

package com.infullmobile.android.infullmvp.requestcodes

import android.support.v4.util.ArrayMap

/**
 * Created by jacek on 21/02/17.
 */
class FibonacciRequestCodes : RequestCodeProvider<String> {

    private val codesMap = ArrayMap<String, Int>(INIT_SIZE)

    override fun requestCodeFor(identifier: String): Int {
        if (!codesMap.contains(identifier)) {
            val currentCount = codesMap.keys.count() { it != null }
            val fibonacciOffset = 2 /*fib always start with either 0,1,1 or 1,1*/
            val nextFibNumberIndex = currentCount + fibonacciOffset + 1
            val requestCode = nextInFibonacci(nextFibNumberIndex)
            codesMap.put(identifier, requestCode)
            return requestCode
        }

        return codesMap[identifier] ?: identifier.hashCode()
        /*this may throw an exception down the line as request codes are being check down the line by the activity*/
    }

    private fun nextInFibonacci(numberIndex: Int): Int {
        if (numberIndex === 1 || numberIndex === 2) {
            return 1
        }
        var fibo1 = 1
        var fibo2 = 1
        var fibonacci = 1
        for (i in 3..numberIndex) {
            fibonacci = fibo1 + fibo2
            fibo1 = fibo2
            fibo2 = fibonacci

        }
        return fibonacci
    }

    companion object {
        const val INIT_SIZE = 10
    }
}
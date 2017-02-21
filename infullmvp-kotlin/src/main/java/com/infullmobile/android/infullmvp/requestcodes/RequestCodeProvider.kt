/*
 * Copyright © ${YEAR} inFullMobile. All rights reserved.
 */

package com.infullmobile.android.infullmvp.requestcodes

/**
 * Created by jacek on 21/02/17.
 */
interface RequestCodeProvider<in Identifier : Any> {
    fun requestCodeFor(identifier: Identifier): Int
}
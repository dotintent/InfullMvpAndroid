/*
 * Copyright © ${YEAR} inFullMobile. All rights reserved.
 */

package com.infullmobile.android.infullmvp

import android.app.Activity
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 * Created by jacek on 21/02/17.
 */
@RunWith(RobolectricTestRunner::class)
class LaunchableIntentTest {

    @Test fun shouldNotReportSameCodeForDifferentClasses() {
        /*given*/
        val launchableOne = TestLaunchableOne(Robolectric.buildActivity(FragmentActivity::class.java).get())
        val launchableTwo = TestLaunchableTwo(Robolectric.buildActivity(FragmentActivity::class.java).get())

        /*when*/
        val requestCodeOne = launchableOne.requestCode
        val requestCodeTwo = launchableTwo.requestCode

        /*then*/
        assert(requestCodeOne != requestCodeTwo)
    }

    @Test fun shouldReturnTrueForMatchingCode() {
        /*given*/
        val launchableOne = TestLaunchableOne(Robolectric.buildActivity(FragmentActivity::class.java).get())
        val launchableTwo = TestLaunchableTwo(Robolectric.buildActivity(FragmentActivity::class.java).get())

        /*when*/
        val expectedTrue = launchableOne.codeMatch(launchableOne.requestCode)
        val expectedFalse = launchableTwo.codeMatch(launchableOne.requestCode)

        /*then*/
        assert(expectedTrue == true)
        assert(expectedFalse == false)
    }

    @Test fun shouldReturnFalseForMatchingCode() {
        /*given*/
        val activity = Robolectric.buildActivity(FragmentActivity::class.java).get()
        val launchableOne = TestLaunchableOne(activity)
        val launchableTwo = TestLaunchableTwo(activity)

        val completelyOtherLaunchableIntent = object
            : LaunchableIntent(activity, Intent(activity, SomeOtherActivity::class.java)) {}

        /*when*/
        val expectedFalse = launchableOne.codeMatch(completelyOtherLaunchableIntent.requestCode)
        val expectedFalseToo = launchableTwo.codeMatch(completelyOtherLaunchableIntent.requestCode)

        /*then*/
        assert(expectedFalse == false)
        assert(expectedFalseToo == false)
    }

    @Test fun shouldReportCanceledResultsProperly() {
        /*given*/
        val activity = Robolectric.buildActivity(FragmentActivity::class.java).get()
        val launchableOne = TestLaunchableOne(activity)
        val launchableTwo = TestLaunchableTwo(activity)

        /*when*/
        val expectedTrue = launchableOne.resultCanceled(launchableOne.requestCode, Activity.RESULT_CANCELED)
        val expectedFalse = launchableTwo.resultCanceled(launchableOne.requestCode, Activity.RESULT_CANCELED)

        /*then*/
        assert(expectedTrue == true)
        assert(expectedFalse == false)
    }

    open class TestActivityOne : Activity()
    class TestLaunchableOne(activity: Activity)
        : LaunchableIntent(activity, Intent(activity, TestActivityOne::class.java))

    class SomeOtherActivity : TestActivityOne()

    class TestActivityTwo : AppCompatActivity()
    class TestLaunchableTwo(activity: Activity)
        : LaunchableIntent(activity, Intent(activity, TestLaunchableTwo::class.java))

}
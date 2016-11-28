package com.infullmobile.android.infullmvp

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore

open class InFullNavigation(private val activity: Activity) {

    private val ALL_IMAGES_TYPE = "image/*"
    private val ASPECT_X = "aspectX"
    private val ASPECT_Y = "aspectY"
    private val SCALE = "scale"
    private val ASPECT_X_VALUE = 1
    private val ASPECT_Y_VALUE = 1
    private val SCALE_VALUE = true

    fun finishWithResultOk() {
        finishWithResult(activity, Activity.RESULT_OK, null)
    }

    fun finishWithResultOk(intent: Intent) {
        finishWithResult(activity, Activity.RESULT_OK, intent)
    }

    fun finishWithResultCancelled() {
        finishWithResult(activity, Activity.RESULT_CANCELED, null)
    }

    fun finish() {
        activity.finish()
    }

    fun onBackPressed() {
        activity.onBackPressed()
    }

    fun startCapturingUsingCamera(): LaunchableIntent {
        return LaunchableIntent(activity, cameraIntent())
    }

    fun startPhotoGallery(title: String): LaunchableIntent {
        return LaunchableIntent(activity, galleryIntent(title))
    }

    private fun cameraIntent(): Intent {
        return buildIntent(MediaStore.ACTION_IMAGE_CAPTURE)
    }

    private fun galleryIntent(title: String): Intent {
        val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = ALL_IMAGES_TYPE
        return Intent.createChooser(intent, title)
    }

    private fun finishWithResult(activity: Activity, result: Int, data: Intent?) {
        activity.setResult(result, data)
        activity.finish()
    }

    private fun buildIntent(intentType: String): Intent {
        return Intent(intentType)
                .putExtra(ASPECT_X, ASPECT_X_VALUE)
                .putExtra(ASPECT_Y, ASPECT_Y_VALUE)
                .putExtra(SCALE, SCALE_VALUE)
    }
}

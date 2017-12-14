package funnybrain.mapcamera

import android.content.Context
import android.hardware.Camera
import android.util.Log
import android.view.SurfaceView
import android.view.SurfaceHolder
import java.io.IOException

class CameraPreview(context: Context, camera: Camera) : SurfaceView(context), SurfaceHolder.Callback {

    private var mCamera: Camera? = null
    private val TAG: String = "CameraPreview"

    init {
        mCamera = camera

        holder.addCallback(this)
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }


    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        try {
            mCamera!!.setPreviewDisplay(surfaceHolder)
            mCamera?.startPreview()
        } catch (ioe: IOException) {
            Log.e(TAG, "Error setting camera preview: " + ioe.message)
        }
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, format: Int, w: Int, h: Int) {
        // If your preview can change or rotate, take care of those events here.
        // Make sure to stop the preview before resizing or reformatting it.

        if (holder.surface == null) {
            // preview surface does not exist
            return
        }

        // stop preview before making changes
        try {
            mCamera?.stopPreview()
        } catch (e: Exception) {
            // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here

        // start preview with new settings
        try {
            mCamera?.setPreviewDisplay(holder)
            mCamera?.startPreview()
        } catch (e: Exception) {
            Log.e(TAG, "Error starting camera preview: " + e.message)
        }
    }

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {
        // empty. Take care of releasing the Camera preview in your activity.
    }
}

package funnybrain.mapcamera

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Camera
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var mCamera: Camera? = null
    private var mPreview: CameraPreview? = null

    companion object {
        open fun getCameraInstance(): Camera? {
            var c : Camera? = null
            try {
                c = Camera.open()
            } catch (e: Exception) {}
            return c
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCamera = getCameraInstance()
        mPreview = CameraPreview(this, mCamera!!)
    }

//    private fun checkCameraHardware(x: Context) =
//            (x.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA))
}

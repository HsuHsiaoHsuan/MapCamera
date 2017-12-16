package funnybrain.mapcamera

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Camera
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

    private var mCamera: Camera? = null
    private var mPreview: CameraPreview? = null
    private val PERMISSION_REQUEST_CAMERA: Int = 9527

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

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // No explanation needed, we can request the permission.
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),
                        PERMISSION_REQUEST_CAMERA)
            }
        }

//        mCamera = getCameraInstance()
//        mPreview = CameraPreview(this, mCamera!!)
//        val preview: FrameLayout = findViewById(R.id.camera_preview)
//        preview.addView(mPreview)
    }

//    private fun checkCameraHardware(x: Context) =
//            (x.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA))

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}

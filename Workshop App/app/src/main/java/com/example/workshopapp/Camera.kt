package com.example.workshopapp


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Environment.getExternalStoragePublicDirectory
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import androidx.camera.core.*
import androidx.camera.core.ImageCapture.OutputFileOptions.*
import androidx.camera.lifecycle.ProcessCameraProvider
import com.example.workshopapp.databinding.ActivityCameraBinding


class Camera : AppCompatActivity() {
    private var imageCapture: ImageCapture? = null

    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService
    private lateinit var binding: ActivityCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCameraBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnBack.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
        /*

        // Request camera permissions
        if (allPermissionsGranted()) {

        } else {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
        }

        outputDirectory = getOutputDirectory()

        cameraExecutor = Executors.newSingleThreadExecutor()
    }

    private fun allPermissionsGranted() =
        REQUIRED_PERMISSIONS.all {
            ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
        }


    private fun takePhoto() {
        //Erstelle eine Referenz vom bearbeitbaren Image Capture Use Case
        val ImageCapture = imageCapture ?: return

        //Erstelle eine Datei mit Zeitstempel
        // Unique Filenames
        val photoFile = File (
            outputDirectory, SimpleDateFormat(FILENAME_FORMAT, Locale.GERMAN).format(System.currentTimeMillis())+".jpg"
        )

        //Erstelle Output Optionen die Metadaten und die oben erstelle photoFile beinhalten
        val outputOptions =  Builder(photoFile).build()

        //Image Capture Listener der getriggert wird, wenn ein Foto gemacht wurde
        imageCapture!!.takePicture(
            outputOptions, ContextCompat.getMainExecutor(this), object  : ImageCapture.OnImageSavedCallback {
                override fun onError(exception: ImageCaptureException) {
                    Log.e(TAG, "Photo capture failed: ${exception.message}", exception)
                }

                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    val savedUri = Uri.fromFile(photoFile)
                    val msg = "Photo capture succeeded: $savedUri"
                    Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
                    Log.d(TAG, msg)
                }
            }
        )
    }

    //Hier wird eine Preview des Kamerabildes erstellt. Also wird beim starten der App das Kamerabild angezeigt und kein schwarzer Hintergrund
    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener(Runnable {
            //Nötig um den Kamera Lifecycle an den Lifecycle Owner zu binden
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
            //Vorschau
            val preview = Preview.Builder().build()
                    .also {
                        it.setSurfaceProvider()
                    }
            imageCapture = ImageCapture.Builder().build()

            //Setze die Hauptkamera als Default
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                //Entkoppeln aller Use Cases
                cameraProvider.unbindAll()
                //Use Case an die Kamera binden
                cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageCapture)
            } catch (exc: Exception) {
                Log.e(TAG, "Use case binding failed", exc)
            }
        }, ContextCompat.getMainExecutor(this))
    }




    private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else filesDir
    }


    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }

    companion object {
        private const val TAG = "CameraXBasic"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera()
            } else {
                Toast.makeText(this, "Permissions not granted by the user.", Toast.LENGTH_SHORT)
                    .show()
                finish()
            }
        }




         */

    }
}



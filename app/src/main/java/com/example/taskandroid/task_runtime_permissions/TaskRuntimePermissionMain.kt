package com.example.taskandroid.task_runtime_permissions

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.taskandroid.R

class TaskRuntimePermissionMain : AppCompatActivity() {
    private val PERMISSION_REQUEST_CODE = 101
    private lateinit var textForRuntimePermission: TextView
    private val permissions = arrayOf(
        Manifest.permission.READ_MEDIA_IMAGES,
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_FINE_LOCATION
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_runtime_permission_main)
        textForRuntimePermission = findViewById(R.id.textForRuntimePermission)
        //for display the permission dialog box
        ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE)
    }
    //To show result on the result of permission
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                textForRuntimePermission.text = "All Permissions are Granted."
            } else {
                textForRuntimePermission.text = "Some permissions were denied."
            }
        }
    }
}
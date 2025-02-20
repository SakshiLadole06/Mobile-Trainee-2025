package com.example.taskandroid.taskintentfilter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R
import java.io.File

class TaskIntentFilterMain : AppCompatActivity() {
    private lateinit var callBtn : Button
    private lateinit var emailBtn : Button
    private lateinit var linkBtn : Button
    private lateinit var photosBtn : Button
    private lateinit var audioBtn : Button
    private lateinit var imageViewInIntent:ImageView
    private lateinit var textInIntent: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_intent_filter_main)

        //finding id
        callBtn = findViewById(R.id.callBtn)
        emailBtn = findViewById(R.id.emailBtn)
        linkBtn= findViewById(R.id.linkBtn)
        photosBtn = findViewById(R.id.photosBtn)
        audioBtn = findViewById(R.id.audioBtn)
        imageViewInIntent = findViewById(R.id.imageViewInIntent)
        textInIntent = findViewById(R.id.textInIntent)

        //For open call log
        callBtn.setOnClickListener {
            val url = "tel:8180054811"
            val callIntent = Intent(Intent.ACTION_DIAL,Uri.parse(url))
            startActivity(callIntent)
        }

        //For email Open
        emailBtn.setOnClickListener {
            val url ="mailto:ladolesakshi@gmail.com"
            val emailIntent = Intent(Intent.ACTION_SENDTO,Uri.parse(url))
            startActivity(emailIntent)
        }

        //For Link Open
        linkBtn.setOnClickListener {
            val url = "https://www.yudiz.com/"
            val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(linkIntent)
        }

        //For photos
        photosBtn.setOnClickListener {
            val url = "MediaStore.Images.Media.EXTERNAL_CONTENT_URI"
            val photoIntent = Intent(Intent.ACTION_PICK, Uri.parse(url))
            photoIntent.setType("image/*")
            startActivity(photoIntent)
        }
        //to show image
        if (intent?.action == Intent.ACTION_SEND && intent.type?.startsWith("image/") == true) {
            val imageUri: Uri? = intent.getParcelableExtra(Intent.EXTRA_STREAM)
            if (imageUri != null) {
                imageViewInIntent.setImageURI(imageUri) // Display the shared image
            }
        }

        //For Audios
        audioBtn.setOnClickListener {
            val url = "MediaStore.Audio/*"
            val audioIntent = Intent(Intent.ACTION_PICK, Uri.parse(url))
            audioIntent.setType("audio/*")
            startActivity(audioIntent)
        }
        //to show audio file name
        if (intent?.action == Intent.ACTION_SEND && intent.type?.startsWith("audio/") == true) {
            val audioUri: Uri? = intent.getParcelableExtra(Intent.EXTRA_STREAM)
            if (audioUri != null) {
                val fileName = File(audioUri.path ?: "").name
                textInIntent.text = fileName // Display the audio name
            }
        }
    }
}